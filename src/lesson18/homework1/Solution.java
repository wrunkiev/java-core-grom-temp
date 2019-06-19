package lesson18.homework1;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(findNumbers(" a    234    34e4r5    asdff5ffg   ddddddd    345    ")));
    }

    public static int[] findNumbers(String text){
        if(text == null)
            return null;

        if(text.isEmpty())
            return null;

        if(text.trim().isEmpty())
            return null;

        String[] words = text.trim().split(" ");

        int index = 0;
        for(String word : words){
            if(!word.isEmpty()){
                try {
                    Integer.parseInt(word.trim());
                    index++;
                }catch (Exception e){
                    System.out.println(word + " not a number");
                }
            }
        }

        int[] numbers = new int[index];

        index = 0;
        for(String word : words){
            if(!word.isEmpty()){
                try {
                    numbers[index] = Integer.parseInt(word.trim());
                    index++;
                }catch (Exception e){

                }
            }
        }
        return numbers;
    }
}
