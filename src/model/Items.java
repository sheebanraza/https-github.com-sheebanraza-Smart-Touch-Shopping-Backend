package model;

/**
 * Created by Sheeban Raza on 27-Apr-16.
 */


public class Items {


    public String name;
    public String location;
    public Integer id;

    public Items() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Items(Integer id,String name, String location) {
        this.name = name;
        this.location = location;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", id=" + id +
                '}';
    }
}
