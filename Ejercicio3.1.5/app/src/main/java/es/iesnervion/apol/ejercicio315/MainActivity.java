package es.iesnervion.apol.ejercicio315;
/*
EJERCICIO 5

Diseña una aplicación que permita que el usuario introduzca un texto, y que debajo del texto mostrado haya dos botones "+"
y "-" que permitirán aumentar o disminuir respectivamente el tamaño de letra.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private ProgressBar progressBar;
    private float size;
    private int progressSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initial all privates atributes
        et = (EditText) findViewById(R.id.etText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        size = et.getTextSize();
        progressSize = 0;
    }

    public void clickPlus(View v) {
        if (progressBar.getProgress() < 100) {
            et.setTextSize(TypedValue.COMPLEX_UNIT_PX, size++);
            progressSize = progressSize + 5;
            progressBar(progressSize);

        } else {
            Toast.makeText(this, "Progreso al maximo!", Toast.LENGTH_LONG).show();
        }
    }

    public void clickRest(View v) {
        if (progressBar.getProgress() > 0) {
            et.setTextSize(TypedValue.COMPLEX_UNIT_PX, size--);
            progressSize = progressSize - 5;
            progressBar(progressSize);

        } else {
            Toast.makeText(this, "Progreso al minimo!", Toast.LENGTH_LONG).show();
        }

    }

    public void progressBar(int progress) {
        progressBar.setProgress(progress);
    }
}
