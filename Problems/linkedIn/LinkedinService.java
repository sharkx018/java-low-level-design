package Problems.linkedIn;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedinService {
    private static LinkedinService instance;
    private Map<String, User> users;
    private Map<String, JobPosting> jobPostings;
    private Map<String, List<Notification>> notifications;

    private LinkedinService(){
        users = new HashMap<>();
        jobPostings = new HashMap<>();
        notifications = new HashMap<>();
    }

    public static synchronized LinkedinService getInstance() {
        if(instance == null){
            instance = new LinkedinService();
        }

        return instance;
    }

    public void registerUser(User user){
        this.users.put(user.getId(), user);
    }

    public User loginUser(String email, String password){
        for(User user: users.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals( password)){
                return user;
            }
        }

        return null;

    }

    public void updateUserProfile(User user){
         users.put(user.getId(), user);
    }

    public void sendConnectionRequest(User sender, User receiver){
        Connection connection = new Connection(sender, new Timestamp(System.currentTimeMillis()));
        receiver.getConnections().add(connection);

        Notification notification = new Notification(generateNotificationId(), receiver, NotificationType.CONNECTION_REQUEST, "New connection request from " + sender.getName(), new Timestamp(System.currentTimeMillis()));
        addNotification(notification, receiver.getId());
    }

    public void acceptConnectionRequest(User receiver, User sender){
        for(Connection receiverConnection: receiver.getConnections()){

            if(receiverConnection.getUser().equals(sender)){
                Connection connection = new Connection(receiver, new Timestamp(System.currentTimeMillis()));
                sender.getConnections().add(connection);
                break;

            }
        }
    }


    public List<User> searchUsers(String keyword){
        List<User> result = new ArrayList<>();
        for(User user: users.values()){
            if(user.getName().contains(keyword)){
                result.add(user);
            }
        }

        return result;
    }

    public void postJobPosting(JobPosting jobPosting){

        jobPostings.put(jobPosting.getId(), jobPosting);

        for(User user: users.values()){
            Notification notification = new Notification(
                    generateNotificationId(),
                    user,
                    NotificationType.JOB_POSTING,
                    "New job posting for " + jobPosting.getTitle(),
                    new Timestamp(System.currentTimeMillis())
            );
            addNotification(notification, user.getId());
        }

    }

    public List<JobPosting> searchJobPasting(String keyword){

        List <JobPosting> result = new ArrayList<>();

        for( JobPosting jobPosting : jobPostings.values()){
            if(jobPosting.getTitle().contains(keyword) || (jobPosting.getDescription().contains(keyword) )){
                result.add(jobPosting);
            }

        }

        return result;

    }



    public void sendMessage(User sender, User receiver, String content){
        Message message = new Message(generateMessageId(), content, sender, receiver, new Timestamp(System.currentTimeMillis()));

        // store message in sender
        sender.getSentMessages().add(message);

        // store message in receiver
        receiver.getInbox().add(message);

        // send the notification
        Notification notification = new Notification(generateNotificationId(), receiver, NotificationType.MESSAGE, "Got new message from "+ sender.getName()+", Content: " + content, new Timestamp(System.currentTimeMillis()));

        addNotification(notification, receiver.getId());

    }

    public List<Notification> getAllNotificationForUser(String userId){
        return notifications.getOrDefault(userId, new ArrayList<>());
    }


    public void addNotification(Notification notification, String userId){
        this.notifications.computeIfAbsent(userId, k-> new CopyOnWriteArrayList<>()).add(notification);
    }

    private String generateMessageId(){
        return UUID.randomUUID().toString();
    }


    private String generateNotificationId(){
        return UUID.randomUUID().toString();
    }






}
