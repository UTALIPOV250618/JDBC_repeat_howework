package peaksoft.Service;

import peaksoft.dao.MinisterOfCity;
import peaksoft.util.JdbcConf;

import java.sql.*;

public class MinisterService {


    public static void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS MinisterOfCity(" +
                "minister_id BIGSERIAL PRIMARY KEY NOT NULL," +
                "minister_name varchar(50) NOT NULL," +
                "minister_surname varchar(50) NOT NULL," +
                "city_id int," +
                "FOREIGN KEY(city_id) REFERENCES city(city_id))";
        try(Connection connection = JdbcConf.connection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table MinisterOfCity created Successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void addMinister(MinisterOfCity ministerOfCity){
        String sql = "INSERT INTO ministerofcity(minister_name,minister_surname) VALUES (?,?)";
        try(Connection connection = JdbcConf.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
       preparedStatement.setString(1,ministerOfCity.getMinister_name());
       preparedStatement.setString(2,ministerOfCity.getMinister_surname());
       preparedStatement.executeUpdate();
            System.out.println("Table successfully updated");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void getAllMinisters(){
        String sql = "SELECT*FROM ministerofcity";
        try(Connection connection = JdbcConf.connection();
        Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                System.out.println(resultSet.getInt("minister_id")+" " +
                        resultSet.getString("minister_name")+" "
                                +resultSet.getString("minister_surname")+" " +
                        resultSet.getInt("city_id"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void getMinistersById(int ministerID){
        String sql ="SELECT*FROM ministerofcity WHERE minister_id=?";
        try(Connection connection  =JdbcConf.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,ministerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("minister_id")+" "+
                        resultSet.getString("minister_name")+" "+
                        resultSet.getString("minister_surname")+" "+
                        resultSet.getInt("city_id"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
