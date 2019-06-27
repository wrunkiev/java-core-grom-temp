package lesson5;

import java.util.Arrays;

public class FirstArray {
    public static void main(String[] args) {
        int a;
        a = 10;

        int[] firstArray = new int[4]; // declaration

        System.out.println(Arrays.toString(firstArray));

        firstArray[0] = 11;
        firstArray[1] = 444;
        firstArray[2] = -10;

        for (int i = 0; i < firstArray.length; i++) {
            System.out.println(firstArray[i]);
        }

        System.out.println(Arrays.toString(firstArray));

        int b = 10;
        int[] secondArray = {1, 10, 15, 20, -50};
        System.out.println(Arrays.toString(secondArray));

        //Sys.out.println(secondArray[5]);

        for (int element : secondArray) {
            System.out.println(element);
        }

        for (int i = 0; i < firstArray.length; i++){
            int element = firstArray[i];
            System.out.println(element);
        }

    }
}
