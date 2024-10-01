import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Practice {

	
	public static void main(String args[]) throws FileNotFoundException {
	Scanner scnr = new Scanner(System.in);
	
		ArrayList<Object> courses = new ArrayList<Object>();
		ArrayList<Object> faculties = new ArrayList<Object>();
		ArrayList<Object> gStaffs = new ArrayList<Object>();
		ArrayList<Object> student = new ArrayList<Object>();
	
		System.out.println("Hey Lets Create Objects!");
		System.out.println("We can make Courses, Faculty, General Staffs, and Students");
		
		System.out.println("You get to chose which one you get to create?");
		System.out.println("And remember whenever you feel the need to stop you can type stop.");
		System.out.println("However the Maximun amount of objects you can create is 3 for each.");
		
		String o = "";
		
		
		
		while(!o.equalsIgnoreCase("stop")) {
		System.out.println("Which one you want to create now?");
		o = scnr.nextLine();
		if(o.equalsIgnoreCase("course")){
			if(courses.size() == 3) {
				System.out.println("You already made 3 Course Objects");
			}
			else {Course c = createCourse();
			System.out.println(c.toString());
			courses.add(c);
			
			}
			
		}
		else if(o.equalsIgnoreCase("student")) {
			if(student.size() == 3) {
				System.out.println("You already made 3 Student Objects");
			}
			else {
			Student s = createStudent();
			System.out.println(s.toString());
			student.add(s);
			}
		}
		else if(o.equalsIgnoreCase("General Staff")) {
			if(gStaffs.size() == 3) {
				System.out.println("You already made 3 GeneralStaff Objects");
			}
			else{
				GeneralStaff gS = createGeneralStaff();
				System.out.println(gS.toString());
				gStaffs.add(gS);
			}
		}
		else if(o.equalsIgnoreCase("Faculty")) {
			if(faculties.size() == 3) {
				System.out.println("You already made 3 Faculty Objects");
			}
			else {
			Faculty f = createFaculty();
			System.out.println(f.toString());
			faculties.add(f);
			}
}
		else if(o.equalsIgnoreCase("stop")) {
			
		}
		else {
			System.out.println("Try Again");
		} 
		
		if(faculties.size()== 3 && student.size()== 3 && courses.size()== 3 && gStaffs.size()== 3) {
			o = "stop";
			System.out.println("Yeah you made 3 objects of each!");
		}
		
		
		}
		
		int option = mainMenu();
		while(option != 12) {
		if(option == 1) {
			
			Faculty[] faculty = new Faculty[3];
			System.out.println("Type the number of which Faculty Object you want to add 2 courses");
			for(int i = 0; i < faculties.size(); i++) {
				Faculty temp = (Faculty) faculties.get(i);
				faculty[i] = temp;
				System.out.println((i + 1) + ": " + faculties.get(i));
			}
			int i = scnr.nextInt() - 1;
			
			
			
			System.out.println("What Courses would you like to add to this Faculty Object?");
			
			for(int j = 0; j < courses.size(); j++) {
				System.out.println((j + 1) + ": " + courses.get(j));
			}
			
			int c1 = scnr.nextInt() - 1;
			int c2 = scnr.nextInt() - 1;
			
			Course one = (Course) courses.get(c1);
			Course two = (Course) courses.get(c2);
			faculty[i].addCourseTaught(one);
			faculty[i].addCourseTaught(two);
			
			System.out.println("Courses Added!");
			System.out.println();
			System.out.println(faculty[i].toString());
		}
		
		else if(option == 2) {
			
			Student[] Students = new Student[3];
			System.out.println("Type the number of which Student Object you want to add 2 courses");
			for(int i = 0; i < student.size(); i++) {
				Student temp = (Student) student.get(i);
				Students[i] = temp;
				System.out.println((i + 1) + ": " + student.get(i));
			}
			int i = scnr.nextInt() - 1;
			
			
			
			System.out.println("What Courses would you like to add to this Student Object?");
			
			for(int j = 0; j < courses.size(); j++) {
				System.out.println((j + 1) + ": " + courses.get(j));
			}
			
			int c1 = scnr.nextInt() - 1;
			int c2 = scnr.nextInt() - 1;
			
			Course one = (Course) courses.get(c1);
			Course two = (Course) courses.get(c2);
			Students[i].addCourseTaken(one);
			Students[i].addCourseTaken(two);
			
			System.out.println("Courses Added!");
			System.out.println();
			System.out.println(Students[i].toString());
		}
		
		else if(option == 3) {
			System.out.println("Which Courses would you like to add to an Array Object?");
			
			for(int j = 0; j < courses.size(); j++) {
				System.out.println((j + 1) + ": " + courses.get(j));
			}
			
			int c1 = scnr.nextInt() -1;
			int c2 = scnr.nextInt() -1;
			
			Course one = (Course) courses.get(c1);
			Course two = (Course) courses.get(c2);
			Course[] c = {one, two};
			
			Faculty[] faculty = new Faculty[faculties.size()];
			System.out.println("Which Faculty Object you want to add your Array to?");
			for(int i = 0; i < faculties.size(); i++) {
				Faculty temp = (Faculty) faculties.get(i);
				faculty[i] = temp;
				System.out.println((i + 1) + ": " + faculties.get(i));
			}
			
			int facultyChoose = scnr.nextInt() - 1;
			faculty[facultyChoose].addCoursesTaught(c);
			System.out.println("Array Added");
		}
		
		else if(option == 4) {
			System.out.println("Which Courses would you like to add to an Array Object?");
			
			for(int j = 0; j < courses.size(); j++) {
				System.out.println((j + 1) + ": " + courses.get(j));
			}
			
			int c1 = scnr.nextInt() -1;
			int c2 = scnr.nextInt() -1;
			
			Course one = (Course) courses.get(c1);
			Course two = (Course) courses.get(c2);
			Course[] c = {one, two};
			
			Student[] Students = new Student[student.size()];
			System.out.println("Which Student Object you want to add your Array to?");
			for(int i = 0; i < student.size(); i++) {
				Student temp = (Student) student.get(i);
				Students[i] = temp;
				System.out.println((i + 1) + ": " + student.get(i));
			}
			
			int facultyChoose = scnr.nextInt() - 1;
			Students[facultyChoose].addCoursesTaken(c);
			System.out.println("Array Added");
		}
		
		else if(option == 5) {
			System.out.println("From which Faculty Object Do you want to get a course?");
			for(int i = 0; i < faculties.size(); i++) {
				System.out.println((i + 1) + ": " + faculties.get(i));
			}
			
			int j = scnr.nextInt() - 1;
			
			Faculty f = (Faculty) faculties.get(j);
			
			System.out.println("At what index is the course you looking for?");
			j = scnr.nextInt();
			while(j < 0) {
				System.out.print("invalid index");
				j = scnr.nextInt();
			}
			System.out.println(f.getCourseTaughtAsString(j));
			
		}
		
		else if(option == 6) {
			System.out.println("From which Student Object Do you want to get a course?");
			for(int i = 0; i < student.size(); i++) {
				System.out.println((i + 1) + ": " + student.get(i));
			}
			
			int j = scnr.nextInt() - 1;
			
			Student s = (Student) student.get(j);
			
			System.out.println("At what index is the course you looking for?");
			j = scnr.nextInt();
			while(j < 0) {
				System.out.print("invalid index");
				j = scnr.nextInt();
			}
			System.out.println(s.getCourseTakenAsString(j));
			
		}
		
		else if(option == 7) {
			System.out.println("For which course you going to look for?");
			
			for(int i = 0; i < courses.size(); i++) {
				System.out.println((i + 1) + ": " + courses.get(i));
			}
			int j = scnr.nextInt() - 1;
			Course c = (Course) courses.get(j);
			System.out.println("In which Faculty you going to look for that Courses?");
			for(int i = 0; i < faculties.size(); i++) {
				System.out.println((i + 1) + ": " + faculties.get(i));
			}
			j = scnr.nextInt();
			Faculty f = (Faculty) faculties.get(j);
			
			for(int i = 0; i < f.getNumCoursesTaught(); i++) {
				if(f.getCourseTaught(i).equals(c)) {
					System.out.println("This Faculty teaches that course.");
				}
			}
			
		}
		else if(option == 8) {
			Faculty one = (Faculty) faculties.get(0);
			Faculty two = (Faculty) faculties.get(1);
			Faculty three = (Faculty) faculties.get(2);
			
			int uno = one.getNumCoursesTaught();
			int dos = two.getNumCoursesTaught();
			int tres = three.getNumCoursesTaught();
			
			int max = Math.max(uno, dos);
			int max1 = Math.max(max, tres);
			System.out.println("This Faculty Object Teaches the most courses");
			if(max1 == uno) {
	
				System.out.println(one.toString());
			}
			else if(max1 == dos) {
				System.out.println(two.toString());
			}
			else if(max1 == tres) {
				System.out.println(three.toString());
			}
			
			int min = Math.min(uno, dos);
			int min1 = Math.min(min, tres);
			System.out.println("This Faculty Object Teaches the least courses");
			if(min1 == uno) {
	
				System.out.println(one.toString());
			}
			else if(min1 == dos) {
				System.out.println(two.toString());
			}
			else if(min1 == tres) {
				System.out.println(three.toString());
			}
		}
		
		else if(option == 10) {
			Course[] c = new Course[courses.size()];
			for(int i = 0; i< courses.size(); i++) {
				c[i] = (Course) courses.get(i);
			}
			
			int uno = c[0].getCourseNum();
			int dos = c[1].getCourseNum();
			int tres = c[2].getCourseNum();
			
			int max = Math.max(uno, dos);
			int max1 = Math.max(max, tres);
			System.out.println("The Maximum Catalog goes tooooo");
			if(max1 == uno) {
				
				System.out.println(c[0].toString());
			}
			else if(max1 == dos) {
				System.out.println(c[1].toString());
			}
			else if(max1 == tres) {
				System.out.println(c[2].toString());
			}
			
		}
		
		else if(option == 9) {
			Course[] c = new Course[courses.size()];
			for(int i = 0; i< courses.size(); i++) {
				c[i] = (Course) courses.get(i);
			}
			
			int uno = c[0].getCourseNum();
			int dos = c[1].getCourseNum();
			int tres = c[2].getCourseNum();
			
			int min = Math.min(uno, dos);
			int min1 = Math.min(min, tres);
			System.out.println("The Minimum Catalog goes tooooo");
			if(min1 == uno) {
				
				System.out.println(c[0].toString());
			}
			else if(min1 == dos) {
				System.out.println(c[1].toString());
			}
			else if(min1 == tres) {
				System.out.println(c[2].toString());
			}
			
		}
		
		else if(option == 11) {
			Student[] students = new Student[student.size()];
			int credits = -1;
			int lC = 0;
			Student main = null;
			Student less = null;
			for(int i = 0; i< student.size(); i++) {
				students[i] = (Student) student.get(i);
			
			}	
			int uno = 0;
			for(int i = 0; i < students[0].getNumCoursesTaken(); i++) {
				uno += students[0].getCourseTaken(i).getNumCredits();
			}
			
			int dos = 0;
			for(int i = 0; i < students[1].getNumCoursesTaken(); i++) {
				dos += students[1].getCourseTaken(i).getNumCredits();
			}
			
			int tres = 0;
			for(int i = 0; i < students[2].getNumCoursesTaken(); i++) {
				tres += students[2].getCourseTaken(i).getNumCredits();
			}
			
			int max = Math.max(uno, dos);
			int max1 = Math.max(max, tres);
			//System.out.println("The Maximum Catalog goes tooooo");
			if(max1 == uno) {
				
				main = students[0];
				credits = uno;
			}
			else if(max1 == dos) {
				main = students[1];
				credits = dos;
			}
			else if(max1 == tres) {
				main = students[2];
				credits = tres;
			}
			System.out.println("The student with the most Credits is");
			System.out.println(main.getName() + " with " + credits + "credits.");
			System.out.println();
			int min = Math.min(uno, dos);
			int min1 = Math.min(min, tres);
			//System.out.println("The Maximum Catalog goes tooooo");
			if(min1 == uno) {
				
				less = students[0];
				lC = uno;
			}
			else if(min1 == dos) {
				less = students[1];
				lC = dos;
			}
			else if(min1 == tres) {
				less = students[2];
				lC = tres;
			}
			System.out.println("The student with the least Credits is");
			System.out.println(less.getName() + " with " + lC + "credits.");
		
		}
		else if(option == 12) {
			break;
			
		}
	
			System.out.println("Whats Next?");
			option = scnr.nextInt();
		
	}
		
		System.out.println("Inputing to a file");
		FileOutputStream fOS= null;
		PrintWriter pW = null;
		
		
		try {
			fOS = new FileOutputStream("Text/File");
			pW = new PrintWriter(fOS);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		printer(pW, courses);
		pW.println();
		pW.println();
		printer(pW, faculties);
		pW.println();
		pW.println();
		printer(pW, gStaffs);
		pW.println();
		pW.println();
		printer(pW, student);
		pW.println();
		pW.println();
		
		pW.close();
		
	}
	
	public static Course createCourse() {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Hey you can create a course by Typing if is Graduate, Course Number, Course Department, and the amount of credits. All separate by space");
		Course c = new Course(scnr.nextBoolean(), scnr.nextInt(), scnr.next(), scnr.nextInt());
	return c;
	}
	public static Student createStudent() {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Hey you can create a Student by Typing their name, birth year, department name, and if is tenured graduate. All separate by lines");
		System.out.println("Enter String");
		String l = scnr.nextLine();
		System.out.println("Enter int");
		int i = scnr.nextInt();
		System.out.println("Enter String");
		String s2 = scnr.nextLine();
		s2 = scnr.nextLine();
		System.out.println("Enter Boolean");
		boolean b = scnr.nextBoolean();
		Student s = new Student(l, i, s2, b);
		return s;
		}
	
	public static GeneralStaff createGeneralStaff() {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Hey you can create a General Staff by Typing their name, birth year, department name, and their duty. All separate by lines");
		System.out.println("Enter String");
		String s = scnr.nextLine();
		System.out.println("Enter int");
		int i = scnr.nextInt();
		System.out.println("Enter String");
		String s2 = scnr.nextLine();
		s2 = scnr.nextLine();
		System.out.println("Enter String");
		String b = scnr.nextLine();
		GeneralStaff g = new GeneralStaff(s, i, s2, b);
		return g;
		}
		
	public static Faculty createFaculty() {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Hey you can create a Faculty by Typing their name, birth year, department name, and if is tenured graduate. All separate by lines");
		System.out.println("Enter String");
		String s = scnr.nextLine();
		System.out.println("Enter int");
		int i = scnr.nextInt();
		System.out.println("Enter String");
		String s2 = scnr.nextLine();
		s2 = scnr.nextLine();
		System.out.println("Enter Boolean");
		boolean b = scnr.nextBoolean();
		Faculty f = new Faculty(s, i, s2, b);
		return f;
		}
	
	public static int mainMenu() {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Hey you made it! Now you get to choose what you doing Next. Type the number of Action you want to make.");
		System.out.println("1.Add 2 new Courses to a Faculty object");
		System.out.println("2.Add 2 new Courses to a Student object");
		System.out.println("3.Add an array of 2 Courses to a Faculty object");
		System.out.println("4.Add an array of 2 Courses to a Student object");
		System.out.println("5.Get the Course at index (valid and invalid indexes) from a Faculty object");
		System.out.println("6.Get the Course at index (valid and invalid indexes) from a Student object");
		System.out.println("7.Determine if a Faculty Object teaches a specific Course");
		System.out.println("8.Determine which Faculty object teaches the most and the least courses.");
		System.out.println("9.Determine which Course is the minimum of all Course objects in the catalog.");
		System.out.println("10.Determine which Course is the maximum of all Course objects in the catalog.");
		System.out.println("11.Determine which Student has the most and least credits.");
		System.out.println("12.Stop");
		
		return scnr.nextInt();
	}
	
	public static void printer(PrintWriter pw, ArrayList<Object> myList) {
		
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
			pw.println(myList.get(i));
		}
	}
}
