package cs112projectpart;

public class DataPoint {
	double f1;
	double f2;
	String label;
	Boolean isTrue;
	
	
	public DataPoint(double f1, double f2, String label, Boolean isTrue) {
		
		this.f1 = f1;
		this.f2 = f2;
		this.label = label;
		this.isTrue = isTrue;
		
	}
	
	@Override
	public String toString() {
		return "DataPoint [f1=" + f1 + ", f2=" + f2 + ", label=" + label + ", isTrue=" + isTrue + "]";
	}

	public DataPoint() {
		this.f1=0;
		this.f2=0;
		this.label=null;
		this.isTrue= null;
		
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
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Boolean getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(Boolean isTrue) {
		this.isTrue = isTrue;
		
		
	}
	

}
