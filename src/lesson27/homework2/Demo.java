package lesson27.homework2;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        User user1 = new User(1001, "Daniil", "32434234sdsfuuuuo");
        UserRepository.save(user1);
        System.out.println(UserRepository.getUsers());
        User user2 = new User(1002, "Andrey", "ewrewrwer4343wef");
        UserRepository.save(user2);
        System.out.println(UserRepository.getUsers());
        User user3 = new User(1001, "Test", "ewrewrwer4343wef");
        UserRepository.update(user3);
        System.out.println(UserRepository.getUsers());



    }
}
