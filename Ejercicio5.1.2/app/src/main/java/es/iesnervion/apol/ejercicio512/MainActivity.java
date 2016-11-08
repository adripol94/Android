package es.iesnervion.apol.ejercicio512;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            setListAdapter(new ListAdapter<Team>(this, R.layout.row, R.id.tittle, list()));
        } catch (ClassCastException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private Team[] list() {
        Team[] equipos = {
                new Team(),
                new Team(),
                new Team(),
                new Team(),
                new Team(),
                new Team(),
                new Team(),
                new Team()
        };

        return equipos;
    }

    public void jsonRead() {
        JSONObject readerJSON = new JSONObject();

    }



}