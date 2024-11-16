package Problems.splitwise;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private String id;
    private String name;
    private String email;
    private Map<String , Double> balances;

    User(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
        this.balances = new ConcurrentHashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Double> getBalances() {
        return balances;
    }




}
