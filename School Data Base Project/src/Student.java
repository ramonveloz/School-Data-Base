import java.util.*;

public class Student extends Person implements Comparable {

	private static int numStudents;
	private int studentID;
	private Course[] coursesTaken;
	private int numCoursesTaken;
	private boolean isGraduate;
	private String major;
	
	public Student() {
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = false;
		this.major = "undeclared";
		this.studentID = ++numStudents;
		
	}
	public Student(boolean isGraduate) {
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = "undeclared";
		this.studentID = ++numStudents;
	}
	
	public Student(String major, boolean isGraduate) {
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
		this.studentID = ++numStudents;
	}
	
	public Student(String name, int birthYear, String major, boolean isGraduate) {
		super(name, birthYear);
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
		this.studentID = ++numStudents;
	}
	
	public boolean isGraduate() {
		return isGraduate;
	}
	
	public int getNumCoursesTaken() {
		return numCoursesTaken;
	}
	public static int getNumStudents() {
		return numStudents;
		
	}
	public int getStudentID() {
		return studentID;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setIsGraduate(boolean b) {
		this.isGraduate = b;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void addCourseTaken(Course course) {
		if(numCoursesTaken < coursesTaken.length) {
			coursesTaken[numCoursesTaken] = course;
			numCoursesTaken++;
		}
		
	}
	
	public void addCoursesTaken(Course[] course) {
		coursesTaken = course;
		numCoursesTaken = course.length;
		
	}
	public Course getCourseTaken(int index) {
		if(index >= 0 && index < coursesTaken.length) {
			return coursesTaken[index];
		}
		return null;
	}
	
	public String getCourseTakenAsString(int index) {
		if(index >= 0 && index < numCoursesTaken) {
			return coursesTaken[index].toString();
		}
		return null;
	}
	
	public String getAllCoursesTakenAsString() {
		String c = "";
		if(numCoursesTaken == 0) {
			return null;
		}
		for(int i = 0; i < numCoursesTaken; i++ ) {
			c += getCourseTakenAsString(i);
		}
		return c;
	}
	@Override
	public boolean equals(Object o) {
		if (o == null)   
			return false;  
		if (o == this)  
			return true;
		Student s = (Student)o;
		if(super.equals(s)) {
			if(isGraduate() == s.isGraduate()) {
				if(getStudentID() == s.getStudentID()) {
					if(getMajor().equals(s.getMajor())) {
						if(getNumCoursesTaken() == s.getNumCoursesTaken()) {
							for(int i = 0; i < numCoursesTaken; i++) {
								if(!coursesTaken[i].equals(s.coursesTaken[i])) {
									return false;
								}
							}
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	@Override
	public String toString() {
		String f = "Undergraduate";
		if(isGraduate()) {
			f = "Graduate";
		}
		String w = getAllCoursesTakenAsString(); 
		
		String s = String.format(" Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s", studentID, major, f, numCoursesTaken, w);
		return super.toString() + s;
	}
	@Override
	public int compareTo(Object o) {
		Student c =(Student) o;
		int one = 0;
		int two = 0;
		for(int i = 0; i < numCoursesTaken; i++) {
			one += coursesTaken[i].getNumCredits();
			}
		for(int i = 0; i < c.getNumCoursesTaken(); i++) {
			two += c.coursesTaken[i].getNumCredits();
			}
		if (one == two) {
            return 0;
       } 
		
		else if (one >= two) {
            return 1;
		} 
		else {
            return -1;
        }
	}
	
}
