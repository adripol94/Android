package es.iesnervion.salvavidas;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import es.iesnervion.salvavidas.dummy.DummyContent;

public class ActionActivity extends FragmentActivity implements GameFragment.OnFragmentInteractionListener,
View.OnClickListener, OnListFragmentInteractionListener{

    private Registro reg;
    public static final String RES_KEY = "Resultados";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        reg = new Registro(this);

        Fragment f;
        int n = getIntent().getIntExtra("Fragment", 0);

        if (n == 1) {
             f = new GameFragment();
        } else {
             f = new ResultsFragment().newInstance(reg.getRegs());
        }

        // In case this activity was started with special instructions from an
        // Intent, pass the Intent's extras to the fragment as arguments
        f.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentMain, f).commit();
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View view) {
        makeInvisiableAll();
        String res = "empate";
        String opcMaquina = machineSelected();
        String opcUsuario = ((Button)view).getText().toString();

        if (!opcMaquina.equals(opcUsuario))
            res = validater(opcMaquina, opcUsuario);

        reg.putReg(opcUsuario, opcMaquina, res);


        ((TextView)findViewById(R.id.resultado)).setText(res);
    }

    private void makeInvisiableAll() {
        (findViewById(R.id.MacTijeras)).setVisibility(View.INVISIBLE);
        (findViewById(R.id.MacPiedra)).setVisibility(View.INVISIBLE);
        (findViewById(R.id.MacPapel)).setVisibility(View.INVISIBLE);

    }

    /**
     * Devuelve un random, virtualiza una seleccion de piedra, papel o tijeras d ela maquina.
     * @return
     */
    public String machineSelected() {
        String[] opciones = {
                "piedra",
                "papel",
                "tijeras"
        };

        Random random = new Random();
        int i = random.nextInt((2 - 0) + 1) + 0;
        return opciones[i];
    }


    public String validater(String maquina, String usuario) {
        // 0 = Empate, 1 = Gana maquina, 2 Gana usuario
        String res = "";

        switch (maquina) {
            case "piedra":
                res = usuario.equals("papel") ? "Has ganado" : "No has ganado";
                (findViewById(R.id.MacTijeras)).setVisibility(View.VISIBLE);
                break;
            case "papel":
                res = usuario.equals("tijeras") ? "Has ganado" : "No has ganado";
                (findViewById(R.id.MacPiedra)).setVisibility(View.VISIBLE);
                break;
            case "tijeras":
                res = usuario.equals("piedra") ? "Has ganado" : "No has ganado";
                (findViewById(R.id.MacPapel)).setVisibility(View.VISIBLE);
                break;
        }

        return res;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    public class Registro {

        private Context c;
        private SharedPreferences.Editor editor;
        private SharedPreferences pref;
        private static final String SHAREDPREFERENCE_KEY = "Resgitro";
        private static final String RESULTS = "Resultado";


        public Registro(Context c) {
            this.c = c;
            SharedPreferences pref = getSharedPreferences(SHAREDPREFERENCE_KEY, c.MODE_PRIVATE);
            editor = pref.edit();
            this.pref = pref;
        }

        public void putReg(String opcUse, String opcMac, String res) {
            String time = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(Calendar.getInstance().getTime());
            Set<String> resultado = new HashSet<>();
            resultado.add("Opcion de usuario:" + opcUse);
            resultado.add("Opcion de maquina:" + opcMac);
            resultado.add("Resultado:" + res);

            editor.putStringSet(RESULTS + time, resultado);
            editor.commit();
        }

        public Map<String, ?> getRegs() {
            return pref.getAll();
        }
    }
}
