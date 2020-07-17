package ll.employee.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import ll.employee.pojo.Employee;

public interface EmployeeService {

	int login(Employee employee) throws UnsupportedEncodingException;
	   
	   
	int judge(Employee employee) throws UnsupportedEncodingException;
	
	
	int adminLogin(Employee employee) throws UnsupportedEncodingException;


   	void register(Employee employee);
	
	
	int getAllToalRecord();
	

	void update(Employee e1);
	void save(Employee employee);


	Employee readEmployee(Employee employee);


	boolean deleteEmployee(Employee employee);
	


	List<Employee> readAllBypage(Employee employee, int page, int limit);


	Employee findOne(Employee employee);


	List<Employee> findAll();


	



	

}
