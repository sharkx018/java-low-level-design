package Problems.socialNetworkingService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SocialNetworkingServiceDemo {
    public static void main(String[] args) {
        SocialNetworkService socialNetworkService = SocialNetworkService.getInstance();

        // register user
        User u1 = new User("U001","Mukul", "mukul@gmail.com", "pass", "profile1.jpg", "bio1", new ArrayList<>(), new ArrayList<>());
        User u2 = new User("U002","Aryan", "aryan@gmail.com", "pass", "profile2.jpg", "bio2", new ArrayList<>(), new ArrayList<>());
        socialNetworkService.registerUser(u1);
        socialNetworkService.registerUser(u2);


        // login user
        User loggedInUser = socialNetworkService.login("mukul@gmail.com", "pass");
        if(loggedInUser != null){
            System.out.println("User logged in: "+ loggedInUser.getName());
        }else{
            System.out.println("Invalid email or password");
        }

        // send friend request
        socialNetworkService.sendFriendRequest(u1.getId(), u2.getId());

        // accept friend request
        socialNetworkService.acceptFriendRequest(u2.getId(), u1.getId());


        // create post
        Post p1 = new Post("P001", u1.getId(), "My first post", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new Timestamp(System.currentTimeMillis()));
        Post p2 = new Post("P002", u2.getId(), "having a great day!", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new Timestamp(System.currentTimeMillis()));
        socialNetworkService.createPost(p1);
        socialNetworkService.createPost(p2);

        // like post
        socialNetworkService.likePost(u2.getId(), p1.getId());


        // comment post
        Comment comment = new Comment("C001", u2.getId(), p1.getId(), "Great Post!", new Timestamp(System.currentTimeMillis()));
        socialNetworkService.commentOnPost(comment);


        // get newsfeed
        List<Post> newsFeed = socialNetworkService.getNewsFeed(u1.getId());
        System.out.println("NewsFeeds:");
        for(Post post : newsFeed){
            System.out.println("Post: " + post.getContent());
            System.out.println("Likes: " + post.getLikes().size());
            System.out.println("Comments: " + post.getComments().size());
            System.out.println();
        }

        // get all notifications
        List<Notification> notifications = socialNetworkService.getNotification(u1.getId());
        System.out.println("Notification:");
        for(Notification notification: notifications){
            System.out.println("Type: " + notification.getNotificationType() );
            System.out.println("Content: " + notification.getContent() );
        }
    }
}
