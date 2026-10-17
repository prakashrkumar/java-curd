package in.prakash.CurdOpeationSpring.dto;

import java.time.LocalDateTime;

public class UpdateStudentResponseDto {
    private Long id;
    private String name;
    private int age;
    private   String email;
    private long rollNo;
    private  String subject;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public UpdateStudentResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UpdateStudentResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UpdateStudentResponseDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UpdateStudentResponseDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public long getRollNo() {
        return rollNo;
    }

    public UpdateStudentResponseDto setRollNo(long rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public UpdateStudentResponseDto setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UpdateStudentResponseDto setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UpdateStudentResponseDto setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}