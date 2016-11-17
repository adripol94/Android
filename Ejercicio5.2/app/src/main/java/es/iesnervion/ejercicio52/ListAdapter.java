package es.iesnervion.ejercicio52;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;



/**
 * Created by adripol94 on 11/8/16.
 */

public class ListAdapter<T> extends ArrayAdapter<T> {

    private Context context;
    private T[] obj;

    /***
     *
     * @param context
     * @param resource
     * @param textViewResourceId
     * @param objects
     * @throws ClassCastException
     */

    public ListAdapter(Context context, int resource, int textViewResourceId, T[] objects) throws ClassCastException {
        super(context, resource, textViewResourceId, objects);
        this.context = context;

        if (!(objects instanceof ListReady[])){
            throw new ClassCastException("Objeto no instaciado de ListAdapter");
        }

        this.obj = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View row = convertView;

        // Inflar el layput y inciar el ViewHolder
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            row = inflater.inflate(R.layout.row, parent, false);

            holder = new ViewHolder(row, R.id.image, R.id.tittle, R.id.desc);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        int listView = ((ListReady) obj[position]).getImg();
        // Poner los atributos del holder en el layout
        holder.getImgTeam().setImageResource(listView);
        holder.getTitle().setText(((ListReady) obj[position]).getName());
        holder.getDesc().setText(((ListReady) obj[position]).getCity());
        return row;
        //@IMPORTANT Error en AbsListView Motodo getSelectView sale Nulo!
        // El null pointer sale cuando quiere llamar a otro row y ya no tiene mas rows porque completó la lista.
    }
}
