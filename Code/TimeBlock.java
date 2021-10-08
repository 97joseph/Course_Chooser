

public class TimeBlock {
	private DaysOfWeek day;
	
	private int startTime;
	
	private int endTime;
	
	private String comments;
	
	private String location;
	
	public TimeBlock() {
		day = DaysOfWeek.MONDAY;
		
		startTime = 0;
		
		endTime = 0;
		
		comments = "None";
		
		location = "None";
		
	}
	
	public TimeBlock(DaysOfWeek day, int start, int end) {
		this.day = day;
		startTime = start;
		endTime = end;
		comments = "None";
		location = "None";
	}
	
	public void setDay(DaysOfWeek night) {
		day = night;
	}
	
	public void setStartTime(int n) {
		startTime = n;
	}
	
	public void setEndTime(int m) {
		endTime = m;
	}
	
	public void setComments(String c) {
		comments = c;
	}
	
	public void setLocation(String l) {
		location = l;
	}
	
	public DaysOfWeek getDay() {
		return day;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	public String getComments() {
		return comments;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getFormatedTimeBlock() {
		return startTime + "-" + endTime + " " + comments + " " + location;
		
	}
	
	@Override
	public String toString() {
		return day+" : "+startTime+" - "+endTime+ " Comments: "+ comments + " Location: "+ location;
	}
}