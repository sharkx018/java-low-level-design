package Problems.musicStreamingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MusicRecommender {
    private static MusicRecommender instance;
    private Map<String , List<Song>> userRecommendation;

    private MusicRecommender(){
        userRecommendation = new ConcurrentHashMap<>();
    }

    public synchronized static MusicRecommender getInstance(){
        if(instance == null){
            instance = new MusicRecommender();
        }

        return instance;
    }


    public List<Song> recommendSongs(User user){
        /// Do some logic based on the history of the user...


        return userRecommendation.getOrDefault(user.getId(), new ArrayList<>());



    }

}
