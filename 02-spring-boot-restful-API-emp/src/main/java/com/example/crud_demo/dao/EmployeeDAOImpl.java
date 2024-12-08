package com.example.crud_demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crud_demo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	
	//Define EntityManager
	private EntityManager entityManager;
	
	//Set constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		
		Employee thEmployee = entityManager.merge(employee);
		return thEmployee;
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		
		Employee employee = entityManager.find(Employee.class, id);
		
		entityManager.remove(employee);
		
		return "Employee deleted with ID: "+id;
		
	}

	

	

}
