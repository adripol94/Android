package es.iesnervion.apol.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Connection<Pais>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cursor cru;

        DBHelper db = DBHelper.getInstacie(this);
        SQLiteDatabase helper = db.getReadableDatabase();



    }

    private <T> void ejecutarAsincTask(AsyncTask<T,?,?> task, T...params) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
        else
            task.execute(params);
    }

    @Override
    public Pais getColumn(Pais obj) {
        return null;
    }

    private class TaskPises extends AsyncTask<DBHelper, Void, Cursor> {
        private String[] columnasDeseadas = {Contrato.Paises.COLUMN_NAME_NOMBRE};
        private Context c;


        public TaskPises(Context c) {
            this.c = c;
        }

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param params The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected Cursor doInBackground(DBHelper... params) {
            return (params[0]).getPaises();
        }

        /**
         * <p>Runs on the UI thread after {@link #doInBackground}. The
         * specified result is the value returned by {@link #doInBackground}.</p>
         * <p>
         * <p>This method won't be invoked if the task was cancelled.</p>
         *
         * @param cursor The result of the operation computed by {@link #doInBackground}.
         * @see #onPreExecute
         * @see #doInBackground
         * @see #onCancelled(Object)
         */
        @Override
        protected void onPostExecute(Cursor cursor) {
            Connection con = (Connection) c;
            //TODO what do with a cursor here
            con.getColumn(null);
        }
    }
}
