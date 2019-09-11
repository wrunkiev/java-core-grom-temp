package lesson36.demo;

import lesson36.controller.UserController;
import lesson36.model.User;
import lesson36.model.UserType;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws Exception{
        UserController userController = new UserController();
        Scanner scanner = new Scanner(System.in);
        String userName;
        String password;

        while(true){
            System.out.println("Welcome to site for booking room on all world!!!");
            System.out.println("1. Enter to system...");
            System.out.println("2. To begin registration...");

            int select = Integer.parseInt(scanner.nextLine());
            switch (select){
                case 1:
                    System.out.print("Enter login: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    userController.login(userName, password);
                    break;
                case 2:
                    System.out.println("Enter your name: ");
                    userName = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    password = scanner.nextLine();
                    System.out.println("Enter your country: ");
                    String country = scanner.nextLine();
                    System.out.println("Enter your type (ADMIN or USER): ");
                    String type = scanner.nextLine();
                    UserType userType = null;
                    if(type != null && type.equals(UserType.ADMIN.toString())){
                        userType = UserType.ADMIN;
                    }
                    if(type != null && type.equals(UserType.USER.toString())){
                        userType = UserType.USER;
                    }

                    User user = new User(userController.genIdUser(), userName, password, country, userType);
                    userController.registerUser(user);
                    userController.login(userName, password);
                    break;
            }
        }
    }
}
