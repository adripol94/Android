package es.iesnervion.apol.ejercicio411;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;

import static es.iesnervion.apol.ejercicio411.R.layout.activity_main;

public class MainActivity extends ListActivity {
    TextView selection;
    private Team[] items = {
            new Team("Adrian", 24, 0, ""),
            new Team("ad", 24, 0, ""),
            new Team("asds", 24, 0, ""),
            new Team("Adasdrian", 24, 0, ""),
            new Team("adsasd", 24, 0, ""),
            new Team("adsa", 24, 0, ""),
            new Team("asdasdasdasd", 24, 0, ""),
    };

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        setListAdapter(new IconAdapter<Team>(this, R.layout.row, R.id.head, items));
    }


}
