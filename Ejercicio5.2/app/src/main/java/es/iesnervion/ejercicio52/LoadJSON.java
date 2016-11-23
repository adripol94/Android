package es.iesnervion.ejercicio52;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;


/**
 * Created by apol on 9/11/16.
 */

public class LoadJSON {
    private JSONObject obj;
    private Context c;
    private String name;
    private final int NUM_ETIQUETAS = 4; //IMPORTANT

    public LoadJSON(Context c, String nameJSON) {
        obj = null;
        this.c = c;
        this.name = nameJSON;
        getJsonObj();

    }

    private void getJsonObj() {
        try {

            obj = new JSONObject(loadJSONfromAsset());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJSONfromAsset() {
        InputStream inputStream;
        int size;
        String json = null;

        try {
            AssetManager manager = c.getAssets();
            inputStream = manager.open(name);
            size = inputStream.available();
            byte[] buffer = new byte[size];

            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }



    public JSONObject getObjJSON() {
        JSONObject object = obj;
        return  object;
    }


    //TODO Comentar!
    public Team[] getListArray(String nameArray) {


        HashMap<String, String> array = jsonRead(nameArray);
        Team[] teams = new Team[array.size() / NUM_ETIQUETAS]; //CAUTION size / 4
        int idResource;

        for (int i = 0; i < (array.size() / NUM_ETIQUETAS); i++) {
            idResource = c.getResources().getIdentifier(array.get("img" + i), "drawable", c.getPackageName());
            teams[i] = new Team(idResource, array.get("name" + i), array.get("city" + i), array.get("first" + i));
        }
        return teams;
    }

    //TODO Comentar!
    /**
     * Make a list reding the json and parsing it to array of teams.
     */
    public HashMap jsonRead(String nameArray) {
        JSONObject objJSON;
        JSONArray array = arrayToJsonArray(nameArray);
        HashMap<String, String> arrayHas = new HashMap<String, String>();

        try {

            for (int i = 0; i < array.length(); i++) {
                objJSON = array.getJSONObject(i);
                arrayHas.put("name" + i, objJSON.getString("full_name"));
                arrayHas.put("city" + i, objJSON.getString("city"));
                arrayHas.put("img" + i, objJSON.getString("abbreviation").toLowerCase());
                arrayHas.put("first" + i, objJSON.getString("last_name"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayHas;
    }

    /**
     * [CAUTION: Can return a null]. Devuelte un objeto JSONArray
     * @param arrayName
     * @return
     */
    public JSONArray arrayToJsonArray(String arrayName) {
        JSONArray array = null;
        try {
            array = obj.getJSONArray(arrayName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }


}
