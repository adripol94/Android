package es.iesnervion.apol.ejercicio411;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    TextView selection;
    private Team[] items;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        // Rellenar lista

        items = new Team[] {
                new Team("Atlanta Hawks", "In 1948, the cities of Moline and Rock Island, IL, and Davenport, IA", R.drawable.one, getResources()),
                new Team("Boston Celtics", "Team owner Walter Brown personally chose Celtics over Whirlwinds, Olympians, and Unicorns (yes, Unicorns) as the nickname for Boston's Basketball Association of America team in 1946. ", R.drawable.boston,getResources()),
                new Team("Brooklyn Nets", "The New Jersey Americans joined the American Basketball Association in 1967 and moved to New York the following season", R.drawable.broklyn,getResources()),
                new Team("Charlotte Hornets", "The three finalists in the name-the-team contest for Charlotte's 2004 expansion franchise were Bobcats, Dragons, and Flight.", R.drawable.charlotte,getResources()),
                new Team("Chicago Bulls", "jajAccording to the Chicago Bulls Encyclopedia, team owner Richard Klein was brainstorming nicknames for his new franchise in 1966 and wanted a name that portrayed Chicago's status as the meat capital of the world.aj", R.drawable.chicago,getResources()),
                new Team("Cleveland Cavaliers", "Fans voted Cavaliers the team nickname in 1970 in a poll conducted by the Cleveland Plain-Dealer", R.drawable.clevelan,getResources()),
                new Team("Dallas Mavericks", "jajaj", R.drawable.grey,getResources()),
                new Team("Denver Nuggets", "jajaj", R.drawable.grey,getResources()),
                new Team("Detroit Pistons", "jajaj", R.drawable.grey,getResources()),
                new Team("Golden State Warriorsdds", "jajaj", R.drawable.grey,getResources()),
                new Team("Houston Rockets", "jajaj", R.drawable.grey,getResources()),
                new Team("Indiana Pacers", "jajaj", R.drawable.grey,getResources()),

        };

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