package exercise_1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class NumberRangeTest {
    @Test
    public void testCaseToCheckOutput(){
        List<String> output = NumberRange.range(5,15);
        List<String> expectedOutput= new ArrayList(Arrays.asList("5","Even","7","Even","Odd","Even","11","Even","13","Even","Odd"));
        assertThat(output,is(expectedOutput));
    }
}