package ll.employee.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("json-default")//让这个类继承json-default包
@Result(type="json")//相当于struts.xml中配置action节点下返回json类型
public abstract class JsonAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用于封装返回的结果，struts2会自动后转为JSON类型返回
	protected Map<Object,Object> resultMap;
	
	//静态模块
	{
		resultMap=new HashMap<>();
	}
	
	public Map<Object, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<Object, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	

}
