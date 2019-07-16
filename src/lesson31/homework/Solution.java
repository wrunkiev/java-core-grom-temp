package lesson31.homework;

import java.util.*;

public class Solution {

    private static String validate(String text) throws Exception{
        if(text == null)
            throw new Exception("Input text can't null");

        String tempText = text.trim();
        if(tempText.isEmpty())
            throw new Exception("Input text can't empty");
        return tempText;
    }

    public static Map<Character, Integer> countSymbols(String text)throws Exception{
        String tempText = validate(text);

        char[] chars = tempText.toCharArray();

        Map<Character, Integer> characterMap = new HashMap<>();
        int count;
        for(char c : chars){
            if(Character.isLetter(c)){
                if(!characterMap.containsKey(c)){
                    characterMap.put(c, 1);
                }else {
                    count = characterMap.get(c);
                    count++;
                    characterMap.put(c, count);
                }
            }
        }
        return characterMap;
    }

    private static boolean checkWord(String string)throws Exception{
        boolean isWord = true;
        if(string == null || string.isEmpty() || string.length() <= 2)
            return false;

        for(char c : string.toCharArray()){
            if(!Character.isLetter(c)){
                isWord = false;
            }
        }
        return isWord;
    }

    public static Map<String, Integer> words(String text)throws Exception{
        String inputText = validate(text);

        String[] strings = inputText.split(" ");
        Map<String, Integer> stringMap = new HashMap<>();

        int count;
        for(String s : strings){
            if(checkWord(s)){
                if(!stringMap.containsKey(s)){
                    stringMap.put(s, 1);
                }else {
                    count = stringMap.get(s);
                    count++;
                    stringMap.put(s, count);
                }
            }
        }
        return stringMap;
    }
}
