package com.github.dge1992.lambda.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * @author  dong
 * @desc
 *
 * 级联lambda表达式
 *
 **/
public class Stream3 {

    /**
     * 1.什么是级联lambda表达式
     * > 返回函数的函数可以称为级联lambda表达式
     *
     *
     */

    public static void main(String[] args) {
        Stream3 stream3 = new Stream3();

        //一个接受函数的函数
//        stream3.test1();

        //一个返回函数的函数
//        stream3.test2();

        //创建可重用的函数
//        stream3.test3();

        //创建和重用 lambda 表达式
//        stream3.test4();

        stream3.test5();
    }


    private void test1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int i = totalSelectedValues(numbers, e -> e % 2 == 0);
        System.out.println(i);

        int ii = totalSelectedValues(numbers, e -> e % 2 != 0);
        System.out.println(ii);

        int iii = totalSelectedValues1(numbers);
        System.out.println(iii);

        /**
         * 比较方式1和方式2，我们可以发现方式1更加地灵活
         * 这就是使用内置函数式接口的好处
         * Predicate<Integer> selector
         * boolean test(T t)
         */
    }

    // 方式1
    public int totalSelectedValues(List<Integer> values,
                                          Predicate<Integer> selector) {
        return values.stream()
                .filter(selector)
                .reduce(0, Integer::sum);
    }

    // 方式2
    public int totalSelectedValues1(List<Integer> values) {
        return values.stream()
                .filter(e -> e % 2 == 0)
                .reduce(0, Integer::sum);
    }

    private void test2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = numbers.stream()
                .filter(createIsOdd())
                .reduce(0, Integer::sum);

        System.out.println(reduce);
    }

    /**
     * 内置函数接口创建一个函数返回
     * @return
     */
    public static Predicate<Integer> createIsOdd() {
        Predicate<Integer> check = (Integer number) -> number % 2 != 0;
        return check;
    }

    private void test3() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(e -> e > 50)
                .collect(toList());

        numbers.stream()
                .filter(e -> e > 50)
                .map(e -> e * 2)
                .collect(toList());

        Predicate<Integer> predicate = e -> e > 50;

        numbers.stream()
                .filter(predicate)
                .collect(toList());

        numbers.stream()
                .filter(predicate)
                .map(e -> e * 2)
                .collect(toList());
    }

    private void test4() {
        /**
         *
         * public interface Function<T, R>{}
         * R apply(T t);
         *
         * 可以简单理解为T是参数R是返回值
         *
         */
        Function<Integer, Double> sqrt = value -> Math.sqrt(value);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /**
         * 就是把List的值传进去，对值进行开根号返回值列表
         */
        List<Double> sqrtList = numbers.stream()
                .map(sqrt)
                .collect(toList());

        System.out.println(sqrtList);

        /**
         * 首先这是一个函数, 参数是Integer pivot 返回值是Predicate<Integer>   返回了一个函数
         * Predicate<Integer> 参数是Integer candidate 返回是 candidate > pivot 表达式
         */
        Function<Integer, Predicate<Integer>> isGreaterThan = (Integer pivot) -> {
            Predicate<Integer> isGreaterThanPivot = (Integer candidate) -> {
                return candidate > pivot;
            };
            return isGreaterThanPivot;
        };

        /**
         * 我们很清楚发现 5 就是对应的 pivot  list列表里的元素是candidate
         */
        List<Integer> valuesOver5 = numbers.stream()
                .filter(isGreaterThan.apply(5))
                .collect(toList());

        System.out.println(valuesOver5);

        List<Integer> valuesOver8 = numbers.stream()
                .filter(isGreaterThan.apply(8))
                .collect(toList());

        System.out.println(valuesOver8);
    }

    private void test5() {

        /**
         * 优化isGreaterThan
         */

        Function<Integer, Predicate<Integer>> isGreaterThan = (Integer pivot) -> {
            Predicate<Integer> isGreaterThanPivot = (Integer candidate) -> {
                return candidate > pivot;
            };

            return isGreaterThanPivot;
        };

        /**
         * java8类型推断
         */
        Function<Integer, Predicate<Integer>> isGreaterThan1 = (pivot) -> {
            Predicate<Integer> isGreaterThanPivot = (candidate) -> {
                return candidate > pivot;
            };

            return isGreaterThanPivot;
        };

        /**
         * 我们删除多余的 ()，以及外部 lambda 表达式中不必要的临时引用
         */
        Function<Integer, Predicate<Integer>> isGreaterThan2 = pivot -> {
            return candidate -> {
                return candidate > pivot;
            };
        };

        /**
         * 可以看到内部 lambda 表达式的主体只有一行，显然 {} 和 return 是多余的
         */
        Function<Integer, Predicate<Integer>> isGreaterThan3 = pivot -> {
            return candidate -> candidate > pivot;
        };


        /**
         * Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> candidate -> candidate > pivot;
         */
        Function<Integer, Predicate<Integer>> isGreaterThan4 =
                pivot -> candidate -> candidate > pivot;

        /**
         * 一步一步还算可以接受，我的天一次性，还得多搬砖啊
         */
    }
}
