package es.iesnervion.ejercicio52;


/**
 * //TODO Terminar la clase
 * Created by adripol94 on 11/23/16.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;


// Ya que se tratat de una lista tenemos que añadir la libreria de ListFragment

public class ListTeamsFragment extends ListFragment {
    private Team[] t;

    private OnHeadSelectedListener mClaaBack;

    /**
     * Interfaz diseñada para implementar que la clase escuche cuando se le clickea a una opc de la lista
     * Created by adripol94 on 11/23/16.
     */

    public interface OnHeadSelectedListener {
        public void onArticleSelected(int position);
    }


    /** OPC: 1 ERROR;
    public ListTeamsFragment(Team[] t) {

    } **/
    
    /** OPC: 2 (http://stackoverflow.com/questions/17422111/how-to-avoid-non-default-constructors-in-fragments) **/
    public static ListTeamsFragment newInstance(Team[] t) {
        Bundle args = new Bundle();
        
        ListTeamsFragment fragment = new ListTeamsFragment();
        args.putParcelableArray("teams", t);
        fragment.setArguments(args);
        return fragment;
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

        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        // Recoger el valor por el bundle que se le introdujo desde newInstance
        if (getArguments() != null) {
            t = (Team[]) getArguments().getParcelableArray("teams");
        }

        // Crear la lista
        setListAdapter(new ListAdapter<Team>(getActivity(), R.layout.row, R.id.tittle, t));
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
    }



    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to {@link Activity#onStart() Activity.onStart} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStart() {
        super.onStart();
    }



}