package ll.employee.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ll.employee.dao.EmployeeDAO;
import ll.employee.pojo.Employee;
import ll.employee.util.HibernateUtil;



@Component(value="employeeDao")
public class EmployeeDaoImpl implements EmployeeDAO{
	
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeDAO.class);
	
	//设置property constants
	
	public static final String USERNAME="username";
	public static final String PASSWORD="password";
	
	private Session session;
	
	@Resource(name="hibernateUtil")
	private HibernateUtil hibernateUtil;	
	
	
	
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		try {
			session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();				
			session.save(employee);
			transaction.commit();
			
		} catch (RuntimeException re) {
			log.error("save failed",re);
			throw re;
			
		}finally {
			HibernateUtil.closeSession(session);
		}
		
		
	}



	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		
		try {
			session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			session.delete(employee);
			transaction.commit();
			
		} catch (RuntimeException re) {
			log.error("delete failed",re);
			throw re;
		}finally {
			HibernateUtil.closeSession(session);
		}
		
		
		
	}



	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
		try {
			session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			session.update(employee);
			transaction.commit();
			
		} catch (RuntimeException re) {
			log.error("update failed",re);
			throw re;
		}
		finally {
			HibernateUtil.closeSession(session);
		}
		
		
	}



	@Override
	public Employee findById(Integer id) {
		
		try {
			session=HibernateUtil.getSession();
			Employee employee=session.get(Employee.class, id);					
			return employee;
			
		} catch (RuntimeException re) {
			log.error("get failed",re);
			throw re;
		}finally {
			HibernateUtil.closeSession(session);
		}

	}
	
	
	public List<Employee> findByProperty(String propertyName, Object value) {
		log.debug("finding Employee instance with property: " + propertyName + ", value: " + value);
		try {
			String hql = "from Employee as model where model." + propertyName + "= ?";
			session=HibernateUtil.getSession();
			Query queryObject = session.createQuery(hql);
			queryObject.setParameter(0, value);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
			
		}finally {
			HibernateUtil.closeSession(session);
		}
		
	}


	@Override
	public List<Employee> findByUsername(Object username) {
		// TODO Auto-generated method stub
		System.out.println("来到了这里:findbyUserName");
		return findByProperty(USERNAME,username);
	}
	
	@Override
	public List<Employee> findByPasword(Object password){
		return findByProperty(USERNAME,password);
		
	}



	@Override
	public List<Employee> findByPage(String username, int page, int limit) {
		// TODO Auto-generated method stub
		
		try {
			
			session=HibernateUtil.getSession();
			
			String queryString="from Employee";
			
			if (username!=null&&!username.equals("")) {
				queryString+=" where username like '%"+username+"%'";				
			}
			
			Query query=session.createQuery(queryString);			
			query.setFirstResult((page-1)*limit);
			query.setMaxResults(limit);
			
			return query.list();		
			
		} catch (RuntimeException re) {
			// TODO: handle exception
			throw re;
		}finally {
			HibernateUtil.closeSession(session);
		}
	}




	@Override
	public Integer getAllToalRecord() {
		// TODO Auto-generated method stub
		try{
			String hql="select count(*)from Employee where isAdmin=0";
			session=HibernateUtil.getSession();
			Query query=session.createQuery(hql);
			
			Object object=query.uniqueResult();
			
			Long lobj=(Long)object;
			System.out.println(lobj);
			int count=lobj.intValue();
			return  count;
			
			
		}catch (RuntimeException re) {
			// TODO: handle exception
			throw re;
		}finally {
			HibernateUtil.closeSession(session);
		}
		
	}



	@Override
	public List<Employee> findAll() {
		try {
			session=HibernateUtil.getSession();
			Query query=session.createQuery("from Employee");
			
			return query.list();
			
		} catch (RuntimeException re) {
			// TODO: handle exception
			throw re;
			
		}finally {
			HibernateUtil.closeSession(session);	
		}
		
	}

	
}
