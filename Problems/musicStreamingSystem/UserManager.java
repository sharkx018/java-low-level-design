package Problems.musicStreamingSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {
    private static UserManager instance;
    private Map<String , User> users;

    private UserManager(){
        users = new ConcurrentHashMap<>();
    }

    public synchronized static UserManager getInstance(){
        if(instance == null){
            instance = new UserManager();
        }

        return instance;
    }

    public void registerUser(User user){
        this.users.put(user.getId(), user);
    }

    public User login(String username, String password){

        for(Map.Entry<String, User> userEntry: users.entrySet()){
            if(userEntry.getValue().getUsername().equals(username) && userEntry.getValue().getPassword().equals(password)){
                return userEntry.getValue();
            }
        }

        return null;
    }
}
