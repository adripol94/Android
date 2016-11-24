package es.iesnervion.ejercicio52;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * TODO Terminar!
 * Created by adripol94 on 11/23/16.
 */

public class DescriptionFragment extends Fragment {
    final static String ARG_TEAM = "team";
    private Team mTeamActual = null;

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Comprobamos que no haya instancia, que no venga de un onStop, de ser así lo recogemos
        if (savedInstanceState != null) {
            mTeamActual = savedInstanceState.getParcelable(ARG_TEAM);
        }

        // Inflamos la vista y la devolvemos
        return inflater.inflate(R.layout.content_team_description, container, false);
    }

    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to {@link Activity#onStart() Activity.onStart} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStart() {
        super.onStart();

        // Comprobamos que no venga ningun argumento y lo recogemos
        Bundle args = getArguments();

        if (args != null) {
            updateDescriptionView(args.getParcelable(ARG_TEAM));
        } else if (mTeamActual != null) {
            updateDescriptionView(mTeamActual);
        }
    }

    /**
     * Called to ask the fragment to save its current dynamic state, so it
     * can later be reconstructed in a new instance of its process is
     * restarted.  If a new instance of the fragment later needs to be
     * created, the data you place in the Bundle here will be available
     * in the Bundle given to {@link #onCreate(Bundle)},
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}, and
     * {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>This corresponds to {@link Activity#onSaveInstanceState(Bundle)
     * Activity.onSaveInstanceState(Bundle)} and most of the discussion there
     * applies here as well.  Note however: <em>this method may be called
     * at any time before {@link #onDestroy()}</em>.  There are many situations
     * where a fragment may be mostly torn down (such as when placed on the
     * back stack with no UI showing), but its state will not be saved until
     * its owning activity actually needs to save its state.
     *
     * @param outState Bundle in which to place your saved state.
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Para guardar la instancia guardamos el objeto en si
        outState.putParcelable(ARG_TEAM, mTeamActual);
    }

    private void updateDescriptionView(Parcelable team) {
        Team t = (Team) team;

        ImageView img = (ImageView) getActivity().findViewById(R.id.imgCabecera);
        TextView title = (TextView) getActivity().findViewById(R.id.titleTeam);
        TextView desc = (TextView) getActivity().findViewById(R.id.descriptionTeam);
        TextView link = (TextView) getActivity().findViewById(R.id.linkTeam);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_description);

        img.setImageResource(t.getImg());
        title.setText(t.getName());
        desc.setText(t.getCity());


        toolbar.setTitle(t.getName().toString()); //Añade al toolbar un nombre especifico(Nombre del equipo)
        link.setText(t.getWeb());
        desc.setText(t.getCity());

        Linkify.addLinks(link, Linkify.WEB_URLS); //Pone formato de nombre a url
    }
}
