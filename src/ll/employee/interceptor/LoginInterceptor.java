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

	//创建拦截器
	public void init() {
		
	}
	
	//销毁拦截器
	public void destroy(){
		
	}
	
	//这里写拦截器的逻辑
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		String methodNameString=invocation.getProxy().getMethod();
		
		//获得拦截的方法
		Method currentMethod=invocation.getAction().getClass().getMethod(methodNameString);
		
		
		//获得当前session的客户信息
		Employee employee= (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
		
		
		
		//如果方法上添加了注解
		if (currentMethod.isAnnotationPresent(Authority.class)) {
			
			System.out.println("拦截器起作用了");
			
			if (employee==null) {
				
				System.out.println("进入了拦截器，显示未登录");
				
				return Action.LOGIN;
			}else{
				
				System.out.println("进入了拦截器,已经登录，放行");
				return  invocation.invoke();
			}	
			
		}
		else{
			
			System.out.println("进入了拦截器,方法上未使用注解");
			return invocation.invoke();
		}
	}


}
