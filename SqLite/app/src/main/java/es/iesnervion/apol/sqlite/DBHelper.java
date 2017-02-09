package es.iesnervion.apol.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import es.iesnervion.apol.sqlite.Contrato.*;

/**
 * Created by apol on 9/02/17.
 */

public class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "geografia.sb";
    private static final int DATABASE_VERSION = 1;
    private static DBHelper instacia = null;
    private Context c;

    /**
     * Método para obtener la instancia (patrón singleton)
     * @param c
     * @return
     */
    public synchronized static DBHelper getInstacie(Context c) {
        if (instacia == null)
            instacia = new DBHelper(c);
        return instacia;
    }

    /**
     * Al constructor podríamos pasarle todos los parámetros que le vamos a pasar posteriormente
     *al constructor de la superclase, pero en nuestro caso el nombre de la BD va a ser fijo,
     *y no vamos a pasarle un Cursor personalizado (siempre pasaremos null). Y como además el número de versión
     *vamos a modificarlo cambiando el valor de la constante DATABASE_VERSION, nos basta
     * con pasar el contexto. Hacemos el constructor privado porque usaremos el patrón Singleton.
     * @param c
     */
    private DBHelper(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
        this.c = c;
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        ContentValues valores = new ContentValues();
        db.execSQL("CREATE TABLE " +Paises.TABLE_NAME_PAISES+" ("
                + Paises._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Paises.COLUMN_NAME_NOMBRE + " TEXT, "
                + Paises.COLUMN_NAME_POBLACION + " TEXT"
                + ");");

        db.execSQL("CREATE TABLE " +Ciudades.TABLE_NAME_CIUDADES+" ("
                + Ciudades._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Ciudades.COLUMN_NAME_NOMBRE + " TEXT, "
                + Ciudades.COLUMN_NAME_POBLACION + " TEXT, "
                + Ciudades.COLUMN_NAME_PAIS_AL_QUE_PERTENECE + " INTEGER, "
                + " FOREIGN KEY ("+Ciudades.COLUMN_NAME_PAIS_AL_QUE_PERTENECE+") REFERENCES "+Paises.TABLE_NAME_PAISES+" ("+Paises._ID+")"
                + ");");

        //INSERTAMOS PAISES
        valores.put(Paises.COLUMN_NAME_NOMBRE, "Francia");
        valores.put(Paises.COLUMN_NAME_POBLACION, "66 millones");

        db.insert(Paises.TABLE_NAME_PAISES,null,valores);

        valores.put(Paises.COLUMN_NAME_NOMBRE, "Alemania");
        valores.put(Paises.COLUMN_NAME_POBLACION, "80 millones");

        db.insert(Paises.TABLE_NAME_PAISES,null,valores);


        //INSERTAMOS CIUDADES
        valores.put(Ciudades.COLUMN_NAME_NOMBRE, "Lyon");
        valores.put(Ciudades.COLUMN_NAME_POBLACION, "485000");
        valores.put(Ciudades.COLUMN_NAME_PAIS_AL_QUE_PERTENECE,"1");

        db.insert(Ciudades.TABLE_NAME_CIUDADES,null,valores);

        valores.put(Ciudades.COLUMN_NAME_NOMBRE, "Marsella");
        valores.put(Ciudades.COLUMN_NAME_POBLACION, "850000");
        valores.put(Ciudades.COLUMN_NAME_PAIS_AL_QUE_PERTENECE,"1");

        db.insert(Ciudades.TABLE_NAME_CIUDADES,null,valores);

        valores.put(Ciudades.COLUMN_NAME_NOMBRE, "París");
        valores.put(Ciudades.COLUMN_NAME_POBLACION, "2250000");
        valores.put(Ciudades.COLUMN_NAME_PAIS_AL_QUE_PERTENECE,"1");

        db.insert(Ciudades.TABLE_NAME_CIUDADES,null,valores);

        valores.put(Ciudades.COLUMN_NAME_NOMBRE, "Berlin");
        valores.put(Ciudades.COLUMN_NAME_POBLACION, "3500000");
        valores.put(Ciudades.COLUMN_NAME_PAIS_AL_QUE_PERTENECE,"2");

        db.insert(Ciudades.TABLE_NAME_CIUDADES,null,valores);

    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Vamos a actualizar simplemente destruyendo la BD antigua y creando la nueva versión de la misma.
        //Se podría hacer de forma más elegante, y hacer los cambios necesarios para pasar de una versión
        //a otra (p.ej. añadir sólo las tablas diferentes de la nueva versión, añadir las nuevas columnas ,etc...)

        Log.w("Constants", "Upgrading database, which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + Ciudades.TABLE_NAME_CIUDADES);
        db.execSQL("DROP TABLE IF EXISTS " + Paises.TABLE_NAME_PAISES);
        onCreate(db);
    }

    /**
     * quí se haría una desactualización ordenada de la BD.
     *En nuestro caso, por simplicidad simplemente destruiremos la BD existente y la crearemos de nuevo.
     *Y como eso mismo es lo que hace nuestro onUpgrade, pues hacemos una llamada al mismo.
     * Called when the database needs to be downgraded. This is strictly similar to
     * {@link #onUpgrade} method, but is called whenever current version is newer than requested one.
     * However, this method is not abstract, so it is not mandatory for a customer to
     * implement it. If not overridden, default implementation will reject downgrade and
     * throws SQLiteException
     * <p>
     * <p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public Cursor getPaises() {
        Cursor cur;
        cur = getReadableDatabase().rawQuery("SLECT * FROM " + Paises.TABLE_NAME_PAISES + ";", null);
        return cur;
    }

    public Cursor getCiudades() {
        Cursor cur;
        cur = getReadableDatabase().rawQuery("SELECT * FROM " + Ciudades.TABLE_NAME_CIUDADES + ";", null);
        return cur;
    }
}
