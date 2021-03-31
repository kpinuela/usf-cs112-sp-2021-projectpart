package cs112projectpart;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public abstract class Predictor {
	abstract ArrayList<DataPoint> readData(String filename) ;
	abstract String test(DataPoint data);
	abstract Double getAccuracy (ArrayList <DataPoint> data);
	abstract Double getPrecision (ArrayList<DataPoint> data);
	ArrayList<DataPoint> readData(File filename) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
