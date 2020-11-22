package training.termialoperators;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperatorsExercise implements StreamTerminalOperators {


    //Two different ways to add to a Collection
    //1
    @Override
    public void addToSet(Stream<String> stream, Set<String> set) {
        set.addAll(stream.collect(Collectors.toSet()));
    }
    //2
    @Override
    public void addToListInReverseOrder(Stream<String> stream, List<String> list) {
        stream.sorted(Comparator.reverseOrder()).forEach(s -> list.add(s));
    }

    @Override
    public String[] collectToArray(Stream<String> stream) {
        return stream.toArray(String[]::new);
    }

    @Override
    public Set<String> collectToSet(Stream<String> stream) {
        return stream.collect(Collectors.toSet());
    }

    @Override
    public List<String> collectToList(Stream<String> stream) {
        return stream.collect(Collectors.toList());
    }

    @Override
    public String mergeIntoString(Stream<String> stream) {
        return stream.collect(Collectors.joining("-"));
    }

    @Override
    public int countCharacters(Stream<String> stream) {
        return stream.collect(Collectors.joining()).length();
    }

    @Override
    public int longestWordLength(Stream<String> stream) {
        return stream.max(Comparator.comparingInt(String::length)).orElse("").length();
    }

    @Override
    public String longestWord(Stream<String> stream) {
        return stream.max(Comparator.comparingInt(String::length)).orElse("");
    }

    @Override
    public Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream) {
        return stream.collect(Collectors.groupingBy(String::length));
    }
}
