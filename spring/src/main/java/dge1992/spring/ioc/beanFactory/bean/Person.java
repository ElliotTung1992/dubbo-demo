package dge1992.spring.ioc.beanFactory.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person {

    private String name;
    private Integer age;
    private boolean sex;

    private Car car;
    private Dog dog;

    private List cars;
    private String[] strs;

    private Set setValues;
    private Map mapping;

    public Person() {

    }

    public Person(Set setValues) {
        this.setValues = setValues;
    }

    public Person(List cars, String[] strs) {
        this.cars = cars;
        this.strs = strs;
    }

    public Person(Car car, Dog dog) {
        this.car = car;
        this.dog = dog;
    }

    public Person(String name, Integer age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public List getCars() {
        return cars;
    }

    public void setCars(List cars) {
        this.cars = cars;
    }

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public Set getSetValues() {
        return setValues;
    }

    public void setSetValues(Set setValues) {
        this.setValues = setValues;
    }

    public Map getMapping() {
        return mapping;
    }

    public void setMapping(Map mapping) {
        this.mapping = mapping;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", car=" + car +
                ", dog=" + dog +
                ", cars=" + cars +
                ", strs=" + Arrays.toString(strs) +
                ", setValues=" + setValues +
                ", mapping=" + mapping +
                '}';
    }
}
