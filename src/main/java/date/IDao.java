package date;

import model.Car;

import java.util.List;

public interface IDao<x> {

    public List<x> toate();

    public Car omasina (int id);

    public void sterge (int id);


    void update(Car masinaEditata);

    void salveaza(Car masinaNoua);
}
