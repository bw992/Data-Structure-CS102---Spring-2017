package schoolreg;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	ArrayList<course> initiate_course= new ArrayList<course>();
	BufferedReader br = new BufferedReader(new FileReader(new File("path/to MyUniversityCourse.csv ")));
	String line;	
		// ** Need to be fixed : Figure out how to direct to the csv file 
	while((Lline = br.readLine())!=null){
		String[] lineArray = line.split("");
			
		course cos = new course(lineArray[0],lineArray[1], Integer.parseInt(lineArray[2]),Integer.parseInt(lineArray[3]),ArrayList<lineArray[4]>,lineArray[5],Integer.parseInt(lineArray[6]),lineArray[7]))
			
		initiate_course.add(cos);
		}
		
		return result
	}
}
