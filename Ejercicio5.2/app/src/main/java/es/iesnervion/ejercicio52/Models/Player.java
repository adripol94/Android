package es.iesnervion.ejercicio52.Models;

import android.os.Parcel;
import android.os.Parcelable;

import es.iesnervion.ejercicio52.R;

/**
 * Created by adriol94 on 12/14/16.
 */

public class Player implements Parcelable{
    public static final String ALA_PIVOT = "Ala-Pivot";
    public static final String PIVOT = "Pivot";
    public static final String ALERO = "Alero";
    public static final String ESCOLTA = "Escolta";
    public static final String BASE = "Base";

    private int img;
    private String name;
    private int peso;
    private int altura;

    public Player() {
        this.img = R.drawable.not_found;
        this.name = "Default";
        this.altura = 0;
        this.peso = 0;
    }

    public Player(int img, String name, int peso, int altura) {
        this.img = img;
        this.name = name;
        this.altura = altura;
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.img);
        dest.writeString(this.name);
        dest.writeInt(this.peso);
        dest.writeInt(this.altura);
    }

    protected Player(Parcel in) {
        this.img = in.readInt();
        this.name = in.readString();
        this.peso = in.readInt();
        this.altura = in.readInt();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel source) {
            return new Player(source);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };
}
