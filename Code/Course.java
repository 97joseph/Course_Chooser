import java.util.*;

public class Course {
	private String courseName;
	private String location;
	private ArrayList <TimeBlock> timeBlocks;
		

	public Course() {
		courseName = "None";
		location = "None";
		timeBlocks = new ArrayList <TimeBlock>();
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getLocation() {
		return location;
	}
	
	public void addTimeBlocks(TimeBlock timeBlocks) {
		this.timeBlocks.add(timeBlocks);
	}
	
	public void setTimeBlocks(int b, TimeBlock timeBlocks) {
		this.timeBlocks.add(b, timeBlocks);
	}
	
	public void removeTimeBlocks(int a) {
		this.timeBlocks.remove(a);
	}
	
	public int getNumTimeBlocks() {
		return timeBlocks.size();
	}
	
	public TimeBlock getTimeBlocks(int c) {
		return timeBlocks.get(c);
	}
	
	@Override
	public String toString() {
		return ("Number of meeting days for course: " + timeBlocks.size() + "\n" + "Course Name: " + courseName + "\n" + "Course Location: " + location + "\n" + timeBlocks );
		
	}

}
