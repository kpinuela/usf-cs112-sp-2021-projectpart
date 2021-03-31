package cs112projectpart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.*;
import java.util.*;

public class DummyPredictor extends Predictor {
	private Double testAvg;
	private Double trainAvg;
	private List<Integer[]> sumList;
	private Double fdiff;
	


	


	String test(DataPoint data) {
		Double fdiff = data.getF2() - data.getF1();
		if(fdiff>0) {
			return "The difference is Positive!!";
			
		}
		else {
		return"The Difference is negative! ";
		}
		
	}
		
		
		
	
		
		
		
	/*Double trainCheck= Math.abs(data.getF1() - this.testAvg);
	
	Double testCheck =Math.abs(data.getF1() - this.trainAvg);
	
	if(trainCheck>testCheck) {
		return "Test";
	}
	if(testCheck>trainCheck) {
		return "Train";
	}
	
	return "Something..";
	}
	*/

	@Override
	Double getAccuracy(ArrayList<DataPoint> data) {
		// TODO Auto-generated method stub
		return 57.;
	}

	@Override
	Double getPrecision(ArrayList<DataPoint> data) {
		// TODO Auto-generated method stub
		return 100.1;
	}

	@Override
	ArrayList<DataPoint> readData(String filename) {
		ArrayList <DataPoint> readdata = new ArrayList<DataPoint>();
		try {
			Scanner scanner = new Scanner(new File(filename));
			
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] splitStr = line.split(" ");
				Double f1 = Double.parseDouble(splitStr[0]);
				Double f2 = Double.parseDouble(splitStr[1]);
				String label= (splitStr[2]);
				Boolean isTrue= Boolean.parseBoolean(splitStr[3]);
				DataPoint newData = new DataPoint(f1,f2, label, isTrue);
				readdata.add(newData); 
				
				
				
				

				
				
				
				

			}
			
			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println(e);
			// TODO Auto-generated catch block
			
		}
		return readdata;
		
	
		
		// TODO Auto-generated method stub
		
		
		

	}

	
}
