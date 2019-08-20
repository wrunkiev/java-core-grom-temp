package lesson36.repository;

import lesson36.model.User;
import lesson36.model.UserType;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class UserRepository {
    private static String path = "C:/Soft/Files/UserDb.txt";

    /*private static void validateUserDb()throws Exception{
        File file = new File(path);

        if(!file.exists())
            throw new Exception("Exception in method 'validateUserDb'. Access denied to data base of user");

        if(!file.canRead())
            throw new Exception("Exception in method 'validateUserDb'. Can't read from data base of user");

        if(!file.canWrite())
            throw new Exception("Exception in method 'validateUserDb'. Can't write to data base of user");
    }

    private static ArrayList<String> readUsersFromDb()throws Exception{
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

    private static void validateUserInDb()throws Exception{
        for(String sU : readUsersFromDb()){
            for (String sF : sU.split(",")){
                if(sF.trim().isEmpty())
                    throw new Exception("Exception in method 'validateUserInDb'. Data Base of User is crashed");
            }
        }
    }

    private static ArrayList<User> getUserAll()throws Exception{
        validateUserInDb();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<String> userFields = new ArrayList<>();
        User user;

        for(String sU : readUsersFromDb()){
            for (String sF : sU.split(",")){
                userFields.add(sF.trim());
            }
            user = new User(Long.parseLong(userFields.get(0)),
                    userFields.get(1),
                    userFields.get(2),
                    userFields.get(3),
                    getUserType(userFields.get(4)));
            users.add(user);
            userFields.clear();
        }
        return users;
    }

    private static UserType getUserType(String userType)throws Exception{
        for(UserType uT : UserType.values()){
            if(uT.toString().equals(userType)){
                return uT;
            }
        }
        throw new Exception("Exception in method 'getUserType'. UserType with type: " + userType + " is not exist");
    }

    private static void validateNewUser(User user)throws Exception{
        for(User u : getUserAll()){
            if(u.equals(user)){
                throw new Exception("Exception in method 'validateNewUser'. This user with ID: " + u.getId() + " is exist already");
            }
        }
    }

    public static long genIdUser()throws Exception{
        Random random = new Random();
        boolean flag;
        long id;

        do{
            flag = true;
            id = random.nextInt();
            for(User u : getUserAll()){
                if(u.getId() == id || id < 0){
                    flag = false;
                }
            }
        }while (!flag);
        return id;
    }

    public User registerUser(User user)throws Exception{
        validateNewUser(user);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
            if(getUserAll().size() == 0)
                bufferedWriter.append(user.toString());
            else{
                bufferedWriter.append("\n");
                bufferedWriter.append(user.toString());
            }
        }catch (IOException e){
            System.err.println("Exception in method 'registerUser'. Can't write to file " + path);
        }
        return user;
    }*/
}
