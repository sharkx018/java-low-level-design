package DesignPattern.singleton;

public class ThreadSafeSingleton {
    private ThreadSafeSingleton(){}

    private static ThreadSafeSingleton instance;

    private static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}