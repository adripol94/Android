package es.iesnervion.ejercicio52.View.Activity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import es.iesnervion.ejercicio52.R;
import es.iesnervion.ejercicio52.View.Adapters.ListAdapterGallery;

public class GalleryPlayers extends AppCompatActivity {
    public static final int GALLERYPLAYERS_REQUEST = 2;
    public static final String GALLERY_PHOTO_KEY = "foto";

    //Restablecer por un metodo

    private static final Integer[] IMG_PLAYERS = {
            R.drawable.jugador00,
            R.drawable.jugador01,
            R.drawable.jugador02,
            R.drawable.jugador03,
            R.drawable.jugador04,
            R.drawable.jugador05,
            R.drawable.jugador06,
            R.drawable.jugador07,
            R.drawable.jugador08,
            R.drawable.jugador09,
            R.drawable.jugador10,
            R.drawable.jugador11,
            R.drawable.jugador12,
            R.drawable.jugador13,
            R.drawable.jugador14,
            R.drawable.jugador15,
            R.drawable.jugador16,
            R.drawable.jugador17,
            R.drawable.jugador18,
            R.drawable.jugador19,
            R.drawable.jugador20,
            R.drawable.jugador21,
            R.drawable.jugador22,
            R.drawable.jugador23,
            R.drawable.jugador24,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_players);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView galleryPlayer_gv = (GridView) findViewById(R.id.galleryImg_gv);


        galleryPlayer_gv.setAdapter(new ListAdapterGallery(this, R.layout.content_gallery_player_row
        , IMG_PLAYERS));

        galleryPlayer_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent();
                it.putExtra(GALLERY_PHOTO_KEY, IMG_PLAYERS[i]);

                setResult(RESULT_OK, it);
                finish();
            }
        });

    }

}
