package da;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.city;
import util.dbUtil;

public class CityDA implements CitydaI {

        private Connection conn;

        public CityDA(){
                conn=dbUtil.getConnection();
        }
        @Override
        public void addCity(city City) {
                try{
                        String query="INSERT INTO public.City (city_id, city_name) VALUES (?,?)";
                        PreparedStatement preparedStatement = conn.prepareStatement(query);

                        preparedStatement.setLong(1, City.getRid());
                        preparedStatement.setString(2, City.getCityName());

                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
                catch(SQLException e)
                {
                        System.out.println(e.getMessage());
                }

        }

        @Override
        public List<city> getAllcitys() {
                List<city> Cities = new ArrayList<city>();
                //City[] Cities = new city[10];
                try
                {
                String query = "SELECT * FROM public.city";
                Statement statement = conn.createStatement();

                ResultSet citiesTable = statement.executeQuery(query);

                while(citiesTable.next()){
                        city c = new city();
                        c.setRid(citiesTable.getInt("City_id"));
                        c.setCityName(citiesTable.getString("City_name"));

                        Cities.add(c);
                }
                }
                catch (SQLException e)
                {
                System.out.println(e.getMessage());
                }
                return Cities;
        }





        @Override
        public city getCityByID(int CityID) {

                city newCity = new city();

                try
                {
                String query = "SELECT * FROM public.city WHERE city_id='"+CityID+"'";

                Statement statement = conn.createStatement();

                ResultSet citiesStatement = statement.executeQuery(query);


                while(citiesStatement.next()){
                        newCity.setRid(citiesStatement.getInt("City_id"));
                        newCity.setCityName(citiesStatement.getString("City_name"));

                }

                }
                catch (SQLException e)
                {
                System.out.println(e.getMessage());
                }


                return newCity;

        }



        @Override
        public void updateCity(city City) {

                try
                {
                String query = "UPDATE public.city SET city_name= ? where city_ID= ?";

        PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setInt(2,City.getRid());
                preparedStatement.setString(1,City.getCityName());

                preparedStatement.executeUpdate();
                preparedStatement.close();

                }
                catch (SQLException e)
                {
                System.out.println(e.getMessage());
                }


        }

        @Override
        public void deleteCity(int CityID) {

                try
                {
                String query = "DELETE FROM public.city WHERE city_id= ?";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setInt(1,CityID );

                preparedStatement.executeUpdate();

                }
                catch (SQLException e)
                {
                System.out.println(e.getMessage());
                }




        }

}