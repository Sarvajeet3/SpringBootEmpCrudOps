package com.example.crud_demo.service;

import java.util.List;

import com.example.crud_demo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee employee);
	
	String deleteById(int id);
	
}
