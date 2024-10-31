package DesignPattern.singleton;

public class StaticBlockSingleton {

    private StaticBlockSingleton(){}

    private static StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        }catch (Error error){
            throw new RuntimeException("Exception occurred in creating runtime instance");
        }
    }


    public StaticBlockSingleton getInstance(){
        return instance;
    }

}