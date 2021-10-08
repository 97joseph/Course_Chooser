import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class Department {
	private String departmentName;
	
	private String unitName;
	
	private String universityName;
	
	private ArrayList<Faculty> faculty;
	
	
	public Department() {
		this.departmentName = "None";
		
		this.unitName = "None";
		
		this.universityName = "None";
		
		this.faculty = new ArrayList<Faculty>();
		
		
	}
	
	public Department(String department, String uName, String univName, Faculty f ) {
		departmentName = department;
		unitName = uName;
		universityName = univName;
		faculty = new ArrayList<Faculty>();
		f = new Faculty();
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
	public void setFaculty(ArrayList<Faculty> fac) {
		faculty = fac;
	}
	
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public String getUnitName() {
		return unitName;
	}
	
	public String getUniversityName() {
		return universityName;
		
	}
	
	public ArrayList<Faculty> getFaculty() {
		return faculty;
	}
	
	public int getNumFaculty() {
		return faculty.size();
	}
	
	public Faculty getFaculty(int a) {
		return faculty.get(a);
	}
	
	public void removeFaculty(int s) {
		faculty.remove(s);
	}
	
	public void addFaculty(Faculty n) {
		faculty.add(n);
	}
	
	public void addFacultyAt(int ind, Faculty f) {
		faculty.add(ind, f);
	}
	@Override
	public String toString() {
		return departmentName + "\n" + unitName + "\n " 
	           + universityName + "\n " + faculty;
	}
	
	public void laodDepartmentData(String fileName) throws IOException {
		FileInputStream fn = new FileInputStream(fileName);
		Scanner scnr = new Scanner(fn);
		
		departmentName = scnr.nextLine();
		unitName = scnr.nextLine();
		universityName = scnr.nextLine();
		while(scnr.hasNext()) {
			Faculty fc = new Faculty();
			fc.setFirstName(scnr.nextLine());
			fc.setLastName(scnr.nextLine());
			
			
			fc.setOfficeLocation(scnr.nextLine());
			this.addFaculty(fc);
			
			int numOfCourses = Integer.parseInt(scnr.nextLine());
			
			for(int i = 0; i < numOfCourses; i++) {
				Course course = new Course();
				course.setCourseName(scnr.nextLine());
				course.setLocation(scnr.nextLine());
				fc.addCourses(course);
				
				int numOfMeetings = Integer.parseInt(scnr.nextLine());
				
				for(int n = 0; n < numOfMeetings; n++) {
					String dayLine = scnr.nextLine();
					String[] words = dayLine.split(",");
					
					DaysOfWeek day = DaysOfWeek.valueOf(words[0].trim().toUpperCase());
					
					int st = Integer.parseInt(words[1].trim());
					
					int en = Integer.parseInt(words[2].trim());
					
					TimeBlock b = new TimeBlock(day, st, en);
					
					course.addTimeBlocks(b);
				}
				
			}
			
			int num = Integer.parseInt(scnr.nextLine());
			for(int i = 0; i < num; i++) {
				String dayLine = scnr.nextLine();
				String[] words = dayLine.split(",");
				DaysOfWeek day = DaysOfWeek.valueOf(words[0].trim().toUpperCase());
				
				int st = Integer.parseInt(words[1].trim());
				
				int en = Integer.parseInt(words[2].trim());
				
				TimeBlock b = new TimeBlock(day, st, en);
				
				fc.addOfficeHours(b);
				
			}
			
			int numOfAppointments = Integer.parseInt(scnr.nextLine());
			for (int m = 0; m < numOfAppointments; m++) {
				String des = scnr.nextLine();
				String dayLine = scnr.nextLine();
				String[] words = dayLine.split(",");
				DaysOfWeek day = DaysOfWeek.valueOf(words[0].trim().toUpperCase());
				
				int st = Integer.parseInt(words[1].trim());
				
				int en = Integer.parseInt(words[2].trim());
				
				
				TimeBlock b = new TimeBlock(day, st, en);
				
				Appointment p = new Appointment(des,b);
				
				fc.addAppointments(p);
				
			}
			
		}
		scnr.close();
	
	}
	
	public void saveDepartmentData(String fileName) throws IOException{
		FileOutputStream file = new FileOutputStream(fileName);
		PrintWriter p = new PrintWriter(file);
		p.println(this.toString());
		p.close();
	}
	
	public String atAGlance(int t) {
		String str = "";
		for (Faculty faculty: this.faculty) {
			for(Course course: faculty.getCourses()) {
				for(int i = 0; i < course.getNumTimeBlocks(); i++) {
					if((course.getTimeBlocks(i).getStartTime() == t )|| (course.getTimeBlocks(i).getEndTime() == t)) {
						str += (faculty.getFirstName() + " " + faculty.getLastName() + " has course " + course.getCourseName() + " at this time");
						break;
					}
				}
			}
			
			for(TimeBlock officeHours: faculty.getOfficeHours()) {
				if((officeHours.getStartTime() == t) || (officeHours.getEndTime() == t)) {
					str += (faculty.getFirstName() + " " + faculty.getLastName() + " has office hours " + officeHours.getLocation() + " at this time.");
					break;
				}
			}
			
			for (Appointment meetings: faculty.getAppointments()) {
				if((meetings.getTimeBlock().getStartTime() == t) || (meetings.getTimeBlock().getEndTime() == t)) {
					str += (faculty.getFirstName() + " " + faculty.getLastName() + " has an appointment " + meetings.getDescription() + " at this time.");
					break;
				}
			}
		}
		return str;
	}
	
	
	
}
