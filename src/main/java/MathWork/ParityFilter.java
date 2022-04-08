package MathWork;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ParityFilter {
//    public static List<Integer> evenNumbers(List<Integer> number){
//        return number.stream()
//                .filter(getEven())
//                .collect(Collectors.toList());
//    }
//
//    public static List<Integer> oddOrNot(List<Integer> number){
//        return number.stream()
//                .filter(getOdd())
//                .collect(Collectors.toList());
//    }
//
//    public static List<Integer> primeOrNot(List<Integer> number){
//        return number.stream()
//                .filter(isPrime())
//                .collect(Collectors.toList());
//     }
//    public static  List<Integer> oddPrime(List<Integer> number){
//         return number.stream()
//                 .filter(getOdd())
//                 .filter(isPrime())
//                 .collect(Collectors.toList());
//     }
//    public static  List<Integer> evenMultiples(List<Integer> number){
//        return number.stream()
//                .filter(getEven())
//                .filter(getMultipleOf(number))
//                .collect(Collectors.toList());
//    }
//    public static  List<Integer> oddMultiplesGreaterThan10(List<Integer> number){
//        return number.stream()
//                .filter(getOdd() )
//                .filter(getGreaterThan(number))
//                .collect(Collectors.toList());
//    }
    enum PredicateChainType {
        AND,
        OR
    }

    public static List<Integer> withAllCommands(List<Integer> list, List<Predicate<Integer>> commands) {
        //initializing predicate
        Predicate<Integer> predicate = constructPredicate(commands, PredicateChainType.AND);
        if (predicate == null) return list;
        return filter(list, predicate);
    }

    public static List<Integer> withAnyCommand(List<Integer> list, List<Predicate<Integer>> commands) {
        //initializing predicate
        Predicate<Integer> predicate = constructPredicate(commands, PredicateChainType.OR);
        if (predicate == null) return list;
        return filter(list, predicate);
    }
    private static Predicate<Integer> constructPredicate(List<Predicate<Integer>> commands, PredicateChainType chainType) {
        if (commands.size() < 1) return null;
        Predicate<Integer> predicate = commands.get(0);
        if (predicate == null) return null;
        //constructing predicate
        for (int i = 1; i < commands.size(); i++) {
            Predicate<Integer> currentPredicate = commands.get(i);
            if (currentPredicate != null)
                if (chainType == PredicateChainType.AND)
                    predicate = predicate.and(currentPredicate);
                else if (chainType == PredicateChainType.OR)
                    predicate = predicate.or(currentPredicate);

        }
        return predicate;
    }
    // predicates
    public static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Input: ");
//        System.out.print("Specify numbers separated by ','" + "\nlist: ");
//        List<Integer> list = new ArrayList<>();
//        //constructing list from data
//        String[] number = scanner.nextLine().split(",");
//        for (String num : number) list.add(Integer.parseInt(num.trim()));
//        //letting user know what commands to be used.
////        List<String> keywords = Arrays.asList("even", "odd", "prime", "odd prime", "greater than <number>", "multiple of <number>");
//        System.out.println("Command List: ");
//        System.out.print("Specify commands, ex: even, greater than 5, multiple of 10,.." + "\nCommands: ");
//        //commands extraction
//        String[] commands = scanner.nextLine().split(",");
//        //output
//        System.out.println("Output: ");
//        ParityFilter.withAnyCommand(list, asList(commands)).forEach(System.out::println);
     }
}
