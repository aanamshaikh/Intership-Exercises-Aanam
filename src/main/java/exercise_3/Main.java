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
import static java.lang.System.*;
import static java.nio.file.Files.walk;
import static java.util.stream.IntStream.*;

public class Main  {

    private static List<String> list;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter search from (File // Stdin): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String type1 = "file";
        String type2 = "stdin";
        if(input.equalsIgnoreCase(type1)){
            System.out.print("Enter the search string and File Location:");
            String data = sc.nextLine();
            String[] split = data.split(" ");
            String searchString = split[0];
            String location = split[1];
            List<String> readFile = readFile(new File(location));
            List<String> search = searchProcessing(searchString, readFile);
//            for(String s:search){
//                out.println(s);
//            }
            out.println("To Write the result to file enter the file location: ");
            String writeLocation = sc.nextLine();
            List<String> output = writeToFile(search, new File(location));
            for (String o:output){
                out.print(o+" ");

            }
        }
        if(input.equalsIgnoreCase(type2)){
            out.println("Enter the search String:");
            String searchStr = sc.nextLine();
            List<String> inp = extractedFromInput();
            List<String> result = searchProcessing(searchStr, inp);
            for(String r : result){
                out.print(r+" ");
            }
        } else
            System.out.println("Sorry");

    }

    public static List<String> extractedFromInput() {
        List<String> scList;
        try (Scanner sc = new Scanner(in)) {
            out.print("Enter the inputs: ");
            scList = Arrays.asList(sc.nextLine().split(" "));
        }
        return scList;
    }

    public static List<String> readFile(File fileName) throws IOException {

        List<String> result = null;
        if(fileName.canRead() && fileName.isFile()){
            try (Stream<String> lines = Files.lines(Paths.get(String.valueOf(fileName)))) {
                result = lines
                        .map(l -> l.toLowerCase().split(" "))//\s+
                        .flatMap(Arrays::stream)
                        .collect(Collectors.toList());
            }
        }
//        if(fileName.isDirectory()){
//            List<String> strings = searchDirectory(fileName);
//            out.println(strings.get(1));
//
//        }
        else{
            out.println("Please enter Valid file Name or Directory");
        }
        return result;
    }

    public static List<String> searchProcessing(String searchString, List<String> result) {
        return result.stream()
                .filter(word -> word.contains(searchString)).distinct()
                .collect(Collectors.toList());
    }

    public static List<String> writeToFile(List<String> list,File fileName) throws IOException {

//        Files.write(Paths.get("src/main/java/exercise_3/OutputFile.txt"), list);
        if(fileName.canWrite() && fileName.isFile()){
            Files.write(Paths.get(String.valueOf(fileName)), list);
        }
        return list;
    }

//    public static List<String> searchDirectory(File fileName) throws IOException {
//
//        try(Stream<Path> paths = walk(Paths.get(String.valueOf(fileName)))) {
////            paths.forEach(System.out::println);
//            List<Path> collect = paths.collect(Collectors.toList());
//            List<String> strings = list;
//            int bound = collect.size();
//            for (int i = 1; i <= bound; i++) {
//                String s = String.valueOf(collect.get(1));
//                strings.add(s);
//            }
//        }
//      return list;
//    }
    // String fileName = "src/main/java/exercise_3/InputFile.txt";
    //     List<String> result = readFile(fileName);
    //     List<String> searchProcessing = searchProcessing("er", result);
    //     writeToFile(searchProcessing);
    //
    //     System.out.println(searchProcessing("aa",extractedFromInput()));
}
