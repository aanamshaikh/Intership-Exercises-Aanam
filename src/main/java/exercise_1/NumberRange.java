package exercise_1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NumberRange {

    public static String evenOrOddOrPrime(int number){
        if(isPrime(number)){
            return String.valueOf(number);
        }else{
            if(number%2==0){
                return  "Even";
             }else{
                return "Odd";
            }
        }
    }
    public static boolean isPrime(int number){
        if(number<=1){
            return false;
        }
        if(number==2){
            return true;
        }
        for (int i = 3; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static List<String> range(int start,int end) {
        ArrayList<String> result = new ArrayList<>();
        IntStream
                .range((int) start, (int) end + 1)
                .forEach(num -> getParity(num));
        return result;
    }
    // whether even or odd or prime

    private static String getParity(int num) {
        return evenOrOddOrPrime(num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the start Range: ");
        int start = sc.nextInt();
        System.out.println("Enter the end Range: ");
        int end = sc.nextInt();

        System.out.println(range( start,  end));
//        System.out.println(range().forEach(System.out::println));
     }
}
