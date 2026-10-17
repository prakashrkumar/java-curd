package in.prakash.CurdOpeationSpring.dto;

import java.time.LocalDateTime;

public class CreateStudentResponseDto {
    private Long id;
    private String name;
    private int age;
    private String email;
    private long rollNo;
    private String subject;
    private String message;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public CreateStudentResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateStudentResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public CreateStudentResponseDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateStudentResponseDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public long getRollNo() {
        return rollNo;
    }

    public CreateStudentResponseDto setRollNo(long rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public CreateStudentResponseDto setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CreateStudentResponseDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public CreateStudentResponseDto setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public CreateStudentResponseDto setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
