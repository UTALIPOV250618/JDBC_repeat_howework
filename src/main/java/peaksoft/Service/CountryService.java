package peaksoft.Service;

import peaksoft.dao.City;
import peaksoft.dao.Country;
import peaksoft.util.JdbcConf;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryService {

    public  static void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS Country(" +
                "country_id SERIAL PRIMARY KEY NOT NULL," +
                "country_name varchar(50) NOT NULL," +
                "country_region varchar(50) NOT NULL)";
        try (Connection connection = JdbcConf.connection();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table country created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void addCountry(Country country){

        String sql = "INSERT INTO  Country(country_name,country_region) " +
                "VALUES(?,?)";
        try(Connection connection = JdbcConf.connection();
            PreparedStatement prstm = connection.prepareStatement(sql)){
            prstm.setString(1,country.getCountry_name());
            prstm.setString(2,country.getCountry_region());
            prstm.executeUpdate();
            System.out.println("New country added successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static List<Country> getAllCountry(){
        List<Country> countries = new ArrayList<>();
        String sql = "SELECT*FROM Country";
        try (Connection connection = JdbcConf.connection();
        Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)
        ){
            while (resultSet.next()){
                System.out.println(resultSet.getInt("country_id")+
                        " "+resultSet.getString("country_name")+" "
                +resultSet.getString("country_region"));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return countries;
    }
    public static  void updateCountryCode(int country_id,String country_region){
        String sql = "UPDATE City set country_region = ? where country_id=?";
        try(Connection connection = JdbcConf.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,country_id);
            preparedStatement.setString(2,country_region);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
