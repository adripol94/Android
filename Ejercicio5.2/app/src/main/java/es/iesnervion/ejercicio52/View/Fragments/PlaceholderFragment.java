package es.iesnervion.ejercicio52.View.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.iesnervion.ejercicio52.Models.PlayerManager;
import es.iesnervion.ejercicio52.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private PlayerManager manager;

    public PlaceholderFragment() {
    }


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber, PlayerManager manager) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putParcelable(PlayerManager.PLAYERMANAGER_NAME_KEY, manager);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Infla los frragments necesarios dependiendo de la posicion en la que este
     * por medio de {@value ARG_SECTION_NUMBER}.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = null;


        if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
            rootView = inflater.inflate(R.layout.fragment_teams, container, false);

            // Comprobación del tipo de pantalla en la que está, para ello llamamos a el fragment team
            // (el .xml que deberia de salir en caso de que sea un movil y si no esta nulo significa
            // que es un movil, si de lo contrario sale una table se iniciará el otro .xml de sw620dp

            if (rootView.findViewById(R.id.fragment_team_movil) != null) {


                // Comprobamos si viene de un estado onStoped osea que sea la primera vez que se
                // ejecuta o no

                if (savedInstanceState != null)
                    return rootView;

                // Creamos una instancia del fragment lista y lo añadimos en la actividad destinada
                // para el movil.


                ListTeams list = new ListTeams();
                Intent it = new Intent();
                it = getActivity().getIntent();

                if (manager != null)
                    it.putExtra(PlayerManager.PLAYERMANAGER_NAME_KEY, manager);

                list.setArguments(it.getExtras());

                // Con FragmentManager podremos interactuar entre el fragment_movil y la clase list
                // gracias a esto pondremos todos las propiedades preparada de ese
                // fragment en el fragment
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_team_movil, list)
                        .commit();
            }

        } else {

            rootView = inflater.inflate(R.layout.fragment_players, container, false);


            ListPlayers list = new ListPlayers();

            //TODO falla aqui...
            Intent it = getActivity().getIntent();

            if (manager != null) {
                it.putExtra(PlayerManager.PLAYERMANAGER_NAME_KEY, manager);
            }

            list.setArguments(it.getExtras());


            // Con FragmentManager podremos interactuar entre el fragment_movil y la clase list
            // gracias a esto pondremos todos las propiedades preparada de ese
            // fragment en el fragment
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_players, list)
                    .commit();
        }
        return rootView;
    }

    /**
     * Supply the construction arguments for this fragment.  This can only
     * be called before the fragment has been attached to its activity; that
     * is, you should call it immediately after constructing the fragment.  The
     * arguments supplied here will be retained across fragment destroy and
     * creation.
     *
     * @param args
     */
    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        manager = args.getParcelable(PlayerManager.PLAYERMANAGER_NAME_KEY);
    }
}

