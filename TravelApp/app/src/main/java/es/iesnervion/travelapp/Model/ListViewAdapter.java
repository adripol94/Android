package es.iesnervion.travelapp.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import es.iesnervion.travelapp.R;

/**
 * Created by adriol94 on 1/11/17.
 */

public class ListViewAdapter extends ArrayAdapter<CardViewObj> {
    private Context c;

    public ListViewAdapter(Context context, int resource, CardViewObj[] objects) {
        super(context, resource, objects);
        c = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem vh;
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.style_recyclerview, parent, false);

            vh = new ViewHolderItem(row, R.id.textView_style_cardView, R.id.relativeLayout_style_cardView);
            row.setTag(vh);
        } else {
            vh = (ViewHolderItem) row.getTag();
        }

        vh.getTextView().setText(getItem(position).name);
        vh.relativeLayout.setBackgroundResource(getItem(position).img);

        return row;
    }


    public class ViewHolderItem {
        private TextView textView;
        private RelativeLayout relativeLayout;

        public ViewHolderItem(View v, int textViewId, int relativeLayoutId) {
            textView = (TextView) v.findViewById(textViewId);
            relativeLayout = (RelativeLayout) v.findViewById(relativeLayoutId);
        }

        public TextView getTextView(){
            return textView;
        }

        public RelativeLayout getRelativeLayout(){
            return relativeLayout;
        }
    }
}
