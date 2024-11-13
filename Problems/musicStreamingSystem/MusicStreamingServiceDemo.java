package Problems.musicStreamingSystem;

import java.util.ArrayList;
import java.util.List;

public class MusicStreamingServiceDemo {
    public static void main(String[] args) {

        MusicStreamingService musicStreamingService = new MusicStreamingService();

        // add user
        User user1 = new User("1", "john@gmail.com", "password");
        User user2 = new User("2", "jane@gmail.com", "password");

        // create Songs
        Song song1 = new Song("1", "Song 1", "Artist 1", "Album 1", 12);
        Song song2 = new Song("2", "Song 2", "Artist 2", "Album 2", 10);
        Song song3 = new Song("3", "Song 3", "Artist 3", "Album 3", 20);


        // create albums
        Album album1 = new Album("1", "Album 1", "Artist 1", List.of(song1));
        Album album2 = new Album("2", "Album 2", "Artist 2", List.of(song2));
        Album album3 = new Album("3", "Album 3", "Artist 3", List.of(song3));


        // create artist
        Artist artist1 = new Artist("1", "Artist 1", List.of(album1));
        Artist artist2 = new Artist("2", "Artist 2", List.of(album2));
        Artist artist3 = new Artist("3", "Artist 3", List.of(album3));

        // add music to the library
        musicStreamingService.getMusicLibrary().addArtist(artist1);
        musicStreamingService.getMusicLibrary().addArtist(artist2);
        musicStreamingService.getMusicLibrary().addArtist(artist3);

        // register user
        musicStreamingService.getUserManager().registerUser(user1);
        musicStreamingService.getUserManager().registerUser(user2);

        // login user
        User loggedInUser = musicStreamingService.getUserManager().login("john@gmail.com", "password");
        if(loggedInUser != null){
            System.out.println("User logged in: " + loggedInUser.getUsername());
        }else{
            System.out.println("Invalid user or password");
        }

        // search for song
        List<Song> searchedSong = musicStreamingService.getMusicLibrary().searchSongs("Song");
        System.out.println("Search results:");
        for(Song song: searchedSong){
            System.out.println("Song: " + song.getTitle() + " - " + song.getArtist());
        }


        // create a playlist

        Playlist playlist = new Playlist("1", "My String", loggedInUser);
        playlist.addSongs(song1);
        playlist.addSongs(song2);
        loggedInUser.addPlaylist(playlist);

        // get song recommendation
        List<Song> recommendSongs = musicStreamingService.getMusicRecommender().recommendSongs(loggedInUser);
        System.out.println("Recommended results:");
        for(Song song: searchedSong){
            System.out.println("Song: " + song.getTitle() + " - " + song.getArtist());
        }

        // play song
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playSong(song1);

        // pause song
        musicPlayer.pause();

        // seek to time
        musicPlayer.seekTo(10);

        // get user playlist
        List<Playlist> playlists = loggedInUser.getPlaylists();
        System.out.println("User Playlists:");
        for(Playlist playlists1: playlists){
            System.out.println("Playlist: " + playlists1.getTitle());
            System.out.println("Songs:");
            for(Song song: playlists1.getSongs()){
                System.out.println("- "+ song.getTitle());
            }
        }


    }
}
