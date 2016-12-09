package es.iesnervion.apol.nbav2.adpatative;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import es.iesnervion.apol.nbav2.Jugador;
import es.iesnervion.apol.nbav2.R;

/**
 * Created by apol on 9/12/16.
 */

public class GalleryAdaptative extends ArrayAdapter<Integer>{
    private Context c;
    private Integer[] player;

    public GalleryAdaptative(Context context, int resource, int textViewResourceId, Integer[] objects) {
        super(context, resource, textViewResourceId, objects);
        this.player = objects;
        this.c = context;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder vh;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            row = inflater.inflate(R.layout.gallery_player_plantilla, parent, false);

            vh = new ViewHolder(row, R.id.plantilla_Gallery_player_Img);
            row.setTag(vh);
        } else {
            vh = (ViewHolder) row.getTag();
        }

        vh.getImgView().setImageResource(player[position]);

        return row;
    }
}
