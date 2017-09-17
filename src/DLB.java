import java.util.*;
import java.io.*;

class Node {
	int data; 
	Node next; 
	Node down; 
	
	public Node() {
		data = 0; 
		next = null;
		down = null;
	}
	
	public Node(int da, Node n, Node d, boolean isWord) {
		data = da; 
		next = n; 
		down = d; 
	}
	
	public void setNextLink(Node n) {
		next = n; 
	}
	
	public void setDownLink (Node d) {
		down = d; 
	}
	
	public Node getNextNode() {
		return next; 
	}
	
	public Node getDownNode() {
		return down; 
	}
	
	public int getData() {
		return data; 
	}
}

public class DLB {

	private Node root; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your first character: ");
		String letter = sc.next();
		if (letter.length() > 1) {
			System.out.println("Please enter one character at a time");
		}
		
		
	}

}
