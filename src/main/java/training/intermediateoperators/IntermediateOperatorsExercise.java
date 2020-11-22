package training.intermediateoperators;

import javax.sql.ConnectionPoolDataSource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperatorsExercise implements StreamIntermediateOperators {

    @Override
    public Stream<String> wordsLongerThanFiveCharacters(List<String> words) {
        return words.stream().filter(w -> w.length() > 5);
    }

    @Override
    public Stream<String> firstThreeWordsLongerThanFiveCharacters(List<String> words) {
        return words.stream().filter(w -> w.length() > 5).limit(3);
    }

    @Override
    public Stream<String> firstThreeDistinctWordsLongerThanFiveCharactersInReverseAlphabeticalOrder(List<String> words) {
        return words.stream().filter(w -> w.length() > 5).distinct().limit(3).sorted(Comparator.reverseOrder());
    }

    @Override
    public Stream<Integer> lengthOfWords(List<String> words) {
        return words.stream().map(w -> w.length());
    }

    @Override
    public Stream<Integer> staircase() {
        return Stream.iterate(0,n -> n < 8, n -> n+1).flatMap(n-> Stream.iterate(0, i -> i < n,i -> i + 1));
    }
}
