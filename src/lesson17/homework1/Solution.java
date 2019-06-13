package lesson17.homework1;


public class Solution {
    public static void main(String[] args) {
        String str = "   Hello    test123    test     test34test   ";
        System.out.println(countWords(str));
    }




    public static int countWords(String input){
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
            isWord = true;
            if(tempWord.isEmpty()){
                continue;
            }
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
}
