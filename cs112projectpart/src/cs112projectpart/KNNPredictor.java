package cs112projectpart;
import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.math.*;

public class KNNPredictor extends Predictor {
	
	private int k;
	private int surviveCount=0;
	private int deadCount=0;
	private ArrayList<DataPoint> passData;
	
	KNNPredictor(int kParam){
		this.k=kParam;
		
	}
	
	private List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(",");
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
	 return values;
	}
	


	@Override
	ArrayList<DataPoint> readData(String filename) {
		File file = new File(filename);
		Scanner sc;
		surviveCount=0;
		deadCount=0;
		int lineCount =0;
		int invalidData=0;
		Random random = new Random();
		
		ArrayList<DataPoint> readdata = new ArrayList<DataPoint>();
		try {
			sc = new Scanner(file);
			
		}
		catch (FileNotFoundException e) {
			return readdata;
			
		}
		sc.nextLine(); //skips labels
		while (sc.hasNextLine()) {
			lineCount++;
			List<String> records = getRecordFromLine(sc.nextLine());
			
			if(records.size() <7) {
				invalidData++;
				continue;
			}
			
			String survivestr = records.get(1);
			String agestr = records.get(5);
			String farestr = records.get(6);
			int survive = 0;
			double age= 0.0;
			double fare = 0.0;
			
			try {
				survive= Integer.parseInt(survivestr);
				
			}
			catch(NumberFormatException ex) {
				invalidData++;
				continue;
				
			}
			
			try {
				age= Double.parseDouble(agestr);
				
			}
			catch(NumberFormatException ex) {
				invalidData++;
				continue;
				
			}
			
			try {
				fare= Double.parseDouble(farestr);
				
			}
			catch(NumberFormatException ex) {
				invalidData++;
				continue;
				
			}
			boolean testOrTrain = random.nextDouble() < 0.9;
			
			if(testOrTrain) {
				if(survive== 1) {
					surviveCount++;			
				}
				else {
					deadCount++;
				}
			}
			
			DataPoint dp = new DataPoint (age, fare, survive, testOrTrain);
			readdata.add(dp);
			
			
			
		}
		sc.close();
		System.out.println("Total Records: " + lineCount + " \n Survivors: " + surviveCount + "\n Deaths: " + deadCount + "\n Missing Info Files: " + invalidData);
		 
		return readdata;
		
		
		
	}

		
	
	
	private double getDistance(DataPoint p1, DataPoint p2) {
		double totaldistance;
		double x1=p1.getF1();
		double x2=p2.getF1();
		double y1=p1.getF2();
		double y2= p2.getF2();
	
		totaldistance= Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
		return totaldistance;
		
			
		
	}

	
	
	
	
	@Override
	public String test(DataPoint data) {
		int train = this.surviveCount + this.deadCount;
		double testDistance;
		double testLabel;
		Double [][] arr = new Double[train][2];
		
		for(int t = 0; t <train; t++) {
			DataPoint totTrainData = passData.get(t);
			 testDistance= getDistance(data, totTrainData);
			 testLabel = totTrainData.getLabel();
			 arr[t][1]= testLabel;
			 arr[t][0]=testDistance;			
		}
		java.util.Arrays.sort(arr, new java.util.Comparator<Double[]>() {
			public int compare(Double[] a, Double [] b) {
			return a[0].compareTo(b[0]);
			}
			});
		
		int testSurvived= 0;
		int testDied=0;
		double testRec;
		
		if(!data.getIsTest()) {
		for (int t = 0; t<k ;t++) {
			testRec=arr[t][1];
			if(testRec ==1) {
				testSurvived++;
			}
			else {
				testDied++;
			}
		}
		}
		if(testSurvived>testDied) {
			return"1";
		}
		else {
			return "0";
		}
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	Double getAccuracy(ArrayList<DataPoint> data) {
		double truePositive=0.0;
		double falsePositive=0.0;
		double trueNegative=0.0;
		double falseNegative=0.0;
	
		double accuracy;
		double dpLabel;
		double testAcc;
		for(DataPoint dp : data) {
			 dpLabel= dp.getLabel();
			 
			 passData = data;
			 testAcc= Double.parseDouble(test(dp));
			 
			 if(dpLabel==1.0) {
				 if (testAcc==1.0) {
					 truePositive++;
				 }
				 else if (testAcc==0.0) {
					 falsePositive++;
					 
				 }
			 }
			 if(dpLabel==0.0) {
				 if (testAcc==0.0) {
					 trueNegative++;
				 }
				 else if (testAcc==1.0) {
					 falseNegative++;
					 
				 }
			 }
			 
			
		}
		accuracy = (truePositive+ trueNegative)/(truePositive + trueNegative + falsePositive + falseNegative);
		
		
		// TODO Auto-generated method s
		return accuracy;
	}

	@Override
	Double getPrecision(ArrayList<DataPoint> data) {
		double truePositive=0.0;
		double falsePositive=0.0;
		double trueNegative=0.0;
		double falseNegative=0.0;
		double precision;
		double dpLabel;
		double testAcc;
		for(DataPoint dp : data) {
			 dpLabel= dp.getLabel();
			 
			 passData = data;
			 testAcc= Double.parseDouble(test(dp));
			 
			 if(dpLabel==1.0) {
				 if (testAcc==1.0) {
					 truePositive++;
				 }
				 else if (testAcc==0.0) {
					 falsePositive++;
					 
				 }
			 }
			 if(dpLabel==0.0) {
				 if (testAcc==0.0) {
					 trueNegative++;
				 }
				 else if (testAcc==1.0) {
					 falseNegative++;
					 
				 }
			 }
			 
			
		}
		precision = truePositive/(truePositive+falseNegative);
		return precision;
	}
	
}	


