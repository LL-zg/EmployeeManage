package ll.employee.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import ll.employee.dao.SalaryDao;
import ll.employee.pojo.Salary;
import ll.employee.util.HibernateUtil;

@Component(value="salaryDao")
public class SalaryDaoImpl implements SalaryDao{

	//注入工具类对象
	@Resource(name="hibernateUtil")
	private HibernateUtil hibernateUtil;
	
	
	private Session session;
	
	@Override
	public void save(Salary salary) {
		// TODO Auto-generated method stub
		try {
			session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			session.save(salary);
			transaction.commit();
			
		} catch (RuntimeException re) {
			throw re;
		}finally {
			HibernateUtil.closeSession(session);		
		}
		
	}

	@Override
	public void update(Salary salary ) {
		// TODO Auto-generated method stub
		try {
			session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			session.update(salary);
			transaction.commit();
			
		} catch (RuntimeException re) {
			throw re;
		}finally {
			HibernateUtil.closeSession(session);		
		}
		
	}


	@Override
	public void delete(Salary salary ) {
		// TODO Auto-generated method stub
		try {
			session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			session.delete(salary);
			transaction.commit();
			
		} catch (RuntimeException re) {
			throw re;
		}finally {
			HibernateUtil.closeSession(session);		
		}
	}

	@Override
	public Salary findById(Integer sid) {
		// TODO Auto-generated method stub
		try {
			session=HibernateUtil.getSession();
			Salary salary=session.get(Salary.class,sid);
			return salary;
			
		} catch (RuntimeException re) {
			throw re;
		}finally {
			HibernateUtil.closeSession(session);		
		}
		
	}
	
	@Override
	public List<Salary> findByPage(Salary salary, int page, int limit) {
		// TODO Auto-generated method stub
		
		try {
			session=HibernateUtil.getSession();
			Query query=session.createQuery("from Salary");
			
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
			String hql="select count(*)from Salary";
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

	
	
	
}
