package com.github.dge1992.lambda.java8.functional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Java 中的一种更轻松的函数式编程途径:
 *
 * 1.命令式格式
 * 2.声明式格式
 * 3.函数式格式
 *
 */
public class Functional {

    public static void main(String[] args) {
        Functional functional = new Functional();


//        functional.test();

        //函数式格式
        functional.test2();

        /**
         * 在 Java 程序中采用函数式方法和语法有许多好处：代码简洁，更富于表达，不易出错，更容易并行化，而且通常比面向对象的代码更容易理解。
         * 我们面临的挑战在于将思维方式从命令式编程 — 绝大多数开发人员都熟悉它 — 转变为声明式思考。
         */

    }


    private void test() {

        List<String> names =
                Arrays.asList("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");

        //命令式格式
        findNemo(names);

        //声明式格式
        findNemo2(names);
    }


    private void findNemo(List<String> names) {

        /**
         * 因为这是一个命令式编程的程序 — 许多 Java 开发人员最熟悉的格式 — 所以您需要定义程序的每一步：
         * 告诉它迭代每个元素，比较值，设置 flag 变量，然后跳出循环。
         * 命令式格式为您提供了完全的控制权，这有时是件好事。
         * 而另一方面，您需要执行所有工作。在许多情况下，可以减少工作量来提高效率。
         */

        boolean found = false;
        for(String name : names) {
            if(name.equals("Nemo")) {
                found = true;
                break;
            }
        }
        if(found)
            System.out.println("Found Nemo");
        else
            System.out.println("Sorry, Nemo not found");
    }

    private void findNemo2(List<String> names) {

        /**
         * 这个版本中没有任何垃圾变量。您也没有将精力浪费在对集合的循环处理上，而是使用内置的 contains() 方法来完成工作。
         * 在声明式版本中，您无需关心工作如何完成，只要它完成即可。
         * contains() 的实现可能不同，但只要结果符合预期，您可能就会很开心。花更少的精力获得同样的结果。
         */

        if(names.contains("Nemo"))
            System.out.println("Found Nemo");
        else
            System.out.println("Sorry, Nemo not found");
    }

    private void test2() {

        /**
         * 尽管函数式格式的编程始终是声明式的，但简单地使用声明式编程并不等于函数式编程。
         * 这是因为函数式编程合并了 <声明式方法> 与 <高阶函数> 。
         * 什么是高阶函数
         * > 可以接收、创建或返回函数的函数或方法被视为高阶函数。
         */

        Map<String, Integer> pageVisits = new HashMap<>();
        Map<String, Integer> pageVisits1 = new HashMap<>();

        String page = "https://agiledeveloper.com";

        incrementPageVisit(pageVisits, page);
        incrementPageVisit(pageVisits, page);

        System.out.println(pageVisits.get(page));

        incrementPageVisit1(pageVisits1, page);
        incrementPageVisit1(pageVisits1, page);

        System.out.println(pageVisits1.get(page));
    }

    public static void incrementPageVisit(Map<String, Integer> pageVisits, String page) {

        /**
         * incrementPageVisit() 方法是使用命令式格式编写的：它的职责是递增给定页面的计数，将该计数存储在 Map 中。
         * 该方法不知道给定页面是否有计数，所以它首先会检查是否存在计数。
         * 如果不存在，那么它会插入一个 “0” 作为该页面的计数。然后获得该计数，递增它，并将新值存储在 Map 中。
         */

        if(!pageVisits.containsKey(page)) {
            pageVisits.put(page, 0);
        }

        pageVisits.put(page, pageVisits.get(page) + 1);
    }

    public static void incrementPageVisit1(Map<String, Integer> pageVisits, String page) {
        /**
         * 因为 merge() 是一个高阶函数，所以新代码实际上是一个不错的函数式编程示例：
         */
        pageVisits.merge(page, 1, (oldValue, value) -> oldValue + value);
    }

}
