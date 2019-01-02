package com.ysp.arithmetic;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/10/11
 * @description
 * @since 1.0
 */
public class BinarySearch {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        final long l = System.currentTimeMillis();

        List<Integer> collect = IntStream.range(0, 100000000).boxed().collect(Collectors.toList());
        System.out.println("消耗: " + (System.currentTimeMillis() - l));
        List<String> strings = Arrays.asList("A", "B", "C", "D", "F", "I", "J", "K", "M");
        final int d = find(collect, 100000000 / 2 - 1);
        System.out.println(atomicInteger.get());
    }

    private static int find(List<Integer> nameList, int guessName) {

        int low = 0;
        int high = nameList.size() - 1;

        while (low <= high) {
            atomicInteger.getAndAdd(1);
            int middle = (low + high) / 2;

            int middleName = nameList.get(middle);

            if (guessName > middleName) {
                low = middle + 1;
            }

            if (guessName < middleName) {
                high = middle - 1;
            }
            if (guessName == middleName) {
                return middle;
            }
        }
        return 0;
    }
}
