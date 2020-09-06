package com.github.bruce.concurrent.threadpool;

import java.util.Random;
import java.util.concurrent.*;

public class Translator {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(new Translator().translate("abc"));
    }

    // todo
    public String translate(String content) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<>(executor);
        executorCompletionService.submit(() -> baidu(content));
        executorCompletionService.submit(() -> google(content));
        executorCompletionService.submit(() -> youdao(content));
        String result = executorCompletionService.take().get();
        executor.shutdown();
        return result;
    }

    public String baidu(String content) {
        randomSleep("baidu");
        return "baidu";
    }

    public String google(String content) {
        randomSleep("google");
        return "googe";
    }

    public String youdao(String content) {
        randomSleep("youdao");
        return "youdao";
    }

    private void randomSleep(String s) {
        try {
            int i = new Random().nextInt(3000);
            Thread.sleep(i);
            System.out.println(s + " sleep " + i + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
