package in.prakash.CurdOpeationSpring.dto;

public class UpdateStudentResquestDto {
    private String name;
    private int age;

    private long rollNo;

    private String subject;

    public String getName() {
        return name;
    }

    public UpdateStudentResquestDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UpdateStudentResquestDto setAge(int age) {
        this.age = age;
        return this;
    }

    public long getRollNo() {
        return rollNo;
    }

    public UpdateStudentResquestDto setRollNo(long rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public UpdateStudentResquestDto setSubject(String subject) {
        this.subject = subject;
        return this;
    }
}
