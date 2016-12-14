package es.iesnervion.ejercicio52.Models;

/**
 * Created by adriol94 on 12/14/16.
 */

public class Player {
    public static final String ALA_PIVOT = "Ala-Pivot";
    public static final String PIVOT = "Pivot";
    public static final String ALERO = "Alero";
    public static final String ESCOLTA = "Escolta";
    public static final String BASE = "Base";

    private int img;
    private String name;
    private int peso;
    private int altura;

    public Player() {
        this.img = 123;
        this.name = "Default";
        this.altura = 0;
        this.peso = 0;

    }

    public Player(int img, String name, int peso, int altura) {
        this.img = img;
        this.name = name;
        this.altura = altura;
        this.peso = peso;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
