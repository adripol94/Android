package es.iesnervion.apol.ejercicio512;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apol on 8/11/16.
 */

public class Team implements ListReady, Parcelable {
    private int img;
    private String name;
    private String city;

    public Team() {
        img = R.drawable.not_found;
        name = "Default";
        city = "Default";
    }

    public Team(int img, String name, String city) {
        this.img = img;
        this.name = name;
        this.city = city;
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

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

//    public int describeContents() {
//        return 0;
//    }
//
//    public void writeToParcel(Parcel out, int flags) {
//        out.writeInt(mData);
//    }
//
//    public static final Parcelable.Creator<Team> CREATOR
//            = new Parcelable.Creator<Team>() {
//        public Team createFromParcel(Parcel in) {
//            return new Team(in);
//        }
//
//        public Team[] newArray(int size) {
//            return new Team[size];
//        }
//    };
//
//    private Team(Parcel in) {
//        mData = in.readInt();
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.img);
        dest.writeString(this.name);
        dest.writeString(this.city);
    }

    protected Team(Parcel in) {
        this.img = in.readInt();
        this.name = in.readString();
        this.city = in.readString();
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

