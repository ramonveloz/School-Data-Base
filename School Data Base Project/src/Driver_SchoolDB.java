// https://youtu.be/1mBAdCo_-yQ
//Im sorry for the quality my computer has not being working properly lately
//I tried to make it as short as I could

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
 
public class Driver_SchoolDB {

	public static void main(String args[]) throws IOException {
		
		FileInputStream fIS = null;
		Scanner sIS = null;

		try {
			fIS = new FileInputStream("Text/SchoolDB_Initial.txt");
			sIS = new Scanner(fIS);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		printEverything(sIS);
		
		fIS.close();
		sIS.close();
		
		try {
			fIS = new FileInputStream("Text/SchoolDB_Initial.txt");
			sIS = new Scanner(fIS);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		
		}
		
		sIS.useDelimiter(":");
		int f = 0;
		int g = 0;
		
		String l = String.format("\n");
		
		ArrayList<Object> courses = new ArrayList<Object>();
		ArrayList<Faculty> faculties = new ArrayList<Faculty>();
		ArrayList<Object> gStaffs = new ArrayList<Object>();
		ArrayList<Student> student = new ArrayList<Student>();
		
		while(sIS.hasNextLine()) {
			String text = sIS.next(); 
			
			if (text.equals("Course") || text.equals(l + "Course")) {
				//System.out.print(text + ": ");
				text = "";
				String rice = "";
				rice = sIS.nextLine();
				for(int i = 2; i < rice.length(); i++) {
					
					text += rice.charAt(i);
				}
				
				//System.out.println(text);
				if(f == 0) {
				Scanner separate = new Scanner(text);
				separate.useDelimiter(", ");
				boolean b = separate.nextBoolean();
				int r = separate.nextInt();
				String s = separate.next();
				int r2 = separate.nextInt();
				
				//System.out.println(b + s + r + r2);
				Course c = new Course(b, r, s, r2);
				courses.add(c);
				f++;
				}
				else {
						Scanner separate = new Scanner(text);
						separate.useDelimiter(",");
						boolean b = separate.nextBoolean();
						int r = separate.nextInt();
						String s = separate.next();
						int r2 = separate.nextInt();
						Course c = new Course(b, r, s, r2);
						courses.add(c);
						//System.out.println(b + s + r + r2);
				}
			}
			
			else if(text.equals("Faculty") || text.equals(l + "Faculty")) {
				
				Faculty f1 = faculty(sIS.nextLine());
				faculties.add(f1);
				
				//System.out.println();
			}
			else if(text.equals("Student") ||  text.equals(l + "Student")) {
				
				Student s1 = (student(sIS.nextLine()));
				student.add(s1);
				
			}
			else if(text.equals("GeneralStaff") ||  text.equals(l + "GeneralStaff")) {
				GeneralStaff g1 = generalStaff(sIS.nextLine());
				gStaffs.add(g1);
			}
			else {
				
				System.out.println( sIS.nextLine());
			}
			
		
		}
		
		FileOutputStream fOS = null;
		PrintWriter pW	= null;
		
		try {
			fOS = new FileOutputStream("SchoolDB_Updated.txt");
			pW = new PrintWriter(fOS);
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
		
		pW.println("**************************************************************");
		pW.println("SCHOOL DATABASE INFO:");
		pW.println();
		pW.println("************************************************");
		pW.println("COURSES:");
		printer(pW, courses);
		pW.println("************************************************");
		pW.println("************************************************");
		pW.println("PERSONS:");
		pW.println("************************************************");
		pW.println("************************************************");
		pW.println("EMPLOYEES:");
		pW.println("************************************************");
		pW.println("************************************************");
		pW.println("GENERAL STAFF:");
		printer(pW, gStaffs);
		pW.println("************************************************");
		pW.println("************************************************");
		pW.println("FACULTY:");
		printFaculty(pW, faculties);
		pW.println("************************************************");
		pW.println("************************************************");
		pW.println("STUDENTS:");
		printStudent(pW, student);
		pW.println("************************************************");
		pW.println("**************************************************************");
		pW.println();
		
		pW.close();
		sIS.close();
		
		FileInputStream file = null;
		Scanner print = null;
		
		try {
			file = new FileInputStream("SchoolDB_Updated.txt");
			print = new Scanner(file);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("");
		
		printEverything(print);

		print.close();
		
	}
	
	public static Faculty faculty(String line) {
		if(line.equals(":")) {
			Faculty f = new Faculty();
			return f;
		}
		
		String rice = "";
		int comas = 0;
	
		for(int i = 2; i < line.length(); i++) {
			if(line.charAt(i) == ',') {
				comas++;
			}
			rice += line.charAt(i);
		}
		
		if(comas == 0) {
			Scanner temp = new Scanner(rice);
			boolean b = temp.nextBoolean();
			Faculty f = new Faculty(b);
			return f;
		}
		
		else if(comas == 1) {
			Scanner temp = new Scanner(rice);
			temp.useDelimiter(",");
			String s = temp.next();
			boolean b = temp.nextBoolean();
			
			Faculty f = new Faculty(s, b);
			return f;
		}
		
		else {
			Scanner temp = new Scanner(rice);
			temp.useDelimiter(",");
			Faculty f = new Faculty(temp.next(), temp.nextInt(), temp.next(), temp.nextBoolean());
			return f;
		}
		
	}
	
	public static GeneralStaff generalStaff(String line) {
		if(line.equals(":")) {
			GeneralStaff f = new GeneralStaff();
			return f;
		}
		
		String rice = "";
		int comas = 0;
	
		for(int i = 2; i < line.length(); i++) {
			if(line.charAt(i) == ',') {
				comas++;
			}
			rice += line.charAt(i);
		}
		
		if(comas == 0) {
			//Scanner temp = new Scanner(rice);
			//String b = temp.next();
			GeneralStaff f = new GeneralStaff(rice);
			return f;
		}
		
		else if(comas == 1) {
			Scanner temp = new Scanner(rice);
			temp.useDelimiter(",");
			String s = temp.next();
			String b = temp.next();
			
			GeneralStaff f = new GeneralStaff(s, b);
			return f;
		}
		
		else {
			Scanner temp = new Scanner(rice);
			temp.useDelimiter(",");
			GeneralStaff f = new GeneralStaff(temp.next(), temp.nextInt(), temp.next(), temp.next());
			return f;
		}
	}
	
	public static Student student(String line) {
		if(line.equals(":")) {
			Student f = new Student();
			return f;
		}
		
		String rice = "";
		int comas = 0;
	
		for(int i = 2; i < line.length(); i++) {
			if(line.charAt(i) == ',') {
				comas++;
			}
			rice += line.charAt(i);
		}
		
		if(comas == 0) {
			Scanner temp = new Scanner(rice);
			boolean b = temp.nextBoolean();
			Student f = new Student(b);
			return f;
		}
		
		else if(comas == 1) {
			Scanner temp = new Scanner(rice);
			temp.useDelimiter(",");
			String s = temp.next();
			boolean b = temp.nextBoolean();
			
			Student f = new Student(s, b);
			return f;
		}
		
		else {
			Scanner temp = new Scanner(rice);
			temp.useDelimiter(",");
			Student f = new Student(temp.next(), temp.nextInt(), temp.next(), temp.nextBoolean());
			return f;
		}
	}
	
	public static void printer(PrintWriter pw, ArrayList<Object> myList) {
		
		for(int i = 0; i < myList.size(); i++) {
			pw.println(myList.get(i));
		}
	}
	
public static void printStudent(PrintWriter pw, ArrayList<Student> myList) {
		
		for(int i = 0; i < myList.size(); i++) {
			Student s = myList.get(i);
			String line = s.toString();
			String lineT = "";
			for(int j = 0; j < line.length() - 4; j++) {
				lineT += line.charAt(j);
			}
			pw.println(lineT);
		}
	}

public static void printFaculty(PrintWriter pw, ArrayList<Faculty> myList) {
	
	for(int i = 0; i < myList.size(); i++) {
		Faculty s = myList.get(i);
		String line = s.toString();
		String lineT = "";
		for(int j = 0; j < line.length() - 4; j++) {
			lineT += line.charAt(j);
		}
		pw.println(lineT);
	}
}
	
public static void printEverything(Scanner sIS) {
	while(sIS.hasNextLine()) {
		
		System.out.println(sIS.nextLine());
	}
	
}
	
}