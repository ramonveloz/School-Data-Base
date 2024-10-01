import java.util.*;


public class GeneralStaff extends Employee {

	private String duty;
	
	public GeneralStaff() {
		this.duty = "";
	}
	
	public GeneralStaff(String duty) {
		this.duty = duty;
	}
	
	public GeneralStaff(String deptName, String duty) {
		super(deptName);
		this.duty = duty;
	}
	
	public GeneralStaff(String name, int birthYear, String deptName, String duty) {
		super(name, birthYear, deptName);
		this.duty = duty;
	}
	
	public String getDuty() {
		return duty;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)   
			return false;  
		if (o == this)  
			return true;
		GeneralStaff f = (GeneralStaff) o;
		if(super.equals(f)) {
			if(getDuty().equals(f.getDuty())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String s = String.format(" GeneralStaff: Duty: %10s", duty);
		return super.toString() + s;
	}
	
}
