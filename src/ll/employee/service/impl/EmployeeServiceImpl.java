package ll.employee.service.impl;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ll.employee.dao.EmployeeDAO;
import ll.employee.pojo.Employee;
import ll.employee.service.EmployeeService;

@Service(value="employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Resource(name="employeeDao")
	private EmployeeDAO employeeDao;	
	


	@Override
	public int login(Employee employee) throws UnsupportedEncodingException {
		List<Employee> employeeList = employeeDao.findByUsername(employee.getUsername());
		if (employeeList.size()>0) {
			Employee employee1=employeeList.get(0);
			if(employee1.getPassword().equals(employee.getPassword())){
				employee.setImgUrl(employee1.getImgUrl());
				return 0;
				
			}
			return 2;
		}
		return 1;
	}


	@Override
	public int judge(Employee employee) throws UnsupportedEncodingException {
		String myUserName=URLDecoder.decode(employee.getUsername(),"utf-8");
		List<Employee> employeeList=employeeDao.findByUsername(myUserName);
		if (employeeList.size()>0) {
			return 2;
		}
		
		return 0;
		
	}


	@Override
	public int adminLogin(Employee employee) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		String myUserName=URLDecoder.decode(employee.getUsername(),"utf-8");
		String username=myUserName;
		String password=employee.getPassword();
		
		List<Employee> employeelist=employeeDao.findByUsername(employee.getUsername());
		
		int state=1;
		if(employeelist.size()>0){
			Employee employee1=employeelist.get(0);
			if (employee1.getPassword().equals(password)&&employee1.getIsAdmin()) {
				state=0;
				
			}else{
				state=2;
			}
		}
		return state;
		
	}


	@Override
	public void register(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
		

	}
	
	
	
	@Override
	public Employee readEmployee(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> employeeList=employeeDao.findByUsername(employee.getUsername());

		return employeeList.get(0);
	}
	


	@Override
	public List<Employee> readAllBypage(Employee employee, int page, int limit) {
		// TODO Auto-generated method stub
		List<Employee> employeeList=employeeDao.findByPage(employee.getUsername(),page,limit);
		return employeeList;
		
		
	}
	
	@Override
	public int getAllToalRecord() {
		// TODO Auto-generated method stub
		
		int total=employeeDao.getAllToalRecord();
		return total;
	}


	@Override
	public void update(Employee e1) {
		employeeDao.update(e1);
		
	}
	
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
	}


	@Override
	public boolean deleteEmployee(Employee employee) {
		
		
		Employee ep=employeeDao.findById(employee.getId());
		
		if(ep!=null){
			employeeDao.delete(ep);			
			return true;
		}
		else {
			return false;
		}
	}



	@Override
	public Employee findOne(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.findById(employee.getId());
	}


	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}





}
