package com.github.bruce.java8.function;

public class TestLambdaScope {

    private String value = "Outer Class Scope";

    public String innerClass() {
        // anonymous inner class
        Foo foo = new Foo() {
            private String value = "Inner Class Scope";
            @Override
            public String method(String string) {
                return this.value;
            }
        };
        return foo.method("");
    }

    public String lambdaExpression() {
        Foo foo = s -> {
            String value = "Lambda Scope";
            return this.value;
        };
        return foo.method("");
    }

    public static void main(String[] args) {
        TestLambdaScope testLambdaScope = new TestLambdaScope();
        System.out.println(testLambdaScope.innerClass());
        System.out.println(testLambdaScope.lambdaExpression());
    }

}
