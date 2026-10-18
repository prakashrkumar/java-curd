package in.prakash.CurdOpeationSpring.service;

import in.prakash.CurdOpeationSpring.dto.CreateStudentRequestDTO;
import in.prakash.CurdOpeationSpring.dto.CreateStudentResponseDto;
import in.prakash.CurdOpeationSpring.dto.UpdateStudentResponseDto;
import in.prakash.CurdOpeationSpring.dto.UpdateStudentResquestDto;
import in.prakash.CurdOpeationSpring.entity.Student;
import in.prakash.CurdOpeationSpring.exception.DuplicateResourceException;
import in.prakash.CurdOpeationSpring.exception.ResourceNotFoundException;
import in.prakash.CurdOpeationSpring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDTO studentReqtDTO) {
        Student student = mapToEntity(studentReqtDTO);

        if(emailExists(student)){
            throw new DuplicateResourceException("Student with email " + student.getEmail() + " already exists");
        }
        Student studentResp = studentRepository.save(student);

        return mapToDto(studentResp);
    }

    public CreateStudentResponseDto getStudent(Long id) {
        Student studentRes = studentRepository
                .findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Student with id" + id +"not found")

                        );
                return mapToDto(studentRes);


    }

    public List<CreateStudentResponseDto> getAllStudent() {
        return studentRepository.findByDeletedIsFalse().stream()
                .map(this::mapToDto)
                .toList();
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentResquestDto studentReq) {
        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student with id" + "not Found"));


        existingStudent.setName(studentReq.getName());
        existingStudent.setAge(studentReq.getAge());

        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setDeleted(false);
        Student saveStudent = studentRepository.save(existingStudent);
        return mapToUpdateDto(saveStudent);
    }

    public void deleteStudent(Long id) {
       Student studentToBeDeleted =studentRepository
                .findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Student with id" + "not Found"));
         studentRepository.delete(studentToBeDeleted);





    }

    public void deleteStudentSoftly(Long id) {
        Student studentToBeDeleted =studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Student with id" + "not Found"));




       studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);

    }

    private Student mapToEntity(CreateStudentRequestDTO studentReqDto) {
        Student student = new Student();
        student.setName(studentReqDto.getName());
        student.setEmail(studentReqDto.getEmail());
        student.setRollNo(studentReqDto.getRollNo());
        student.setAge(studentReqDto.getAge());
        student.setSubject(studentReqDto.getSubject());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        student.setDeleted(false);
        return student;
    }

    private CreateStudentResponseDto mapToDto(Student student) {
        CreateStudentResponseDto responseDto = new CreateStudentResponseDto();
        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student created successfully");
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());
        return responseDto;
    }
    private UpdateStudentResponseDto mapToUpdateDto(Student student) {
        UpdateStudentResponseDto responseDto = new UpdateStudentResponseDto();
        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());
        return responseDto;
    }
    private  boolean emailExists(Student student){
   return   studentRepository.existsByEmail(student.getEmail())   ;
    }

}
