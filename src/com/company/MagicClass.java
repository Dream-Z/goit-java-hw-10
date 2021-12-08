package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MagicClass {
    private List<String> names = List.of("Aleksander", "Maxim", "Artyom", "Mikhail", "Ivan", "Danila", "Dmitriy", "Kirill", "Andrei", "Egor");

    public void run() {
        System.out.println("Exercise1:");
        List<String> newNamesList = IntStream.range(0, names.size()).filter(i -> i % 2 != 0).mapToObj(i -> i + ". " + names.get(i)).collect(Collectors.toList());
        System.out.println(newNamesList);

        System.out.println("\nExercise2:");
        List<String> sortedList = names.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList);

        System.out.println("\nExercise3:");
        String [] numbers = {"1, 2, 0", "4, 5"};
        List<Integer> integers = Arrays.stream(String.join(", ", numbers).split(", ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        System.out.print(integers);

        System.out.println("\n\nExercise4:");
        Long a = 25214903917L;
        Long c = 11L;
        Long m = (long) Math.pow(2, 48);

        List<Long> generated = generator(a, c, m, 1).limit(300).collect(Collectors.toList());
        System.out.println("generated: " + generated);

        System.out.println("\nExercise5:");
        List<String> numbersList = List.of("1", "10", "6", "3", "9", "7", "21", "2", "4", "5", "11");
        List<String> resultList = new ArrayList<>();

        Stream<String> shuffledStream = zip(names, numbersList, resultList);
        System.out.println(shuffledStream.collect(Collectors.toList()));

    }

    public Stream<Long> generator(long a, long c, long m, long seed) {
        return Stream.iterate(seed, n -> (a * n + c) % m);
    }

    public <T> Stream<T> zip(List<String> first, List<String> second, List<String> result){
        if(first.size() > second.size()){
            shuffle(second, first, result);
        } else {
            shuffle(first, second, result);
        }
        return (Stream<T>) result.stream();
    }

    public <T> void shuffle(List<String> first, List<String> second, List<String> result){
        for (int i = 0; i < first.size(); i++) {
            result.add(first.get(i));
            result.add(second.get(i));
        }
    }
}
