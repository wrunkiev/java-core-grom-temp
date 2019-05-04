package lesson5;

import java.util.Arrays;

public class HomeWorkUnique {
    public static void main(String[] args) {
        System.out.println(uniqueCount(new int []{1,2,3,1,1,4,5,4,5,1,2,1,3}));
    }

    public static int uniqueCount(int [] array){
        String [] uniq = new String [array.length];

        for(int i = 0; i < array.length; i++){
            if(uniq[i] == null)
                uniq[i] = "Y";
            for (int j = i + 1; j < uniq.length; j++){
                if (array[i] == array[j] && uniq[j] == null){
                    uniq[j] = "N";
                }
            }
        }

        int count = 0;
        for(String el : uniq){
            if (el == "Y")
                count++;
        }
        return count;
    }
}
