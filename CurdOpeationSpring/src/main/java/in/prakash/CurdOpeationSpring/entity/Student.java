package in.prakash.CurdOpeationSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
  private int age;
  private   String email;
  private long rollNo;
    private  String subject;
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public long getRollNo() {
        return rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public String subject() {
        return subject;
    }

    public Student setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Student setRollNo(long rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public String email() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public int age() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public Student setDeleted(Boolean deleted) {
        this.deleted = deleted;
        return this;
    }
}
