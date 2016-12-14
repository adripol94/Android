package es.iesnervion.ejercicio52.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import es.iesnervion.ejercicio52.Models.Player;
import es.iesnervion.ejercicio52.Models.Team;
import es.iesnervion.ejercicio52.R;

/**
 * Created by adriol94 on 12/14/16.
 */

public class ListAdapterPlayer extends ArrayAdapter{
    private Context context;

    public ListAdapterPlayer(Context context, int resource, Object[] objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View cell = convertView;
        ViewHolderPlayer vh;

        Object obj = getItem(position);


        if (obj instanceof Player) {

            Player player = (Player) obj;

            if (cell == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                cell = inflater.inflate(R.layout.row_player_list, parent, false);

                vh = new ViewHolderPlayer(cell, R.id.imagePlayer, R.id.tittlePlayer, R.id.pesoPlayer,
                        R.id.alturaPlayer);
                cell.setTag(vh);
            } else {
                vh = (ViewHolderPlayer) cell.getTag();
            }

            vh.getImg().setImageResource(player.getImg());
            vh.getName().setText(player.getName());
            vh.getAltura().setText(player.getAltura());
            vh.getPeso().setText(player.getPeso());

        } else {

            Team team = (Team) obj;

            if (cell == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                cell = inflater.inflate(R.layout.row_player_list, parent, false);

                vh = new ViewHolderPlayer(cell, R.id.imagePlayer, R.id.tittlePlayer, R.id.pesoPlayer,
                        R.id.alturaPlayer);
                cell.setTag(vh);
            } else {
                vh = (ViewHolderPlayer) cell.getTag();
            }

            vh.getImg().setImageResource(team.getImg());
            vh.getName().setText(team.getName());
            vh.getAltura().setText(team.getCity());
        }

        return cell;
    }
}
