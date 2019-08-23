package lesson34.homework1;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Solution {
    private static void validate(String path)throws Exception{
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

    public static void transferFileContent(String fileFromPath, String fileToPath)throws Exception{
        validate(fileFromPath);
        validate(fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileFromPath))){
            bufferedWriter.write("");
        }catch (IOException e){
            System.err.println("Can't write to file");
        }
    }
}
