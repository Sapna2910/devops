package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping("/action")
	public ModelAndView action() {
		ModelAndView view = new ModelAndView();
		view.setViewName("action_page");
		return view;
	}

	@PostMapping("/saveThroughForm")
	public ModelAndView actionForm(Employee employee) {
		System.out.println("In /saveThroughForm controller");
		System.out.println("Emp FName : " + employee.getFirstName());
		System.out.println("Emp LName : " + employee.getLastName());
		System.out.println("Emp Email : " + employee.getEmailId());
		System.out.println("Emp Dept : " + employee.getDepartment());
		ModelAndView view = new ModelAndView();
		Employee emp = employeeRepository.save(employee);
		view.addObject("obj", emp);
		view.setViewName("action_page");
		return view;
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/sortedEmployees")
	public List<Employee> getSortedEmployees() {
		return employeeRepository.sortByFirstName();
	}

	@GetMapping("/check")
	public Employee status() {
		String response = "Welcome to JavaInUse" + new Date();
		System.out.println(response);
		Employee employee = new Employee();
		employee.setFirstName("Sapna");
		employee.setLastName("Suthar");
		employee.setEmailId("sapna@gmail.com");
		employee.setDepartment("IT");
		employee.getId();
		// employee.setId(0);
		// employeeRepository.save(employee);
		return employee;
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	//@Valid @RequestBody 
	//@Valid @RequestBody 
	
	@PostMapping("/employees")
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
