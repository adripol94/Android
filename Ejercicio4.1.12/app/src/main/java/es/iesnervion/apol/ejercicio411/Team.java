package es.iesnervion.apol.ejercicio411;

/**
 * Created by apol on 27/10/16.
 */

public class Team implements ListReady {
    private String name;
    private String description;
    private int img;

    public Team (String name, String description, int img) {
        this.name = name;
        this.description = description;
        this.img = img;
    }



    public String getDescription() {
        return description;
    }

    public int getImg() {
        return img;
    }

    @Override
    public String getName() {
        return name;
    }
}
