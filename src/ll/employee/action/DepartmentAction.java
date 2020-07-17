package ll.employee.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ll.employee.pojo.Department;
import ll.employee.service.DepartmentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

@ParentPackage("myPackage")
@Controller(value="departmentAction")
@Scope(value="prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Department department =new Department();

	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	private List<Department> departmentList=new ArrayList<Department>();
	
	public List<Department> getDepartmentList() {
		return departmentList;
	}


	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
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
		@Action(value="readAllDepartment",results={@Result(name="readSuccess",type="json",params={"root","result"})})
		public String readAllDepartment() throws Exception{
			departmentList=departmentService.findByPage(department, page, limit);
			
			int total=departmentService.getAllToalRecord();
			
			
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("msg","");
			map.put("code", 0);
			map.put("count",total);	
			map.put("data", departmentList);
			
			//解除死循环
			JsonConfig jsonConfig=new  JsonConfig();
			jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
				
				@Override
				public boolean apply(Object arg0, String name, Object arg2) {
					// TODO Auto-generated method stub
					if (name.equals("setEmployee")) {
						return true;
						
					}
					return false;
				}
			});

			
			JSONObject json=JSONObject.fromObject(map,jsonConfig);
			result=json.toString();
			
			
			return "readSuccess";
			
			
		}
		
		//添加部门
		@Action(value="saveDepartment",results={@Result(name="saveSuccess",location="/index.jsp")})
		public String saveDepartment(){
			departmentService.save(department);
			return "saveSuccess";
			
			
		}
		//编辑工资单
		@Action(value="editDepartment",results={@Result(name="editSuccess",type="json",params={"root","result"})})
		public String  editDepartment(){
			department =departmentService.fingById(department);
			return "editSuccess";
			
			
		}
		
		//修改部门执行的方法
		@Action(value="updateDepartment",results={@Result(name="updateSuccess",location="/index.jsp")})
		public String updateDepartment(){
			departmentService.update(department);
			return "updateSuccess";
			
		}
		
		//删除部门的方法
		@Action(value="deleteDepartment",results={@Result(name="deleteSuccess",type="json" ,params={"root","result"})})
		public String deleteDepartment() {
			Department departmentIS=departmentService.fingById(department);
			departmentService.delete(departmentIS);
			return "deleteSuccess";
			
		}


	

}
