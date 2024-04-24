package com.tutorial.bifunction;


import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


public class Bifunctii {
    @Test
    public void streamSimpleFunction() {
        List<String> lista = new ArrayList<>();
        lista.add("hello");
        lista.add("world");
        lista.add("baeldung");
        List<String> result = lista.stream()
                .map(e -> e + "-")
                .collect(Collectors.toList());
        assert (result.contains("baeldung-"));
        assertEquals(result.get(0), "hello-");
    }

    @Test
    public void streamBifunctionUsingLambda() {
        List<String> lista = new ArrayList<>();
        lista.add("hello");
        lista.add("world");
        lista.add("baeldung");

        String result = lista.stream()
                .reduce("", (a, b) -> b + "-" + a);
        assertEquals("baeldung-world-hello-", result);
    }

    @Test
    public void streamBifunctionUsingLambdaNoTrailingSpaces() {
        List<String> lista = new ArrayList<>();
        lista.add("hello");
        lista.add("world");
        lista.add("baeldung");

        //using lambda
        String result = lista.stream()
                .reduce("", (a, b) -> combineTwoStringsWithoutTrailingDash(a, b));
        //using method reference
        String result1 = lista.stream()
                .reduce("", this::combineTwoStringsWithoutTrailingDash);

        assertEquals("baeldung-world-hello", result);
        assertEquals("baeldung-world-hello", result1);
    }

    @Test
    public void combineElementsFromTwoDifferentTypesLists() {
        List<String> strings = Arrays.asList("a", "b", "c");
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            result.add(strings.get(i) + integers.get(i));
        }
        List<String> expected = Arrays.asList("a1", "b2", "c3");
        assertTrue(checkElemByElem(result, expected));
    }

    @Test
    public void bifunctionToCombineElementsFromTwoDifferentTypesLists() {
        List<String> l1 = Arrays.asList("a", "b", "c");
        List<Integer> l2 = Arrays.asList(1, 2, 3);
        List<String> result = new ArrayList<>();
        result = listCombiner(l1, l2, (a, b) -> a + b);
        List<String> expected = Arrays.asList("a1", "b2", "c3");
        assertTrue(checkElemByElem(result, expected));
    }

    @Test
    public void bifunctionToCheckIfTheValueInTheFirstListIsGraterThanInTheSecondList() {
        List<Double> d = Arrays.asList(1.0d, 2.1d, 3.3d);
        List<Float> f = Arrays.asList(0.1f, 0.2f, 4f);
        List<Boolean> result = new ArrayList<>();
        List<Boolean> expected = Arrays.asList(true, true, false);
        result = listCombiner(d, f, (a, b) -> a > b);
        assertTrue(checkElemByElem(expected, result));
        Assertions.assertThat(result).containsExactly(true, true, false);

        //sau cu functia care se aplica definita separat
        List<Boolean> result2 = listCombiner(d, f, this::firstIsGraterThanSecond);
        Assertions.assertThat(result2).containsExactly(true, true, false);
    }

    @Test
    public void bifunctionToCheckIfTwoListsAreEqual() {
        List<Float> f1 = Arrays.asList(0.1f, 0.2f, 4f);
        List<Float> f2 = Arrays.asList(0.1f, 0.2f, 4f);
        List<Boolean> result = new ArrayList<>();
        result = listCombiner(f1, f2, (e1, e2) -> e1.equals(e2));
        List<Boolean> result2 = listCombiner(f1, f2, Float::equals);
        assertThat(result).containsExactly(true, true, true);
        assertThat(result2).containsExactly(true, true, true);
    }


    @Test
    public void bifunctionCompareTwoDoubleLists(){
        List<Double> d1 = Arrays.asList(1.0d,2.1d,3.3d);
        List<Double> d2 = Arrays.asList(0.1d,0.2d,4d);
        List<Integer> result = listCombiner(d1,d2,Double::compareTo);
        assertThat(result).containsExactly(1,1,-1);
    }

    //A lambda or method reference only becomes a BiFunction after it has been
    // converted by a method invocation. We can use this helper function to convert
    // our lambda into the BiFunction object explicitly.
    @Test
    public void bifunctionComposeBifunctionsCompareTwoDoubleLists(){
        List<Double> d1 = Arrays.asList(1.0d,2.1d,3.3d);
        List<Double> d2 = Arrays.asList(0.1d,0.2d,4d);
        List<Boolean> result = listCombiner(d1,d2,asBifunction(Double::compareTo).
                andThen(i->i>0));
        assertThat(result).containsExactly(true, true, false);
    }

    private String combineTwoStringsWithoutTrailingDash(String a, String b) {
        if (a.isEmpty()) {
            return b;
        }
        return b + "-" + a;
    }

    private <T, U, R> List<R> listCombiner(List<T> l1, List<U> l2, BiFunction<T, U, R> combiner) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < l1.size(); i++) {
            result.add(combiner.apply(l1.get(i), l2.get(i)));
        }
        return result;
    }


    private <T> boolean checkElemByElem(List<T> a, List<T> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(b.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean firstIsGraterThanSecond(Double a, Float b) {
        return a > b;
    }

    private <T,U,V> BiFunction<T,U,V> asBifunction(BiFunction<T,U,V> function){
        return function;
    }


}
