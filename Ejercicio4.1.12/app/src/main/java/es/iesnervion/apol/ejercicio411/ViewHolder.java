package es.iesnervion.apol.ejercicio411;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by apol on 27/10/16.
 */

public class ViewHolder {
    TextView lab;
    TextView account;
    ImageView img;
    TextView desc;
    View row;

    ViewHolder (View row, int labId, int imgId, int descId, int accountId){
        this.lab = (TextView) row.findViewById(labId);
        this.img = (ImageView) row.findViewById(imgId);
        this.desc = (TextView) row.findViewById(descId);
        this.account = (TextView) row.findViewById(accountId);
        this.row = row;
    }

    public TextView getLab (){
        return this.lab;
    }

    public ImageView getImg (){
        return this.img;
    }
    public TextView getDesc() { return this.desc; }
    public TextView getAccount() { return this.account; }

    public View getRow() {
        return row;
    }


}
