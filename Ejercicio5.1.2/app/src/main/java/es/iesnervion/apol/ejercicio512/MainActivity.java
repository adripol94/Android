package es.iesnervion.apol.ejercicio512;

import android.app.ListActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class MainActivity extends ListActivity {

    private final int NUM_ETIQUETAS = 3; //IMPORTANT
    private Team[] teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            makeList();
            setListAdapter(new ListAdapter<Team>(this, R.layout.row, R.id.tittle, teams));
        } catch (ClassCastException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }

    private void makeList() {
        HashMap<String, String> array = jsonRead();
        teams = new Team[array.size() / NUM_ETIQUETAS]; //CAUTION size / 3
        String nameImg;
        int idResource;


        for (int i = 0; i < (array.size() / NUM_ETIQUETAS); i++) {
            idResource = getResources().getIdentifier(array.get("img" + i), "drawable", getPackageName());
            teams[i] = new Team(idResource, array.get("name" + i), array.get("city" + i));
        }
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

    /**
     * This method will be called when an item in the list is selected.
     * Subclasses should override. Subclasses can call
     * getListView().getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param l        The ListView where the click happened
     * @param v        The view that was clicked within the ListView
     * @param position The position of the view in the list
     * @param id       The row id of the item that was clicked
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Team selectedTeam = teams[position];
        Intent intent = new Intent(this, TeamDescription.class);
        intent.putExtra("class", selectedTeam);
        startActivity(intent);
    }
}