package com.github.dge1992.lambda.java8.methods;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

/**
 * @author  dong
 * @desc
 *
 *  java8使用方法引用应用场景
 *
 *  传递表达式（pass-through lambdas）的替代方案
 *
 *  lambda 表达式的存在只是为了传递一个或多个形参，最好将它替换为方法引用
 *
 **/
public class Methods {

    public static void main(String[] args) {

        Methods lambda5 = new Methods();

        //传递lambda表达式是什么？
//        test1();

        //传递形参作为实参
//        lambda5.test2();

        //将形参传递给目标
//        lambda5.test3();

        //传递构造函数调用
//        lambda5.test4();

        //传递多个实参
//        lambda5.test5();

        //最好使用方法引用
        lambda5.test6();

        /**
         * 只要看到一个 lambda 表达式的唯一目的是将形参传递给一个或多个其他函数，就需要考虑将该 lambda 表达式替换为方法引用是否更好。
         * 决定因素在于，lambda 表达式内没有完成任何实际工作。在这种情况下，
         * lambda 表达式就是一个传递表达式，而且它的语法对于当前这个任务而言可能过于复杂了
         */
    }


    private static void test1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(e -> System.out.println(e));
        /**
         * 1.两个表达式的区别：
         * > filter(e -> e % 2 == 0)  第一个 lambda 表达式实际执行一些工作
         *
         * > forEach(e -> System.out.println(e)); 第二个没有
         * 传递给 forEach 方法的 lambda 表达式就是我们所称的传递 lambda 表达式
         *
         * 2.(parameters) -> body
         * >为了理解 (parameters) -> body 的用途，我们需要进入 body（在 -> 的右侧）来查看该形参发生了什么。
         * 如果该 lambda 表达式没有对该形参执行任何实际操作，则付出的努力就白费了。
         *
         */

        /**
         * 将传递 lambda 表达式替换为方法引用会比较有益
         */
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
    }

    private void test2() {
        /**
         * 每种表达式替换为方法引用
         */

        /**
         * 1.实例方法的实参
         * > lambda 表达式将其形参作为实参传递给实例方法，这非常常见。
         * > 形参 e 作为实参传递给 println 方法，该方法本身是 System.out 的一个实例方法。
         * > 我们使用以下格式将此 lambda 表达式替换为方法引用 System.out::println：
         * > forEach(e -> System.out.println(e));     ----->     forEach(System.out::println);
         * > 要将 lambda 表达式更改为方法引用，只需删除通用的部分（形参和实参），并在方法调用上将点替换为冒号。
         */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .forEach(e -> System.out.println(e));

        numbers.stream()
                .forEach(System.out::println);

        /**
         * 2.this上的一个方法的实参
         * 在当前方法的 context 实例上调用实例方法
         *
         * 与将 e -> System.out.println(e) 替换为 System.out::println 非常相似的是，
         * 可以将 lambda 表达式 e -> increment(e)（或更准确地讲 e -> this.increment(e)）
         * 替换为 this::increment。在两种情况下，代码都更加清晰
         *
         */
        numbers.stream()
                .map(e -> increment(e));

        numbers.stream()
                .map(e -> this.increment(e));

        numbers.stream()
                .map(this::increment);

        /**
         * 3.静态方法的实参
         */
        List<String> strs = Arrays.asList("12", "13", "14");

        strs.stream()
                .map(e -> Integer.valueOf(e));

        strs.stream()
                .map(Integer::valueOf);
    }

    public int increment(int number) {
        return number + 1;
    }

    private void test3() {

        /**
         * 现在让我们考虑一种变形：形参是方法调用的目标。
         * .map(e -> e.doubleValue())
         *
         * 在存在疑问时，最好使用 lambda 表达式，以避免任何混淆或可能的错误。
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .map(e -> e.toString())
                .forEach(System.out::println);

        /**
         *
         * 我们不能将 lambda 表达式 (Integer e) -> e.toString() 替换为方法引用 Integer::toString，
         * 因为 Integer 类同时包含静态方法 public static String toString(int i) 和实例方法 public String toString()。
         *
         */
//        numbers.stream()
//                .map(Integer::toString)
//                .forEach(System.out::println);

        numbers.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    private void test4() {
        /**
         * 除了静态和实例方法，也可以使用方法引用来表示对构造函数的调用。
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        LinkedList<Integer> collect = numbers.stream()
                .collect(toCollection(() -> new LinkedList<Integer>()));

        System.out.println(collect);

        LinkedList<Integer> collect1 = numbers.stream()
                .collect(toCollection(LinkedList::new));

        System.out.println(collect1);
    }

    private void test5() {
        /**
         * 目前您已看到了单一形参和传递空形参的例子。但方法引用不仅限于 0 或 1 个形参，它们也适用于多个实参
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer reduce = numbers.stream()
                .reduce(0, (sum, item) -> sum + item);
        System.out.println(reduce);

        Integer reduce1 = numbers.stream()
                .reduce(0, (sum, item) -> Integer.sum(sum, item));
        System.out.println(reduce1);

        Integer reduce2 = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(reduce2);

        /**
         *
         * 作为目标和实参传递
         *
         * lambda 表达式的第一个形参用作实例方法调用的目标。
         * 第二个形参用作该方法的实参。根据此顺序，可以将该 lambda 表达式替换为方法引用。
         */
        List<String> strs = Arrays.asList("hello", " java", " eight");

        String reduce3 = strs.stream()
                .reduce("", (result, str) -> result.concat(str));
        System.out.println(reduce3);

        String reduce4 = strs.stream()
                .reduce("", String::concat);
        System.out.println(reduce4);
    }

    private void test6() {

        /**
         * 要掌握传递 lambda 表达式的变形和结构，以及取代它们的方法引用，需要花一定的时间和精力。
         * 在这之后，就开始感觉使用方法引用取代传递表达式变得更加自然。
         * 比较这两个清单，很容易看到使用方法引用的代码更加流畅且更容易阅读。
         */

        List<String> strs = Arrays.asList("hello", null," java", " eight");

        List<String> nonNullNamesInUpperCase =
                strs.stream()
                        .filter(name -> Objects.nonNull(name))//非null过滤
                        .map(name -> name.toUpperCase())//转换成大写
                        //收集到一个不可修改的列表中
                        .collect(collectingAndThen(toList(), list -> Collections.unmodifiableList(list)));

        System.out.println(nonNullNamesInUpperCase);

        List<String> nonNullNamesInUpperCase1 =
                strs.stream()
                        .filter(Objects::nonNull)
                        .map(String::toUpperCase)
                        .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        System.out.println(nonNullNamesInUpperCase1);
    }
}
