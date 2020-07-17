package ll.employee.pojo;


import org.springframework.stereotype.Component;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */

@Component(value="employee")
public class Employee implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String username;
	private String password;
	private String sex;
	private Integer age;
	private String email;
	private String phone;
	private String imgUrl;
	private Boolean isAdmin;
	// Constructors
	//一对多的表示部门,员工所属部门
	private Department department;
	
	//一对一关系表示员工的工资单
	private Salary salary;

	/** default constructor */
	public Employee() {
		
	}

	/** minimal constructor */
	public Employee(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public Employee(Integer id, String sex,String username, String password,Integer age, String email, String phone,
			String imgUrl, Boolean isAdmin) {
		super();
		this.id = id;
		this.sex = sex;
		this.username = username;
		this.password = password;
		this.age=age;
		this.email = email;
		this.phone = phone;
		this.imgUrl = imgUrl;
		this.isAdmin = isAdmin;
	}

	// Property accessors

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	
	

}