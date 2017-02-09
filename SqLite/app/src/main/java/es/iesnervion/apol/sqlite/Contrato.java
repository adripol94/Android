package es.iesnervion.apol.sqlite;

import android.provider.BaseColumns;

public final class Contrato {

    private Contrato() {}

    //Implementamos la interfaz BaseColumns para tener la columna "_id", necesaria para SimpleCursorAdapter...
    public static final class Paises implements BaseColumns {
        private Paises() {}
        public static final String TABLE_NAME_PAISES="paises";
        public static final String COLUMN_NAME_NOMBRE="nombre";
        public static final String COLUMN_NAME_POBLACION="poblacion";
        public static final String DEFAULT_SORT_ORDER="nombre ASC";
    }

    public static final class Ciudades implements BaseColumns {
        private Ciudades() {}
        public static final String TABLE_NAME_CIUDADES="ciudades";
        public static final String COLUMN_NAME_NOMBRE="nombre";
        public static final String COLUMN_NAME_POBLACION="poblacion";
        public static final String COLUMN_NAME_PAIS_AL_QUE_PERTENECE="pais_al_que_pertenece";
        public static final String DEFAULT_SORT_ORDER="nombre ASC";
    }
}
