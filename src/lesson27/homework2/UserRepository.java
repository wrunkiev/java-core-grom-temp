package lesson27.homework2;

import java.util.ArrayList;

public class UserRepository {
    private static ArrayList<User> users = new ArrayList<>();

    public static User save(User user) {
        if(user == null)
            return null;

        if(findById(user.getId()) != null)
            return null;

        users.add(user);

        int index = users.indexOf(user);

        return users.get(index);
    }

    public static User update(User user) {
        if(user == null)
            return null;

        User curUser = findById(user.getId());
        if(curUser == null)
            return null;

        int index = users.indexOf(curUser);

        users.set(index, user);

        return users.get(index);
    }

    public static void delete(long id) {
        User user = findById(id);
        if(user == null)
            return;

        users.remove(user);
    }

    public static User findById(long id) {
        for(User user : users){
            if(user != null && id == user.getId())
                return user;
        }
        return null;
    }

    public static ArrayList<User> getUsers(){
        return users;
    }
}
