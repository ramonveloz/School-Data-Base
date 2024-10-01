import java.util.*;

public class Employee extends Person implements Comparable{
	
	private String deptName;
	private static int numEmployees = 0;
	private int employeeID;
	
	public Employee() {
		this.deptName = "";
		this.employeeID = numEmployees +1;
		numEmployees++;
	}
	public Employee(String deptName) {
		this.deptName = deptName;
		this.employeeID = numEmployees +1;
		numEmployees++;
	}
	
	public Employee(String name, int birthYear, String deptName) {
		super(name, birthYear);
		this.deptName = deptName;
		this.employeeID = numEmployees +1;
		numEmployees++;
	}
	public String getDeptName() {
		return deptName;
	}
	
	public static int getNumEmployees() {
		return numEmployees;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if(o==null) {
			return false;
		}
		
		Employee e = (Employee) o;
		
		if(super.equals(e)) {
			if(getDeptName().equals(e.getDeptName())) {
				if(getEmployeeID() == e.getEmployeeID()) {
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public String toString() {
		String s = String.format(" Employee: Department: %20s | Employee Number: %3d", deptName, employeeID);
		return super.toString() + s;
	}
	
	@Override
	public int compareTo(Object o) {
		Employee p = (Employee) o;
		
		if (getEmployeeID() == p.getEmployeeID()) {
	            return 0;
	       } 
		else if (getEmployeeID() >= p.getEmployeeID()) {
	            return 1;
	    } else {
	            return -1;
	        }
	}
	
}
