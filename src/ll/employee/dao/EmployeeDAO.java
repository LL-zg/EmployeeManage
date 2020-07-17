package ll.employee.dao;

import java.util.List;

import ll.employee.pojo.Employee;

public interface EmployeeDAO {


	List<Employee> findByUsername(Object username);
	List<Employee> findByPasword(Object password);

	void save(Employee employee);

	void delete(Employee employee);

	void update(Employee employee);

	Employee findById(Integer id);


	List<Employee> findByPage(String username, int page, int limit);

	Integer getAllToalRecord();
	
	List<Employee> findAll();

	


	

}
