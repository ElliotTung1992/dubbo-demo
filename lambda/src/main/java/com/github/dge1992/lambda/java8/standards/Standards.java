package com.github.dge1992.lambda.java8.standards;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author  dong
 * @desc
 *
 * 提倡使用有帮助的编码
 *
 * 表达能力是函数式编程的优势之一
 * 对简洁性的过度追求导致代码无用
 *
 **/
public class Standards {

    public static void main(String[] args) {

        Standards standards = new Standards();
        standards.test1();
    }

    private void test1() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> names = Arrays.asList("hello", "java", "eight");

        //推荐
        //Java 8 垂直对齐各点的约定
        System.out.println(
                numbers.stream()
                        .filter(e -> e  > 3)
                        .filter(e -> e % 2 == 0)
                        .filter(e -> e < 8)
                        .mapToInt(e -> e * 2)
                        .sum());

        //不推荐
        System.out.println(names.stream().filter(name -> name.startsWith("J")).filter(name -> name.length() > 3)
                .map(name -> name.toUpperCase()).collect(Collectors.joining(", ")));

        /**
         * Java 8 垂直对齐各点的约定的好处
         * 1.遵循此约定的代码更容易阅读、理解和解释。我们可以在详细检查每部分之前，快速掌握整个目标。
         * 2.元素非常明确且容易找到，有助于更快地修改。如果我们想包含另一个条件，或者删除或修改一个现有条件，那么可以相对容易找到该行并执行更改。
         * 3.该代码更容易维护，这表明我们关心团队的其他开发人员。除了让代码更容易维护之外，编写有帮助的代码还能显著提高团队士气。
         */
    }
}
