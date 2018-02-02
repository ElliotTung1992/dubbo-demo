package com.github.dge1992.lambda.java8.FunctionalInterface;

@FunctionalInterface
public interface Transformer<T> {

    T transform(T input);

}
