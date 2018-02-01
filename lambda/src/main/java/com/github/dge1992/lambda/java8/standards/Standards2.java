package com.github.dge1992.lambda.java8.standards;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * 使代码更容易阅读、测试和重用的单行 lambda 表达式
 *
 */
public class Standards2 {

    public static void main(String[] args) {

        Standards2 functional = new Standards2();

        //编写lambda表达式的两种方式
//        functional.test1();

        //函数组合的强大功能
//        functional.test2();

        //充满危险的长 lambda 表达式
//        functional.test3();

        //使用 Lambda 作为粘合代码
        functional.test4();

        /**
         * 1.为什么不用 多行的 lambda 表达式
         * > 包含多行的 lambda 表达式具有相反的效果，会让代码变得杂乱且难以阅读。
         * > 多行 lambda 表达式还难以测试和重用，这可能导致重复工作和代码质量差。
         *
         * 2.解决方案
         * > 幸运的是，通过将多行 lambda 表达式的主体转移到一个命名函数中，然后从 lambda 表达式内调用该函数，
         * > 这样很容易避免这些问题。我也推荐尽可能将 lambda 表达式替换为方法引用。
         */
    }

    private void test1() {

        /**
         * 1.普通的函数或方法通常有 4 个元素：
         * > 一个名称
         * > 返回类型
         * > 参数列表
         * > 主体
         *
         * 2.lambda只有这 4 元素中的最后两个：
         * > (parameter list) -> body
         * > “->” 将参数列表与函数主体分离，旨在对给定参数进行处理。
         * > 函数的主体可能是一个表达式或一条语句。
         */


        /**
         * 单行lambda表达式
         */
        IntStream.range(0, 20)
                .forEach(e -> System.out.println(e));

        /**
         * 多行lambda表达式
         *
         * 因为主体包含多行，所以括号 ({})、分号 (;) 和 return 关键字都是必需的。
         */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .map(e -> {
                    double sqrt = Math.sqrt(e);
                    double log = Math.log(e);
                    return sqrt + log;
                })
                .forEach(System.out::println);
    }

    private void test2() {

        //命令式风格
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = 0;
        for(int e : values) {
            if(e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }
        System.out.println(result);

        //函数式风格
        int result1 = values.stream()
                .filter(e -> e > 3)
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .findFirst()
                .orElse(0);
        System.out.println(result1);

        /**
         * 函数组合的表达能力很大程度上依赖于每个 lambda 表达式的简洁性。
         * 如果您的 lambda 表达式包含多行（甚至两行可能都太多），您可能没有理解函数式编程的关键点。
         */
    }

    private void test3() {

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(
                values.stream()
                        .mapToInt(e -> {
                            int sum = 0;
                            for(int i = 1; i <= e; i++) {
                                if(e % i == 0) {
                                    sum += i;
                                }
                            }

                            return sum;
                        })
                        .sum());

        /**
         * 此代码的特点
         * 1.难以读懂
         * 2.用途不明
         * 3.代码质量差
         * 4.难以测试
         * 5.代码覆盖范围小
         */
    }

    private void test4() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //不推荐
        int sum = values.stream()
                .mapToInt(e -> {
                    return IntStream.rangeClosed(1, e)
                            .filter(i -> e % i == 0)
                            .sum();
                })
                .sum();

        System.out.println(sum);

        //推荐
        int sum1 = values.stream()
                .mapToInt(e -> sumOfFactors(e))
                .sum();

        System.out.println(sum1);
    }

    public int sumOfFactors(int number) {
        return IntStream.rangeClosed(1, number)
                .filter(i -> number % i == 0)
                .sum();
    }
}
