package in.prakash.CurdOpeationSpring.service;

import in.prakash.CurdOpeationSpring.entity.Student;
import in.prakash.CurdOpeationSpring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentReq){
        studentReq.setDeleted(false);
        return studentRepository.save(studentReq);
    }
    public Student getStudent(Long id){
        Optional<Student> studentRes=studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentRes.isPresent()){
            return studentRes.get();
        }

        return null;
    }
public  List<Student>getAllStudent(){
 return studentRepository.findByDeletedIsFalse();
}

public Student updateStudent(Long id,Student studentReq){
        Optional<Student>existingStudent=studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToSave=existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setDeleted(false);
return studentRepository.save(studentToSave);
}


public Boolean deleteStudent(Long id) {
    Boolean isStudent = studentRepository.existsById(id);
    if(!isStudent){
        return false;
    }
      studentRepository.deleteById(id);
    return true;
}
//softDeleted
public Boolean deleteStudentSoftly(Long id) {
  Optional<Student> existingStudent=studentRepository.findByIdAndDeletedIsFalse(id);
  if(existingStudent.isEmpty()){
      return false;
  }
  Student studentToSave=existingStudent.get();
  studentToSave.setDeleted(true);
  studentRepository.save(studentToSave);
  return true;
}
}
