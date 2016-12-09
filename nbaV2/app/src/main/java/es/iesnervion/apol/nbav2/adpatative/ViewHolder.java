package es.iesnervion.apol.nbav2.adpatative;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by apol on 9/12/16.
 */

public class ViewHolder {
    private ImageView imgView;

    public ViewHolder(View row, int imageSource) {
        imgView = (ImageView) row.findViewById(imageSource);
    }

    public ImageView getImgView() {
        return imgView;
    }
}
