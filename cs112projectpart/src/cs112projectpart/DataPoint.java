package cs112projectpart;

public class DataPoint {
	private double f1;
	private double f2;
	private int label;
	private Boolean isTest;
	
	
	public DataPoint(double f1, double f2, int label, Boolean isTest) {
		
		this.f1 = f1;
		this.f2 = f2;
		this.label = label ;
		this.isTest = false;
		
	}
	
	public DataPoint () {
		this.f1 = 0;
		this.f2 = 0;
		this.label = 0 ;
		this.isTest = false;
		
	}


	public double getF1() {
		return f1;
	}


	public void setF1(double f1) {
		this.f1 = f1;
	}


	public double getF2() {
		return f2;
	}


	public void setF2(double f2) {
		this.f2 = f2;
	}


	public int getLabel() {
		return label;
	}


	public void setLabel(int label) {
		this.label = label;
	}


	public Boolean getIsTest() {
		return isTest;
	}


	public void setIsTest(Boolean isTest) {
		this.isTest = isTest;
	}

}

	