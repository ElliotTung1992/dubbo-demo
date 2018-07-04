package dge1992.spring.ioc.beanFactory.first.factoryMethod;

import java.time.LocalDate;

public class Person{

    private Cat cat;
    private Dog dog;
    private Pig pig;
    private LocalDate localDate;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Pig getPig() {
        return pig;
    }

    public void setPig(Pig pig) {
        this.pig = pig;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", pig=" + pig +
                ", localDate=" + localDate +
                '}';
    }
}
