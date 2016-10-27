package es.iesnervion.apol.ejercicio411;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;
import static es.iesnervion.apol.ejercicio411.R.layout.activity_main;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    TextView selection;
    private static final Team[] items={
            new Team("adasdds", "jajaj", R.drawable.grey),
            new Team("adasdds", "jajaj", R.drawable.grey),
            new Team("adds", "jajaj", R.drawable.grey),
            new Team("adds", "jajaj", R.drawable.grey),
            new Team("aadsdds", "jajaj", R.drawable.grey),
            new Team("adds", "jajaj", R.drawable.grey),
            new Team("adadsasdds", "jajaj", R.drawable.grey),
            new Team("adds", "jajaj", R.drawable.grey),
            new Team("adasdasdds", "jajaj", R.drawable.grey),
            new Team("adds", "jajaj", R.drawable.grey),
            new Team("adds", "jajaj", R.drawable.grey),
            new Team("adadsds", "jajaj", R.drawable.grey),
    };

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        try {
            setListAdapter(new IconAdapter<Team>(this, R.layout.row, R.id.label, items));
        } catch (ClassCastException e) {
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
        selection=(TextView)findViewById(R.id.selection);
    }

    public void onListItemClick(ListView parent, View v,
                                int position, long id) {
        selection.setText(items[position].getName());
    }

}