package com.github.dge1992.lambda.java8.closure;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author  dong
 * @desc
 *
 * 使用闭包捕获状态
 *
 * 在 Java™ 编程中，我们以不严格地使用术语 lambda 表达式来表示 lambda 表达式和闭包。
 * 但在某些情况下，理解它们的区别很重要。lambda 表达式是无状态的，而闭包是带有状态的。
 * 将 lambda 表达式替换为闭包，是一种管理函数式程序中的状态的好方法。
 *
 **/
public class Closure {

    public static void main(String[] args) {

        /**
         *
         * 闭包不同于 lambda 表达式，因为它们依赖于自己的词法范围来获取一些变量。
         * 因此，闭包可以捕获并携带状态。lambda 表达式是无状态的，闭包是有状态的。
         * 可以在您的程序中使用闭包，将状态从定义上下文携带到执行点。
         *
         */

        Closure closure = new Closure();

//        closure.test1();

        //使用闭包
        closure.test2();
    }


    private void test1() {

        String name = "java";

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello " + name);
            }
        });

        thread.start();

        //lambda 表达式中的变量 name 被绑定到 lambda 表达式的词法范围中的变量 name。
        //严格来讲，此代码中的 lambda 表达式是一个闭包。
        Thread thread1 = new Thread(() -> System.out.println("hello " + name));
        thread1.start();
    }

    private void test2() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(toList());

        System.out.println(collect);

        //使用闭包
        int factor = 4;
        int number = 2;

        //map 方法现在接受一个闭包，而不是一个 lambda 表达式。我们知道，这个闭包接受一个参数 e，但它也捕获并携带 factor 变量的状态。
        List<Integer> collect1 = numbers.stream()
                .filter(e -> e % number == 0)
                .map(e -> e * factor)
                .collect(toList());

        System.out.println(collect1);

    }
}

class Sample {

    public static void call(Runnable runnable) {
        System.out.println("calling runnable");

        //level 2 of stack
        runnable.run();
    }

    public static void main(String[] args) {
        int value = 4;  //level 1 of stack
        call(
                () -> System.out.println(value) //level 3 of stack
        );
    }
}

class Sample1 {

    /**
     * 只要create()方法执行完, value就消失了
     * 但是闭包保留着 value 的一个副本
     *
     */
    public static Runnable create() {
        int value = 4;
        Runnable runnable = () -> System.out.println(value);

        System.out.println("exiting create");
        return runnable;
    }

    public static void main(String[] args) {
        Runnable runnable = create();

        System.out.println("In main");
        runnable.run();
    }
}
