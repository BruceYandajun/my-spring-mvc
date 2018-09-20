package com.github.bruce.java8.parallel;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
        private final int percentage;
        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + String.format("%.2f", apply(quote.getPrice(), quote.getDiscountCode()));
    }

    private static double apply(double price, Code code) {
        Shop.delay();
        return price * (100 - code.percentage) / 100;
    }

    public static List<String> findPrices(String product) {
        return Shop.shops.stream().map(shop -> shop.getPrice_discount(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount).collect(toList());
    }

    public static List<String> findPrices_future(String product) {
        List<CompletableFuture<String>> priceFutures =
                Shop.shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice_discount(product), Shop.executor))
                        .map(future -> future.thenApply(Quote::parse))
                        .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), Shop.executor)))
                        .collect(toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(toList());
    }

    public static Stream<CompletableFuture<String>> findPricesStream(String product) {
        return Shop.shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice_discount(product), Shop.executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote), Shop.executor)));
    }

    public static void printAllPrices() {
        long start = System.nanoTime();
        CompletableFuture[] futures = findPricesStream("myPhone27S")
                .map(f -> f.thenAccept(
                        s -> System.out.println(s + " (done in " +
                                ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();// 所有的都执行完用allOf
        //CompletableFuture.anyOf(futures).join();// 只要有一个执行完用anyOf
        System.out.println("All shops have now responded in "
                + ((System.nanoTime() - start) / 1_000_000) + " msecs");
    }

}
