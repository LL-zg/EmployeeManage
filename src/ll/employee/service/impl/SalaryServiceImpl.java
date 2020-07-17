package ll.employee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ll.employee.dao.DepartmentDao;
import ll.employee.dao.SalaryDao;
import ll.employee.pojo.Department;
import ll.employee.pojo.Salary;
import ll.employee.service.DepartmentService;
import ll.employee.service.SalaryService;

@Component(value="salaryService")
public class SalaryServiceImpl implements SalaryService{

	//注入部门管理的Dao
	@Resource(name="salaryDao")
	private SalaryDao salaryDao;

	@Override
	public void save(Salary salary) {
		salaryDao.save(salary);
		
	}

	@Override
	public Salary fingById(Salary salary) {
		// TODO Auto-generated method stub
		
		return salaryDao.findById(salary.getSid());
	}

	@Override
	public void update(Salary salary) {
		// TODO Auto-generated method stub
		salaryDao.update(salary);
		
	}

	@Override
	public void delete(Salary salary) {
		// TODO Auto-generated method stub
		salaryDao.delete(salary);
		
	}

	@Override
	public List<Salary> findByPage(Salary salary, int page, int limit) {
		// TODO Auto-generated method stub
		
		return salaryDao.findByPage(salary,page,limit);
	}

	@Override
	public int getAllToalRecord() {
		// TODO Auto-generated method stub
		return salaryDao.getAllToalRecord();
	}
	
	
	
	
	
	
	
}
