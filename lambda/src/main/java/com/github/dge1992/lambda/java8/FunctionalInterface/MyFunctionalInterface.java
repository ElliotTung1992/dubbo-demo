package com.github.dge1992.lambda.java8.FunctionalInterface;

import com.github.dge1992.lambda.java8.bean.Product;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * 函数式接口
 */
public class MyFunctionalInterface {

    /**
     * 1.我们说了那么多的lambda表达式，那么lambda的类型是什么？
     * > java是用函数式接口来表示lambda表达式的类型
     *
     * 2.什么是函数式接口
     * 函数式接口都有@FunctionalInterface注解
     * > 2.1 一个函数接口有且只有一个抽象方法
     * > 2.2 在Object类中属于公共方法的抽象方法不会被视为单一抽象方法
     * > 2.3 函数接口可以有默认方法和静态方法
     *
     * 3.什么是内置函数接口
     * 最常用的接口包括 Function<T, R>、Predicate<T> 和 Consumer<T>，它们是在 java.util.function 包中定义的。
     *
     * 4.自定义函数接口
     * > 4.1 要创建自己的函数接口，需要做两件事：
     * >> 4.1.1使用@FunctionalInterface注释该接口，这是java8对自定义函数接口的定义
     * >> 4.1.2确保该接口只有一个抽象方法
     *
     * 5.在任何需要函数接口的地方，我们有三种选择
     * > 5.1 传递一个匿名内部类
     * > 5.2 传递一个lambda表达式
     * > 5.3 在某些情况下用方法引用
     *
     */

    public static void main(String[] args) {
        MyFunctionalInterface functionalInterface = new MyFunctionalInterface();

        //比较java8前后Thread实现方式
//        functionalInterface.test1();

        //内置函数接口的使用
//        functionalInterface.test2();

        //创建自定义函数接口
//        functionalInterface.test3();

        //自定义函数接口和内置函数接口
        functionalInterface.test4();
    }

    private void test2() {
        Predicate<String> predicate = (s) -> s.length() > 3;
        boolean qwe = predicate.test("qwe");
        boolean qwer = predicate.test("qwer");
        boolean qwe1 = predicate.negate().test("qwe");
        System.out.println(qwe);
        System.out.println(qwer);
        System.out.println(qwe1);

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        System.out.println(nonNull.test(null));
        System.out.println(isNull.test(null));

//        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
//        greeter.accept(new Person("Luke", "Skywalker"));

    }

    private void test1() {

        //java8之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("正在运行！！！");
            }
        }).start();

        //java8
        new Thread(() -> System.out.println("starting!!!"))
                .start();
    }

    private void test3() {
        Order order = new Order(Arrays.asList(
                new Product(2, "dong"),
                new Product(5, "feng"),
                new Product(3, "zhu")
        ));

        //传递一个匿名内部类
        order.transformAndPrint(new Transformer<Stream<Product>>() {
            @Override
            public Stream<Product> transform(Stream<Product> input) {
                return input.sorted(comparing(Product::getId));
            }
        });

        //传递一个lambda表达式
        order.transformAndPrint(e ->
            e.sorted(comparing(Product::getId))
        );
    }

    private void test4() {
        /**
         *
         */
    }
}
