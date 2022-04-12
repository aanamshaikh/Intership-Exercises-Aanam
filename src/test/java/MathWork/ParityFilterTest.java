package MathWork;

import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
public class ParityFilterTest {

class Even implements Command{
    @Override
    public boolean apply(Integer num) {
        return num % 2 == 0;
    }
}

class Odd implements Command{
    @Override
    public boolean apply(Integer num) {
        return num % 2 == 1;
    }
}

class Prime implements Command{
    public  boolean isPrime(Integer number){
        if(number<=1){
            return false;
        }
        if(number==2){
            return true;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean apply(Integer num) {
            return isPrime(num);
        }
}

class GreaterThan implements Command{
    private Integer x;
    GreaterThan(Integer x){
            this.x = x;
        }
        @Override
        public boolean apply(Integer num) {
            return num > x ;
        }
}

class LessThan implements Command{
    private Integer x;
    LessThan(Integer x){
        this.x = x;
    }
    @Override
    public boolean apply(Integer num) {
        return num < x ;
    }
}

class MultipleOf implements Command{
    private Integer x;
    MultipleOf(Integer x){
            this.x = x;
        }
        @Override
        public boolean apply(Integer num) {
            return num % x == 0;
        }
}
    @Test
    public void testForCheckEven() {
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        List<Integer> expectedOutput = new ArrayList<>(Arrays.asList(2,4,6,8,10,12,14,16,18,20));
        List<Integer> testEven = ParityFilter.withAllCommands(numbersList,Arrays.asList(new Even()));
        assertThat(expectedOutput, is(testEven));
    }

    @Test
    public void testForCheckOdd() {
        List<Integer> numbersList = new ArrayList<>(Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expectedOutput = new ArrayList<>(Arrays.asList( 1, 3, 5, 7, 9));
        List<Integer> testEven = ParityFilter.withAllCommands(numbersList,Arrays.asList(new Odd()));
        assertThat(expectedOutput, is(testEven));
    }

    @Test
    public void testForCheckPrime() {
        List<Integer> numbersList = new ArrayList<>(Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expectedOutput = new ArrayList<>(Arrays.asList(2, 3, 5, 7));
        List<Integer> testEven = ParityFilter.withAllCommands(numbersList,Arrays.asList(new Prime()));
        assertThat(expectedOutput, is(testEven));
    }

    @Test
    public void testForCheckOddPrime() {
        List<Integer> numbersList = new ArrayList<>(Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expectedOutput = new ArrayList<>(Arrays.asList(3, 5, 7));
        List<Integer> testEven = ParityFilter.withAllCommands(numbersList,Arrays.asList(new Odd(),new Prime()));
        assertThat(expectedOutput, is(testEven));
    }

    @Test
    public void testForCheckEvenMultiplesOf5() {
        List<Integer> numbersList = new ArrayList<>(Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        List<Integer> expectedOutput = new ArrayList<>(Arrays.asList(10, 20));
        List<Integer> testEven = ParityFilter.withAllCommands(numbersList,Arrays.asList(new Even(),new MultipleOf(5)));
        assertThat(expectedOutput, is(testEven));
    }

    @Test
    public void testForCheckOddMultiplesGreaterThan10() {
        List<Integer> numbersList = new ArrayList<>(Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        List<Integer> expectedOutput = new ArrayList<>(Arrays.asList(15));
        List<Integer> testEven = ParityFilter.withAllCommands(numbersList,Arrays.asList(new Odd(),new MultipleOf(3),new GreaterThan(10)));
        assertThat(expectedOutput, is(testEven));
    }

    @Test
    public void testForCheckCommandsMatchingAllConditions() {
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        List<Integer> expectedOutput1 = new ArrayList<>(Arrays.asList(9, 15));
        List<Integer> testAll1 = ParityFilter.withAllCommands(numbersList, Arrays.asList(new Odd(),new GreaterThan(5),new MultipleOf(3)));
        assertThat(expectedOutput1, is(testAll1));

        List<Integer> expectedOutput2 = new ArrayList<>(Arrays.asList(9, 15));
        List<Integer> testAll2 = ParityFilter.withAllCommands(numbersList, Arrays.asList(new Even(),new LessThan(15),new MultipleOf(3)));
        assertThat(expectedOutput1, is(testAll1));
    }

    @Test
    public void testForCheckCommandsMatchingAnyConditions() {
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        List<Integer> expectedOutput1 = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 10, 11, 13, 15, 16, 17, 18, 19, 20));
        List<Integer> testAll1 = ParityFilter.withAnyCommands(numbersList, Arrays.asList(new Prime(),new GreaterThan(15),new MultipleOf(5)));
        assertThat(expectedOutput1, is(testAll1));

        List<Integer> expectedOutput2 = new ArrayList<>(Arrays.asList( 1, 2, 3, 4, 5, 6, 9, 12, 15, 18));
        List<Integer> testAll2 = ParityFilter.withAnyCommands(numbersList, Arrays.asList(new LessThan(6),new MultipleOf(3)));
        assertThat(expectedOutput2, is(testAll2));
    }



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
    // test Cases
//    @Test
//    public void testForParityFilterWithAllCommands() {
//        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
//        List<Integer> expectedOutputAll1 = new ArrayList<>(Arrays.asList(9, 15 ));
//        List<Integer> testAny1 = ParityFilter.withAllCommands(numbersList,Arrays.asList(getOdd(),getGreaterThan(5),getMultipleOf(3)));
//        Assert.assertThat(expectedOutputAll1,is(testAny1));
//
//        List<Integer> expectedOutputAll2= new ArrayList<>(Arrays.asList( 6, 12));
//        List<Integer> testAny2 = ParityFilter.withAllCommands(numbersList,Arrays.asList(getEven(),getLessThan(15),getMultipleOf(3)));
//        Assert.assertThat(expectedOutputAll2,is(testAny2));
//    }
//
//    @Test
//    public void testForParityFilterWithAnyCommand() {
//        //input and expected results
//        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
//        List<Integer> expectedAny1 = new ArrayList<>(Arrays.asList( 2, 3, 5, 7, 10, 11, 13, 15, 16, 17, 18, 19, 20 ));
//        List<Integer> testAny1 = ParityFilter.withAnyCommand(numbersList,Arrays.asList(isPrime(),getGreaterThan(15),getMultipleOf(5)));
//        Assert.assertThat(expectedAny1,is(testAny1));
//
//        List<Integer> expectedAny2= new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 9, 12, 15, 18));
//        List<Integer> testAny2 = ParityFilter.withAnyCommand(numbersList,Arrays.asList(getLessThan(6),getMultipleOf(3)));
//        Assert.assertThat(expectedAny2,is(testAny2));
//    }
}