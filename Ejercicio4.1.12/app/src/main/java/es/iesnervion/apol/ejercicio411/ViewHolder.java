package es.iesnervion.apol.ejercicio411;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by apol on 27/10/16.
 */

public class ViewHolder {
    TextView lab;
    ImageView img;

    ViewHolder (View row, int labId, int imgId){
        this.lab = (TextView) row.findViewById(labId);
        this.img = (ImageView) row.findViewById(imgId);
    }

    public TextView getLab (){
        return this.lab;
    }

    public ImageView getImg (){
        return this.img;
    }

    
}
