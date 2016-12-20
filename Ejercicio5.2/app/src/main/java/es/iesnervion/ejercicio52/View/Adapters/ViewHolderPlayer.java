package es.iesnervion.ejercicio52.View.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by adriol94 on 12/14/16.
 */

public class ViewHolderPlayer {
    private ImageView img;
    private TextView name;
    private TextView peso;
    private TextView altura;

    public ViewHolderPlayer(View cell,int img , int name, int peso, int altura) {
        this.img = (ImageView) cell.findViewById(img);
        this.name = (TextView) cell.findViewById(name);
        this.peso = (TextView) cell.findViewById(peso);
        this.altura = (TextView) cell.findViewById(altura);
    }

    public ImageView getImg() {
        return img;
    }

    public TextView getName() {
        return name;
    }

    public TextView getPeso() {
        return peso;
    }

    public TextView getAltura() {
        return altura;
    }
}
