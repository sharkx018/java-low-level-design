package DesignPattern.adaptor;

public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playMp4(String filename) {
        System.out.println("Playing Mp4 file, Name: " + filename);
    }

    @Override
    public void playVlc(String filename) {
        // do nothing
    }
}
