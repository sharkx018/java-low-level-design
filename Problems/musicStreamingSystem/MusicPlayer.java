package Problems.musicStreamingSystem;

public class MusicPlayer {

    private Song currentSong;
    private Boolean isPlaying;
    private int currentTime;

    public void playSong(Song song){
        currentSong  = song;
        isPlaying = true;
        currentTime = 0;
    }

    public void pause(){
        isPlaying = false;
    }

    public void seekTo(int time){
        currentTime = time;
    }

}
