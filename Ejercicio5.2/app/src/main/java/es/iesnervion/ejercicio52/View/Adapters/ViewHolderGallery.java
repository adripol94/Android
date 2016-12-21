package es.iesnervion.ejercicio52.View.Adapters;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by apol on 9/12/16.
 */

public class ViewHolderGallery {
    private ImageView imgView;

    public ViewHolderGallery(View row, int imageSource) {
        imgView = (ImageView) row.findViewById(imageSource);
    }

    public ImageView getImgView() {
        return imgView;
    }
}
