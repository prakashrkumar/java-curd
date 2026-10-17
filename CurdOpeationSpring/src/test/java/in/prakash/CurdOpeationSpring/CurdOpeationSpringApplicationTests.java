package in.prakash.CurdOpeationSpring;

import in.prakash.CurdOpeationSpring.dto.CreateStudentRequestDTO;
import in.prakash.CurdOpeationSpring.dto.CreateStudentResponseDto;
import in.prakash.CurdOpeationSpring.dto.UpdateStudentResquestDto;
import in.prakash.CurdOpeationSpring.dto.UpdateStudentResponseDto;
import in.prakash.CurdOpeationSpring.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CurdOpeationSpringApplicationTests {

	@Autowired
	private StudentService studentService;

	@Test
	void contextLoads() {
	}

	@Test
	void createAndUpdateResponsesIncludeTimestamps() {
		CreateStudentRequestDTO createRequest = new CreateStudentRequestDTO()
				.setName("Test Student")
				.setAge(20)
				.setEmail("test@example.com")
				.setRollNo(12345)
				.setSubject("Math");

		CreateStudentResponseDto created = studentService.createStudent(createRequest);
		assertNotNull(created.getCreatedAt());
		assertNotNull(created.getUpdatedAt());

		UpdateStudentResquestDto updateRequest = new UpdateStudentResquestDto()
				.setName("Updated Student")
				.setAge(21)
				.setRollNo(12345)
				.setSubject("Science");

		UpdateStudentResponseDto updated = studentService.updateStudent(created.getId(), updateRequest);
		assertNotNull(updated);
		assertNotNull(updated.getCreatedAt());
		assertNotNull(updated.getUpdatedAt());
	}
}
