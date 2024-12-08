package com.example.crud_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud_demo.dao.EmployeeDAO;
import com.example.crud_demo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO theEmployeeDAO;
	
	
	
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		super();
		this.theEmployeeDAO = theEmployeeDAO;
	}



	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return theEmployeeDAO.findAll();
	}



	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return theEmployeeDAO.findById(id);
	}



	@Override
	@Transactional
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return theEmployeeDAO.save(employee);
	}



	@Override
	@Transactional
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		return theEmployeeDAO.deleteById(id);
	}

}
