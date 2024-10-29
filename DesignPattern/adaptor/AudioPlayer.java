package DesignPattern.adaptor;

public class AudioPlayer implements MediaPlayer {


    @Override
    public void play(String audioType, String filename) {
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing the audio file. Name" + filename);
        }
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4") ) {
            MediaAdaptor mediaAdaptor = new MediaAdaptor(audioType);
            mediaAdaptor.play(audioType, filename);
        }else{
            System.out.println("Invalid media. "+ audioType + " format not supported");
        }
    }
}