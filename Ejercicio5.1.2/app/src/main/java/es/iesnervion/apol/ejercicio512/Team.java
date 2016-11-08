package es.iesnervion.apol.ejercicio512;

/**
 * Created by apol on 8/11/16.
 */

public class Team implements ListReady{
    private int img;
    private String name;
    private String city;

    public Team() {
        img = R.drawable.not_found;
        name = "Default";
        city = "Default";
    }

    public Team(int img, String name, String city) {
        this.img = img;
        this.name = name;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
