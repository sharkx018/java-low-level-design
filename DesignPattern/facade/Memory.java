package DesignPattern.facade;

public class Memory {
    public void load(long position, byte[] data){
        System.out.println("Memory: Looking at the position: " + position);
    }
}