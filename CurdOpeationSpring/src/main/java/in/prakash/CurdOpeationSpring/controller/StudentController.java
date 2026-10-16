package in.prakash.CurdOpeationSpring.controller;

import in.prakash.CurdOpeationSpring.entity.Student;
import in.prakash.CurdOpeationSpring.service.StudentService;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
@PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

    Student createStudent=this.studentService.createStudent(student);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(createStudent);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student>getStudent(@PathVariable Long id){
        Student studentRes=studentService.getStudent(id);
        if(studentRes==null){
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRes);

    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>>getAllStudent(){
        List<Student> studentList=studentService.getAllStudent();
        if(studentList.isEmpty()){
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);

    }

    @PutMapping("/get/{id}")
    public ResponseEntity<Student>updateStudent(@PathVariable Long id,@RequestBody Student studentReq){
        Student studentRes=studentService.updateStudent(id,studentReq);
        if(studentRes==null){
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRes);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
       Boolean isDeleted =studentService.deleteStudent(id);
       if(!isDeleted){
           return ResponseEntity.notFound().build();

       }
       return ResponseEntity.ok("record delete");
    }


}
