package com.github.bruce.java8.methodReference;

public enum AppleWeightType {
    LIGHT,
    NORMAL,
    WEIGHT;

   public static AppleWeightType getType(Apple apple) {
        if (apple.getWeight() < 5) {
            return LIGHT;
        }
        if (apple.getWeight() > 6) {
            return WEIGHT;
        }
        return NORMAL;
    }

}
