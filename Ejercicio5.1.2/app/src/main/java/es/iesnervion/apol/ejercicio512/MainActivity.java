package es.iesnervion.apol.ejercicio512;

import android.app.ListActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class MainActivity extends ListActivity {

    private final int NUM_ETIQUETAS = 3; //IMPORTANT

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
        HashMap<String, String> array = jsonRead();
        Team[] teams = new Team[array.size() / NUM_ETIQUETAS]; //CAUTION size / 3
        String nameImg;
        int idResource;


        for (int i = 0; i < (array.size() / NUM_ETIQUETAS); i++) {
            idResource = getResources().getIdentifier(array.get("img" + i), "drawable", getPackageName());
            teams[i] = new Team(idResource, array.get("name" + i), array.get("city" + i));
        }

        return teams;
    }

    public HashMap jsonRead() {
        JSONObject objJSON;
        LoadJSON json = new LoadJSON(this, "nba.json");
        JSONArray array = json.getArray("Teams");
        HashMap<String, String> arrayHas = new HashMap<String, String>();

        try {

            for (int i = 0; i < array.length(); i++) {
                objJSON = array.getJSONObject(i);
                arrayHas.put("name" + i, objJSON.getString("full_name"));
                arrayHas.put("city" + i, objJSON.getString("city"));
                arrayHas.put("img" + i, objJSON.getString("abbreviation").toLowerCase());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayHas;
    }

}