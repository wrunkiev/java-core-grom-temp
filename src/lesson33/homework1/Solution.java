package lesson33.homework1;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Scanner;



public class Solution {
    private static void validate(String path)throws Exception{
        if(path == null)
            throw new Exception("Path can't be null");

        if(path.trim().isEmpty())
            throw new Exception("Path can't be empty");
    }

    public static void writeToFileFromConsole(String path)throws InterruptedException{
        try{
            validate(path);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return;
        }

        Scanner scanner;
        FileReader fileReader;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        String str;

        try{
            fileReader = new FileReader(path);
        }catch (FileNotFoundException e){
            System.err.println("File with path " + path + " not found");
            return;
        }

        System.out.println("Enter file content to write in the file:");

        while(true){
            scanner = new Scanner(System.in);
            str = scanner.nextLine();
            if(str.equals("wr"))
                break;

            try{
                fileWriter = new FileWriter(path, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.append(str);
                bufferedWriter.append("\n");
            }catch (IOException e){
                System.err.println("Can't write to file with path " + path);
            }finally {
                IOUtils.closeQuietly(fileReader);
                IOUtils.closeQuietly(bufferedWriter);
                IOUtils.closeQuietly(fileWriter);
            }
        }
    }
}
