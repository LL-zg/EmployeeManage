package ll.employee.util;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


@Component(value="hibernateUtil")
public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private static Session session;
	
	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}

	
	//获取SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//获取Session
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}
	
	//用于提供返回于本地线程绑定的session的方法
	public static  Session getSessionObject() {
		return sessionFactory.getCurrentSession();
		
	}
	
	//关闭Session
	public static void closeSession(Session session) {
		if(session != null) {
			session.close();
		}
	}
}
