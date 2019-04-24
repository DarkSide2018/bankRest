package com.bankrest.additionalTasks;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class AutoTest extends Main {
    public static void main(String[] args) {

        Stream.generate(() -> "1")
                .filter(x -> x.length() > 1)
                .limit(10)
                .forEach(System.out::println);

    }

    private static List<String> customsort(List<String> list) {
       return list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
