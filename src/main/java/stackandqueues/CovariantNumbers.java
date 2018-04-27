package stackandqueues;

import java.util.Arrays;
import java.util.List;

public class CovariantNumbers {
    private static long sum(Number[] numbers) {
        long summation = 0;
        for(Number number : numbers) {
            summation += number.longValue();
        }
        return summation;
    }

    private static long sum(List<Number> numbers) {
        long summation = 0;
        for(Number number : numbers) {
            summation += number.longValue();
        }
        return summation;
    }

    private static void printNumbersArray() {
        Integer[] myInts = {1,2,3,4,5};
        Long[] myLongs = {1L, 2L, 3L, 4L, 5L};
        Double[] myDoubles = {1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.println(sum(myInts));
        System.out.println(sum(myLongs));
        System.out.println(sum(myDoubles));
    }

    private static void printNumbersGeneric() {
        List<Integer> myInts = Arrays.asList(1,2,3,4,5);
        List<Long> myLongs = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<Double> myDoubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
//        System.out.println(sum(myInts)); //compiler error
//        System.out.println(sum(myLongs)); //compiler error
//        System.out.println(sum(myDoubles)); //compiler error
    }

    public static void main(String[] args) {
        printNumbersArray();
        printNumbersGeneric();
    }
}
