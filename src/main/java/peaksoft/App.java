package peaksoft;

import peaksoft.Service.CityService;
import peaksoft.Service.CountryService;
import peaksoft.Service.MinisterService;
import peaksoft.dao.Country;
import peaksoft.dao.MinisterOfCity;


public class App 
{
    public static void main( String[] args )
    {

//        City city = new City("London",020);
//        CityService.addCity(city);
        CityService.getAllCity();
//        CityService.updateCityCode(6,56);

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
//        CountryService.createTable();

//        Country country1 = new Country("Kyrgyzstan","Central Asia");
//        Country country2= new Country("Turkey","Southeast Europe");
//        Country country3= new Country("England","Europe");
//        Country country4= new Country("Russia","Asia");
//        Country country5= new Country("Canada","North America");
//
//        CountryService.addCountry(country1);
//        CountryService.addCountry(country2);
//        CountryService.addCountry(country3);
//        CountryService.addCountry(country4);
//        CountryService.addCountry(country5);

//        CountryService.getAllCountry();
//        MinisterService.createTable();
        MinisterOfCity ministerOfCity = new MinisterOfCity("Sulaiman","Talipov");
        MinisterService.addMinister(ministerOfCity);
        MinisterService.getAllMinisters();
    }
}
