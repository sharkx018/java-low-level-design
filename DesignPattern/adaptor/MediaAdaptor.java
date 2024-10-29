package DesignPattern.adaptor;

public class MediaAdaptor implements MediaPlayer{

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdaptor(String audioType){
        if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }else if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VlcPlayer();
        }
    }

    @Override
    public void play(String audioType, String filename) {
        if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(filename);
        }else if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(filename);
        }
    }
}