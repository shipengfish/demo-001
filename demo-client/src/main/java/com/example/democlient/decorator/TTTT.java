package com.example.democlient.decorator;

import java.util.concurrent.CompletableFuture;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/11/28
 * @description
 * @since 1.0
 */
public class TTTT {

    public static void main(String[] args) {
        final long l = System.currentTimeMillis();
//        a();
//        b();

        final CompletableFuture<String> fa = fa();
        final CompletableFuture<String> fb = fb();

        final Object join = CompletableFuture.anyOf(fa, fb).join();
        System.out.println("有一个执行完毕"+join);
        CompletableFuture.allOf(fa, fb).join();
        System.out.println("所有都完毕");
        final CompletableFuture<String> ll = fa.thenCombine(fb, (c, d) -> c + "---" + d);

        final CompletableFuture<String> l2 =
                fa.thenCompose(hh -> CompletableFuture.supplyAsync(() -> hh + "hello"));

        System.out.println(ll.join());
        System.out.println(l2.join());

        System.out.println(fa.join() + fb.join());



        System.out.println(fa.thenApply(aaa -> aaa + "bbb").join());
        System.out.println(System.currentTimeMillis() - l);
    }

    public static CompletableFuture<String> fa() {
        return CompletableFuture.supplyAsync(() -> a());
    }

    public static CompletableFuture<String> fb() {
        return CompletableFuture.supplyAsync(() -> b(""));
    }

    public static String a() {
        try {
            Thread.sleep(1000);
            return "hello";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String b(String str) {
        try {
            Thread.sleep(3000);
            return "world" + str;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }
}
