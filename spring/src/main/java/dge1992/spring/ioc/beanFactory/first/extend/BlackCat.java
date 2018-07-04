package dge1992.spring.ioc.beanFactory.first.extend;

public class BlackCat extends Cat{
    String colour;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "BlackCat{" +
                "colour='" + colour + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
