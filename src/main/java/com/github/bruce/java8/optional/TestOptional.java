package com.github.bruce.java8.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

import static com.github.bruce.utils.BaseUtil.line;

public class TestOptional {
    public static void main(String[] args) {
        Insurance insurance = new Insurance("Sunshine");
        Car car = new Car();
        car.setInsurance(Optional.ofNullable(insurance));
        Person person = new Person();
        person.setAge(30);
        person.setCar(Optional.ofNullable(car));

        Optional<Person> optionalPerson = Optional.ofNullable(person);
        line(getCarInsuranceName(optionalPerson, 20));
    }

    /**
     * 找出年龄大于或者等于minAge参数的Person所对应的保险公司名称
     * @param person
     * @param minAge
     * @return
     */
    private static String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}



@Data
class Person {
    private Integer age;
    private Optional<Car> car;
}
@Data
class Car {
    private Optional<Insurance> insurance;
}
@Data
@AllArgsConstructor
class Insurance {
    private String name;
}