package model;

public class Car {

    private Integer id;
    private String make;
    private String model;
    private Integer proprietari;
    private Integer service;

    public Car() {

    }

    public Car(Integer id, String make, String model, Integer proprietari, Integer service) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.proprietari = proprietari;
        this.service = service;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getProprietari() {
        return proprietari;
    }

    public void setProprietari(Integer proprietari) {
        this.proprietari = proprietari;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", proprietari=" + proprietari +
                ", service=" + service +
                '}';
    }
}
