package ll.employee.pojo;

import org.springframework.stereotype.Component;

@Component(value="salary")
public class Salary implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer sid;//工资单id
	
	private Long basePay;//基本工资
	
	private Long subsidy;//津贴
	
	private Long acFuncd;//公积金
	
	private Long socialSec;//保险费
	
	private Long misc;//水电杂费
	
	//一对一的关系表示表属于某个员工,同时要生成get，set方法
	private Employee employee;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Long getBasePay() {
		return basePay;
	}

	public void setBasePay(Long basePay) {
		this.basePay = basePay;
	}

	public Long getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(Long subsidy) {
		this.subsidy = subsidy;
	}

	public Long getAcFuncd() {
		return acFuncd;
	}

	public void setAcFuncd(Long acFuncd) {
		this.acFuncd = acFuncd;
	}

	public Long getSocialSec() {
		return socialSec;
	}

	public void setSocialSec(Long socialSec) {
		this.socialSec = socialSec;
	}

	public Long getMisc() {
		return misc;
	}

	public void setMisc(Long misc) {
		this.misc = misc;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
