import java.util.*;

public class Faculty extends Employee implements Comparable {

	private Course[] coursesTaught;
	private int numCoursesTaught;
	private boolean isTenured;
	
	public Faculty() {
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = false;
		
	}
	
	public Faculty(boolean isTenured) {
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
		
	}
	
	public Faculty(String deptName, boolean isTenured) {
		super(deptName);
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
		
	}
	public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
		super(name, birthYear, deptName);
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
		
	}
	
	public boolean isTenured() {
		return isTenured;
	}
	
	public int getNumCoursesTaught() {
		return numCoursesTaught;
	}
	
	public void setIsTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}
	
	public void addCourseTaught(Course course) {
		if(numCoursesTaught < coursesTaught.length) {
			this.coursesTaught[numCoursesTaught] = course;
			this.numCoursesTaught++;
		}
		
	}
	
	public void addCoursesTaught(Course[] course) {
		coursesTaught = course;
		numCoursesTaught = course.length;
		
	}
	
	public Course getCourseTaught(int index) {
		if(index >= 0 && index < coursesTaught.length) {
			return coursesTaught[index];
		}
		return null;
	}
	
	public String getCourseTaughtAsString(int index) {
		if(index >= 0 && index < numCoursesTaught) {
			return coursesTaught[index].toString();
		}
		return null;
	}
	
	public String getAllCoursesTaughtAsString() {
		String c = "";
		if(numCoursesTaught == 0) {
			return null;
		}
		for(int i = 0; i < numCoursesTaught; i++ ) {
			c += getCourseTaughtAsString(i);
		}
		return c;
	}
	@Override
	public boolean equals(Object o) {
		if (o == null)   
			return false;  
		if (o == this)  
			return true;
		Faculty f = (Faculty) o;
		
		if(super.equals(f)) {
			if(isTenured()== f.isTenured()) {
				if(getNumCoursesTaught() == f.getNumCoursesTaught()) {
					for(int i = 0; i < numCoursesTaught; i++) {
						if(!coursesTaught[i].equals(f.coursesTaught[i])) {
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public String toString() {
		String f = "Not Tenured";
		if(isTenured()) {
			f = "Is Tenured";
		}
		String w = getAllCoursesTaughtAsString();
		
		String s = String.format(" Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s", f , numCoursesTaught, w);
	return super.toString() + s;
	}
	@Override
	public int compareTo(Object o) {
		Faculty p = (Faculty) o;

		if (getNumCoursesTaught() == p.getNumCoursesTaught()) {
	            return 0;
	       } 
		else if (getNumCoursesTaught() >= p.getNumCoursesTaught()) {
	            return 1;
	    } else {
	            return -1;
	        }
	}
}
