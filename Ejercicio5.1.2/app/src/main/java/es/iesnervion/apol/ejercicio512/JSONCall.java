package es.iesnervion.apol.ejercicio512;

import android.support.annotation.NonNull;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by adripol94 on 11/8/16.
 * @IMPORTAN
 * Based in: http://www.androidhive.info/2012/01/android-json-parsing-tutorial/
 */

/***
 * No constructor declarado.
 */
public class JSONCall {


    /***
     * Hace una llamada pasando reqUrl a obj URL, crear la conexion y declararla como metodo GET,
     * llamar a metodo converStreamToString
     * @param reqUrl String url of request
     * @return String
     */
    public String makeCall(String reqUrl) {
        String answer = null;

        try {
            URL url = new URL(reqUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // METODH TO CALL: GET

            InputStream stream = new BufferedInputStream(connection.getInputStream());
            answer = convertStreamToString(stream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return answer;
    }

    /***
     * Lee todas las lineas hasta llegar a nulo, haciendole un append de cada linea del json.
     * @param is InputStream
     * @return String answer
     */
    @NonNull
    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
