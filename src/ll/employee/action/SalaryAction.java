package ll.employee.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ll.employee.pojo.Employee;
import ll.employee.pojo.Salary;
import ll.employee.service.EmployeeService;
import ll.employee.service.SalaryService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

@ParentPackage("myPackage")
@Controller(value="salaryAction")
@Scope(value="prototype")
public class SalaryAction extends ActionSupport implements ModelDriven<Salary>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Salary salary =new Salary();
	

	public Salary getSalary() {
		return salary;
	}


	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	
	


	@Override
	public Salary getModel() {
		// TODO Auto-generated method stub
		return salary;
	}
	
	@Resource(name="salaryService")
	private SalaryService salaryService;
	
	//注入员工的service用于查找所有员工
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	private List<Salary> salaryList=new ArrayList<Salary>();
	
	public List<Salary> getSalaryList() {
		return salaryList;
	}
	
	private String result;
	
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}

	
	
	//创建page.limit变量用于接收前端页面传来的页数和单页最最大数
		private int page;
		private int limit;
		
		
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

		//查询的方法
		@Action(value="readAllSalary",results={@Result(name="readSuccess",type="json",params={"root","result"})})
		public String readAllSalary(){
			salaryList=salaryService.findByPage(salary, page, limit);
			
			int total=salaryService.getAllToalRecord();
			
			
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("msg","");
			map.put("code", 0);
			map.put("count",total);	
			map.put("data", salaryList);
			
			//先过滤掉
			JsonConfig jsonConfig=new  JsonConfig();
			jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
				
				@Override
				public boolean apply(Object arg0, String name, Object arg2) {
					// TODO Auto-generated method stub
					if (name.equals("employee")) {
						return true;
						
					}
					return false;
				}
			});
			
			
			JSONObject json=JSONObject.fromObject(map,jsonConfig);
			result=json.toString();
			
			
			return "readSuccess";
			
			
		}

		//编辑工资单
		@Action(value="editSalary",results={@Result(name="editSuccess",type="json",params={"root","result"})})
		public String  editSalary(){
			salary=salaryService.fingById(salary);
			return "editSuccess";
			
			
		}
		
		//修改部门执行的方法
		@Action(value="updateSalary",results={@Result(name="updateSuccess",location="/index.jsp")})
		public String updateSalary(){
			salaryService.update(salary);
			return "updateSuccess";
			
		}
		
		//删除部门的方法
		@Action(value="deleteSalary",results={@Result(name="deleteSuccess",type="json" ,params={"root","result"})})
		public String deleteSalary() {
			System.out.println("来到了这里");
			System.out.println(salary.getSid());
			Salary salaryIS=salaryService.fingById(salary);
			salaryService.delete(salaryIS);
			return "deleteSuccess";
			
		}
		
		//跳转到添加工资单的页面，并附上员工信息
		
		@Action(value="toAddSalaryPage",results={@Result(name="toadd",location="/admin/addSalary.jsp")})
		public String  toAddSalaryPage(){
			
			List<Employee> listEmployee=employeeService.findAll();
			
			ServletActionContext.getRequest().setAttribute("listEmployee", listEmployee);
			
			return "toadd";
			
		}
		
		//添加工资单
		@Action(value="addSalary",results={@Result(name="addSalary",location="/admin/readAllSalary.jsp")})
		public String addSalary(){
			
			salaryService.save(salary);
			return "addSalary";
			
		}
		


	

}
