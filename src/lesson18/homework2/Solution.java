package lesson18.homework2;

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

        String wordNumber = "";
        boolean isNumber;
        for(String word : words){
            if(!word.isEmpty()){
                isNumber = true;
                for(Character ch : word.trim().toCharArray()){
                    if(!Character.isDigit(ch)){
                        System.out.println(word.trim() + " not a number");
                        isNumber = false;
                        wordNumber = "";
                        break;
                    }
                    wordNumber += ch;
                }
                if(isNumber == true)
                    index++;
            }
        }

        int[] numbers = new int[index];

        index = 0;
        wordNumber = "";
        for(String word : words){
            if(!word.isEmpty()){
                isNumber = true;
                for(Character ch : word.trim().toCharArray()){
                    if(!Character.isDigit(ch)){
                        isNumber = false;
                        wordNumber = "";
                        break;
                    }
                    wordNumber += ch;
                }
                if(isNumber == true){
                    numbers[index] = Integer.parseInt(wordNumber);
                    index++;
                }
            }
        }
        return numbers;
    }
}
