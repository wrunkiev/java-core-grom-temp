package lesson15.homework1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User user1 = new User(1, "1", "1");
        User user2 = new User(2, "2", "2");
        User user3 = new User(3, "3", "3");
        User user4 = new User(4, "4", "4");
        User user5 = new User(5, "5", "5");
        UserRepository userRepository = new UserRepository(new User[]{null, null, null, null, null});

        //update for add null user
        System.out.println(userRepository.save(user1));
        System.out.println(Arrays.toString(userRepository.getUsers()));










    }
}
