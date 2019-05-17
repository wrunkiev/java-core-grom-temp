package lesson15.homework1;

public class UserRepository {
    //fileds
    private User[] users;

    //constructor
    public UserRepository(User[] users) {
        this.users = users;
    }

    //getters
    public User[] getUsers() {
        return users;
    }

    //methods
    //save new user
    public User save(User user){
        if(user == null)
            return null;

        for(User us : users)
            if (us != null)
                if (us.equals(user))
                    return null;

        int index = 0;
        for(User us : users){
            if(us == null){
                users[index] = user;
                return user;
            }
            index ++;
        }
        return null;
    }

    //update user
    public User update(User user){
        if(user == null)
            return null;

        int index = 0;
        for(User us : users){
            if(us != null){
                if(us.getId() == user.getId()){
                    users[index] = user;
                    return user;
                }
            }
            index++;
        }
        return null;
    }

    //delete user
    public void delete(long id){
        int index = 0;
        for (User us : users){
            if(us != null){
                if(us.getId() == id){
                    users[index] = null;
                    break;
                }
            }
            index++;
        }
    }

    //find user
    public User findUser(User user){
        if(user == null)
            return null;

        int index = 0;
        for (User us : users){
            if(us != null)
                if(us.getId() == user.getId())
                    return user;
            index++;
        }
        return null;
    }
}
