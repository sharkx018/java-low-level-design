package Problems.socialNetworkingService;

import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String profilePicture;
    private String bio;
    private List<Post> posts;
    private List<String> friends;

    User(String id, String name, String email, String password, String profilePicture, String bio, List<Post> posts, List<String> friends){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePicture = profilePicture;
        this.bio = bio;
        this.posts = posts;
        this.friends = friends;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<String> getFriends() {
        return friends;
    }

    public String getBio() {
        return bio;
    }


}
