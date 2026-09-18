package com.example.Jpa_annotation_concept;

import java.beans.BeanProperty;
import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Jpa_annotation_concept.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor 
public class JpaAnnotationConceptApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAnnotationConceptApplication.class, args);
	}

	private final EmployeeRepository repository;

@Bean 
public CommandLineRunner commandLineRunner() {
	return  args -> {
		//Employee employee = new Employee(null, "Name 1", "Desc 1", 1000.99)
		System.out.println("CommandLineRunner run method");

		Employee employee = Employee.builder()
							.name(name: "Ranjit Nayak")
							.description(description: "Ranjit is a loyal employee.")
							.salary(BigDecimal.valueOf(10000.98))
							.status(EmployeeStatus.ACTIVE)
							.build();

		Employee emp =	repository.save(employee);	
		Employee savedEmployee = repository
									.findById(emp.getId()).orElseThrow();

		savedEmployee.setName(name:"Ankit Kumar");
		savedEmployee.setDescription(description:"Ankit is a good boy");	
		
		repository.save(savedEmployee);
	};
}

}


