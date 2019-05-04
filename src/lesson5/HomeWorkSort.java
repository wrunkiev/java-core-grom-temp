package lesson5;

import java.util.Arrays;

public class HomeWorkSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortAscending(new int []{10, 4, 5, 3})));
        System.out.println(Arrays.toString(sortDescending(new int []{10, 4, 5, 3})));
    }

    public static int [] sortAscending(int [] array){
        int temp;
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[i] > array[j])
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static int [] sortDescending(int [] array){
        int temp;
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[i] < array[j])
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
