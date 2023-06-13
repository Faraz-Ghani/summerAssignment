package summerAssignment;

public class Queue {
	public Node head;
	Node tail;
	int count=0;
	public void EnQueue(int year,double mag,String country) {
		if(head==null) {
		head=tail=new Node(year,mag,country);
		}
		else {
			tail.next=new Node(year,mag,country);
			tail = tail.next;
		}
		count++;
	}
	
	public void EnQueue(Node temp) {
		if(head==null) {
		head=tail=temp;
		}
		else {
			tail.next=temp;
			tail = tail.next;
		}
		count++;
	}
	
	public Node DeQueue() {
		if(head==null) {
			return null;
		}
		else {
			Node temp=head;
			head=head.next;
			return temp;
		}
	}
	
	public void PrintAll() {
		for(Node temp=head; temp!=null;temp=temp.next) {
			System.out.println(temp);
		}
	}
	
	public void sort() {
		Node[] tempArr = new Node[count];
		int i=0;
		for(Node temp = head;temp.next!=null;temp=temp.next,i++) {
			tempArr[i] = temp;
		}
		
	}
	public static void BubbleSort1D(Node[] Nodes) {
		Node temp=null;
		
		for (int i=0; i<Nodes.length-1;i++) {
			for (int j=0 ;j<Nodes.length-1-i;j++){
				
				if(Nodes[j].Year>Nodes[j+1].Year)
				{		temp=Nodes[j+1];
						Nodes[j+1]=Nodes[j];
						Nodes[j]=temp;
				}	
			}			
		}
	}
}
