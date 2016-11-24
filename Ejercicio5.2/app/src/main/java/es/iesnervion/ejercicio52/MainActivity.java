package es.iesnervion.ejercicio52;

import android.app.ListActivity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


//ATC: FragmentActivity extendida!!!!!!!!!!!!!!!!!

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle(R.string.app_name);
        // Cambiar el color de la letra del toolbar por aquí, de otra forma no se llega a cambiar!
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));

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

            try {
                ListTeamsFragment list = new ListTeamsFragment();

                // Hereda setArguments desde Fragment
                list.setArguments(getIntent().getExtras());

                // Con FragmentManager podremos interactuar entre el fragment_movil y la clase list
                // gracias a esto pondremos todos las propiedades preparada de ese
                // fragment en el fragment
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_movil, list)
                        .commit();

            } catch (ClassCastException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onTeamSelected(Team team) {
        //TODO Terminar!!! : Depende de DescriptionFragment


    }
}