package Problems.socialNetworkingService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SocialNetworkService {
    private static SocialNetworkService instance;
    private Map<String, User> users;
    private Map<String, Post> posts;
    private Map<String, List<Notification>> notifications;


    private SocialNetworkService(){
        users = new ConcurrentHashMap<>();
        posts = new ConcurrentHashMap<>();
        notifications = new ConcurrentHashMap<>();
    }

    public static synchronized SocialNetworkService getInstance(){
        if(instance == null){
            instance = new SocialNetworkService();
        }
        return instance;
    }

    // register user
    public void registerUser(User user){
        this.users.put(user.getId(), user);
    }

    // login user
    public User login(String email, String password){
        for(User user: users.values()){
            if(user.getEmail().toLowerCase().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    // update userProfile
    public void updateUserProfile(User user){
        this.users.put(user.getId(), user);

    }

    // add post
    public void createPost(Post post){
        posts.put(post.getId(), post);
        User user = this.users.get(post.getUserId());
        if(user != null){
            user.getPosts().add(post);
        }
    }

    // like post
    public void likePost(String userId, String postId){
        User user = this.users.get(userId);
        Post post = this.posts.get(postId);

        if(user != null && post!=null && post.getLikes().contains(userId) == false){
            post.getLikes().add(userId);
            Notification notification = new Notification(
                    generatedNotificationId(),
                    post.getUserId(),
                    NotificationType.LIKE,
                    "Your post was liked by " + user.getName(),
                    new Timestamp(System.currentTimeMillis()));

            sendNotification(post.getUserId(), notification);
        }
    }

    // comment post
    public void commentOnPost(Comment comment){
        Post post = this.posts.get(comment.getPostId());
        if(post!=null){
            post.getComments().add(comment);
            Notification notification = new Notification(
                    generatedNotificationId(),
                    post.getUserId(),
                    NotificationType.COMMENT,
                    "Your post received comment from " + comment.getUserId(),
                    new Timestamp(System.currentTimeMillis()));

            sendNotification(post.getUserId(), notification);
        }

    }

    // get newsFeed
    public List<Post> getNewsFeed(String userId){
        List<Post> newsfeed = new ArrayList<>();
        User user = this.users.get(userId);
        if(user != null){
            for(String friendId: user.getFriends()){
                User friend = users.get(friendId);
                if(friend != null){
                    newsfeed.addAll(friend.getPosts());
                }

            }

            newsfeed.addAll(user.getPosts());
            newsfeed.sort((p1, p2)-> p2.getTimestamp().compareTo(p1.getTimestamp()));
        }

        return newsfeed;

    }

    // send friendRequest
    public void sendFriendRequest(String senderId, String receiverId){
        User receiver = users.get(receiverId);

        if(receiver!=null){
            Notification notification = new Notification(
                    generatedNotificationId(),
                    receiverId,
                    NotificationType.FRIEND_REQUEST,
                    "You got friend request from "+senderId,
                    new Timestamp(System.currentTimeMillis())
            );

            sendNotification(receiverId, notification);
        }


    }


    // accept friendRequest
    public void acceptFriendRequest(String userId, String friendId){
        User user = users.get(userId);
        User friend = users.get(friendId);

        if(user != null && friend != null){
            user.getFriends().add(friendId);
            friend.getFriends().add(userId);
            Notification notification = new Notification(
                    generatedNotificationId(),
                    friendId,
                    NotificationType.FRIEND_REQUEST_ACCEPTED,
                    "Friend request accepted by " + userId,
                    new Timestamp(System.currentTimeMillis())
            );

            sendNotification(friendId, notification);
        }
    }


    // send notification
    public void sendNotification( String userId, Notification notification){
        System.out.println("New notification: " +notification.getNotificationType() + " , content: " + notification.getContent() );
        notifications.computeIfAbsent(userId, k-> new CopyOnWriteArrayList<>()).add(notification);

    }

    // get notification
    public List<Notification> getNotification(String userId){
        return this.notifications.getOrDefault(userId, new ArrayList<>());
    }

    // generateNotificationId
    public String generatedNotificationId(){
        return UUID.randomUUID().toString();
    }

}
