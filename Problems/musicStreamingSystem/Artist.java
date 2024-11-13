package Problems.musicStreamingSystem;

import java.util.List;

public class Artist {
    private String id;
    private String name;
    private List<Album> albums;

    public Artist(String id, String name, List<Album> albums){
        this.id = id;
        this.name = name;
        this.albums = albums;
    }

    public void addAlbum(Album album){
        this.albums.add(album);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
