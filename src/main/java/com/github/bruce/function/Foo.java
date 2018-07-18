package com.github.bruce.function;

//@FunctionalInterface
public interface Foo {

    String method(String string);

    default void defaultMethod() {

    }

    default void abc() {

    }
}
