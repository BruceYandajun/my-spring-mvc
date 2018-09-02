package com.github.bruce.java8.methodReference;

public class Apple {
    private Integer weight;
    private String color;
    private String owner;

    public Apple() {

    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple(String color) {
        this.color = color;
    }

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(Integer weight, String color, String owner) {
        this.weight = weight;
        this.color = color;
        this.owner = owner;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String toString() {
        return "weight:" + weight + ", color:" + color + ", owner:" + owner;
    }
}