package es.iesnervion.salvavidas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        (findViewById(R.id.juagar_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inflado del fragment

                // Create a new Fragment to be placed in the activity layout
                Intent it = new Intent(MainActivity.this, ActionActivity.class);
                it.putExtra("Fragment", 1);
                startActivity(it);
            }
        });

        (findViewById(R.id.estadisticas)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ActionActivity.class);
                it.putExtra("Fragment", 2);
                startActivity(it);
            }
        });
    }
}
