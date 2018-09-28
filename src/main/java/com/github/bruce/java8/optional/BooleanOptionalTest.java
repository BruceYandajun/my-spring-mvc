package com.github.bruce.java8.optional;

import java.util.Optional;

import static com.github.bruce.utils.BaseUtil.line;

public class BooleanOptionalTest {

    public static void main(String[] args) {
        // 判断person是不是20岁
        Person person = new Person();
        person.setAge(null);
//        person = null;
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        boolean result = optionalPerson.map(Person::getAge).filter(a -> a == 20).isPresent();
        line(result);
    }
}
