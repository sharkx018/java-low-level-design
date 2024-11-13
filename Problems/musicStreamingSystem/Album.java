package Problems.musicStreamingSystem;

import java.util.List;

public class Album {
    private String id;
    private String title;
    private String artist;
    private List<Song> songs;

    public Album(String id, String title, String artist, List<Song> songs){
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.songs = songs;
    }

    public String getArtist() {
        return artist;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Song> getSongs() {
        return songs;
    }


}
