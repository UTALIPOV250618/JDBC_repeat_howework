package peaksoft.dao;

public class City {
    private int city_id;
    private String city_name;
    private int city_code;

    public City() {
    }

    public City(String city_name, int city_code) {
        this.city_name = city_name;
        this.city_code = city_code;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getCity_code() {
        return city_code;
    }

    public void setCity_code(int city_code) {
        this.city_code = city_code;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                ", city_code=" + city_code +
                '}';
    }
}
