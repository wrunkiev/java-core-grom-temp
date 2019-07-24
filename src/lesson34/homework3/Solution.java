package lesson34.homework3;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.List;

public class Solution {
    public static void copyFileContent(String fileFromPath, String fileToPath)throws Exception{
        validateFile(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
    }

    private static void validateFile(String fileFromPath, String fileToPath)throws Exception{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if(!fileFrom.exists()){
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }

        if(!fileTo.exists()){
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }

        if(!fileFrom.canRead()){
            throw new Exception("File " + fileFrom + " does not have permissions to be read");
        }

        if(!fileTo.canWrite()){
            throw new Exception("File " + fileTo + " does not have permissions to be written");
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

    private static void writeToFile(String path, StringBuffer contentToWrite){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
            if(readFromFile(path).length() == 0)
                bufferedWriter.append(contentToWrite);
            else{
                bufferedWriter.append("\n");
                bufferedWriter.append(contentToWrite);
            }
        }catch (IOException e){
            System.err.println("Can't write to file");
        }
    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath)throws Exception{
        validateFile(fileFromPath, fileToPath);
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        FileUtils.copyFile(fileFrom, fileTo);
    }
}
