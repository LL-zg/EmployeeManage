 package ll.employee.action;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ll.employee.interceptor.Authority;
import ll.employee.pojo.Department;
import ll.employee.pojo.Employee;
import ll.employee.pojo.Salary;
import ll.employee.service.DepartmentService;
import ll.employee.service.EmployeeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
@ParentPackage("myPackage")
@Controller(value="employeeAction")
@Scope(value="prototype")


public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */	
	
    private File file;
	
	private String fileFileName;
	
	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
//ִ��
	@Override
	public Employee getModel() {
		return employee;
	}
	
	private Employee employee=new Employee();

	public Employee getEmployee() {
		return employee;
	}
	//����һ��List���ϣ�����get���������ڽ�list���Ϸŵ�ֵջ�У���ǰ��Ϊʲô����ͨ��<s:property value="list[index]"/>����ȡ������Ķ���
	private List<Employee> employeeList=new ArrayList<Employee>();


	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	private String result;
	
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}
	
	
	private int page=1;
	private int limit=8;
	
	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}
 
	
//	@Autowired�Զ�ע��
//@Resource(name="  ")��������ע��
//	private EmployeeDAO employeeDao;
//ʹ��ע��ע�벻��Ҫset����
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	//ע�벿�ŵ�DepartmentService�����ڲ������еĲ���
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	
	@Action(value="loginUser", results={@Result(name="login",type="json",params={"root","result"}),@Result(name="loginError",location="/login.jsp")})
	public String loginUser() throws UnsupportedEncodingException{
		
		
		int isFind =employeeService.login(employee);
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("msg", isFind);
		map.put("username",employee.getUsername());
		
/*		resultMap.put("msg", isFind);
		resultMap.put("username",employee.getUsername());*/
		

		JSONObject json=JSONObject.fromObject(map);
		result=json.toString();
		if(isFind==0){
			Employee employeeIs=employeeService.readEmployee(employee);
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("employee",employeeIs);
			return "login";
		}
		else {
			 
			return "loginError";
			
		}
			
		
	}
	

		@Action(value="judgeEmployee",results={@Result(name="success",type="json",params={"root","result"})})
		public String judgeEmployee() throws UnsupportedEncodingException{
			int flag=employeeService.judge(employee);
			
			
//			int flag=0;//�û���������			

			result=(String.valueOf(flag));
			return "success";
		}
		
		
		@Action(value="adminLoginUser",results={@Result(name="adminLoginSucc",type="json",params={"root","result"})})
		public String adminLoginUser() throws UnsupportedEncodingException{
			
			int state=employeeService.adminLogin(employee);
			
			
			if(state==0){
				System.out.println(employee.getUsername());
				HttpSession session=ServletActionContext.getRequest().getSession();
				session.setAttribute("Employee",employee);
			}
			
			Map<String,Object> map=new HashMap<String, Object>();
			
			map.put("msg", state);
			JSONObject json=JSONObject.fromObject(map);
			result =json.toString();
		
			return "adminLoginSucc";
			
		}
		
		@Action(value="registerUser",results={@Result(name="registerSucc", type="json",params={"root","result"})})
		public String registerUser(){
			
			employeeService.register(employee);

						
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("success",true);
			JSONObject json=JSONObject.fromObject(map);
			result =json.toString();
			return "registerSucc";
			
		}
		//��ת�����Ա����ҳ��
		@Action(value="toAddPage",results={@Result(name="toadd",location="/admin/addEmployee.jsp")})
		public String toAddPage(){
			List<Department> listDepartment=departmentService.finAll();
			
			//�ŵ�ҳ����������
			ServletActionContext.getRequest().setAttribute("listDepartment", listDepartment);
			return "toadd";
			
		}
		
		@Action(value="addEmployee",results={@Result(name="addEmployee",location="/admin/readAllEmployee.jsp")})
		public String addEmployee(){
			employeeService.save(employee);
			
			return "addEmployee";
			
		}
		
		
		//��ת���Լ��Ĺ��ʵ�ҳ��
		@Action(value="toSalary",results={@Result(name="toadd",location="/salaryTip.jsp")})
		public String toSalary(){

			HttpSession session=ServletActionContext.getRequest().getSession();
			Employee emp = (Employee) session.getAttribute("employee");
			ServletActionContext.getRequest().setAttribute("salary", emp.getSalary());
			
			return "toadd";
					
				}
		
		@Action(value="readAllEmployee",results={@Result(name="readAllEmployee", type="json",params={"root","result"})})
		public String readAllEmployee() throws Exception{
						
			
			employeeList=employeeService.readAllBypage(employee,page,limit);
			
			int total =employeeService.getAllToalRecord();
			
			System.out.println(page);
			
			System.out.println(limit);
			
			
			Map<String,Object> map =new HashMap<String, Object>();
			map.put("msg","");
			map.put("code", 0);		
			map.put("count",total);	
/*			JSONArray array=JSONArray.fromObject(employeeList);*/
			map.put("data",employeeList);
			
			//�����ѭ��
			JsonConfig jsonConfig=new  JsonConfig();
			jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
				
				@Override
				public boolean apply(Object arg0, String name, Object arg2) {
					// ����Ҫ���˵��ֶΣ�Ҳ����ʵ�����е����������ж�
					if (name.equals("salary")||name.equals("department")) {
						return true;
						
					}
					return false;
				}
			});

			JSONObject json=JSONObject.fromObject(map,jsonConfig);
			result=json.toString();
			
			//��ȡֵջ����������
/*			ActionContext.getContext().getValueStack().set("json",JSONObject.fromObject(map));*/

			
/*			request.setAttribute("total",total);
			request.setAttribute("employeeList",employeeList);
			request.setAttribute("curPage", page);*/
			return "readAllEmployee";
		}
		
		@Action(value="deleteEmployee",results={@Result(name="success",type="json",params={"root","result"})})
		public String deleteEmployee() throws ServerException,IOException{
			System.out.println(employee.getId());
			boolean success=employeeService.deleteEmployee(employee);
			Map<String,Object> map=new HashMap<String, Object>();
			
			map.put("success", success);
			
			JSONObject json=JSONObject.fromObject(map);
			result=json.toString();
			return SUCCESS;
			
		}
		
		@Authority("")
		@Action(value="modifyEmployee",results={@Result(name="success",location="/index.jsp")})
		
		public String modifyEmployee() throws IOException{
			
			employeeService.update(employee);
				
			return SUCCESS;
			
		}
		
		
		@Action(value="findOneEmployee",results={@Result(name="success",location="/index.jsp")})
		public String findOneEmployee() throws IOException{
			
			Employee oneEmployee= employeeService.findOne(employee);
			ServletActionContext.getRequest().getSession().setAttribute("employee",oneEmployee);
			return SUCCESS;
			
		}
		
		
		
		
		@Action(value="uploadImage",results={@Result(name="uploadSuccess",location="/index.jsp")})
		public String uploadImage()throws IOException{
			
		
			String path=ServletActionContext.getServletContext().getRealPath("upload");
			System.out.println(path);
			
			String saveFileName = path+ "\\"+ fileFileName;
			System.out.println(saveFileName);
			
			File destFile = new File(saveFileName);
			
			FileUtils.copyFile(file, destFile);
			
			System.out.println("Action��id��"+employee.getId());
			Employee e1 = employeeService.findOne(employee);
			Employee e2=null;
			
			if(employee!=null){
				e1.setImgUrl("upload\\"+ fileFileName);
				employeeService.update(e1);
				
				e2=employeeService.findOne(employee);
				System.out.println(e2.getUsername());
				
			}
			ServletActionContext.getRequest().getSession().setAttribute("employee",e1);
			
			return "uploadSuccess";
			
		}


		


}
