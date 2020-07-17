package ll.employee.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("json-default")//�������̳�json-default��
@Result(type="json")//�൱��struts.xml������action�ڵ��·���json����
public abstract class JsonAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//���ڷ�װ���صĽ����struts2���Զ���תΪJSON���ͷ���
	protected Map<Object,Object> resultMap;
	
	//��̬ģ��
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
