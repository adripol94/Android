package es.iesnervion.ejercicio52.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import es.iesnervion.ejercicio52.Adapters.ListAdapterPlayer;
import es.iesnervion.ejercicio52.Models.Player;
import es.iesnervion.ejercicio52.Models.PlayerManager;
import es.iesnervion.ejercicio52.R;

/**
 * Created by adriol94 on 12/14/16.
 */

public class ListPlayers extends ListFragment {
    private PlayerManager manager;

    private OnHeadPlayerSelected mCallBack;

    public interface OnHeadPlayerSelected {
        public void onPlayerSelected(Player player);
    }

    /**
     * Called to do initial creation of a fragment.  This is called after
     * {@link #onAttach(Activity)} and before
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * <p>
     * <p>Note that this can be called while the fragment's activity is
     * still in the process of being created.  As such, you can not rely
     * on things like the activity's content view hierarchy being initialized
     * at this point.  If you want to do work once the activity itself is
     * created, see {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>Any restored child fragments will be created before the base
     * <code>Fragment.onCreate</code> method returns.</p>
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            manager = new PlayerManager();
        } else {
            manager = savedInstanceState.getParcelable(PlayerManager.PLAYERMANAGER_NAME);
        }

        if (manager.getPlayers().length > 1)
            setListAdapter(new ListAdapterPlayer(getContext(), R.layout.row_player_list, manager.getPlayers()));
    }


    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to {@link Activity#onStart() Activity.onStart} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStart() {
        super.onStart();

        // Comprobamos si el segundo fragment es nullo, de no ser así se indicará que estamos en una
        // tablet
        // De ser así indicaremos con CHOICE_MODE_SINGLE que se quedará seleccionada en la lista
        // la opcion seleccionada.
        if (getFragmentManager().findFragmentById(R.id.fragment_descriptions) != null) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }

    }

    /**
     * Called when a fragment is first attached to its context.
     * {@link #onCreate(Bundle)} will be called after this.
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Castear el context, de no poder saltará la excepcion
        try {
            mCallBack = (OnHeadPlayerSelected) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("No implementado OnHeadSelectedListener into MainActivity" +
                    "or Activity lunch :( "
                    + e.getMessage() + ")");
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
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        mCallBack.onPlayerSelected(manager.getPlayer(position));

        getListView().setItemChecked(position, true);
    }
}
