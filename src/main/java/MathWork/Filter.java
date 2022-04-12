package MathWork;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Filter {
//    public static Predicate<Integer> isPrime() {
//        return num -> {
//            if (num <= 1) return false;
//            if (num == 2) return true;
//            for (int i = 2; i <= num / 2; i++)
//                if (num % i == 0) return false;
//            return true;
//        };
//    }
//    public static Predicate<Integer> getEven() {
//        return integer -> integer % 2 == 0;
//    }
//
//    public static Predicate<Integer> getOdd() {
////        return integer -> integer % 2 == 1;
//        return getEven().negate();
//    }
//
//    private static Predicate<Integer> getMultipleOf(int num) {
//        return integer -> integer % num == 0;
//    }
//
//    public static Predicate<Integer> getOddPrime() {
//        return getOdd().and(isPrime());
//    }
//
//    public static Predicate<Integer> getGreaterThan(int num) {
//        return integer -> integer > num;
//    }
//
//    public static Predicate<Integer> getLessThan(int num) {
//        return  integer -> integer < num;
//    }
//
//    private static Map<String ,Predicate<Integer>> temporary = new Hashmap<>();
//    Filter(){
//        temporary.put("even",getEven());
//        temporary.put("odd",getOdd());
//        temporary.put("prime",isPrime());
//    }





}
