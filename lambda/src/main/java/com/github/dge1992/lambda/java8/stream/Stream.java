package com.github.dge1992.lambda.java8.stream;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @author  dong
 * @desc
 *
 * 函数组合与集合管道模式
 *
 **/
public class Stream {

    public static void main(String[] args) {

        /**
         *
         * 1.什么是语句
         * > 语句执行一个操作，但不会生成任何结果。就本质而言，任何执行有用的操作的语句都会导致数据变化。这是语句表达其效果的唯一方式
         * > 在代码中使用语句就像是合作处理一部分工作，但无法在团队成员之间直接转交工作结果。
         * > 分享结果的唯一方法是将它放在桌面上或架子上，让另一位团队成员可以获得它
         *
         * 2.什么是表达式
         * > 它们可以得出结果而不会导致变化
         * > 表达式的工作更像一条链：当某个人完成一项任务时，他将结果转交给链中的下一个人。
         *
         * 3.什么是集合管道模式
         * > 会将从一次运算收集的输出提供给下一次运算。
         *
         * 4.两种实现方法的比较:
         * > 4.1 函数式代码比命令式代码更简洁。
         * > 4.2 函数式代码不会表现出明显的易变性，而且使用了更少的垃圾变量。
         * > 4.3 第二个方法中使用的函数/方法都是有返回值的表达式
         * > 4.4 getModelsAfter2000UsingPipeline 使用了集合管道模式，而且非常富于表达。
         */

        Stream stream = new Stream();

        List<String> modelsAfter2000UsingFor = stream.getModelsAfter2000UsingFor(Iterating.createCars());
        System.out.println(modelsAfter2000UsingFor);

        List<String> modelsAfter2000UsingPipeline = stream.getModelsAfter2000UsingPipeline(Iterating.createCars());
        System.out.println(modelsAfter2000UsingPipeline);

    }

    public List<String> getModelsAfter2000UsingFor(List<Car> cars) {

        /**
         * 使用语句进行迭代和排序
         *
         * 这个排序示例演示了我所称的语句的效果。尽管函数和方法通常可用作表达式，
         * 但 Collectionssort 方法没有返回结果。因为它被用作语句，所以它改变了作为参数提供的列表。
         * 两个 for 循环在迭代时都改变了相应的列表。作为语句，这是这些元素的工作方式
         *
         */
        List<Car> carsSortedByYear = new ArrayList<>();

        //把Year大于2000的过滤出来
        for(Car car : cars) {
            if(car.getYear() > 2000) {
                carsSortedByYear.add(car);
            }
        }

        //对汽车按照year进行排序
        Collections.sort(carsSortedByYear, new Comparator<Car>() {
            public int compare(Car car1, Car car2) {
                return new Integer(car1.getYear()).compareTo(car2.getYear());
            }
        });

        //查询存储对应的名称
        List<String> models = new ArrayList<>();
        for(Car car : carsSortedByYear) {
            models.add(car.getModel());
        }

        return models;
    }

    public static List<String> getModelsAfter2000UsingPipeline(
            List<Car> cars) {
        /**
         * 使用集合管道进行迭代和排序
         *
         * 在函数编程中，通常会通过一系列更小的模块化函数或运算来对复杂运算进行排序。
         * 该系列被称为函数组合（composition of functions, or a function composition）。
         * 当一个数据集合流经一个函数组合时，它就变成一个集合管道。函数组合和集合管道是函数式编程中常用的两种设计模式。
         *
         * 可以看到 getModelsAfter2000UsingPipeline 函数如何执行集合管道，通过一系列函数转换给定输入。
         * 随着数据流经各个函数，Java 8 的惰性计算和函数融合功能
         * 可帮助避免在某些情况下创建中间对象。数据在管道中传输时，函数不会使中间对象变得可见或可用。
         *
         */
        return
                cars.stream()
                        .filter(car -> car.getYear() > 2000)
                        .sorted(Comparator.comparing(Car::getYear))
                        .map(Car::getModel)
                        .collect(toList());
    }
}

class Car {

    private String make;
    private String model;
    private int year;

    public Car(String theMake, String theModel, int yearOfMake) {
        make = theMake;
        model = theModel;
        year = yearOfMake;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}

class Iterating {

    public static List<Car> createCars() {
        return Arrays.asList(
                new Car("Jeep", "Wrangler", 2011),
                new Car("Jeep", "Comanche", 1990),
                new Car("Dodge", "Avenger", 2010),
                new Car("Buick", "Cascada", 2016),
                new Car("Ford", "Focus", 2012),
                new Car("Chevrolet", "Geo Metro", 1992)
        );
    }
}
