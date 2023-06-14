package summerAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class app {
	public static void main( String[] args ) throws IOException
    {	
		Queue data = new Queue();//Main Queue
		Queue BiggestEarthquakes = new Queue();//Problem 1
    	Stack[] CountryStack = new Stack[8];   //Problem 2
    	LinkedList Above5Magnitude = new LinkedList(); //Problem 3
    	//Adding Data
		String path = "C:\\Users\\faraz\\OneDrive\\Desktop\\summerAssignment\\dataset-PBL.xlsx";
    	
    	File file = new File(path);
    	
    	FileInputStream input = new FileInputStream(file);
    	
    	XSSFWorkbook workbook = new XSSFWorkbook(input);
        
    	XSSFSheet sheet = workbook.getSheetAt(0);
    	
    	int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
    	
    	//for rows
    	for(int i=1;i<=rowcount;i++) {
    		
    		data.EnQueue((int)sheet.getRow(i).getCell(0).getNumericCellValue(),	//year
    				sheet.getRow(i).getCell(2).getNumericCellValue(),  			//magnitude
    				sheet.getRow(i).getCell(1).getStringCellValue());			//Country
    		}
    	
    	
    	System.out.println("Solving Problem One: Biggest Earthquakes between 2009 and 2013");
    	//Problem 1 Output
    	BiggestEarthquakes=BiggestEarthQuakeSort(data);
    	 System.out.println();
         
    	BiggestEarthquakes.PrintAll();
    	System.out.println();
    	System.out.println();
    	
    	
    	System.out.println("Solving Problem Two: Recent 5 Earthquakes from Each Country");
    	//Problem 2 Output
    	System.out.println();
         
    	CountryStack=RecentEarthquakes(data);
    	
    	System.out.println();
    	
    	System.out.println("Solving Problem Three: Most Recent Earthquakes above 5 Magnitude");
    	//Problem 3 Ouput
    	Over5Magnitude(CountryStack);
    }

	
	//Problem 1 Solution
	private static Queue BiggestEarthQuakeSort(Queue data) {
		Queue tempQueue = new Queue();//temp Queue
		Node nullNode = new Node(0,0,"");//empty node model
		Node[] years= {nullNode,nullNode,nullNode,nullNode,nullNode};//filling with empty nodes
		
		
		for(Node temp = data.head;temp.next!=null;temp=temp.next) {//go through entire data
		
			//check year and store in that year
			switch(temp.Year) {
			case 2009:
				if(temp.Magnitude>years[0].Magnitude) {
					years[0]=temp;}
				break;
			case 2010:
				if(temp.Magnitude>years[1].Magnitude) {
					years[1]=temp;}
				break;
			case 2011:
				if(temp.Magnitude>years[2].Magnitude) {
					years[2]=temp;}
				break;
			case 2012:
				if(temp.Magnitude>years[3].Magnitude) {
					years[3]=temp;}
				break;
			case 2013:
				if(temp.Magnitude>years[4].Magnitude) {
					years[4]=temp;}
				break;
			}		
		}
		//add from array into a queue
		for(Node i: years) {
			tempQueue.EnQueue(i.Year,i.Magnitude,i.Country);
		}
		
		return tempQueue;
}

	//Problem 2 Solution
	private static Stack[] RecentEarthquakes(Queue data) {
		Stack[] stck = new Stack[8];
		//Initialize Stack array
		stck[0] = new Stack("Japan");
		stck[1] = new Stack("Russia");
		stck[2] = new Stack("United States");
		stck[3] = new Stack("Greece");
		stck[4] = new Stack("Australia");
		stck[5] = new Stack("United Kingdom");
		stck[6] = new Stack("France");
		stck[7] = new Stack("Pakistan");
		
		for(Node temp = data.head;temp!=null;temp=temp.next) {
			if(temp.Country.equalsIgnoreCase("Japan")) {
				stck[0].push(temp.Year, temp.Magnitude, temp.Country);
			}
			else if(temp.Country.equalsIgnoreCase("Russia")) {
				stck[1].push(temp.Year, temp.Magnitude, temp.Country);
			}
			else if(temp.Country.equalsIgnoreCase("United States")) {
				stck[2].push(temp.Year, temp.Magnitude, temp.Country);
			}
			else if(temp.Country.equalsIgnoreCase("Greece")) {
				stck[3].push(temp.Year, temp.Magnitude, temp.Country);
			}
			else if(temp.Country.equalsIgnoreCase("Australia")) {
				stck[4].push(temp.Year, temp.Magnitude, temp.Country);
			}
			else if(temp.Country.equalsIgnoreCase("United Kingdom")) {
				stck[5].push(temp.Year, temp.Magnitude, temp.Country);
			}
			else if(temp.Country.equalsIgnoreCase("France")) {
				stck[6].push(temp.Year, temp.Magnitude, temp.Country);
			}
			else if(temp.Country.equalsIgnoreCase("Pakistan")) {
				stck[7].push(temp.Year, temp.Magnitude, temp.Country);
			}	
		}
		

		System.out.println("The Following are the 5 most recent earthquakes in every Country ");
		for(Stack temp : stck) {
			System.out.println("For "+temp.Country+" : ");
			temp.printRecentEarthquakes();
		}
		
		return stck;
	}

	private static LinkedList Over5Magnitude(Stack[] Stack) {
		LinkedList LL= new LinkedList();
		
		for (Stack stack : Stack) {
            Node topNode = stack.peek();
             if (topNode != null && topNode.Magnitude > 5) {
                LL.addAtStart(topNode.Year,topNode.Magnitude,topNode.Country);
            }
        }
		
		System.out.println();
        // Display the linked list of most recent earthquakes
        System.out.println("The Most Recent Earthquakes Above Magnitude 5:");
        
        for (Node node =LL.head;node!=null;node=node.next) {
             	System.out.println(node);
            
        }
		
		return LL;
	}
}