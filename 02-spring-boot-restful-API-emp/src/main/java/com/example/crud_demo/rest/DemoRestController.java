package com.example.crud_demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_demo.entity.Employee;
import com.example.crud_demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class DemoRestController {
	
	private EmployeeService theEmployeeService;

	@Autowired
	public DemoRestController(EmployeeService theEmployeeService) {
		this.theEmployeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployee(){
		return theEmployeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		return theEmployeeService.findById(employeeId);
	}
	
	@PostMapping("/employees")
	public Employee setEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		return theEmployeeService.save(theEmployee);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		return theEmployeeService.save(theEmployee);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){
		return theEmployeeService.deleteById(employeeId);
	}
}
