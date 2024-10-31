package DesignPattern.singleton;

public class EagerSingleton {

    private EagerSingleton(){}

    private static final EagerSingleton instance = new EagerSingleton();

    public EagerSingleton getInstance(){
        return instance;
    }


}