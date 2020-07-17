package ll.employee.dao;

import java.util.List;

import ll.employee.pojo.Salary;

public interface SalaryDao {

	void save(Salary salary);

	void update(Salary salary);

	Salary findById(Integer sid);

	void delete(Salary salary);

	List<Salary> findByPage(Salary salary, int page, int limit);

	Integer getAllToalRecord();
	
	

}
