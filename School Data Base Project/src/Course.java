import java.util.*;

public class Course implements Comparable{
	
	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept;
	private int numCredits;

	
	public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits ) {
	
		this.isGraduateCourse = isGraduateCourse;
		this.courseNum = courseNum;
		this.courseDept = courseDept;
		this.numCredits = numCredits;
		
	}
	
	public boolean isGraduateCourse() {
		return isGraduateCourse;
	}
	
	public int getCourseNum() {
		return courseNum;
	}
	
	public String getCourseDept() {
		return courseDept;
	}
	
	public int getNumCredits() {
		return numCredits;
	}
	
	public String getCourseName() {
		if(isGraduateCourse) {
			return "G" + courseDept + courseNum;
		}
		else {
			return "U" + courseDept + courseNum;
		}
	}
	
	public boolean equals(Object o) {
		if (o == null)   
			return false;  
		if (o == this)  
			return true;
		Course c = (Course) o;
		
		if(isGraduateCourse() == c.isGraduateCourse) {
			if(getCourseNum() == c.getCourseNum()) {
				if(getCourseDept().equals(c.getCourseDept())) {
					if(getNumCredits() == c.getNumCredits()) {
						if(getCourseName().equals(c.getCourseName())) {
							return true;
						}
					}
				}
			}
		}
		return false;
		
	}
	
	public String toString() {
		String l = "Undergraduate";
		if(isGraduateCourse()) {
			l = "Graduate";
		}
		String f = String.format("Course: %3s-%3d | Number of Credits: %02d | %s", courseDept, courseNum, numCredits, l);
	return f;
	}
	
	@Override
	public int compareTo(Object o) {
		Course c = (Course) o;
		if (this.numCredits == c.numCredits) {
            return 0;
        } 
		else if (this.numCredits >= c.numCredits) {
            return 1;
        } else {
            return -1;
        }
	}
	
}
