
public class Appointment {
	
	private String description;
	
	private TimeBlock timeBlock;
	
	public Appointment() {
		
		description = "None";
		
		timeBlock = new TimeBlock();
	}
	
	public Appointment(String des, TimeBlock s) {
		description = des;
		
		timeBlock = new TimeBlock(s.getDay(), s.getStartTime(), s.getEndTime());
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public TimeBlock getTimeBlock() {
		return timeBlock;
	}
	
}
