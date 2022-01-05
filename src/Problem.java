import java.util.Arrays;
import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {
        array();
    }
    public static void text (){
        System.out.println("Enter num");
    }
    public static int num (int length){
       Scanner scanner = new Scanner(System.in);
        int result = length;
        return result;
    }
    public static void sum (int length){
        int sum = num(length) + 5;
        System.out.println(sum);
    }

    public static void array() {
        int[] arr = getInts();
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int[] getInts() {
        int[] arr = {7, 3, 14, 10};
        return arr;
    }
}

