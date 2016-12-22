package es.iesnervion.ejercicio52.View.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
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

import es.iesnervion.ejercicio52.Models.PlayerException;
import es.iesnervion.ejercicio52.Models.PlayerManager;
import es.iesnervion.ejercicio52.View.Fragments.DescriptionFragment;
import es.iesnervion.ejercicio52.View.Fragments.ListPlayers;
import es.iesnervion.ejercicio52.View.Fragments.ListTeams;
import es.iesnervion.ejercicio52.Models.Player;
import es.iesnervion.ejercicio52.Models.Team;
import es.iesnervion.ejercicio52.R;
import es.iesnervion.ejercicio52.View.Fragments.PlaceholderFragment;

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

    /** Manejadora de {@link Player} */
    private PlayerManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Edited Cambiar a false para eliminar el boton atras
         getSupportActionBar().setDisplayHomeAsUpEnabled(false);



        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, AddPlayer.class);
                startActivityForResult(it, AddPlayer.ADDPLAYER_REQUEST);
            }
        });

    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        if (manager != null)
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), manager);
        else {
            manager = new PlayerManager();
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        }

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
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(PlayerManager.PLAYERMANAGER_NAME_KEY, manager);
        super.onSaveInstanceState(outState);
    }

    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == AddPlayer.ADDPLAYER_REQUEST && resultCode == RESULT_OK) {
            try {

                Player p = (Player) data.getExtras().get(Player.PLAYER_KEY);
                manager.addPlayer(p);

            } catch (ClassCastException | PlayerException e) {
                Snackbar.make(findViewById(R.id.main_content), e.getMessage(), Snackbar.LENGTH_LONG);
            }
        }
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
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     *
     * Antes estaba con {@link FragmentPagerAdapter} pero se ha cambiado a
     * {@link FragmentStatePagerAdapter}!!
     *
     * {@link FragmentPagerAdapter} no destruye el fragment pero {@link FragmentStatePagerAdapter}
     * si que destruye el fragment
     *
     * http://stackoverflow.com/questions/12581896/fragmentpageradapter-getitem-is-not-called
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
        private PlayerManager manager;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public SectionsPagerAdapter(FragmentManager fm, PlayerManager manager) {
            super(fm);
            this.manager = manager;

        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if (manager == null)
                return PlaceholderFragment.newInstance(position + 1);
            else
                return PlaceholderFragment.newInstance(position + 1, manager);
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
