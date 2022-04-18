package exercise_3;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.System.in;
import static java.lang.System.out;

public class Grep {
    public static void main(String[] args) throws IOException {
        searchRecursively("test", Paths.get("src/main/resources/"));
        List<String> a =Arrays.asList("literature a great subject");
        writeToFile(a, new File("src/main/resources/OutputFile.txt"));
    }

    public static List<String> searchStringInFile(String searchString, Path file) {
        try (Stream<String> lines = Files.lines(file)) {
            return lines.filter(s -> s.contains(searchString)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void searchRecursively(String searchString, Path folder) {
        try (Stream<Path> paths = Files.walk(folder)) {
            paths.forEach(f ->
            {
                if (Files.isRegularFile(f)) {
                    try {
                        if(Files.isReadable(f)){
                            List<String> s =searchStringInFile(searchString,f);
                            for (String line:s){
                                System.out.println(f + " : "+line);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> extractedFromInput() {
        List<String> scList;
        try (Scanner sc = new Scanner(in)) {
            out.print("Enter the inputs: ");
            scList = Arrays.asList(sc.nextLine().split(" "));
        }
        return scList;
    }
    public static List<String> searchProcessing(String searchString, List<String> result) {
        return result.stream()
                .filter(line -> line.contains(searchString))
                .collect(Collectors.toList());
    }
    public static List<String> writeToFile(List<String> list, File fileName) throws IOException {

//        Files.write(Paths.get("src/main/java/exercise_3/OutputFile.txt"), list);
        if (fileName.canWrite() && fileName.isFile()) {
            Files.write(Paths.get(String.valueOf(fileName)), list);
        }
        return list;
    }

}
