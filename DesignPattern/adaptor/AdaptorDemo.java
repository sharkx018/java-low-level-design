package DesignPattern.adaptor;

public class AdaptorDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond_the_horizon.mp3");
        audioPlayer.play("vlc", "far_far_away.vlc");
        audioPlayer.play("mp4", "alone.mo4");
        audioPlayer.play("avi", "mind_me.avi");
    }

}