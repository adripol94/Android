package es.iesnervion.apol.ejercicio512;

import android.content.Context;
import android.view.View;

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

    public LoadJSON(Context c) {
        obj = null;
        this.c = c;
        getJsonObj();

    }

    private String loadJSONfromAsset(Context c) {
        InputStream inputStream;
        int size;
        String json = null;

        try {
            inputStream = c.getAssets().open("nba.json");
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
            obj = new JSONObject(loadJSONfromAsset(c));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getObjJSON() {
        JSONObject object = obj;
        return  object;
    }


}
