package com.employeesysytem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeesysytem.model.Employee;
import com.employeesysytem.servie.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
  @Autowired	
  private EmployeeService employeeService;
  
  @PostMapping("/employee")
  public Employee createdEmployee(@RequestBody Employee employee) {
	  System.out.println(employee);
	  //return null;
	  return employeeService.createEmployee(employee);
  }
  
  @GetMapping("/employee")
  public List<Employee> getAllemployee(){
	  return employeeService.getAllEmployee();
  }
  
  @DeleteMapping("/employee/{id}")
  public ResponseEntity<Map<String,Boolean>> deleteEmploye(@PathVariable Long id){
	  boolean deleted = false;
	  deleted = employeeService.deletEmployee(id);
	  Map<String,Boolean> response= new HashMap<>(); 
	  response.put("deleted", deleted);
	  return ResponseEntity.ok(response);
  }
  
  @GetMapping("/employee/{id}")
  public ResponseEntity<Employee> getEmploye(@PathVariable Long id){
	  
	  Employee employee = employeeService.getEmployee(id);
	  return ResponseEntity.ok(employee);
  }
  
  @PutMapping("/employee/{id}")
  public ResponseEntity<Employee> updateEmploye(@PathVariable Long id,
		  @RequestBody Employee employee){
	  
	  Employee employee1 = employeeService.updateEmployee(id,employee);
	  return ResponseEntity.ok(employee1);
  }
  
}
