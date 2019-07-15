package lesson31.homework;

import java.util.*;

public class Solution {

    public static Map<Character, Integer> countSymbols(String text)throws Exception{
        if(text == null)
            throw new Exception("Input text can't null");

        String tempText = text.trim();
        if(tempText.isEmpty())
            throw new Exception("Input text can't empty");

        char[] chars = tempText.toCharArray();

        Set<Character> characterSet = new HashSet<>();

        for(char c : chars){
            if(Character.isLetter(c)){
                characterSet.add(c);
            }
        }

        Integer[] indexes = new Integer[characterSet.size()];

        int index = 0;
        int count;
        for (char c : characterSet){
            count = 0;
            for(char x : chars){
                if(c == x){
                    count++;
                }
            }
            indexes[index] = count;
            index++;
        }


        Map<Character, Integer> characters = new HashMap<>();
        index = 0;
        for(Character c : characterSet){
            characters.put(c, indexes[index]);
            index++;
        }

        return characters;
    }

    public static Map<String, Integer> words(String text)throws Exception{
        if(text == null)
            throw new Exception("Input text can't null");
        String tempText = text.trim();
        if(tempText.isEmpty())
            throw new Exception("Input text can't empty");

        String[] strings = tempText.split(" ");
        Set<String> stringSet =  new HashSet<>();

        boolean isWord = true;
        for(String s : strings){
            if(s != null && !s.trim().isEmpty()){
                for(Character c : s.toCharArray()){
                    if(!Character.isLetter(c)){
                        isWord = false;
                        break;
                    }
                }
                if(isWord){
                    stringSet.add(s);
                }
                isWord = true;
            }
        }

        Integer[] indexes = new Integer[stringSet.size()];

        int index = 0;
        int count;
        for (String s : stringSet){
            count = 0;
            for(String x : strings){
                if(s != null && s.equals(x)){
                    count++;
                }
            }
            indexes[index] = count;
            index++;
        }

        Map<String, Integer> stringMap = new HashMap<>();
        index = 0;
        for(String s : stringSet){
            stringMap.put(s, indexes[index]);
            index++;
        }
        return stringMap;
    }
}
