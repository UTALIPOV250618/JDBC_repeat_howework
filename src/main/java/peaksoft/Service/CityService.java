package peaksoft.Service;

import peaksoft.dao.City;
import peaksoft.util.JdbcConf;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityService {

    public  static void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS City(" +
                "City_id SERIAL PRIMARY KEY NOT NULL," +
                "City_name varchar(50) NOT NULL," +
                "City_code INTEGER NOT NULL UNIQUE)";
        try (Connection connection = JdbcConf.connection();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table City created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void addCity(City city){

        String sql = "INSERT INTO  City(City_name,City_code) " +
                "VALUES(?,?)";
        try(Connection connection = JdbcConf.connection();
            PreparedStatement prstm = connection.prepareStatement(sql)){
            prstm.setString(1,city.getCity_name());
            prstm.setInt(2,city.getCity_code());
            prstm.executeUpdate();
            System.out.println("New city added successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static List<City> getAllCity(){
        List<City> cities = new ArrayList<>();
        String sql = "SELECT*FROM City";
        try (Connection connection = JdbcConf.connection();
        Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)
        ){
            while (resultSet.next()){
                System.out.println(resultSet.getInt("city_id")+
                        " "+resultSet.getString("city_name")+" "
                +resultSet.getInt("city_code"));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return cities;
    }
    public static  void updateCityCode(int city_id,int city_code){
        String sql = "UPDATE City set city_code = ? where city_id=?";
        try(Connection connection = JdbcConf.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,city_code);
            preparedStatement.setInt(2,city_id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
