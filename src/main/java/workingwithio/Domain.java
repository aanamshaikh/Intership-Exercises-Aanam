package workingwithio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Domain {
    public static void main(String[] args) {

        readLongestWords("src/main/java/workingwithio/data.txt");
        wordsOfEachLength("src/main/java/workingwithio/data.txt");
        listFiles("src/main/");
        listNonDirectoryFiles("src/main/");
    }

    //You want to process the contents of a text file using streams.
    //Finding the 10 longest words in the web2 dictionary
    public static void readLongestWords(String fileName){
        try(Stream<String> line = Files.lines(Paths.get(fileName))){
            line.filter(word->word.length()>4)
                    .sorted(Comparator.comparing(String::length))//.reversed()
                    .limit(10)
                    .distinct()
                    .forEach(w->System.out.printf("%s (%d) %n",w,w.length()));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Example 7-4. Number of words of each length, in descending order
    public static void wordsOfEachLength(String fileName){
        try(Stream<String> line = Files.lines(Paths.get(fileName))) {
            Map<Integer, Long> map = line
                    .filter(s -> s.length() > 5)
                    .collect(Collectors.groupingBy(String::length, Collectors.counting()));

            map.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .forEach(e -> System.out.printf("Length %d: %d words%n",
                            e.getKey(), e.getValue()));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    //Using Files.list(path)
    public static void listFiles(String fileName){
        try (Stream<Path> line =Files.list(Paths.get(fileName))) {
            line.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    Finding the nondirectory files in the fileio package
    public static void listNonDirectoryFiles(String fileName){
        try (Stream<Path> paths =
                     Files.find(Paths.get(fileName), Integer.MAX_VALUE,
                             (path, attributes) ->
                                     !attributes.isDirectory() && path.toString().contains("workingwithio"))) {
            paths.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
