package Problems.taskManagementSystem;

import java.util.Date;

public class Task {
    private String id;
    private String title;
    private String description;
    private Date dueDate;
    private int priority;
    private TaskStatus status;
    private User assignedUser;

    public Task(String id, String title ,String description, Date dueDate, int priority, User assignedUser){
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = TaskStatus.PENDING;
        this.assignedUser = assignedUser;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
