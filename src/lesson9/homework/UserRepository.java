package lesson9.homework;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames()
    {
        int i = 0;
        for (User user : users){
            if(user != null) {
                i++;
            }
        }
        String [] userNames = new String[i];
        int k = 0;
        for (i = 0; i < users.length; i++)
        {
            if(users[i] != null){
                userNames[k] = users[i].getName();
                k++;
            }
        }
        return userNames;
    }

    public long[] getUserIds(){
        int i = 0;
        for (User user : users){
            if(user != null) {
                i++;
            }
        }
        long [] userIds = new long [i];
        int k = 0;
        for (i = 0; i < users.length; i++){
            if(users[i] != null)
                userIds[k] = users[i].getId();
                k++;
        }
        return userIds;
    }

    public String getUserNameById(long id){
        for(int i = 0; i < users.length; i++){
            if(users[i] != null){
                if(users[i].getId() == id)
                    return users[i].getName();
            }
        }
        return null;
    }

    public User getUserByName(String name){
        for(int i = 0; i < users.length; i++){
            if(users[i] != null)
                if(users[i].getName() == name)
                    return users[i];
        }
        return null;
    }

    public User getUserById(long id){
        for(int i = 0; i < users.length; i++){
            if(users[i] != null)
                if(users[i].getId() == id)
                    return users[i];
        }
        return null;
    }

    public User getUserBySessionId(String sessionId){
        if(sessionId == null)
            return null;
        for(int i = 0; i < users.length; i++){
            if(users[i] != null)
                if(users[i].getSessionId() == sessionId)
                    return users[i];
        }
        return null;
    }

    public User save(User user){
        if(user == null)
            return null;


        for (int i = 0; i < users.length; i++){
            if(users[i] == null) {
                users[i] = user;
                return user;
            }
            else if(users[i].getId() == user.getId())
                return null;
        }
        return null;
    }

    public User findById(long id){
        for(int i = 0; i < users.length; i++){
            if(users[i] != null)
                if(users[i].getId() == id)
                    return users[i];
        }
        return null;
    }


    public User update(User user){
        for(int i = 0; i < users.length; i++){
            if(user != null){
                if(users[i] != null) {
                    if (users[i].getId() == user.getId()) {
                        users[i] = null;
                        users[i] = user;
                        return user;
                    }
                }
            }
        }
            return null;
    }

    public void delete(long id){
        for (int i = 0; i < users.length; i++){
            if(users[i] != null) {
                if (users[i].getId() == id)
                    users[i] = null;
            }
        }
    }
}
