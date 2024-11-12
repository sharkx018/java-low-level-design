package Problems.linkedIn;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedinDemo {
    public static void main(String[] args) {
        LinkedinService linkedinService = LinkedinService.getInstance();

        // create users
        User user1 = new User("U001", "Andrew", "andrew@gmail.com", "123", new Profile(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User("U002", "John", "john@gmail.com", "123", new Profile(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        linkedinService.registerUser(user1);
        linkedinService.registerUser(user2);

        // user login
        User loggedInUser  = linkedinService.loginUser("andrew@gmail.com", "123");

        // update the profile
        Profile profile  = new Profile();
        profile.setHeadline("Software Engineer");
        profile.setSummary("Passion about coding and problem solving");
        loggedInUser.setProfile(profile);
        linkedinService.updateUserProfile(loggedInUser);

        // send connection request
        linkedinService.sendConnectionRequest(user1, user2);

        // accept connection request
        linkedinService.acceptConnectionRequest(user2, user1);

        // post the job
        JobPosting jobPosting = new JobPosting("J001", "Software Developer", "we are hiring", Arrays.asList("Java", "Python"), "Bhitaura", new Timestamp(System.currentTimeMillis()));
        linkedinService.postJobPosting(jobPosting);

        // search a user()
        List<User> searchUsers = linkedinService.searchUsers("Andrew");
        System.out.println("Searched Users:");
        for(User user: searchUsers){
            System.out.println("Name: " + user.getName());
            System.out.println("Headline: " + user.getProfile().getHeadline());
            System.out.println();
        }


        // search job posting
        List<JobPosting> jobPostings = linkedinService.searchJobPasting("Software");
        System.out.println("Job Posting Results:");
        for(JobPosting jobPosting1: jobPostings){
            System.out.println("Title: " + jobPosting1.getTitle());
            System.out.println("Description: " + jobPosting1.getTitle());
            System.out.println();
        }


        // send message
        linkedinService.sendMessage(user1, user2, "Hi there , Hope you are doing well!");


        // get all notification
        List<Notification> notifications = linkedinService.getAllNotificationForUser(user2.getId());
        System.out.println("Notifications:");
        for(Notification notification: notifications){
            System.out.println("Type: " + notification.getNotificationType());
            System.out.println("Content: " + notification.getContent());
        }

    }
}
