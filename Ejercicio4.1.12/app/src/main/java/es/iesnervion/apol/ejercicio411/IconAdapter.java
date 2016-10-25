package es.iesnervion.apol.ejercicio411;

import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by apol on 25/10/16.
 */

public class IconAdapter<T> extends ArrayAdapter<T> {
    View row;
    ViewHolder holder;
    Team[] items;

    /**
     * Constructor
     *
     * @param context            The current context.
     * @param resource           The resource ID for a layout file containing a layout to use when
     *                           instantiating views.
     * @param textViewResourceId The id of the TextView within the layout resource to be populated
     * @param objects            The objects to represent in the ListView.
     */
    public IconAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        super(context, resource, textViewResourceId, objects);
        this.items = (Team[]) objects;
    }

    public View getView(int pos, View convertView, ViewGroup parent, Context context) {
        boolean find = false;
        row = convertView;

        if (row == null) {
            LayoutInflater inflater=  (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row, parent, false);

            holder = new ViewHolder(row, R.id.head, R.id.img);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        holder.getLab().setText(items[pos].getNombreCompleto());
        holder.getImg().setImageResource(items[pos].getFotoPerfil());
        return row;
    }
}
