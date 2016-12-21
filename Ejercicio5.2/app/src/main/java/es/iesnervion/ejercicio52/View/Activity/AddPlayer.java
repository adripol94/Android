package es.iesnervion.ejercicio52.View.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;


import es.iesnervion.ejercicio52.Models.Player;
import es.iesnervion.ejercicio52.R;

public class AddPlayer extends AppCompatActivity {
    public static final int ADDPLAYER_REQUEST = 1;
    private Player p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        p = new Player();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.putExtra(Player.PLAYER_KEY, p);
                setResult(RESULT_OK, it);
                finish();
            }
        });

        // OnClick...
        (findViewById(R.id.imagePlayer_iv)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(AddPlayer.this, GalleryPlayers.class);
                startActivityForResult(it, GalleryPlayers.GALLERYPLAYERS_REQUEST);
            }
        });

    }


    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == GalleryPlayers.GALLERYPLAYERS_REQUEST && resultCode == RESULT_OK) {
            int resourceImg = data.getExtras().getInt(GalleryPlayers.GALLERY_PHOTO_KEY);

            ((ImageView) findViewById(R.id.imagePlayer_iv)).setImageResource(resourceImg);
            p.setImg(resourceImg);
        }

    }
}
