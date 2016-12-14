package es.iesnervion.ejercicio52.Layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import es.iesnervion.ejercicio52.R;
import es.iesnervion.ejercicio52.Models.Team;

/**
 * Esta clase pertence a {@link Team}
 *
 * Created by adriol94 on 12/14/16.
 */

public class TeamDescription extends AppCompatActivity {
    private Team team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_description);

        Bundle extras = getIntent().getExtras();
        ImageView img = (ImageView) findViewById(R.id.imgCabecera);
        TextView title = (TextView) findViewById(R.id.titleTeam);
        TextView desc = (TextView) findViewById(R.id.descriptionTeam);
        TextView link = (TextView) findViewById(R.id.linkTeam);

        if (extras == null) {
            Toast.makeText(this, "Error, extras null", Toast.LENGTH_LONG).show();
        }

        team = extras.getParcelable("class");

        img.setImageResource(team.getImg());
        title.setText(team.getName().toString());

        toolbar.setTitle(team.getName().toString()); //Añade al toolbar un nombre especifico(Nombre del equipo)
        link.setText(team.getWeb());
        desc.setText(team.getCity());

        Linkify.addLinks(link, Linkify.WEB_URLS); //Pone formato de nombre a url
    }
}
