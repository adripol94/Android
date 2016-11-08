package es.iesnervion.apol.ejercicio411;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import es.iesnervion.apol.ejercicio411.Account.Account;

/**
 * Created by apol on 27/10/16.
 */

public class IconAdapter<T> extends ArrayAdapter<T> {
    private Context c;
    private Account[] obj;

    IconAdapter(Context c, int resourceId, int textId, T[] objects) throws ClassCastException{
        super(c, resourceId, textId, objects);
        this.c = c;

        if (!(objects instanceof Account[])) {
            throw new ClassCastException("ERROR: El objeto especificado no se pudo castear para su uso");
        }
        this.obj = (Account[]) objects;

    }

    public int getViewTypeCount() {
        return 2;
    }

    public int getItemViewType(int position)  {
        return position % 2;
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {

        View row = convertView;
        ViewHolder holder;
        String nameClass;
        RelativeLayout.LayoutParams params;

        if (row==null){
            LayoutInflater inflater= (LayoutInflater) c.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

            if (getItemViewType(position) == 0) {
                row = inflater.inflate(R.layout.row, parent, false);
            } else {
                row = inflater.inflate(R.layout.row_grey, parent, false);
            }

            holder = new ViewHolder(row,R.id.label,R.id.icon, R.id.desc, R.id.accountName);
            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();
        }

        holder.getLab().setText(obj[position].getName());
        holder.getImg().setImageResource(obj[position].getIcon());
        holder.getDesc().setText(obj[position].getEmail());
        holder.getAccount().setText(obj[position].getAccount());

        return(row);
    }
}
