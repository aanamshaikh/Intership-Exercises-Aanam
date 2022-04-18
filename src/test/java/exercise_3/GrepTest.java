package exercise_3;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

class GrepTest {

    @Test
    public void testToSearchInFile() throws IOException {
        List<String> input = Grep.searchStringInFile("literature", Paths.get("src/main/resources/test1.txt"));
        List<String> writeFile = Grep.writeToFile(input, new File("src/main/java/exercise_3/OutputFile.txt"));
        MatcherAssert.assertThat(writeFile, is(writeFile));

    }

    @Test
    public void recursiveSearch() {
        Grep.searchRecursively("test", Paths.get("src/main/resources/"));

    }

    @Test
    public void writeToFile() throws IOException {
        List<String> list = Arrays.asList("Literature is a great subject");
        Grep.writeToFile(list, new File("src/main/resources/OutputFile.txt"));

    }

    @Test
    public void testFromStdin() {
        List<String> inp = Arrays.asList("literature", "lite", "light", "litter");
        List<String> output = Grep.searchProcessing("lit", inp);
        List<String> expectedOutput = Arrays.asList("literature", "lite", "litter");
        MatcherAssert.assertThat(output, is(expectedOutput));

    }
}