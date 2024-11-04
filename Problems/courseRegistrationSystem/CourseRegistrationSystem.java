package Problems.courseRegistrationSystem;

import Problems.concertBookingSystem.ConcertBookingSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationSystem {
    private static CourseRegistrationSystem instance;
    private List<Student> students;
    private List<Course> courseList;
    private List<Registration> registrationList;



    private CourseRegistrationSystem(){
        students = new ArrayList<>();
        courseList = new ArrayList<>();
        registrationList = new ArrayList<>();
    }

    public static CourseRegistrationSystem getInstance(){
        if(instance == null){
            instance = new CourseRegistrationSystem();
        }

        return instance;
    }

    public void addStudents(Student student){
        this.students.add(student);
    }

    public void addCourses(Course course){
        this.courseList.add(course);
    }

    public List<Course> searchCourses(String query){
        List<Course> searchedCourses = new ArrayList<>();
        for(Course course: courseList){
            if(course.getEnrolledStudents()<course.getMaxCapacity() &&
                    course.getName().contains( query) ||
                    course.getCode().contains(query)){
                searchedCourses.add(course);
            }
        }

        return searchedCourses;
    }

    public void registerCourse(Student student, Course course){

        if(course.getEnrolledStudents() <  course.getMaxCapacity()){

            Registration registration = new Registration(student, course, LocalDateTime.now());
            registrationList.add(registration);
            student.addCourse(course);
            course.setEnrolledStudents(course.getEnrolledStudents() + 1);

            System.out.println("Student with name: "+student.getName() + ", has enrolled in course: " + course.getName()+ " by " + course.getInstructor());

        }else{
            System.out.println("Can not enroll, max capacity reached");
        }


    }

    public List<Course> getRegisteredCourse(Student student){
        return student.getRegisteredCourses();
    }



}