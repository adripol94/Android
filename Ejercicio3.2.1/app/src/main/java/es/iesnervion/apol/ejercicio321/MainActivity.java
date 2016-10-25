package es.iesnervion.apol.ejercicio321;
/*
Diseñar una aplicación que tenga un texto en la parte superior, y a través de cuatro checkboxes se
pueda poner el texto en negrita, en tamaño de fuente gigantesco, en tamaño de fuente minúsculo,
en color rojo.

 */
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private float restSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial privates atributes
        et = (EditText) findViewById(R.id.et_txt);
        restSize = et.getTextSize();
    }

    /**
     * Make Red the EditText
     * @param v
     */
    public void setRed(View v) {
        CheckBox cb = (CheckBox) findViewById(R.id.cbRed);

        if (cb.isChecked()) {
            et.setTextColor(getResources().getColor(R.color.red));
        } else {
            et.setTextColor(getResources().getColor(R.color.black));
        }
    }

    /**
     * Make Bold the EditText
     * @param v
     */
    public void setBold(View v) {
        CheckBox cb = (CheckBox) findViewById(R.id.cbBold);
        if (cb.isChecked()) {
            et.setTypeface(et.getTypeface(), Typeface.BOLD);
        } else {
            et.setTypeface(et.getTypeface(), Typeface.NORMAL);
        }
    }

    /**
     * Make Big the EditText
     * @param v
     */
    public void setBig(View v) {
        CheckBox cb = (CheckBox) findViewById(R.id.gbGiatn);

        if (cb.isChecked()) {
            et.setTextSize(TypedValue.COMPLEX_UNIT_PX, 500);
            // Esto se debe de hacer un radio Button y evitaremos el error del click
        } else {
            et.setTextSize(TypedValue.COMPLEX_UNIT_PX, restSize);
        }
    }

    /**
     * Make Small The EditText
     * @param v
     */
    public void setSmall(View v) {
        CheckBox cb = (CheckBox) findViewById(R.id.cbSmall);

        if (cb.isChecked()) {
            et.setTextSize(TypedValue.COMPLEX_UNIT_PX,10);
            // Esto se debe de hacer un radio Button y evitaremos el error del click
        } else {
            et.setTextSize(TypedValue.COMPLEX_UNIT_PX, restSize);
        }

    }
}
