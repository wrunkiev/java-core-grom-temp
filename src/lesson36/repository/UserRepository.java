package lesson36.repository;

import lesson36.model.User;
import java.io.*;
import java.util.ArrayList;

public class UserRepository {
    private String path = "C:/Soft/Files/UserDb.txt";

    private void validateUserDb()throws Exception{
        File file = new File(path);

        if(!file.exists())
            throw new Exception("Exception in method 'validateUserDb'. Access denied to data base of user");

        if(!file.canRead())
            throw new Exception("Exception in method 'validateUserDb'. Can't read from data base of user");

        if(!file.canWrite())
            throw new Exception("Exception in method 'validateUserDb'. Can't write to data base of user");
    }

    public ArrayList<String> readUsersFromDb()throws Exception{
        validateUserDb();
        ArrayList<String> res = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                res.add(line);
            }
        }catch (IOException e){
            System.err.println("Exception in method 'readUsersFromDb'. Reading from file " + path + " failed");
        }
        return res;
    }

    public User registerUser(User user)throws Exception{
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
            if(readUsersFromDb().size() == 0)
                bufferedWriter.append(user.toString());
            else{
                bufferedWriter.append("\n");
                bufferedWriter.append(user.toString());
            }
        }catch (IOException e){
            System.err.println("Exception in method 'registerUser'. Can't write to file " + path);
        }
        return user;
    }
}
