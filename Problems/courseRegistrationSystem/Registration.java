package Problems.courseRegistrationSystem;


import java.time.LocalDateTime;
import java.util.UUID;

public class Registration {

    private String registrationId;
    private Student student;
    private Course course;
    private LocalDateTime registrationTime;

    public Registration(Student student, Course course, LocalDateTime registrationTime){
        this.registrationId = generateRegistrationId();
        this.student = student;
        this.course = course;
        this.registrationTime = registrationTime;
    }


    private String generateRegistrationId(){
        return "REG_"+ UUID.randomUUID();
    }

}