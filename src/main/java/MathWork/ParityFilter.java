package MathWork;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Predicate;

interface Command{
     boolean apply(Integer num);
}

public class ParityFilter {

    public static  List<Integer> withAllCommands(List<Integer> numbers,List<Command> commands ){
       return numbers.stream().filter(number->commands.stream().allMatch(command-> command.apply(number))).collect(Collectors.toList());
    }
    public static  List<Integer> withAnyCommands(List<Integer> numbers,List<Command> commands ){
        return numbers.stream().filter(number->commands.stream().anyMatch(command-> command.apply(number))).collect(Collectors.toList());
    }
//    public static void main(String[] args) {
//        List<Integer> numberList=  new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
//        List<Command> commands = new ArrayList<>(Arrays.asList(new Even(),new MultipleOf(2),new Prime()));
//        System.out.println(withAllCommands(numberList,commands));
//    }
//    public static  List<Integer> withAllCommands(List<Integer> numbers,List<Command> commands ){
//        List<Integer> outputList = new ArrayList<>();
//        for(Integer num :numbers){  //1,2,3,4,5,6
//           boolean allMatch = true;
//            for(Command command:commands){//even,multipleof//prime
//                if(!command.apply(num)){
//                    allMatch = false;
//                    break;
//                }
//            }
//            if(allMatch){
//                outputList.add(num);
//            }
//        }
//        return outputList;
//    }
//    public static  List<Integer> withAnyCommands(List<Integer> numbers,List<Command> commands ){
//        List<Integer> outputList = new ArrayList<>();
//        for(Integer num :numbers){  //1,2,3,4,5,6
//            boolean anyMatch = false;
//            for(Command command:commands){//odd,greaterThan3
//                if(command.apply(num)){
//                    anyMatch = true;
//                    break;
//                }
//            }
//            if(anyMatch){
//                outputList.add(num);
//            }
//        }
//        return outputList;
//    }


//    enum PredicateChainType {
//        AND,
//        OR
//    }
//
//    public static List<Integer> withAllCommands(List<Integer> list, List<Predicate<Integer>> commands) {
//        //initializing predicate
//        Predicate<Integer> predicate = constructPredicate(commands, PredicateChainType.AND);
//        if (predicate == null) return list;
//        return filter(list, predicate);
//    }
//
//    public static List<Integer> withAnyCommand(List<Integer> list, List<Predicate<Integer>> commands) {
//        //initializing predicate
//        Predicate<Integer> predicate = constructPredicate(commands, PredicateChainType.OR);
//        if (predicate == null) return list;
//        return filter(list, predicate);
//    }
//
//    private static Predicate<Integer> constructPredicate(List<Predicate<Integer>> commands, PredicateChainType chainType) {
//        if (commands.size() < 1) return null;
//        Predicate<Integer> predicate = commands.get(0);
//        if (predicate == null) return null;
//        //constructing predicate
//        for (int i = 1; i < commands.size(); i++) {
//            Predicate<Integer> currentPredicate = commands.get(i);
//            if (currentPredicate != null)
//                if (chainType == PredicateChainType.AND)
//                    predicate = predicate.and(currentPredicate);
//                else if (chainType == PredicateChainType.OR)
//                    predicate = predicate.or(currentPredicate);
//
//        }
//        return predicate;
//    }
//    // predicates
//    public static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
//        return list.stream().filter(predicate).collect(Collectors.toList());
//    }

}
