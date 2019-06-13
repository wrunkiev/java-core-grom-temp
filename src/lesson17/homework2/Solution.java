package lesson17.homework2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String str = "     Hello    test123    test     test34test       ";
        System.out.println(maxWord(str));
        System.out.println(minWord(str));
    }

    private static int countWords(String input){
        if(input == null)
            return 0;
        String strWithoutSpace = input.trim();
        if(strWithoutSpace.isEmpty())
            return 0;

        String tempWord;
        boolean isWord;
        int countWords = 0;
        String[] words = strWithoutSpace.split(" ");
        for (int i = 0; i < words.length; i++){
            tempWord = words[i].trim();
            if(tempWord.isEmpty()){
                continue;
            }
            isWord = true;

            for(int j = 0; j < tempWord.length(); j++){
                if(!Character.isLetter(tempWord.charAt(j))){
                    isWord = false;
                    break;
                }
            }
            if(isWord)
                countWords++;
        }
        return countWords;
    }

    private static String[] findWords(String input){
        if(input == null)
            return null;
        String strWithoutSpace = input.trim();
        if(strWithoutSpace.isEmpty())
            return null;
        int countWords = countWords(strWithoutSpace);
        if(countWords == 0)
            return null;

        boolean isWord;
        int index = 0;

        String[] findWords = new String[countWords];
        String[] words = strWithoutSpace.split(" ");
        String tempWord;
        for(int i = 0; i < words.length; i++){
            tempWord = words[i].trim();
            if(tempWord.isEmpty()){
                continue;
            }

            isWord = true;
            for(int j = 0; j < tempWord.length(); j++){
                if(!Character.isLetter(tempWord.charAt(j))){
                    isWord = false;
                    break;
                }
            }
            if(isWord) {
                findWords[index] = tempWord;
                index++;
            }
        }
        return findWords;
    }


    public static String maxWord(String input){
        if(input == null)
            return null;
        String strWithoutSpace = input.trim();
        if(strWithoutSpace.isEmpty())
            return null;

        String[] words = findWords(strWithoutSpace);
        if(words == null)
            return null;

        String maxWord = words[0];
        for(int i = 1; i < words.length; i++){
            if(maxWord.length() < words[i].length()){
                maxWord = words[i];
            }
        }
        return maxWord;
    }

    public static String minWord(String input){
        if(input == null)
            return null;
        String strWithoutSpace = input.trim();
        if(strWithoutSpace.isEmpty())
            return null;

        String[] words = findWords(strWithoutSpace);
        if(words == null)
            return null;

        String minWord = words[0];
        for(int i = 1; i < words.length; i++){
            if(minWord.length() > words[i].length()){
                minWord = words[i];
            }
        }
        return minWord;
    }
}
