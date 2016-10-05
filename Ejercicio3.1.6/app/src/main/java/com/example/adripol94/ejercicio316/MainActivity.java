package com.example.adripol94.ejercicio316;

/*
Crea una aplicaciÛn con una imagen que al ser pulsada se cambie por otra.
Por ejemplo, una imagen de un altavoz y otra de un altavoz tachado...
 */


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int MAXIMO_IMG = 200;
    private ImageView img;
    private Button bt;
    private EditText et;
    private String path;
    private File f;
    private Bitmap bitmap[];
    private int c; // C OF COUNT!!!! @IMPORTANT

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = 0; //@IMPORTANT C TO 0!!!

        bt = (Button) findViewById(R.id.bt_action);
        et = (EditText) findViewById(R.id.pathImg);
        img = (ImageView) findViewById(R.id.img);
        img.setOnClickListener(this);
    }


    public void showImages(View v) {
        if (et.getVisibility() == View.VISIBLE) {

            path = et.getText().toString();
            f = new File("/sdcard/" + path);

            try {
                chargerBitmap();
                et.setVisibility(View.INVISIBLE);
                img.setVisibility(View.VISIBLE);

            } catch (OutSidePermittedRangeException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        } else {
            et.setVisibility(View.VISIBLE);
            img.setVisibility(View.INVISIBLE);
        }

    }

    private void chargerBitmap() throws OutSidePermittedRangeException {
        File file[];

        /* Se que deberia de comprobar primero el numero de archivos antes de siquiera crear el array pero no sé como hacerlo */
        /* @IMPORTANT FILENAME Comprueba si tiene extension jpg */
        file = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                boolean isAccepted = false;

                 if (name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg")) {
                     isAccepted = true;
                 }
                return isAccepted;
            }
        });

        if (file.length> MAXIMO_IMG)
            throw new OutSidePermittedRangeException("Tiene demasiadas imagenes");


        if (f.exists()) {

            bitmap = new Bitmap[file.length];

            for (int i = 0 ; i < file.length ; i++) {
                bitmap[i] = BitmapFactory.decodeFile(file[i].getAbsolutePath());
            }

            Toast.makeText(this, "All pictures Loaded", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Sorry, web can't finde a folder: " + path, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if ( c == bitmap.length ) {
            c = 0;
        }
        img.setImageBitmap(bitmap[c]);
        c++;

    }
}
