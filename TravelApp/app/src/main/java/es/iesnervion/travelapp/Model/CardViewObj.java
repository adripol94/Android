package es.iesnervion.travelapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adriol94 on 1/11/17.
 */

public class CardViewObj implements Parcelable {
    public int img;
    public String name;

    public CardViewObj(String name, int img) {
        this.img = img;
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.img);
        dest.writeString(this.name);
    }

    protected CardViewObj(Parcel in) {
        this.img = in.readInt();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<CardViewObj> CREATOR = new Parcelable.Creator<CardViewObj>() {
        @Override
        public CardViewObj createFromParcel(Parcel source) {
            return new CardViewObj(source);
        }

        @Override
        public CardViewObj[] newArray(int size) {
            return new CardViewObj[size];
        }
    };
}
