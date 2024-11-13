package Problems.musicStreamingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MusicLibrary {

    private static MusicLibrary instance;
    private Map<String, Song> songs;
    private Map<String, Album> albums;
    private Map<String , Artist> artists;

    private MusicLibrary(){
        songs = new ConcurrentHashMap<>();
        albums = new ConcurrentHashMap<>();
        artists = new ConcurrentHashMap<>();
    }


    public synchronized static MusicLibrary getInstance(){
        if(instance == null){
            instance = new MusicLibrary();
        }

        return instance;
    }


    public Song getSong(String songId){
        return songs.get(songId);
    }


    public Album getAlbum(String albumId){
        return albums.get(albumId);
    }


    public Artist getArtist(String artistId){
        return artists.get(artistId);
    }


    public void addSong(Song song){
        songs.put(song.getId(), song);
    }


    public void addAlbum(Album album){
        albums.put(album.getId(), album);
        for(Song song: album.getSongs()){
            addSong(song);
        }
    }


    public void addArtist(Artist artist){
        artists.put(artist.getId(), artist);
        for(Album album: artist.getAlbums()){
            addAlbum(album);
        }
    }


    public List<Song> searchSongs(String keyword){
        List<Song> searchedSongs = new ArrayList<>();
        for(Song song: songs.values()){
            if(song.getTitle().contains(keyword) || song.getArtist().contains(keyword) || song.getAlbum().contains(keyword)){
                searchedSongs.add(song);
            }
        }

        return searchedSongs;
    }

}

