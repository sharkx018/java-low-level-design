package Problems.musicStreamingSystem;

public class MusicStreamingService {
    private final MusicLibrary musicLibrary;
    private final UserManager userManager;
    private final MusicRecommender musicRecommender;

    public MusicStreamingService(){
        musicLibrary = MusicLibrary.getInstance();
        userManager = UserManager.getInstance();
        musicRecommender = MusicRecommender.getInstance();
    }

    public MusicLibrary getMusicLibrary() {
        return musicLibrary;
    }

    public MusicRecommender getMusicRecommender() {
        return musicRecommender;
    }

    public UserManager getUserManager() {
        return userManager;
    }
}
