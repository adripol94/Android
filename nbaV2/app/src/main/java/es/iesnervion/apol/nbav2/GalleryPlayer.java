package es.iesnervion.apol.nbav2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import es.iesnervion.apol.nbav2.adpatative.GalleryAdaptative;

public class GalleryPlayer extends AppCompatActivity {
    private Integer[] players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_player);

        GridView gv = (GridView) findViewById(R.id.Grid_Gallery_Player);
        chargerAllPicPlayer();
        gv.setAdapter(new GalleryAdaptative(this, R.layout.gallery_player_plantilla,
                R.id.plantilla_Gallery_player_Img, players));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent();
                it.putExtra("img", players[i]);
                setResult(AddPlayer.RESULT_OK, it);
                finish();
            }
        });
    }

    /**
     * Carga manual de las imagenes de los jugadores.
     */
    private void chargerAllPicPlayer() {
        players = new Integer[]{
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
        };


    }

}
