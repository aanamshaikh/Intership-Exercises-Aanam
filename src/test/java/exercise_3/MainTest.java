package exercise_3;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;



class MainTest {

     @Test
     public void testFromFile() throws IOException {

         List<String> input = Main.readFile(new File("src/main/java/exercise_3/InputFile.txt"));
         List<String> result = Main.searchProcessing("er",input);
         List<String> writeFile = Main.writeToFile(result, new File("src/main/java/exercise_3/OutputFile.txt"));
         MatcherAssert.assertThat(writeFile, is(result));
     }

    @Test
    public void testFromStdin() {

//     List<String> input = Main.extractedFromInput();
     List<String> inp =Arrays.asList("literature","lite","light","litter");
     List<String> output = Main.searchProcessing("lit",inp);
     List<String> expectedOutput = Arrays.asList("literature","lite","litter");
     MatcherAssert.assertThat(output, is(expectedOutput));
     }

    //    @Test
//    public void testFromDirectory() throws IOException {
//     List<String> input = Main.searchDirectory(new File("src/main/exercise3"));
//     List<String> fileRead = Main.readFile((File) input);
//     List<String> output = Main.searchProcessing("test", fileRead);
//     List<String> output1 = Main.writeToFile(output, new File("src/main/exercise3/outputfile.txt"));
//     List<String> expectedOutput = Main.readFile((File) output1);
//     MatcherAssert.assertThat(output, is(expectedOutput));
//    }
//
}