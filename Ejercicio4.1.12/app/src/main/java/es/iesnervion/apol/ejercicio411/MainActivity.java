package es.iesnervion.apol.ejercicio411;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import es.iesnervion.apol.ejercicio411.Account.Account;
import es.iesnervion.apol.ejercicio411.Account.Facebook;
import es.iesnervion.apol.ejercicio411.Account.Google;
import es.iesnervion.apol.ejercicio411.Account.Twitter;

public class MainActivity extends ListActivity {
    TextView selection;
    private static final Account[] items={
            new Twitter("Twitter", "email", "@account"),
            new Twitter("Twitter", "email", "@account"),
            new Twitter("Twitter", "email", "@account"),
            new Facebook("Facebook", "Email", "@account"),
            new Facebook("Facebook", "Email", "@account"),
            new Google("Google", "Email", "@account"),
            new Twitter("Twitter", "email", "@account"),
            new Twitter("Twitter", "email", "@account"),
            new Twitter("Twitter", "email", "@account"),
            new Facebook("Facebook", "Email", "@account"),
            new Facebook("Facebook", "Email", "@account"),
            new Google("Google", "Email", "@account")
    };

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        try {
            setListAdapter(new IconAdapter<Account>(this, R.layout.row, R.id.label, items));
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