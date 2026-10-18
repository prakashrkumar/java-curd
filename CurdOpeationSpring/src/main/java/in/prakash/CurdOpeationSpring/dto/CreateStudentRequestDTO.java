package in.prakash.CurdOpeationSpring.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDTO {
    @NotBlank(message = "Name can not be null/empty or blank ")
    @Size(min = 2,max = 50,message = "Student name must be within 2 to 50 character long")
    private String name;
    @NotNull(message = "Age is required")
    @Min(value = 18,message = "student must be at least 18 year old")

    private Integer age;
    @NotBlank(message = "student email cannot be blink")
    @Email(message = "student email must be valid")
    private String email;
    @NotNull(message = "rollno is required")
    private Long rollNo;
    @NotBlank(message = "sublect name must be required")
    private String subject;

    public String getName() {
        return name;
    }

    public CreateStudentRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public CreateStudentRequestDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateStudentRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getRollNo() {
        return rollNo;
    }

    public CreateStudentRequestDTO setRollNo(Long rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public CreateStudentRequestDTO setSubject(String subject) {
        this.subject = subject;
        return this;
    }
}
