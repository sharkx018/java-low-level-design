package Problems.courseRegistrationSystem;

import java.util.List;

public class CourseRegistrationDemo {

    public static void main(String[] args) {

        CourseRegistrationSystem courseRegistrationSystem = CourseRegistrationSystem.getInstance();

        Course course1 = new Course("CS001", "Operating System", "Pankaj", 30, 5);
        Course course2 = new Course("CS002", "Database Management", "Rohit", 30, 5);

        courseRegistrationSystem.addCourses(course1);
        courseRegistrationSystem.addCourses(course2);

        Student student1 = new Student(1, "Mukul", "mukul@gmail.com");
        Student student2 = new Student(1, "Aryan", "aryan@gmail.com");

        courseRegistrationSystem.addStudents(student1);
        courseRegistrationSystem.addStudents(student2);

        List<Course> searchCourses = courseRegistrationSystem.searchCourses("CS");
        System.out.println("Searched Results:");
        for(Course course: searchCourses){
            System.out.println(course.getCode() + ": " +course.getName() + " by " + course.getInstructor()  );
        }

        courseRegistrationSystem.registerCourse(student1, course1);
        courseRegistrationSystem.registerCourse(student1, course2);

        List<Course> courseStd1 = courseRegistrationSystem.getRegisteredCourse(student1);
        System.out.println("Registered Courses for "+student1.getName());
        for(Course course: courseStd1){
            System.out.println(course.getCode() + ": " +course.getName() + " by " + course.getInstructor());
        }


        List<Course> courseStd2 = courseRegistrationSystem.getRegisteredCourse(student2);
        System.out.println("Registered Courses for "+student2.getName());
        for(Course course: courseStd2){
            System.out.println(course.getCode() + ": " +course.getName() + " by " + course.getInstructor());
        }


    }
}