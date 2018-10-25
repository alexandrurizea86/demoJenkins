package date;

import model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DateMasinaSQL implements IDao <Car> {

    @Override
    public List <Car> toate() {



        List<Car> listaMasini = new ArrayList<>();

        try{

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "1234");

            PreparedStatement statementul = con.prepareStatement("SELECT * FROM cars");

            ResultSet rezultate = statementul.executeQuery();

            while (rezultate.next()) {
                Car masina = new Car();

                masina.setId(rezultate.getInt("id"));
                masina.setMake(rezultate.getString("make"));
                masina.setModel(rezultate.getString("model"));
                masina.setProprietari(rezultate.getInt("proprietari"));
                masina.setService(rezultate.getInt("service"));

                listaMasini.add(masina);

            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaMasini;
    }


    @Override
    public Car omasina(int id) {


        try {


            Class.forName("com.mysql.jdbc.Driver");

            Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "1234");
            PreparedStatement statementul = conexiune.prepareStatement("SELECT * FROM cars WHERE id = " + id);

            ResultSet rezultate = statementul.executeQuery();

            while(rezultate.next()) {

                Car omasina = new Car();

                omasina.setId(rezultate.getInt("id"));
                omasina.setMake(rezultate.getString("make"));
                omasina.setModel(rezultate.getString("model"));
                omasina.setProprietari(rezultate.getInt("proprietari"));
                omasina.setService(rezultate.getInt("service"));

                return omasina;
            }


        }catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    public void sterge(int id) {


        try{

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "1234");

            PreparedStatement statementul = con.prepareStatement("DELETE FROM cars WHERE id = ?");

            statementul.setInt(1, id);

            statementul.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    public void update(Car masinaEditata) {


        try{

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "1234");

            PreparedStatement statementul = con.prepareStatement("UPDATE cars SET make=?, model=?, proprietari=?, service=? WHERE id=?");

            statementul.setString(1, masinaEditata.getMake());
            statementul.setString(2, masinaEditata.getModel());


            if (masinaEditata.getProprietari() == null) {
                statementul.setInt(3, Types.INTEGER);
            } else {
                statementul.setInt(3, masinaEditata.getProprietari());
            }

            if (masinaEditata.getService() == null) {
                statementul.setInt(4, Types.INTEGER);
            } else {
                statementul.setInt(4, masinaEditata.getService());
            }

            statementul.setInt(5, masinaEditata.getId());

            statementul.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    public void salveaza(Car masinaNoua) {


        try{

            Class.forName("com.mysql.jdbc.Driver");

            Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "1234");

            PreparedStatement statementul = conexiune.prepareStatement("INSERT INTO cars (make, model, proprietari, service) VALUES (?, ?, ?, ?)");

            statementul.setString(1, masinaNoua.getMake());
            statementul.setString(2, masinaNoua.getModel());


            if (masinaNoua.getProprietari() == null) {

                statementul.setNull(3, Types.INTEGER);

            } else {
                statementul.setInt(3, masinaNoua.getProprietari());

            }

            if (masinaNoua.getService() == null) {

                statementul.setNull(4, Types.INTEGER);


            } else {

                statementul.setInt(4, masinaNoua.getService());

            }

            statementul.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
