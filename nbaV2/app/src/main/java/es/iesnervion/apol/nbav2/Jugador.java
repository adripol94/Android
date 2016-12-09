package es.iesnervion.apol.nbav2;

/**
 * Created by apol on 9/12/16.
 */

public class Jugador {
    private String nombre;
    private int altura;
    private int peso;
    private int img;

    public Jugador(String nombre, int altura, int peso, int img) {
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
