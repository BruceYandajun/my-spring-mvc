package com.github.bruce.java8.function;

//@FunctionalInterface
public interface Foo {

    String method(String string);

    default void defaultMethod() {

    }

    default void abc() {

    }
}
