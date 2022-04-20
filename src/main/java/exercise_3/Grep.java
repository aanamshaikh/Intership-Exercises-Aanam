package exercise_3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grep {

    public LinkedHashMap<String, List<String>> searchRecursively(String searchString, Path folder) {
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        try (Stream<Path> paths = Files.walk(folder)) {
            paths.forEach(path ->
            {
                if (Files.isRegularFile(path)) {
                    try {

                        List<String> s = searchStringInFile(searchString, path);
                        if (!s.isEmpty()) {
                            map.put(String.valueOf(path), s);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public List<String> searchStringInFile(String searchString, Path file) {
        return searchProcessing(searchString, readFromFile(file));

    }

    public List<String> searchProcessing(String searchString, List<String> result) {
        return result.stream()
                .filter(line -> line.contains(searchString))
                .collect(Collectors.toList());
    }

    public List<String> readFromFile(Path path) {
        File file = new File(String.valueOf(path));
        if (file.exists() && file.canRead()) {
            try {
                return Files.readAllLines(file.toPath());
            } catch (IOException e) {
                System.err.print("Err :" + e.getMessage());
            }
        }
        return Collections.emptyList();
    }

    public void writeToFile(Path fileName, List<String> list) throws IOException {
        Files.write(fileName, list, StandardCharsets.UTF_8);
//        Files.write(Paths.get(String.valueOf(fileName)), list);
    }

//    public static List<String> extractedFromInput() {
//        List<String> scList;
//        try (Scanner sc = new Scanner(in)) {
//            out.print("Enter the inputs: ");
//            scList = Arrays.asList(sc.nextLine().split(" "));
//        }
//        return scList;
//    }

//    for(Map.Entry<String, List<String>> entries :map.entrySet()){
//        String key = entries.getKey();
//        List<String> value = entries.getValue();
//        System.out.print(key+":");
//        value.forEach(System.out::println);
//    }
}
