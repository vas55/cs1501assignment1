public class Node {
	public char data; 
	public Node next = null; 
	public Node down = null; 
	
	
	public Node(char d) {
		this.data = d;
	}
	
	public Node() {
	}
	
	//make next node
	public void makeNextNode(Node n){
		this.next = n;
	}	
	//make down node
	public void makeDownNode(Node d) {
		this.down = d; 
	}
	
	//get the value that's below the specified node
	public Node getDownNode(Node d) {
		return down; 
	}
	//get the value of the node of the next
	public Node getNextNode(Node n) {
		return next;
	}
	//get data of node
	public char getData() {
		return this.data; 
	}
	
	public void setData(char d) {
		this.data = d;
	}
}

