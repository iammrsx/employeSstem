package com.employeesysytem.servie;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeesysytem.entity.EmployeeEntity;
import com.employeesysytem.model.Employee;
import com.employeesysytem.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepository.save(employeeEntity);
		return employee;
	}
	
	@Override
	public List<Employee> getAllEmployee(){
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
		List<Employee> employes = employeeEntities
				.stream()
				.map(emp -> new Employee(
					emp.getId(),
					emp.getFirstName(),
					emp.getLastName(),
					emp.getEmailId()
						)).collect(Collectors.toList());
		return employes;
		
	}

	@Override
	public Boolean deletEmployee(Long id) {
		EmployeeEntity employee = employeeRepository.findById(id).get();
		employeeRepository.delete(employee);
		return true;
	}

	@Override
	public Employee getEmployee(Long id) {
		EmployeeEntity employeEntity = employeeRepository.findById(id).get();
		Employee employe = new Employee();
		BeanUtils.copyProperties(employeEntity, employe);
		return employe;
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		
		EmployeeEntity employee1 = employeeRepository.findById(id).get();
		employee1.setFirstName(employee.getFirstName());
		employee1.setLastName(employee.getLastName());
		employee1.setEmailId(employee.getEmailId());
		employeeRepository.save(employee1);		
		return employee;
	}
}
