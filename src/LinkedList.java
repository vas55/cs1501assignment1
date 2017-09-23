
public class LinkedList {
	
	Node root; 
	
	//constructor
	//create null root ?
	public LinkedList() {
		root = new Node(); 
	}
	
	public void addFirstWord(String s) {
		char[] wordArray = s.toCharArray();
		System.out.println("In base case...");
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
	public void add (String s) {
		//base case where I just put the first word into the dlb straight in 
		// if root is null
		char[] wordArray = s.toCharArray();
		//System.out.println("Next node value: " + root.next);
		//System.out.println("Down node value: " + root.down);
		//System.out.println("Root node value: " + root);
		addAnyOtherWord (wordArray, root);
		
	}
	
	//this function will add a word into the DLB 
	
	private void addAnyOtherWord (char[] chars, Node root) {
		//start at root
		Node current = root;
		System.out.println("In LinkedList addanyotherword...");
		System.out.println("current Node value: " + current);
		System.out.println("Next node value: " + current.next);
		System.out.println("Down node value: " + current.down);
		System.out.println("Root node value: " + root);
		
		for (int i = 0; i<chars.length; i++) {
			System.out.println("NEXT LETTER IN WORD");
			//if value of data is the same as value in character
			System.out.println("getData:" + current.getData());
			System.out.println("index i = " + i);
			System.out.println("chars[" + i + "]: " + chars[i]);
			if (current.data == chars[i]) {
				//if it equals the same then move down
				System.out.println("They equal each other");
				if (current.down == null) {
					//if end of word
					System.out.println("characters equal each other and down node is null");
					if (i == chars.length-1){
						//insert flag under current word
						System.out.println("Inputting flag...");
						Node d = new Node ('^');
						d = current.down;
					}
					else {
						Node d = new Node (chars[i+1]);
						current.down = d;
						System.out.println("creating down node: " + d.data);
						System.out.println("checking that down node equals: " + current.down.data);
						current = current.down;
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
				System.out.println("They do not equal each other");
				//is next node null? if so then put value into next node
				if (current.next == null) {
					//create node and add value
					System.out.println("create next node");
					Node n = new Node(chars[i]);
					current.next = n; 
					current = current.next;
					
					//need to backtrack array though because I'm now pointing at the newly entered letter. 
					//If I do that then my logic would put the next letter as a next node 
					//instead of a down node
					i--;
				}
				else {
					//move to the next node
					System.out.println("next node value: " + current.next.data);
					System.out.println("just move to the next node");
					current = current.next;
					i--;
				}
			} // end else if 
			
		} // end for loop
		
		//need to add logic where we add a symbol in the down node to signify if it is a completed word
		
	} //end private addAnyOtherWord function
	
}