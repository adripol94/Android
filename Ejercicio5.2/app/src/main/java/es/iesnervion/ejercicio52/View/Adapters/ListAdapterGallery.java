package es.iesnervion.ejercicio52.View.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import es.iesnervion.ejercicio52.R;


/**
 * Created by apol on 9/12/16.
 */

public class ListAdapterGallery extends ArrayAdapter<Integer>{
    private Context c;
    private Integer[] player;

    /**
     * Lista preparada para seleccionar las fotos de los jugadores
     * @param context
     * @param resource
     * @param objects
     */
    public ListAdapterGallery(Context context, int resource, Integer[] objects) {
        super(context, resource, objects);
        this.player = objects;
        this.c = context;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolderGallery vh;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            row = inflater.inflate(R.layout.content_gallery_player_row, parent, false);

            vh = new ViewHolderGallery(row, R.id.imagePlayer_galleryView_iv);
            row.setTag(vh);
        } else {
            vh = (ViewHolderGallery) row.getTag();
        }

        vh.getImgView().setImageResource(player[position]);

        return row;
    }
}
