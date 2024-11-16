package Problems.taskManagementSystem;

import java.util.Date;
import java.util.List;

public class TaskManagementSystemDemo {
    public static void main(String[] args) {

        TaskManager taskManager = TaskManager.getInstance();

        // create user;
        User u1 = new User("u1", "John Doe", "john@example.com");
        User u2 = new User("u2", "Jame Doe", "jane@example.com");

        // create tasks
        Task t1 = new Task("t1", "Task 1", "Description 1", new Date(), 1, u1);
        Task t2 = new Task("t2", "Task 2", "Description 2", new Date(), 2, u2);
        Task t3 = new Task("t3", "Task 3", "Description 3", new Date(), 1, u1);

        // add task to the task manager
        taskManager.createTask(t1);
        taskManager.createTask(t2);
        taskManager.createTask(t3);

        // update the task
        t2.setDescription("Updated Description");
        taskManager.updateTask(t2);

        // Search Task
        List<Task> searchedResults = taskManager.searchTask("Task");
        System.out.println("Searched Result:");
        for(Task task: searchedResults){
            System.out.println(task.getTitle());
        }

        // filter Task
        List<Task> filteredTasks = taskManager.filterTask(TaskStatus.PENDING, new Date(0), new Date(), 1);
        System.out.println("Filtered Result:");
        for(Task task: filteredTasks){
            System.out.println(task.getTitle());
        }

        taskManager.markTaskAsComplete("t1");

        List<Task> taskHistory = taskManager.getTaskHistory(u1);
        System.out.println("Task History for "+ u1.getName() + ":");
        for(Task task: taskHistory){
            System.out.println(task.getTitle() + ": status-> " + task.getStatus());
        }

        taskManager.deleteTask("3");

    }
}
