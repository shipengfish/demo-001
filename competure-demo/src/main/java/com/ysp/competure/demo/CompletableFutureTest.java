package com.ysp.competure.demo;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/12/8
 * @description
 * @since 1.0
 */
public class CompletableFutureTest {

    static ExecutorService executors = Executors.newFixedThreadPool(Math.min(10, 100), r -> {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    });

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // 1. 普通调用方式
//         final String a = a();
//         final String b = b();
//        System.out.println(a);
//        System.out.println(b);

        CompletableFuture<String> fa = fa();
        CompletableFuture<String> fb = fb(null);

        // 2. 普通使用异步编程
//        System.out.println(fa.join());
//        System.out.println(fb.join());


        // 3. 优先使用最早返回的结果
        String earlyResponse = (String) CompletableFuture.anyOf(fa, fb).join();
        System.out.println(earlyResponse);


        // 4. 等到所有结果都响应，再进行后续操作
//        CompletableFuture.allOf(fa, fb).join();
//        System.out.println(fa.join());
//        System.out.println(fb.join());


        // 5. 合并两者的结果.
//        String combine = sfa.thenCombine(fb, (k1, k2) -> k1 + " combine " + k2).join();
//        System.out.println(combine);


        // 6. 结果间有依赖关系
//        String compose = fa.thenCompose(CompletableFutureTest::fb).join();
//        System.out.println(compose);

        System.out.println("耗时: " + (System.currentTimeMillis() - start));
    }

    private static CompletableFuture<String> fa() {
        return CompletableFuture.supplyAsync(CompletableFutureTest::a, executors);
    }

    private static CompletableFuture<String> fb(String input) {
        System.out.println("input: " + input);
        return CompletableFuture.supplyAsync(CompletableFutureTest::b, executors)
                .exceptionally(Throwable::getMessage);
    }


    private static String a() {
        int duration = 0;
        try {
            duration = RandomUtils.nextInt(1, 5);
            Thread.sleep(SECONDS.toMillis(duration));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello world " + "method【a】sleep " + duration;
    }

    private static String b() {
        int duration = 0;
        try {
            duration = RandomUtils.nextInt(1, 5);
            Thread.sleep(SECONDS.toMillis(duration));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello world " + "method【b】sleep " + duration;
    }

}
