package com.github.dge1992.lambda.java8.type;

import java.util.Comparator;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;

/**
 * @author  dong
 * @desc
 *
 * java8 lambda表达式中使用类型推算
 *
 **/
public class Type {

    public static void main(String[] args) {

        /**
         * 虽然类型推算使我们的编程看起来更加便捷，但是我们还是要注意命名规范
         */
        Type type = new Type();

        //java8 中的类型推算
        type.test1();

//        type.test2();
    }


    private void test1() {

        IntStream.rangeClosed(1, 5)
                .forEach((int number) -> System.out.println(number * 2));

        // 当您从某个数字范围中提取一个值时，编译器知道该值的类型为 int。
        // 不需要在代码中显式声明该值，尽管这是目前为止的约定。
        IntStream.rangeClosed(1, 5)
                .forEach((number) -> System.out.println(number * 2));

        //编译器会直接报错，因为number.length()是String的方法
//        IntStream.rangeClosed(1, 5)
//                .forEach((number) -> System.out.println(number.length() * 2));

    }


}



