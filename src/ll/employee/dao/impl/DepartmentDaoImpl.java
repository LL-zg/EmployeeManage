package ll.employee.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import ll.employee.dao.DepartmentDao;
import ll.employee.pojo.Department;
import ll.employee.util.HibernateUtil;

@Component(value="departmentDao")
public class DepartmentDaoImpl implements DepartmentDao{

	//注入工具类对象
	@Resource(name="hibernateUtil")
	private HibernateUtil hibernateUtil;
	
	
	private Session session;
	
	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		try {
			session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			session.save(department);
			transaction.commit();
			
			
		} catch (RuntimeException re) {
			throw re;
			
		}finally {
			HibernateUtil.closeSession(session);		
		}
		
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		try {
			session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			session.update(department);
			transaction.commit();
			
			
		} catch (RuntimeException re) {
			throw re;
		}finally {
			HibernateUtil.closeSession(session);		
		}
		
	}


	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		try {
			session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			session.get(Department.class,department.getIdd());
			session.delete(session.get(Department.class,department.getIdd()));
			transaction.commit();
			
		} catch (RuntimeException re) {
			throw re;
		}finally {
			HibernateUtil.closeSession(session);		
		}
	}

	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		try {
			session=HibernateUtil.getSession();
			Department department=session.get(Department.class,did);
			return department;
			
		} catch (RuntimeException re) {
			throw re;
		}finally {
			HibernateUtil.closeSession(session);		
		}
		
	}
	
	@Override
	public List<Department> findByPage(Department department, int page, int limit) {
		// TODO Auto-generated method stub
		
		try {
			session=HibernateUtil.getSession();
			Query query=session.createQuery("from Department");
			
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
			String hql="select count(*)from Department";
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
	public List<Department> findAll() {
		try {
			session=HibernateUtil.getSession();
			Query query=session.createQuery("from Department");

			return query.list();
			
		} catch (RuntimeException re) {
			// TODO: handle exception
			throw re;
		}finally {
			HibernateUtil.closeSession(session);		
		}
	}

	
	
	
}
