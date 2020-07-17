package ll.employee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ll.employee.dao.DepartmentDao;
import ll.employee.pojo.Department;
import ll.employee.service.DepartmentService;

@Component(value="departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	//注入部门管理的Dao
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;

	@Override
	public void save(Department department) {
		departmentDao.save(department);
		
	}

	@Override
	public Department fingById(Department department) {
		// TODO Auto-generated method stub
		
		return departmentDao.findById(department.getIdd());
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
		
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
		
	}

	@Override
	public List<Department> findByPage(Department department, int page, int limit) {
		// TODO Auto-generated method stub
		
		return departmentDao.findByPage(department,page,limit);
	}

	@Override
	public int getAllToalRecord() {
		// TODO Auto-generated method stub
		return departmentDao.getAllToalRecord();
	}

	@Override
	public List<Department> finAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}
	
	
	
	
	
	
	
}
