package es.iesnervion.ejercicio52.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import es.iesnervion.ejercicio52.Models.Team;
import es.iesnervion.ejercicio52.R;


/**
 * Created by adripol94 on 11/8/16.
 */

public class ListAdapterTeam extends ArrayAdapter {

    private Context context;
    private Team[] obj;

    /***
     *
     * @param context
     * @param resource
     * @param objects
     * @throws ClassCastException
     */

    public ListAdapterTeam(Context context, int resource, Team[] objects) throws ClassCastException {
        super(context, resource, objects);
        this.context = context;
        this.obj = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderTeam holder;
        View row = convertView;

        // Inflar el layput y inciar el ViewHolderTeam
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            row = inflater.inflate(R.layout.content_teams_row, parent, false);

            holder = new ViewHolderTeam(row, R.id.image, R.id.tittle, R.id.desc);
            row.setTag(holder);
        } else {
            holder = (ViewHolderTeam) row.getTag();
        }

        int listView = obj[position].getImg();

        // Poner los atributos del holder en el layout
        holder.getImgTeam().setImageResource(listView);
        holder.getTitle().setText(obj[position].getName());
        holder.getDesc().setText(obj[position].getCity());
        return row;
    }
}
