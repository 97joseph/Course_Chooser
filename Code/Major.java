import java.io.*;
import java.util.*;

public class Major {

	public static void main(String[] args) throws IOException {
		File fn = new File("input.txt");
		
		FileInputStream f = new FileInputStream(fn); 
		Scanner scnr = new Scanner(f);
		
		Department dep = new Department();
		dep.laodDepartmentData("input.txt");
		dep.saveDepartmentData("output.txt");
		
		System.out.println(dep.getFaculty(0).getCalendar());
		System.out.println();
		System.out.println(dep.atAGlance(1100));
		System.out.println();
		System.out.println(dep.atAGlance(1300));
		scnr.close();
		
	}
}
