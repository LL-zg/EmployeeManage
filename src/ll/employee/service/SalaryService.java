package ll.employee.service;

import java.util.List;

import ll.employee.pojo.Salary;

public interface SalaryService {

	void save(Salary salary);

	Salary fingById(Salary salary);

	void update(Salary salary);

	void delete(Salary salary);

	List<Salary> findByPage(Salary salary, int page, int limit);

	int getAllToalRecord();

}
