package es.iesnervion.apol.ejercicio512;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TeamDescription extends AppCompatActivity {
    private Team team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_description);
        Bundle extras = getIntent().getExtras();
        ImageView img = (ImageView) findViewById(R.id.imgCabecera);
        TextView title = (TextView) findViewById(R.id.titleTeam);
        TextView desc = (TextView) findViewById(R.id.descriptionTeam);

        if (extras == null) {
            Toast.makeText(this, "Error, extras null", Toast.LENGTH_LONG).show();
        } else {
            team = extras.getParcelable("class");
        }
        img.setImageResource(team.getImg());
        title.setText(team.getName().toString());
        desc.setText(team.getCity().toString());
    }
}
