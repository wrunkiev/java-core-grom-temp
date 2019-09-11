package lesson36.service;

import lesson36.controller.HotelController;
import lesson36.controller.RoomController;
import lesson36.model.UserType;
import lesson36.repository.UserRepository;
import lesson36.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    private void validateUser()throws Exception{
        for(String sU : userRepository.readUsersFromDb()){
            for (String sF : sU.split(",")){
                if(sF.trim().isEmpty())
                    throw new Exception("Exception in method 'validateUser'. Data Base of User is crashed");
            }
        }
    }

    public ArrayList<User> getUsers()throws Exception{
        validateUser();

        ArrayList<User> users = new ArrayList<>();
        ArrayList<String> userFields = new ArrayList<>();
        User user;

        for(String sU : userRepository.readUsersFromDb()){
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

    private UserType getUserType(String userType)throws Exception{
        UserType[] userTypes = UserType.values();
        for(UserType uT : userTypes){
            if(uT.toString().equals(userType)){
                return uT;
            }
        }
        throw new Exception("Exception in method 'getUserType'. UserType with this: " + userType + " is not exist");
    }

    private void validateNewUser(User user)throws Exception{
        for(User u : getUsers()){
            if(u.equals(user)){
                throw new Exception("Exception in method 'validateNewUser'. This user with ID: " + u.getId() + " is exist already");
            }
        }
    }

    public User registerUser(User user)throws Exception{
        validateNewUser(user);
        return userRepository.registerUser(user);
    }

    public User login(String userName, String password)throws Exception{
        HotelController hotelController = new HotelController();
        RoomController roomController = new RoomController();
        User user = null;
        Scanner scanner = new Scanner(System.in);
        for(User u : getUsers()){
            if(u.getUserName().equals(userName) && u.getPassword().equals(password)){
                user = u;
                break;
            }
        }

        if(user != null && user.getUserType().equals(UserType.ADMIN)){
            System.out.println("You have access to that methods:");
            System.out.println("1. Add hotel...");
            System.out.println("2. Remove hotel...");
            System.out.println("3. Add room...");
            System.out.println("4. Remove room...");
            int select = Integer.parseInt(scanner.next());
            switch (select){
                case 1:
                    //hotelController.addHotel();
                    break;
                case 2:
                    //hotelController.deleteHotel();
                    break;
                case 3:
                    //roomController.addRoom();
                    break;
                case 4:
                    //roomController.deleteRoom();
                    break;
            }
        }
        if(user != null && user.getUserType().equals(UserType.USER)){
            System.out.println("You have access to that methods:");
            System.out.println("1. To find hotel by name...");
            System.out.println("2. To find hotel by city...");
            System.out.println("3. To find rooms by filter...");
            System.out.println("4. To book room...");
            System.out.println("5. To cancel reservation...");
            System.out.println("6. To logout...");
            int select = Integer.parseInt(scanner.next());
            switch (select){
                case 1:
                    //hotelController.addHotel();
                    break;
                case 2:
                    //hotelController.deleteHotel();
                    break;
                case 3:
                    //roomController.addRoom();
                    break;
                case 4:
                    //roomController.deleteRoom();
                    break;
            }
        }
        return user;
    }
}
