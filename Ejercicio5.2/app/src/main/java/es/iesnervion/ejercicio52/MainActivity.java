package es.iesnervion.ejercicio52;

import android.app.ListActivity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends ListActivity {
    private Team[] teams;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle(R.string.app_name);
        // Cambiar el color de la letra del toolbar por aquí, de otra forma no se llega a cambiar!
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));

        // Carga el JSON
        teams = new LoadJSON(this, "nba.json").getListArray("Teams");

        // Comprobación del tipo de pantalla en la que está, para ello llamamos a el fragment movil
        // (el .xml que deberia de salir en caso de que sea un movil y si no esta nulo significa
        // que es un movil, si de lo contrario sale una table se iniciará el otro .xml de sw620dp

        if (findViewById(R.id.fragment_movil) != null) {


            // Comprobamos si viene de un estado onStoped osea que sea la primera vez que se
            // ejecuta o no

            if (savedInstanceState != null)
                return;

            // Creamos una instancia del fragment lista y lo añadimos en la actividad destinada
            // para el movil.
            //TODO Crear instancia y instanciarlo

            try {
                ListTeamsFragment list = new ListTeamsFragment().newInstance(teams);
            } catch (ClassCastException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }

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