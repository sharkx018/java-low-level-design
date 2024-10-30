package DesignPattern.facade;

public class HardDrive {
    public byte[] read(long lba, int size){
        System.out.println("Hard-drive reading with sector " + lba + " and with size "+size);
        return new byte[size];
    }
}