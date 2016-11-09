package es.iesnervion.apol.ejercicio512;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
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
        HashMap<String, String> array = jsonRead();
        Team[] teams = new Team[array.size()];
        String nameImg;

        for (int i = 0; i < array.size() / 3; i++) {
            teams[i] = new Team(R.drawable.not_found, array.get("name" + i), array.get("city" + i));
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
                arrayHas.put("img" + i, objJSON.getString("abbreviation"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayHas;
    }


}