package ll.employee.dao;

import java.util.List;

import ll.employee.pojo.Department;

public interface DepartmentDao {

	void save(Department department);

	void update(Department department);

	Department findById(Integer did);

	void delete(Department department);

	List<Department> findByPage(Department department, int page, int limit);

	Integer getAllToalRecord();

	List<Department> findAll();
	
	

}
