package Problems.courseRegistrationSystem;

public class Course {
    private String code;
    private String name;
    private String instructor;
    private double duration;
    private int maxCapacity;
    private int enrolledStudents;

    Course(String code, String name, String instructor, double duration, int maxCapacity){
        this.code = code;
        this.instructor = instructor;
        this.name = name;
        this.duration = duration;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = 0;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getCode() {
        return code;
    }

    public void setEnrolledStudents(int enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}