package es.iesnervion.ejercicio52;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by adripol94 on 11/8/16.
 */

public class ViewHolder {
    private ImageView imgTeam;
    private TextView title;
    private TextView desc;

    public ViewHolder(View row, int imgId, int titleId, int descId) {
        imgTeam = (ImageView) row.findViewById(imgId);
        title = (TextView) row.findViewById(titleId);
        desc = (TextView) row.findViewById(descId);
    }

    public ImageView getImgTeam() {
        return imgTeam;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDesc() {
        return desc;
    }
}
