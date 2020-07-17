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

	
	//��ȡSessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//��ȡSession
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}
	
	//�����ṩ�����ڱ����̰߳󶨵�session�ķ���
	public static  Session getSessionObject() {
		return sessionFactory.getCurrentSession();
		
	}
	
	//�ر�Session
	public static void closeSession(Session session) {
		if(session != null) {
			session.close();
		}
	}
}
