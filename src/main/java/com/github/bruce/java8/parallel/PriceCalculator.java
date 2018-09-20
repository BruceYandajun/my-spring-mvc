package com.github.bruce.java8.parallel;

import java.util.concurrent.Future;

import static com.github.bruce.utils.BaseUtil.line;

public class PriceCalculator {

    public static void main(String[] args) {
        line("The number of available processors : " + Runtime.getRuntime().availableProcessors());

        Discount.printAllPrices();
    }

    public static void getPriceAsync() throws InterruptedException {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync_Simple("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        line("Invocation returned after " + invocationTime + " msecs");
        // 执行更多任务，比如查询其他商店
        Thread.sleep(1000);
        // 在计算商品价格的同时
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        line("Price returned after " + retrievalTime + " msecs");
    }

    public static void sequentialStream() {
        long start = System.nanoTime();
        line(Shop.findPrices("iphone se"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        line("Done in " + duration + " msecs");
    }

    public static void parallelStream() {
        long start = System.nanoTime();
        line(Shop.findPrices_parallel("iphone se"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        line("Done in " + duration + " msecs");
    }

    public static void futureStream() {
        long start = System.nanoTime();
        line(Shop.findPrices_customizePool("iphone se"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        line("Done in " + duration + " msecs");
    }

    public static void discount() {
        long start = System.nanoTime();
        line(Discount.findPrices("iphone se"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        line("Done in " + duration + " msecs");
    }

    public static void discount_future() {
        long start = System.nanoTime();
        line(Discount.findPrices_future("iphone se"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        line("Done in " + duration + " msecs");
    }

}
