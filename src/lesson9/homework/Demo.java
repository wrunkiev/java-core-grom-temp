package lesson9.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User user1 = new User (1, "A", "1");
        User user2 = new User (2, "B", "2");
        User user3 = new User(3, "C", "3");
        User user4 = new User(4, "D", "4");
        User user5 = new User(5, "E", "5");

        UserRepository userRepository = new UserRepository(new User[]{user1,user2, user3, user4, user5});

        // удалить существующего юзера
        userRepository.delete(2);
        System.out.println(Arrays.toString(userRepository.getUsers()));

        userRepository = new UserRepository(new User[]{user1,user2, user3, user4, user5});

        // удалить несуществующего юзера
        userRepository.delete(6);
        System.out.println(Arrays.toString(userRepository.getUsers()));

        userRepository = new UserRepository(new User[]{user1,user2, user3, user4, user5});

        // сохранить того же узера
        System.out.println(userRepository.save(user1));
        System.out.println(Arrays.toString(userRepository.getUsers()));

        //сохранить null
        userRepository = new UserRepository(new User[]{user1,user2, user3, user4, user5});
        System.out.println(userRepository.save(null));
        System.out.println(Arrays.toString(userRepository.getUsers()));
    }
}
