package peaksoft.dao;

public class Country {
    private int country_id;
    private String country_name;
    private String country_region;

    public Country(int country_id, String country_name, String country_region) {
        this.country_id = country_id;
        this.country_name = country_name;
        this.country_region = country_region;
    }

    public Country(String country_name, String country_region) {
        this.country_name = country_name;
        this.country_region = country_region;
    }

    public Country() {
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_region() {
        return country_region;
    }

    public void setCountry_region(String country_region) {
        this.country_region = country_region;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_id=" + country_id +
                ", country_name='" + country_name + '\'' +
                ", country_region='" + country_region + '\'' +
                '}';
    }
}
