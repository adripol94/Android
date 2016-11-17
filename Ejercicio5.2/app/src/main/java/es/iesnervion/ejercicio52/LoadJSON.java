package es.iesnervion.ejercicio52;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by apol on 9/11/16.
 */

public class LoadJSON {
    private JSONObject obj;
    private Context c;
    private String name;

    public LoadJSON(Context c, String nameJSON) {
        obj = null;
        this.c = c;
        this.name = nameJSON;
        getJsonObj();

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

    private void getJsonObj() {
        try {

            obj = new JSONObject(loadJSONfromAsset());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getObjJSON() {
        JSONObject object = obj;
        return  object;
    }

    /**
     * [CAUTION: Can return a null]. Devuelte un objeto JSONArray
     * @param arrayName
     * @return
     */
    public JSONArray getArray(String arrayName) {
        JSONArray array = null;
        try {
            array = obj.getJSONArray(arrayName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }

}
