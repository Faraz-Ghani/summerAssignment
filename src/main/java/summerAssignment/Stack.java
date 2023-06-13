package summerAssignment;

public class Stack {
		Node top;
		int size;
		String Country;
		
		public Stack(String country) {
			top =null;
			size = 0;
			Country=country;
		}
		public void push (int year,double magnitude,String country ) {
			Node node = new Node(year, magnitude, country);
			node.next=top;
			top = node;
			size++;
		}
		
		public void push(Node newNode) {
			newNode.next=top;
			top = newNode;
			size++;
		}
		public Node pop () {
			if(isempty()) {
				return null;
			}
			else {
			Node temp= top;
			top = top.next;
			size--;
			return temp;
		}}
		
		public int size() {
			return size;
		}
		
		public Node peek() {
			if(isempty()) {
				return null;
			}
			else {
				return top;		
			}
		}
		
		public boolean isempty() {
			return top == null;
		}
		
		  public void printRecentEarthquakes() {
	        if (isempty()) {
	            System.out.println("No recent earthquakes in " + Country);
	        } else {
	        	Stack tempStack = new Stack(Country);
	        	tempStack.top=top;
	            for(int i=1;i<6;i++) {
	            	if(tempStack.peek()!=null) {
	            		System.out.println(i+". "+tempStack.pop());
	            	}
	            	else {
	            		System.out.println(i+". No earthquake");
	            	}
	            }
	        }
		  }
		@Override
		public String toString() {
			String str = "[";
			Stack temp = new Stack(Country);
			temp.top=this.top;
			int Size = size;
			for(int i =0 ; i<Size;i++) {
				str=str+" "+temp.pop();
			}
			str=str+" ]";
			return str;
		}
		
	}


