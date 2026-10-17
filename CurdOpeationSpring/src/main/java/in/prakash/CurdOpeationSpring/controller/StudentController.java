package in.prakash.CurdOpeationSpring.controller;

import in.prakash.CurdOpeationSpring.dto.CreateStudentRequestDTO;
import in.prakash.CurdOpeationSpring.dto.CreateStudentResponseDto;
import in.prakash.CurdOpeationSpring.dto.UpdateStudentResponseDto;
import in.prakash.CurdOpeationSpring.dto.UpdateStudentResquestDto;
import in.prakash.CurdOpeationSpring.entity.Student;
import in.prakash.CurdOpeationSpring.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// validation -> spring-boot-starter-validation

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDto> createStudent(@Valid  @RequestBody CreateStudentRequestDTO studentRequestDTO) {
        CreateStudentResponseDto createdStudent = studentService.createStudent(studentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@PathVariable Long id) {
        CreateStudentResponseDto studentRes = studentService.getStudent(id);
        if (studentRes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRes);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent() {
        List<CreateStudentResponseDto> studentList = studentService.getAllStudent();
        if (studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id, @RequestBody UpdateStudentResquestDto studentReq) {
        UpdateStudentResponseDto studentRes = studentService.updateStudent(id, studentReq);
        if (studentRes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRes);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Boolean isDeleted = studentService.deleteStudent(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("record delete");
    }

    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id) {
        Boolean isDeleted = studentService.deleteStudentSoftly(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }
}
