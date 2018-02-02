package com.github.dge1992.lambda.java8.FunctionalInterface;

import com.github.dge1992.lambda.java8.bean.Product;

import java.util.List;
import java.util.stream.Stream;

public class Order {

    List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    /**
     * 把商品的流传进去,然后直接对流进行遍历
     * @param transformProduct
     */
    public void transformAndPrint(
            Transformer<Stream<Product>> transformProduct) {

        transformProduct.transform(products.stream())
                .forEach(System.out::println);
    }
}
