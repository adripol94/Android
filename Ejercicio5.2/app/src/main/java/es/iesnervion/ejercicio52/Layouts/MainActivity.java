package es.iesnervion.ejercicio52.Layouts;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import es.iesnervion.ejercicio52.Fragments.DescriptionFragment;
import es.iesnervion.ejercicio52.Fragments.ListPlayers;
import es.iesnervion.ejercicio52.Fragments.ListTeams;
import es.iesnervion.ejercicio52.Models.Player;
import es.iesnervion.ejercicio52.Models.Team;
import es.iesnervion.ejercicio52.R;

public class MainActivity extends AppCompatActivity implements ListTeams.OnHeadTeamSelected, ListPlayers.OnHeadPlayerSelected{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * El {@link FloatingActionButton} será usado segun el fragment que vaomos a usar
     * si es Equipos estara {@code View.INVISIBLE} si es Jugadores se habilitara con
     * {@code View.VISIBLE}
     */
    private FloatingActionButton fab;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Edited Cambiar a false para eliminar el boton atras
         getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {


            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0)
                    fab.setVisibility(View.INVISIBLE);
                else
                    fab.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPlayerSelected(Player player) {

    }

    @Override
    public void onTeamSelected(Team team) {
        DescriptionFragment descriptionFragment = (DescriptionFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_descriptions);

        if (descriptionFragment != null) {

            descriptionFragment.updateDescriptionView(team);
        } else {
            DescriptionFragment newDescriptionFragment = new DescriptionFragment();

            Bundle args = new Bundle();
            args.putParcelable(DescriptionFragment.ARG_TEAM, team);

            newDescriptionFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_descriptions, newDescriptionFragment);

            //Añade a la pila el fragment
            transaction.addToBackStack(null);

            transaction.commit();
        }


    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

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

                if (getActivity().findViewById(R.id.fragment_team) != null) {


                    // Comprobamos si viene de un estado onStoped osea que sea la primera vez que se
                    // ejecuta o no

                    if (savedInstanceState != null)
                        return rootView;

                    // Creamos una instancia del fragment lista y lo añadimos en la actividad destinada
                    // para el movil.


                    ListTeams list = new ListTeams();
                    list.setArguments(getActivity().getIntent().getExtras());

                    // Con FragmentManager podremos interactuar entre el fragment_movil y la clase list
                    // gracias a esto pondremos todos las propiedades preparada de ese
                    // fragment en el fragment
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_team, list)
                            .commit();
                }

            } else {

                rootView = inflater.inflate(R.layout.fragment_players, container, false);

                ListPlayers list = new ListPlayers();
                list.setArguments(getActivity().getIntent().getExtras());

                // Con FragmentManager podremos interactuar entre el fragment_movil y la clase list
                // gracias a esto pondremos todos las propiedades preparada de ese
                // fragment en el fragment
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_players, list)
                        .commit();
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.title_activity_main_teams);
                case 1:
                    return getString(R.string.title_activity_main);
            }
            return null;
        }
    }
}
