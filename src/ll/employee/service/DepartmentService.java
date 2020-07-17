package ll.employee.service;

import java.util.List;

import ll.employee.pojo.Department;

public interface DepartmentService {

	void save(Department department);

	Department fingById(Department department);

	void update(Department department);

	void delete(Department department);

	List<Department> findByPage(Department department, int page, int limit);

	int getAllToalRecord();

	List<Department> finAll();

}
