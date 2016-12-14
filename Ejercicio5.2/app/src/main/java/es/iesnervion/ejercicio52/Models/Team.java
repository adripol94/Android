package es.iesnervion.ejercicio52.Models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import es.iesnervion.ejercicio52.R;

/**
 * Created by apol on 8/11/16.
 */

public class Team implements ListReady, Parcelable {
    private int img;
    private String name;
    private String city;
    private String web;

    /**
     * Img default, ya que que no podemos acceder a las carpetas Equipos tendremos que ir por
     * getResources().getIndentifiquer y pensamos que e smas facil hacerlo fuera de la clase.
     *
     */
    public Team() {
        img = R.drawable.nba_logo;
        name = "NBA Teams";
        city = "World";
        web = "http://www.google.com";
    }

    public Team(int img, String name, String city) {
        this.img = img;
        this.name = name;
        this.city = city;
        web = "http://www.google.com";
    }

    /**
     *
     * @param img R.id.IMAGEN
     * @param name Nombre del equipo
     * @param city Ciudad del equipo
     * @param primer_nombre Primer nombre del quipo
     */
    public Team(int img, String name, String city, String primer_nombre) {
        this.img = img;
        this.name = name;
        this.city = city;
        this.web = "http://global.nba.com/teams/#!/" + primer_nombre;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public String getWeb() { return web; };


    @Override
    public String toString() {
        return "Team{" +
                "img=" + img +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", web='" + web + '\'' +
                '}';
    }

    /* Responsabilidad del autogenerator de Parcelable */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.img);
        dest.writeString(this.name);
        dest.writeString(this.city);
        dest.writeString(this.web);
    }

    public Team(Parcel in) {
        this.img = in.readInt();
        this.name = in.readString();
        this.city = in.readString();
        this.web = in.readString();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}

