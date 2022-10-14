package com.employeesysytem.servie;

import java.util.List;

import com.employeesysytem.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployee();

	Boolean deletEmployee(Long id);

	Employee getEmployee(Long id);

	Employee updateEmployee(Long id, Employee employee);

}
