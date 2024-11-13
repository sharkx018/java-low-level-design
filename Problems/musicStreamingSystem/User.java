package Problems.musicStreamingSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String username;
    private String password;
    private List<Playlist> playlists;

    User(String id, String username, String password) {
        this.id =id;
        this.username = username;
        this.password = password;
        this.playlists = new ArrayList<>();
    }

    public void addPlaylist(Playlist playlist){
        this.playlists.add(playlist);
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }
}