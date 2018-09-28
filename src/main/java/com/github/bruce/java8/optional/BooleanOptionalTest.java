package com.github.bruce.java8.optional;

import java.util.Optional;

import static com.github.bruce.utils.BaseUtil.line;

public class BooleanOptionalTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(21);
        person = null;
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        boolean watched = optionalPerson.filter(p -> p.getAge() == 20).isPresent();
        line(watched);
    }
}
