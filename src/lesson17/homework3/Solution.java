package lesson17.homework3;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String str = "     Hello work   test123    test     test34test  work    te2st     test  or   ";
        System.out.println(mostCountedWord(str));

    }





    public static String mostCountedWord(String input){
        if(input == null)
            return null;
        String strWithoutSpace = input.trim();
        if(strWithoutSpace.isEmpty())
            return null;

        String[] words = findWords(strWithoutSpace);
        if(words == null)
            return null;

        int[] res = new int[words.length];
        for(String word : words){
            for (int i = 0; i < words.length; i++){
                if(word.equals(words[i])){
                    res[i]++;
                }
            }
        }

        int posWord = 0;
        int maxDuplicate = res[0];
        for(int i = 1; i < res.length; i++){
            if(maxDuplicate < res[i]) {
                maxDuplicate = res[i];
                posWord = i;
            }
        }
        return words[posWord];
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
}
