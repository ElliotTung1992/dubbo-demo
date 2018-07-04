package dge1992.spring.bean;

public class Car {

    private String name;
    private Integer year;
    private String brand;

    public Car() {
    }

    public Car(String name, Integer year, String brand) {
        this.name = name;
        this.year = year;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                '}';
    }
}
