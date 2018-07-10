package com.dge1992.spring.ioc.part2;

/**
 * people类
 */
public class People {

    private String name;
    private Integer age;
    private Car car;

    public People() {

    }

    public People(String name, Integer age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public void driveCar(){
        car.drive();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
