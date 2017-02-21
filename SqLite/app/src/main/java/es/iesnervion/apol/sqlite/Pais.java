package es.iesnervion.apol.sqlite;

/**
 * Created by apol on 9/02/17.
 */

public class Pais {
    private int id;
    private String nombre;
    private String poblacion;

    public Pais() {
    }

    public Pais(int id, String nombre, String poblacion) {
        this.id = id;
        this.nombre = nombre;
        this.poblacion = poblacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
}
