package lesson36.controller;

import lesson36.model.Hotel;
import lesson36.service.UserService;
import lesson36.model.User;

import java.util.Random;

public class UserController {
    private UserService userService = new UserService();

    private void validateUser(User user)throws Exception{
        if(user == null)
            throw new Exception("Exception in method 'validateUser'. User can't be null");

        if(user.getUserName() == null || user.getUserName().isEmpty())
            throw new Exception("Exception in method 'validateUser'. Name of user can't be empty or null");

        if(user.getPassword() == null || user.getPassword().isEmpty())
            throw new Exception("Exception in method 'validateUser'. Password of user can't be empty or null");

        if(user.getCountry() == null || user.getCountry().isEmpty())
            throw new Exception("Exception in method 'validateUser'. Country of user can't be empty or null");

        if(user.getUserType() == null)
            throw new Exception("Exception in method 'validateUser'. UserType of user can't be null");
    }

    public User registerUser(User user)throws Exception{
        validateUser(user);
        return userService.registerUser(user);
    }

    private void validateLoginUser(String userName, String password) throws Exception{
        if(userName == null || userName.equals("")){
            throw new Exception("Exception in method 'validateLoginUser'. Login can't be null or empty");
        }

        if(password == null || password.equals("")){
            throw new Exception("Exception in method 'validateLoginUser'. Password can't be null or empty");
        }
    }

    public long genIdUser()throws Exception{
        Random random = new Random();
        boolean flag;
        long id;

        do{
            flag = true;
            id = random.nextInt();
            for(User u : userService.getUsers()){
                if(u.getId() == id || id < 0){
                    flag = false;
                }
            }
        }while (!flag);
        return id;
    }

    public User login(String userName, String password)throws Exception{
        validateLoginUser(userName, password);
        return userService.login(userName, password);
    }


}
