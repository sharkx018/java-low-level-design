package DesignPattern.adaptor;

public class VlcPlayer implements AdvancedMediaPlayer {


    @Override
    public void playMp4(String filename) {
        // do nothing
    }

    @Override
    public void playVlc(String filename) {
        System.out.println("Playing vlc file, Name: " + filename);
    }
}