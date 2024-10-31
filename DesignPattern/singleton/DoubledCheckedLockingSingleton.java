package DesignPattern.singleton;

public class DoubledCheckedLockingSingleton {

    private DoubledCheckedLockingSingleton(){}

    private static volatile DoubledCheckedLockingSingleton instance;

    public static DoubledCheckedLockingSingleton getInstance(){
        if(instance == null){
            synchronized (DoubledCheckedLockingSingleton.class){
                if(instance == null){
                    instance = new DoubledCheckedLockingSingleton();
                }
            }
        }

        return instance;
    }




}
