package cs112projectpart;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class MainJ {
	
	

 
    private static void initAndShowGUI() {

	JFrame myFrame = new JFrame("Project 1");
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container contentPane = myFrame.getContentPane();
	  

	
	contentPane.setLayout(new FlowLayout());

	
	
	contentPane.add(new JPanel());
	
	contentPane.add(new JButton("Accuracy:  "));
	 contentPane.add(new JButton("Prescision:  "));
	//JLabel lab1 = new JLabel(null, getAccuracy() );
	myFrame.setLayout(new GridLayout(2,2));
	
	myFrame.pack();
	myFrame.setVisible(true);
    }
    
	




	public static void main(String[] args) {
		ArrayList<DataPoint> dpReadData= new ArrayList<DataPoint>();
		DummyPredictor dp = new DummyPredictor();
		
	
		
		dpReadData=dp.readData("data.txt");
		
		
		//Double x = dp.getAccuracy(dpReadData);
	
		System.out.println(dpReadData);
		
		dp.getAccuracy(dpReadData);
		dp.getPrecision(dpReadData);
		
		
		
	
		
	

		
	
		 SwingUtilities.invokeLater(
		          new Runnable() { public void run() { initAndShowGUI(); } }
		        );
		

	
			
			
			

			


	}

}
