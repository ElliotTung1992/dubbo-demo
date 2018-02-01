package com.github.dge1992.lambda.java8.stream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author  dong
 * @desc
 *
 * 传统 for 循环的函数式替代方案
 *
 * 尽管 for 循环包含许多可变部分，开发人员仍非常熟悉它，并会不假思索地使用它。
 * 从 Java 8 开始，有多个强大的新方法可帮助简化复杂迭代。
 *
 **/
public class Stream2 {

    public static void main(String[] args) {

        Stream2 stream = new Stream2();

        //for循环的麻烦
//        stream.test1();

        //可变变量与参数
//        stream.test2();

        //封闭范围
//        stream.test3();

        //跳过值
//        stream.test4();

        //逆向迭代
        stream.test5();

        /**
         * 在也不同for循环了
         * 0.0
         */

    }

    private void test1() {

        for(int i = 1; i < 4; i++) {
            System.out.print(i + "...");
        }

        IntStream.range(1, 4)
                .forEach(i -> System.out.print(i + "..."));

        /**
         * 不同于 for，range 不会强迫我们初始化某个可变变量。
         * 迭代会自动执行，所以我们不需要像循环索引一样定义增量。
         */
    }

    private void test2() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //变量 i 是单个变量，它会在每次对循环执行迭代时发生改变
        for(int i = 0; i < 5; i++) {
            //创建一个局部临时变量
            int temp = i;
            executorService.submit(new Runnable() {
                public void run() {
                    System.out.println("Running task " + temp);
                }
            });
        }

        //range 示例中的变量是拉姆达表达式的参数，所以它在每次迭代中都是一个全新的变量
        //它是实际最终变量，因为我们不会在任何地方更改它的值
        IntStream.range(0, 5)
                .forEach(i ->
                        executorService.submit(new Runnable() {
                            public void run() {
                                System.out.println("Running task " + i);
                            }
                        }));

        executorService.shutdown();
    }

    private void test3() {

        for(int i = 0; i <= 5; i++) {
            System.out.println(i);
        }

        IntStream.rangeClosed(0, 5).
                forEach(System.out::println);
    }

    private void test4() {

        int total = 0;
        for(int i = 1; i <= 100; i = i + 3) {
            total += i;
        }
        System.out.println(total);

        int sum = IntStream.iterate(1, e -> e + 3)
                .limit(34)
                .sum();
        System.out.println(sum);

//        limit(34)这个计算太恶心，java9用takeWhile代替
//        IntStream.iterate(1, e -> e + 3)
//                .takeWhile(i -> i <= 100)
//                .sum();
    }

    private void test5() {

        for(int i = 7; i > 0; i--) {
            System.out.println(i);
        }

        IntStream.iterate(7, e -> e - 1)
                .limit(7)
                .forEach(System.out::println);

        /**
         * java9 使用 takeWhile 和 dropWhile 方法来动态调整迭代流。
         */
    }

}
