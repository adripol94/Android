package es.iesnervion.apol.ejercicio322;
/*
Implementar una pequeña calculadora. Deberá tener dos campos de texto en los que el usuario pueda
meter dos números, y a través de radiobuttons el usuario decida la operación a llevar a cabo: suma,
resta, multiplicación o división.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        resultado = 0;
    }

    /**
     * Called when a view has been clicked.
     * Imprime los caracteres en la pantalla
     *
     * @param v The view that was clicked.
     */
    public void onClick(View v) {
        String cadena;

        switch (v.getId()) {
            case R.id.bt0:
                textView.append("0");
                break;
            case R.id.bt1:
                textView.append("1");
                break;
            case R.id.bt2:
                textView.append("2");
                break;
            case R.id.bt3:
                textView.append("3");
                break;
            case R.id.bt4:
                textView.append("4");
                break;
            case R.id.bt5:
                textView.append("5");
                break;
            case R.id.bt6:
                textView.append("6");
                break;
            case R.id.bt7:
                textView.append("7");
                break;
            case R.id.bt8:
                textView.append("8");
                break;
            case R.id.bt9:
                textView.append("9");
                break;
            case R.id.btDelete:
                cadena = textView.getText().toString();
                // Comprueba si hay caracter para borrar
                if (cadena.length() != 0) {
                    textView.setText(cadena.substring(0, cadena.length() - 1));
                }
                break;
            case R.id.btSuma:
                textView.append("+");
                break;
            case R.id.btResta:
                textView.append("-");
                break;
            case R.id.btDivide:
                textView.append("/");
                break;
            case R.id.btMultiplica:
                textView.append("*");
                break;
            case R.id.btEqual:
                cadena = textView.getText().toString();
                // comprueba si hay operando logico para la cuenta
                if (!contieneCuenta(cadena)) {
                    actionEqual(cadena);
                }
                textView.setText(String.valueOf(resultado));
                break;
        }
    }

    /**
     *
     * @param cadena cadena para comporbar
     * @return flase si tiene uno; true si tiene error y por tanto no tiene digitos
     */
    private boolean contieneCuenta(String cadena) {
        char c;
        boolean noStop = true;
        for (int i = 0; i < cadena.length() && noStop; i++) {
            c = cadena.charAt(i);
            if (!Character.isDigit(c)) {
                noStop = false;
            }

        }
        return noStop;
    }

    /**
     * Encargada de coger los numeros de la cadena y comprobar el operador logico
     * @param cad
     */
    private void actionEqual(String cad) {
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();
        char numberChar, signo = ' ';
        boolean noNumero = false;
        boolean num2find = false;

        for (int i = 0; i < cad.length(); i++) {
            numberChar = cad.charAt(i);

            if (!noNumero && Character.isDigit(numberChar)) {
                n1.append(numberChar);
            } else if (!Character.isDigit(numberChar)) {
                if (num2find) {
                    hacerCuenta(n1, n2, signo);
                    n1.delete(0, n1.length());
                    n1.append(resultado);
                    n2.delete(0, n2.length());
                    signo=numberChar;
                } else {
                    signo = numberChar;
                    num2find = true;
                    noNumero = true;
                }
            } else {
                n2.append(numberChar);
            }
        }
        hacerCuenta(n1, n2, signo);
    }

    /**
     * Comprueba el operador pasado por parametro y hace la cuenta
     * @param n1 numero pasado por String
     * @param n2 numero pasado por String
     * @param signo signo logico pasado por Char
     */
    private void hacerCuenta(StringBuilder n1, StringBuilder n2, char signo) {
        int num1 = Integer.parseInt(n1.toString());
        int num2 = Integer.parseInt(n2.toString());

        switch (signo) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '/':
                resultado = num1 / num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            default:
                Toast.makeText(this, "Error al hacerCuenta", Toast.LENGTH_LONG).show();
        }

    }

}
