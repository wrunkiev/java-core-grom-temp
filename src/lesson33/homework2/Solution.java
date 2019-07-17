package lesson33.homework2;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {
    public static void readFileByConsolePath(){
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String path;

        System.out.println("Please, enter file path to read: ");
        try{
            path = br.readLine();
            readFile(path);
        }catch (IOException e){
            System.err.println("Reading from keyboard failed");
        }finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }

    }

    private static void readFile(String path) {
        FileReader reader;
        try{
            reader = new FileReader(path);
        }catch (FileNotFoundException e){
            System.err.println("File with path " + path + " not found");
            return;
        }

        BufferedReader br = new BufferedReader(reader);

        try{
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.err.println("Reading from file " + path + " failed");
        }finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }
}
