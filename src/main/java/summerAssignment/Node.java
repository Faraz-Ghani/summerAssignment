package summerAssignment;

public class Node {

	Node next = null;
	String Country;
	int Year;
	double Magnitude;
	
	Node(int year,double magnitude,String country){
		Year=year;
		Magnitude=magnitude;
		Country=country;
	}
	
	@Override
	public String toString() {
		String string = "In "+Year+" "+Country+" Suffered an earthquake of magnitude "+Magnitude; 
		return string;
	}
}
