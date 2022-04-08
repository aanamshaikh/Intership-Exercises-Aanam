package MathWork;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import static org.hamcrest.CoreMatchers.is;

public class ParityFilterTest {
    public static Predicate<Integer> isPrime() {
        return num -> {
            if (num <= 1) return false;
            if (num == 2) return true;
            for (int i = 2; i <= num / 2; i++)
                if (num % i == 0) return false;
            return true;
        };
    }
    public static Predicate<Integer> getEven() {
        return integer -> integer % 2 == 0;
    }

    public static Predicate<Integer> getOdd() {
//        return integer -> integer % 2 == 1;
        return getEven().negate();
    }

    private static Predicate<Integer> getMultipleOf(int num) {
        return integer -> integer % num == 0;
    }

    public static Predicate<Integer> oddPrime() {
        return getOdd().and(isPrime());
    }

    public static Predicate<Integer> getGreaterThan(int num) {
        return integer -> integer > num;
    }

    public static Predicate<Integer> getLessThan(int num) {
        return integer -> integer < num;
    }
    // test Cases
    @Test
    public void testForParityFilterWithAllCommands() {
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        List<Integer> expectedOutputAll1 = new ArrayList<>(Arrays.asList(9, 15 ));
        List<Integer> testAny1 = ParityFilter.withAllCommands(numbersList,Arrays.asList(getOdd(),getGreaterThan(5),getMultipleOf(3)));
        Assert.assertThat(expectedOutputAll1,is(testAny1));

        List<Integer> expectedOutputAll2= new ArrayList<>(Arrays.asList( 6, 12));
        List<Integer> testAny2 = ParityFilter.withAllCommands(numbersList,Arrays.asList(getEven(),getLessThan(15),getMultipleOf(3)));
        Assert.assertThat(expectedOutputAll2,is(testAny2));
    }

    @Test
    public void testForParityFilterWithAnyCommand() {
        //input and expected results
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        List<Integer> expectedAny1 = new ArrayList<>(Arrays.asList( 2, 3, 5, 7, 10, 11, 13, 15, 16, 17, 18, 19, 20 ));
        List<Integer> testAny1 = ParityFilter.withAnyCommand(numbersList,Arrays.asList(isPrime(),getGreaterThan(15),getMultipleOf(5)));
        Assert.assertThat(expectedAny1,is(testAny1));

        List<Integer> expectedAny2= new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 9, 12, 15, 18));
        List<Integer> testAny2 = ParityFilter.withAnyCommand(numbersList,Arrays.asList(getLessThan(6),getMultipleOf(3)));
        Assert.assertThat(expectedAny2,is(testAny2));
    }
}