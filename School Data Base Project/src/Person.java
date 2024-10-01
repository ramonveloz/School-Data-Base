import java.util.*;
public class Person implements Comparable{

	private String name;
	private int birthYear;
	
	public Person() {
		this.name = "";
		this.birthYear = 0;
	}
	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public void setName(String name) {
		this.name = name;
}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
}
	public int getBirthYear() {
		return birthYear;
}

	public String getName() {
		return name;
}
	public boolean equals(Object o) {
		if (o == null)   
			return false;  
		if (o == this)  
			return true;
		Person p = (Person) o;
		
		if(getName().equals(p.getName())) {
			if(getBirthYear() == p.getBirthYear()) {
				return true;
			}
		}
		return false;
	}
	public String toString() {
		String f = String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
		return f;
	}
	@Override
	public int compareTo(Object o) {
		Person p = (Person) o;
		if(getBirthYear() == p.getBirthYear()) {
			return 0;
		}
		else if(getBirthYear() >= p.getBirthYear()) {
			return 1;
		}
		else {
		return -1;
		}
	}
	
	
}
