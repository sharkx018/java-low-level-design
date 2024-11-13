package Problems.musicStreamingSystem;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String id;
    private String title;
    private User owner;
    private List<Song> songs;

    public Playlist(String id, String title, User owner) {
        this.owner = owner;
        this.id = id;
        this.title = title;
        this.songs = new ArrayList<>();
    }

    public void addSongs(Song song){
        this.songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getOwner() {
        return owner;
    }
}
