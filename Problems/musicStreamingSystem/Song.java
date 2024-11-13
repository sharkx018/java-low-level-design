package Problems.musicStreamingSystem;

public class Song {
    private String id;
    private String title;
    private String artist;
    private String album;
    private int duration;

    public Song(String id, String title, String artist, String album, int duration){
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getAlbum() {
        return album;
    }
}
