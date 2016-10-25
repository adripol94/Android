package es.iesnervion.apol.ejercicio411;

import android.os.Parcelable;

/**
 * Created by apol on 20/10/16.
 */

public class Team {
    private String nombreCompleto;
    private int fotoPerfil;
    private String descripcion;

    public Team(String nombreEquipo, int fotoPefil, String descripcion) {
        this.nombreCompleto = nombreEquipo;
        this.fotoPerfil = fotoPefil;
        this.descripcion = descripcion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getFotoPerfil() {
        return fotoPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
