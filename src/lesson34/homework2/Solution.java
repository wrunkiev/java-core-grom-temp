package lesson34.homework2;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void transferSentences(String fileFromPath, String fileToPath, String word)throws Exception{
        validateFile(fileFromPath);
        validateFile(fileToPath);
        writeToFile(fileToPath, findTextWithWord(readFromFile(fileFromPath), word));
        writeToFile(fileFromPath, findTextWithoutWord(readFromFile(fileFromPath), word));

    }

    private static void validateFile(String path)throws Exception{
        File file = new File(path);

        if(!file.exists()){
            throw new FileNotFoundException("File " + file + " does not exist");
        }

        if(!file.canRead()){
            throw new Exception("File " + file + " does not have permissions to be read");
        }

        if(!file.canWrite()){
            throw new Exception("File " + file + " does not have permissions to be written");
        }
    }

    private static StringBuffer readFromFile(String path){
        StringBuffer res = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                res.append(line);
                res.append("\n");
            }
            if(res.length() != 0)
                res.replace(res.length() - 1, res.length(), "");
        }catch (FileNotFoundException e){
            System.err.println("File does not exist");
        }catch (IOException e){
            System.err.println("Reading from file " + path + " failed");
        }
        return res;
    }

    private static void validateInputText(StringBuffer stringBuffer) throws Exception{
        if(stringBuffer == null)
            throw new Exception("Input text can't be null");

        if(stringBuffer.toString().isEmpty())
            throw new Exception("Input text can't be empty");
    }

    private static StringBuffer findTextWithWord(StringBuffer stringBuffer, String word)throws Exception{
        validateInputText(stringBuffer);

        StringBuffer resBuffer = new StringBuffer();

        for(String s : stringBuffer.toString().split("\\.")){
            if(s.length() > 10 && s.contains(word)){
                resBuffer.append(s);
                resBuffer.append(".");
            }
        }
        return resBuffer;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
                bufferedWriter.append(contentToWrite);
        }catch (IOException e){
            System.err.println("Can't write to file");
        }
    }

    private static StringBuffer findTextWithoutWord(StringBuffer stringBuffer, String word)throws Exception{
        validateInputText(stringBuffer);

        StringBuffer resBuffer = new StringBuffer();

        for(String s : stringBuffer.toString().split("\\.")){
            if(!s.contains(word)){
                resBuffer.append(s);
                resBuffer.append(".");
            }
        }
        return resBuffer;
    }
}
