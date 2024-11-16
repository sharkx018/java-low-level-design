package Problems.taskManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager {
    private static TaskManager instance;
    private Map<String , Task> tasks;
    private Map<String, List<Task>> userTasks;


    private TaskManager(){
        tasks = new ConcurrentHashMap<>();
        userTasks = new ConcurrentHashMap<>();
    }

    public static synchronized TaskManager getInstance(){
        if(instance == null){
            instance = new TaskManager();
        }
        return instance;
    }

    public void createTask(Task task){
        this.tasks.put(task.getId(), task);
        assignTaskToUser(task.getAssignedUser(), task);
    }

    public void updateTask(Task updatedTask){
        Task existingTask = this.tasks.get(updatedTask.getId());
        if(existingTask != null){
            synchronized (existingTask){
                existingTask.setTitle(updatedTask.getTitle());
                existingTask.setDescription(updatedTask.getDescription());
                existingTask.setDueDate(updatedTask.getDueDate());
                existingTask.setPriority(updatedTask.getPriority());
                existingTask.setStatus(updatedTask.getStatus());
                User existingUser = existingTask.getAssignedUser();
                User updatedUser = updatedTask.getAssignedUser();
                if(!existingUser.equals(updatedUser)){
                    unAssignTaskFromUser(existingUser, existingTask);
                    assignTaskToUser(updatedUser, existingTask);
                }
            }
        }
    }


    public void deleteTask(String taskId){
        Task task = tasks.remove(taskId);
        if(task !=null){
            unAssignTaskFromUser(task.getAssignedUser(), task);
        }
    }

    public List<Task> filterTask(TaskStatus status, Date startDate, Date endDate, int priority){
        List<Task> filteredTask = new ArrayList<>();
        for(Task task: tasks.values()){
            if(
                task.getStatus() == status &&
                task.getDueDate().compareTo(startDate) >=0 &&
                task.getDueDate().compareTo(endDate) <= 0 &&
                task.getPriority() == priority){
                filteredTask.add(task);
            }
        }

        return filteredTask;
    }

    public List<Task> searchTask(String keyword){
        List<Task> searchedTasks = new ArrayList<>();
        for(Task task: tasks.values()){
            if(task.getTitle().contains(keyword) || task.getDescription().contains(keyword)){
                searchedTasks.add(task);
            }
        }

        return searchedTasks;
    }


    public void markTaskAsComplete(String taskId){
        Task task = tasks.get(taskId);
        if(task != null){
            synchronized (task){
                task.setStatus(TaskStatus.COMPLETED);
            }
        }
    }

    public List<Task> getTaskHistory(User user){
        List<Task> userTasks = this.userTasks.getOrDefault(user.getId(), new ArrayList<>());
        return new ArrayList<>(userTasks);
    }


    private void assignTaskToUser(User user, Task task){
        this.userTasks.computeIfAbsent(user.getId(), k->new CopyOnWriteArrayList<>()).add(task);
    }

    private void unAssignTaskFromUser(User user, Task task){
        List<Task> taskList = userTasks.get(user.getId());
        if(taskList != null){
            taskList.remove(task);
        }
    }

}
