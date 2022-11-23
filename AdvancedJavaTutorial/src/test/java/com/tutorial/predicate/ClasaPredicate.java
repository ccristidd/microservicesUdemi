package com.tutorial.predicate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClasaPredicate {

    @Test
    public void basicExampleSimplePredicate() {
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        assertEquals(2, result.size());
        assertThat(result).containsExactly("Adam", "Alexander");
    }

    @Test
    public void basicExampleMultiplePredicates() {
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .filter(name -> name.length() < 5)
                .collect(Collectors.toList());
        assertEquals(1, result.size());
        assertThat(result).containsExactly("Adam");
    }

    @Test
    public void basicExampleComplexPredicates() {
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A") && name.length() < 5)
                .collect(Collectors.toList());
        assertEquals(1, result.size());
        assertThat(result).containsExactly("Adam");
    }

    @Test
    public void combiningPredicatesUsingPredcateMethodAnd() {
        //In this example, we'll define our Predicates explicitly,
        // and then we'll combine them using Predicate.and():
        Predicate<String> predicate1 = str -> str.startsWith("A");
        Predicate<String> predicate2 = str -> str.length() < 5;
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        List<String> result = names.stream()
                .filter(predicate1.and(predicate2))
                .collect(Collectors.toList());
        assertEquals(1, result.size());
        assertThat(result).containsExactly("Adam");
    }

    @Test
    public void combiningPredicatesUsingPredcateMethodOr() {
        //In this example, we'll define our Predicates explicitly,
        // and then we'll combine them using Predicate.and():
        Predicate<String> predicate1 = str -> str.startsWith("J");
        Predicate<String> predicate2 = str -> str.length() < 5;
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        List<String> result = names.stream()
                .filter(predicate1.or(predicate2))
                .collect(Collectors.toList());
        assertEquals(3, result.size());
        assertThat(result).contains("John", "Adam", "Tom");
    }

    @Test
    public void combiningPredicatesUsingPredcateMethodNegate() {
        //In this example, we'll define our Predicates explicitly,
        // and then we'll combine them using Predicate.and():
        Predicate<String> predicate1 = str -> str.startsWith("J");
        Predicate<String> predicate2 = str -> str.length() < 5;
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        List<String> result = names.stream()
                .filter(predicate1.negate())
                .collect(Collectors.toList());

        List<String> result2 = names.stream()
                .filter(predicate1.or(predicate2.negate()))
                .collect(Collectors.toList());
        assertEquals(3, result.size());
        assertThat(result).contains("Adam", "Alexander", "Tom");

        assertEquals(2, result2.size());
        assertThat(result2).contains("John", "Alexander");
    }

    @Test
    public void combiningPredicatesInline() {
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        List<String> result = names.stream()
                .filter(((Predicate<String>) name -> name.startsWith("A"))
                        .and(name -> name.length() < 5))
                .collect(Collectors.toList());
        assertEquals(1, result.size());
        assertThat(result).containsExactly("Adam");
    }

    @Test
    public void combinePreicatesByReducingThemAndWithLambda() {
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom", "Mel");
        List<Predicate<String>> predicates = new ArrayList<>();
        predicates.add(a -> a.startsWith("A"));
        predicates.add(a -> a.length() > 5);
        predicates.add(a -> a.contains("d"));

        //identity de la reduce de fapt face true "and" celelalte conditii sau false "and" celelalte conditii
        //sau true "or" celelalte conditii sau false "or" celelalte conditii
        List<String> result = names.stream()
                .filter(predicates.stream()
                        .reduce(x -> true, (p, r) -> p.and(r)))
                .collect(Collectors.toList());
        assertEquals(1, result.size());
        assertThat(result).containsExactly("Alexander");
    }

    @Test
    public void combinePreicatesByReducingThemOrWithMethodReference() {
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom", "Mel");
        List<Predicate<String>> predicates = new ArrayList<>();
        predicates.add(a -> a.startsWith("A"));
        predicates.add(a -> a.length() > 5);
        predicates.add(a -> a.contains("d"));

        //identity de la reduce de fapt face true "and" celelalte conditii sau false "and" celelalte conditii
        //sau true "or" celelalte conditii sau false "or" celelalte conditii
        List<String> result = names.stream()
                .filter(predicates.stream()
                        .reduce(x -> false, Predicate::or))
                .collect(Collectors.toList());
        assertEquals(2, result.size());
        assertThat(result).containsExactly("Adam", "Alexander");
    }
}
