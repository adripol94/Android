package es.iesnervion.apol.ejercicio411;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

/**
 * Created by apol on 27/10/16.
 */

public class IconAdapter<T> extends ArrayAdapter<T> {
    private Context c;
    private ListReady[] obj;

    IconAdapter(Context c, int resourceId, int textId, T[] objects) throws ClassCastException{
        super(c, resourceId, textId, objects);
        this.c = c;

        if (!(objects instanceof ListReady[])) {
            throw new ClassCastException("ERROR: El objeto especificado no se pudo castear para su uso");
        }
        this.obj = (ListReady[]) objects;

    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {

        View row = convertView;
        ViewHolder holder;

        if (row==null){
            LayoutInflater inflater= (LayoutInflater) c.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            row=inflater.inflate(R.layout.row, parent, false);

            holder = new ViewHolder (row,R.id.label,R.id.icon);
            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();
        }

        holder.getLab().setText(obj[position].getName());
        holder.getImg().setImageResource(obj[position].getImg());
        if (position % 2 == 0) {

        }

        return(row);
    }
}
