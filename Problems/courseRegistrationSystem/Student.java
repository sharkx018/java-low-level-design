package Problems.courseRegistrationSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private String email;
    private List<Course> registeredCourses;

    Student(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
        this.registeredCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void addCourse(Course course){
        this.registeredCourses.add(course);
    }


}