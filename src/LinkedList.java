
public class LinkedList {
	
	Node root = null; 
	
	public void add (String s) {
		//base case where I just put the first word into the dlb straight in 
		// if root is null
		char[] wordArray = s.toCharArray();
		if (root == null) {
			//puts first letter of FIRST WORD into the array
			root = new Node(wordArray[0]);
			Node curr = root; 
			//build the word all the way down because if node is null then nothing is below it
			for (int i = 1; i < wordArray.length; i++) {
				Node d = new Node (wordArray[i]);
				curr.makeDownNode(d);
				curr = curr.down;
			}
		}
		//if not first word then just add next word. Put string from text into function
		else {
			addAnyOtherWord (wordArray, root);
		}
	}
	
	//this function will add a word into the DLB 
	private void addAnyOtherWord (char[] chars, Node root) {
		//start at root
		Node current = root;

		for (int i = 0; i<chars.length; i++) {
			
			//if value of data is the same as value in character
			if (current.getData() == chars[i]) {
				//if it equals the same then move down
				if (current.down == null) {
					//if end of word
					if (i == chars.length-1){
						//insert flag under current word
						Node d = new Node ('^');
						current.down = d;
					}
					else {
						Node d = new Node (chars[i+1]);
						current.down = d;
						current.down = current;
					}
					//idk if i need this below
					//don't need this because i'm losing a letter when going down
					//i--;
				}
				if (current.down != null) {
					current = current.down;
				}
			}
			else if (current.getData() !=chars[i]) {
				//is next node null? if so then put value into next node
				if (current.next == null) {
					//create node and add value
					Node n = new Node(chars[i]);
					current.next = n; 
					current.next = current;
					
					//need to backtrack array though because I'm now pointing at the newly entered letter. 
					//If I do that then my logic would put the next letter as a next node 
					//instead of a down node
					i--;
				}
				else if (current.next != null){
					//move to the next node
					current = current.next;
					i--;
				}
			} // end else if 
		} // end for loop
		//need to add logic where we add a symbol in the down node to signify if it is a completed word
		
	} //end private addAnyOtherWord function
}
