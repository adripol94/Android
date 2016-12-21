package es.iesnervion.ejercicio52.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by adriol94 on 12/14/16.
 */

public class PlayerManager implements Parcelable {
    public static final String PLAYERMANAGER_NAME = "playerManager";
    public static final String PLAYERMANAGER_NAME_KEY = "playerManagerKey";

    private static final int MAXIMO = 10;
    private ArrayList<Player> p;

    public PlayerManager() {
        p = new ArrayList<>(MAXIMO);
    }

    public ArrayList<Player> getPlayers() {
        return p;
    }

    public Player getPlayer(int i) {
        return p.get(i);
    }


    public void addPlayer(Player player) throws PlayerException {
        if (p.size() >= MAXIMO)
            throw new PlayerException("Superado el maximo de jugadores permitidos");

        p.add(player);

    }

    public void removePlayer(int i) throws PlayerException {
        if (p.size() < i)
            throw new PlayerException("No se puede borrar dicho jugador");

        this.p.remove(i);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.p);
    }

    protected PlayerManager(Parcel in) {
        this.p = in.createTypedArrayList(Player.CREATOR);
    }

    public static final Creator<PlayerManager> CREATOR = new Creator<PlayerManager>() {
        @Override
        public PlayerManager createFromParcel(Parcel source) {
            return new PlayerManager(source);
        }

        @Override
        public PlayerManager[] newArray(int size) {
            return new PlayerManager[size];
        }
    };
}
