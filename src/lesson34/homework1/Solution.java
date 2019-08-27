package lesson34.homework1;

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

    private static StringBuffer readFromFile(String path)throws Exception{
        StringBuffer res = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(path));

        String line;
        while ((line = br.readLine()) != null){
            res.append(line);
            res.append("\n");
        }
        if(res.length() != 0)
            res.replace(res.length() - 1, res.length(), "");

        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite)throws Exception{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));

        if(readFromFile(path).length() == 0)
            bufferedWriter.append(contentToWrite);
        else{
            bufferedWriter.append("\n");
            bufferedWriter.append(contentToWrite);
        }
    }

    public static void transferFileContent(String fileFromPath, String fileToPath)throws Exception{
        validate(fileFromPath);
        validate(fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileFromPath));

        bufferedWriter.write("");
    }
}
