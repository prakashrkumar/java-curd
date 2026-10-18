package in.prakash.CurdOpeationSpring;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.prakash.CurdOpeationSpring.dto.CreateStudentRequestDTO;
import in.prakash.CurdOpeationSpring.dto.CreateStudentResponseDto;
import in.prakash.CurdOpeationSpring.dto.UpdateStudentResquestDto;
import in.prakash.CurdOpeationSpring.dto.UpdateStudentResponseDto;
import in.prakash.CurdOpeationSpring.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CurdOpeationSpringApplicationTests {

	@Autowired
	private StudentService studentService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void createAndUpdateResponsesIncludeTimestamps() {
		CreateStudentRequestDTO createRequest = new CreateStudentRequestDTO()
				.setName("Test Student")
				.setAge(20)
				.setEmail("test@example.com")
				.setRollNo(12345L)
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

	@Test
	void createRequestAcceptsLargeRollNumber() throws Exception {
		CreateStudentRequestDTO request = objectMapper.readValue("""
				{
				  "name": "Bishun kumar",
				  "age": 45,
				  "email": "Bishun@gmail.com",
				  "rollNo": 1201900146856,
				  "subject": "Biology"
				}
				""", CreateStudentRequestDTO.class);

		assertEquals(1201900146856L, request.getRollNo());
	}
}
