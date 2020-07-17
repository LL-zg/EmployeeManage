package ll.employee.pojo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Component(value="department")
public class Department implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	/**
	 * 
	 */
	
	
	private Integer idd;
	private String dname;
	private String dmanager;
	private Integer dnumber;
	private String ddesc;
	
	private Set<Employee> setEmployee= new HashSet<Employee>();

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** full constructor */
	public Department(String dname, String ddesc) {
		this.dname = dname;
		this.ddesc = ddesc;
	}

	// Property accessors

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDdesc() {
		return this.ddesc;
	}

	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	//生成员工的set,get
	public Set<Employee> getSetEmployee() {
		return setEmployee;
	}

	public void setSetEmployee(Set<Employee> setEmployee) {
		this.setEmployee = setEmployee;
	}

	public Integer getIdd() {
		return idd;
	}

	public void setIdd(Integer idd) {
		this.idd = idd;
	}

	public String getDmanager() {
		return dmanager;
	}

	public void setDmanager(String dmanager) {
		this.dmanager = dmanager;
	}

	public Integer getDnumber() {
		return dnumber;
	}

	public void setDnumber(Integer dnumber) {
		this.dnumber = dnumber;
	}


}