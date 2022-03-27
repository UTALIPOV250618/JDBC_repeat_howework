package peaksoft.dao;

public class MinisterOfCity {
    private int minister_id;
    private String minister_name;
    private String minister_surname;
    private City city;

    public MinisterOfCity(String minister_name, String minister_surname) {
        this.minister_name = minister_name;
        this.minister_surname = minister_surname;
    }

    public MinisterOfCity() {
    }

    public int getMinister_id() {
        return minister_id;
    }

    public void setMinister_id(int minister_id) {
        this.minister_id = minister_id;
    }

    public String getMinister_name() {
        return minister_name;
    }

    public void setMinister_name(String minister_name) {
        this.minister_name = minister_name;
    }

    public String getMinister_surname() {
        return minister_surname;
    }

    public void setMinister_surname(String minister_surname) {
        this.minister_surname = minister_surname;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "MinisterOfCity{" +
                "minister_id=" + minister_id +
                ", minister_name='" + minister_name + '\'' +
                ", minister_surname='" + minister_surname + '\'' +
                ", city=" + city.getCity_id() +
                '}';
    }
}
