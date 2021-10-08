import java.util.*;

public class Faculty {
	private String firstName;
	
	private String lastName;
	
	private String officeLocation;
	
	private ArrayList<Course> courses;
	
	private ArrayList<TimeBlock> officeHours;
	
	private ArrayList<Appointment> appointments;
	
	public Faculty() {
		firstName = null;
		
		lastName = null;
		
		officeLocation = null;
		
		courses = new ArrayList<Course>();
		
		officeHours = new ArrayList<TimeBlock>();
		
		appointments = new ArrayList<Appointment>();	
		
	}
	
	public Faculty(String Fname, String Lname, String l) {
		firstName = Fname;
		lastName = Lname;
		officeLocation = l;
		courses = new ArrayList<Course>();
		officeHours = new ArrayList<TimeBlock>();
		appointments = new ArrayList<Appointment>();
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public void setLastName(String last) {
		lastName = last;
	}
	
	public void setOfficeLocation(String office) {
		officeLocation = office;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
		
	}
	
	public String getOfficeLocation() {
		return officeLocation;
	}
	
	
	public int getNumCourses() {
		return courses.size();
	}
	
	
	
	public void addCourses(Course s) {
		courses.add(s);
	}
	
	public void addCourseAt(int index, Course c) {
		courses.add(index, c);
	}
	
	public void setCourses(ArrayList <Course> c) {
		courses = c;
	}
	
	public void removeCourses(int a) {
		courses.remove(a);
	}
	
	public ArrayList <Course> getCourses(){
		return courses;
	}
	
	public Course getCourses(int d) {
		return courses.get(d);
	}
	
	
	public int getNumOfficeHours() {
		return officeHours.size();
	}
	
	public void setOfficeHours(ArrayList <TimeBlock> off) {
		officeHours = off;
	}
	
	
	public void addOfficeHours(TimeBlock n) {
		officeHours.add(n);
	}
	
	public void addOfficeHoursAt(int index, TimeBlock t) {
		officeHours.add(index, t);
	}
	
	public ArrayList <TimeBlock> getOfficeHours(){
		return officeHours;
	}
	
	public TimeBlock getOfficeHours(int ind) {
		return officeHours.get(ind);
		
	}
	
	public void removeOfficeHours(int i) {
		officeHours.remove(i);
	}
	
	public int getNumAppointments() {
		return appointments.size();
		
	}
	
	public void addAppointments(Appointment n) {
		appointments.add(n);
	}
	
	public void addAppointmentsAt(int ind, Appointment s) {
		appointments.add(ind, s);
	}
	
	public void setAppointments(int app, Appointment appoint) {
		appointments.add(app, appoint);
	}
	
	public void removeAppointments(int ind) {
		appointments.remove(ind);
	}
	
	public ArrayList <Appointment> getAppointments(){
		return appointments;
	}
	
	public Appointment getAppointments(int ind) {
		return appointments.get(ind);
	}
	
	
	public String getCalendar() {
		String str = "";
		for(Course course: this.getCourses()) {
			for(int i = 0; i < course.getNumTimeBlocks(); i++) {
				for(int j = 0; j <= 2400; j+=5) {
					if((course.getTimeBlocks(i).getStartTime() == j) || (course.getTimeBlocks(i).getEndTime() == j)) {
						str += (course.getTimeBlocks(i).getDay()) + "\nCourse:" + (course.toString()) + course.getTimeBlocks(i).getStartTime() + "-" + course.getTimeBlocks(i).getEndTime() + "\n";
						break;
					}
				}
			}
		}
		
		for(int k = 0; k < this.getNumOfficeHours(); k++) {
			TimeBlock office = this.getOfficeHours(k);
			for(int n = 0; n <= 2400; n+= 5) {
				if((office.getStartTime() == n)) {
					str += office.getDay() + "\nOffice hours:" + office.getStartTime() + "-" + office.getEndTime() + "\n";
					
					break;
				}
			}
		}
		
		for(int z = 0; z < this.getNumAppointments(); z++) {
			Appointment ap = this.getAppointments(z);
			for(int s = 0; s <= 2400; z+=5) {
				if((ap.getTimeBlock().getStartTime() == s)) {
					str += ap.getTimeBlock().getDay() + "\nAppointment: " + ap.getTimeBlock().getStartTime() + "-" + 
				ap.getTimeBlock().getEndTime() + "\n";
					break;
				}
				
			}
			
		}
		
		return str;
		
		
	}
	
	@Override
	public String toString() {
		return "Faculty: " + firstName +" \n" + "Faculty: " + lastName + "\n" + "Office Location: " + officeLocation
				+ "\n" + "Number of Courses: " + courses.size() + "\n" + courses + "\n" + "Office Hours: " + getNumOfficeHours() + "\n" + 
				"Appointment: " +
				getNumAppointments() + "\n";
		
		
	}
	

}
