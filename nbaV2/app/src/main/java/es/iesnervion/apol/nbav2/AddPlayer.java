package es.iesnervion.apol.nbav2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class AddPlayer extends AppCompatActivity {
    private ImageView img;
    private static final int INICIOPESO = 150;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        img = (ImageView) findViewById(R.id.imgPlayer_addPlayer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Click metodo para cambiar la foto.
     * @param v
     */
    public void changePicture(View v) {
        Intent it = new Intent(AddPlayer.this, GalleryPlayer.class);
        startActivityForResult(it, 1);
    }

    /**
     * Carga los datos(opciones) del 150 a 250 para el Spinner y los mete
     */
    public void chargerSpinnerInt() {
        Spinner sp = (Spinner) findViewById(R.id.spPeso);

        for (int i=0; i < )


        sp.setAdapter(new ArrayAdapter<Integer>(this, R.layout.content_add_player, ));
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
        int r = data.getIntExtra("img", 1);
        img.setImageResource(r);
    }
}
