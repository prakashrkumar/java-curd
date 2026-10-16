package in.prakash.CurdOpeationSpring;

import com.sun.jdi.PathSearchingVirtualMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class CurdOpeationSpringApplication {


	public static void main(String[] args) {
		SpringApplication.run(CurdOpeationSpringApplication.class, args);
		System.out.println("heloo curd start kar bahi ok");
	}

}



