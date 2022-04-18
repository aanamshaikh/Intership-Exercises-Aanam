//package exercise_3;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//import static java.lang.System.*;
//
//public class practise {
//
//    private static List<String> list;
//
//    public static void main(String[] args) throws IOException {
////        System.out.print("Enter search from (File // Stdin): ");
////        Scanner sc = new Scanner(System.in);
////        String input = sc.nextLine().trim();
////        String type1 = "file";
////        String type2 = "stdin";
////        if(input.equalsIgnoreCase(type1)){
////            System.out.print("Enter the search string and File Location:");
////            String data = sc.nextLine();
////            String[] split = data.split(" ");
////            String searchString = split[0];
////            String location = split[1];
////            List<String> readFile = readFile(new File(location));
////            List<String> search = searchProcessing(searchString, readFile);
//////            for(String s:search){
//////                out.println(s);
//////            }
////            out.println("To Write the result to file enter the file location: ");
////            String writeLocation = sc.nextLine();
////            List<String> output = writeToFile(search, new File(location));
//////            for (String o:output){
//////                out.print(o+" ");
//////
//////            }
////            out.println(output);
////        }
////        if(input.equalsIgnoreCase(type2)){
////            out.println("Enter the search String:");
////            String searchStr = sc.nextLine();
////            List<String> inp = extractedFromInput();
////            List<String> result = searchProcessing(searchStr, inp);
////            for(String r : result){
////                out.print(r+" ");
////            }
////        }
//////        else
//////            System.out.println("Sorry");
////        searchInFileDirectories("literature", Paths.get("src/main/java/exercise_3/InputFile.txt"));
//
//    }
//
//    public static boolean findSearchString(String searchString, Path fileName) throws IOException {
//        try (Stream<String> lines = Files.lines(fileName)) {
//            return lines.filter(s -> s.contains(searchString)).anyMatch(s -> s.contains(s));
//        }
//    }
//
//    public List<String> searchStringInFile(String searchString, Path file) {
//        try (Stream<String> lines = Files.lines(file)) {
//            return lines.filter(s -> s.contains(searchString)).collect(Collectors.toList());
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
////    public static List<String> searchProcessing(String searchString, List<String> result) {
////        return result.stream()
////                .filter(line -> line.contains(searchString))
////                .collect(Collectors.toList());
////    }
//
//    public static List<String> writeToFile(List<String> list, File fileName) throws IOException {
//
////        Files.write(Paths.get("src/main/java/exercise_3/OutputFile.txt"), list);
//        if (fileName.canWrite() && fileName.isFile()) {
//            Files.write(Paths.get(String.valueOf(fileName)), list);
//        }
//        return list;
//    }
//
//    public static List<String> extractedFromInput() {
//        List<String> scList;
//        try (Scanner sc = new Scanner(in)) {
//            out.print("Enter the inputs: ");
//            scList = Arrays.asList(sc.nextLine().split(" "));
//        }
//        return scList;
//    }
//}
//
//
