package ll.employee.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import ll.employee.pojo.Employee;



public class LoginInterceptor extends MethodFilterInterceptor{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//����������
	public void init() {
		
	}
	
	//����������
	public void destroy(){
		
	}
	
	//����д���������߼�
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		String methodNameString=invocation.getProxy().getMethod();
		
		//������صķ���
		Method currentMethod=invocation.getAction().getClass().getMethod(methodNameString);
		
		
		//��õ�ǰsession�Ŀͻ���Ϣ
		Employee employee= (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
		
		
		
		//��������������ע��
		if (currentMethod.isAnnotationPresent(Authority.class)) {
			
			System.out.println("��������������");
			
			if (employee==null) {
				
				System.out.println("����������������ʾδ��¼");
				
				return Action.LOGIN;
			}else{
				
				System.out.println("������������,�Ѿ���¼������");
				return  invocation.invoke();
			}	
			
		}
		else{
			
			System.out.println("������������,������δʹ��ע��");
			return invocation.invoke();
		}
	}


}
