package es.iesnervion.travelapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adriol94 on 1/11/17.
 */

public class CardView implements Parcelable {
    public int img;
    public String name;

    public CardView(String name, int img) {
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

    protected CardView(Parcel in) {
        this.img = in.readInt();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<CardView> CREATOR = new Parcelable.Creator<CardView>() {
        @Override
        public CardView createFromParcel(Parcel source) {
            return new CardView(source);
        }

        @Override
        public CardView[] newArray(int size) {
            return new CardView[size];
        }
    };
}
