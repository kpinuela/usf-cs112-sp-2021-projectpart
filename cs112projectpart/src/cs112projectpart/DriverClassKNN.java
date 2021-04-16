package cs112projectpart;
import java.util.*;
import javax.swing.*;
import java.awt.*;



import java.io.*;

public class DriverClassKNN {
	private static double driverAcc=0.0;
	private static double driverPrec=0.0;
	
	

		
		

	public static void main(String[] args) {
		
		
		System.out.println("Enter an Odd Integer: ");
		Scanner inputScan= new Scanner(System.in);
		int k = inputScan.nextInt();
		while(k>1 && k%2==0) {
			System.out.println("Invalid please enter another ");
			k= inputScan.nextInt();
		
			
		}
		inputScan.close();
		
	
		
		
		
		Predictor KNNPredictor = new KNNPredictor(k);
		ArrayList<DataPoint> driverData = new ArrayList<DataPoint>();
		driverData = KNNPredictor.readData("titanic.csv");  
		driverAcc=KNNPredictor.getAccuracy(driverData)*100;
		driverPrec=KNNPredictor.getPrecision(driverData)*100;	
		System.out.println(driverAcc);
		
		
		SwingUtilities.invokeLater(
		          new Runnable() { public void run() { 
		        	  initAndShowGUI(); } }
		        );
		

	}





	public static void initAndShowGUI() {
		JFrame frame= new JFrame();
		frame.setTitle("Kyle's Project 2");
	frame.setSize(500,500);
	Container contentpane =frame.getContentPane();
	contentpane.setLayout(new GridLayout(1,1));
	contentpane.setPreferredSize(new Dimension(400,400));
	
	String driverAcstr= String.valueOf(driverAcc);
	String driverPstr= String.valueOf(driverPrec);
	


	
	
	
	JButton aButton = new JButton("Accuracy:"+  driverAcstr);
	JButton pButton = new JButton("Precision: "  +  driverPstr   );
	
	contentpane.add(aButton);
	contentpane.add(pButton);
	frame.pack();
	frame.setVisible(true);
	
	
	
	
	
		// TODO Auto-generated method stub
		
	}

}
