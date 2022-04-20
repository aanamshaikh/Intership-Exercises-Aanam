package exercise_3;

import org.junit.jupiter.api.Test;

import static java.lang.System.setOut;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;


class GrepTest {
    Grep grep = new Grep();

    @Test
    public void testToSearchInFile() {

        //no Match
        //given
        List<String> expected_noMatch = Arrays.asList();
        //when
        List<String> noMatch = grep.searchStringInFile("teach", Paths.get("src", "main", "resources", "test1.txt"));
        //then
        assertThat(noMatch, is(expected_noMatch));

        //one Match
        //given
        List<String> expected_oneMatch = Arrays.asList("this is a test file");
        //when
        List<String> oneMatch = grep.searchStringInFile("test", Paths.get("src", "main", "resources", "test1.txt"));
        //then
        assertThat(oneMatch, is(expected_oneMatch));


        //Many Match
        //given
        List<String> expected_manyMatches = Arrays.asList("This is a test file", "one can test a program by running test case");
        //when
        List<String> manyMatches = grep.searchStringInFile("test", Paths.get("src", "main", "resources", "test2.txt"));
        //then
        assertThat(manyMatches, is(expected_manyMatches));

    }

    @Test
    public void recursiveSearch() {
        LinkedHashMap<String, List<String>> map1 = new LinkedHashMap<>();

        //no Match
        LinkedHashMap<String, List<String>> noMatch = grep.searchRecursively("bee", Paths.get("src/main/resources/"));
        assertThat(noMatch, is(map1));


        //one Match
        //given
        map1.put("src\\main\\resources\\Inputfile.txt", Arrays.asList("this is an input file"));
        //when
        LinkedHashMap<String, List<String>> oneMatch = grep.searchRecursively("input", Paths.get("src/main/resources/"));
        //then
        assertThat(oneMatch, is(map1));

        //many Match
        LinkedHashMap<String, List<String>> map2 = new LinkedHashMap<>();
        //given
        map2.put("src\\main\\resources\\test1.txt", Arrays.asList("this is a test file"));
        map2.put("src\\main\\resources\\test2.txt", Arrays.asList("This is a test file", "one can test a program by running test case"));
        //when
        LinkedHashMap<String, List<String>> manyMatch = grep.searchRecursively("test", Paths.get("src/main/resources/"));
        //then
        assertThat(manyMatch, is(map2));
    }

    @Test
    public void writeToFile() throws IOException {
        //given
        List<String> list = Arrays.asList("Literature is a great subject");

        //when
        grep.writeToFile(Paths.get("src", "main", "resources", "OutputFile.txt"), list);
        List<String> strings = grep.readFromFile(Paths.get("src", "main", "resources", "OutputFile.txt"));

        //then
        assertThat(list, is(strings));

    }

    @Test
    public void testFromStdin() {

        PrintStream out = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        //given
        List<String> result = grep.searchStringInFile("foo", Paths.get("src", "main", "resources", "input.txt"));

        //when
        result.forEach(System.out::println);

        //then
        assertThat("barbazfoo\n" +
                "food", is(output.toString().trim().replaceAll("\r", "")));
        setOut(out);

//        List<String> inp = Arrays.asList("literature", "lite", "light", "litter");
//        List<String> output = grep.searchProcessing("lit", inp);
//        List<String> expectedOutput = Arrays.asList("literature", "lite", "litter");
//        MatcherAssert.assertThat(output, is(expectedOutput));
    }
}