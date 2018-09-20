package com.github.bruce.java8.parallel;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang.math.RandomUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.stream.Collectors.toList;

@Data
@AllArgsConstructor
public class Shop {
    public static List<Shop> shops;
    public static Executor executor;

    static {
        shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));
        executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                r -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                });
    }

    private String name;

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPrice_discount(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[
                RandomUtils.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread (() -> {
            double price = calculatePrice(product);
            try {
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsync_Simple(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public Future<Double> getPriceAsync_executor(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product), executor);
    }

    public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    public static List<String> findPrices_parallel(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    public static List<String> findPrices_future(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getName() + " price is " +
                                        shop.getPrice(product)))
                        .collect(toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(toList());
    }

    public static List<String> findPrices_customizePool(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getName() + " price is " +
                                        shop.getPriceAsync_executor(product)))
                        .collect(toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(toList());
    }


    private double calculatePrice(String product) {
        delay();
        return RandomUtils.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        int delay = 500 + RandomUtils.nextInt(2000);
//        delay = 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}