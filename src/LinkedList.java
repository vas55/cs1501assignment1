import java.util.Arrays;


public class LinkedList {
	
	Node root; 
	
	//constructor
	//create null root ?
	public LinkedList() {
		root = new Node(); 
	}
	
	
	// *******************************************************
	// *****************ADD FUNCTION **********************
	// *******************************************************
	public void addFirstWord(String s) {
		char[] wordArray = s.toCharArray();
		//System.out.println("In base case...");
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
		//System.out.println("In LinkedList addanyotherword...");
		//System.out.println("current Node value: " + current);
		//System.out.println("Next node value: " + current.next);
		//System.out.println("Down node value: " + current.down);
		//System.out.println("Root node value: " + root.data);
		
		for (int i = 0; i<chars.length; i++) {
			//System.out.println("NEXT LETTER IN WORD");
			//if value of data is the same as value in character
			//System.out.println("getData:" + current.getData());
			//System.out.println("index i = " + i);
			//System.out.println("chars[" + i + "]: " + chars[i]);
			if (current.data == chars[i]) {
				//if it equals the same then move down
				//System.out.println("They equal each other");
				if (current.down == null) {
					//if end of word
					//System.out.println("characters equal each other and down node is null");
					if (i == chars.length-1){
						//insert flag under current word
						System.out.println("Inputting flag...");
						Node d = new Node ('^');
						current.down = d;
					}
					else {
						Node d = new Node (chars[i+1]);
						current.down = d;
						//System.out.println("creating down node: " + d.data);
						//System.out.println("checking that down node equals: " + current.down.data);
						current = current.down;
					}
					//idk if i need this below
					//don't need this because i'm losing a letter when going down
					//i--;
				}
				if (current.down != null) {
					//System.out.println("They equal each other and move down");
					current = current.down;
				}
			}
			
			else if (current.getData() !=chars[i]) {
				//System.out.println("They do not equal each other");
				//is next node null? if so then put value into next node
				if (current.next == null) {
					//create node and add value
					//System.out.println("create next node");
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
					//System.out.println("next node value: " + current.next.data);
					//System.out.println("just move to the next node");
					current = current.next;
					i--;
				}
			} // end else if 
			
		} // end for loop
		
		//need to add logic where we add a symbol in the down node to signify if it is a completed word
		
	} //end private addAnyOtherWord function
	
	
	// *******************************************************
	// *****************SEARCH FUNCTION **********************
	// *******************************************************
	//WordList array
	//capable of storing more than 5 words because there's a chance the word matches the user input so we need to move on to the next name
	String[] WL = new String[100];
	int openIndex = 0;
	
	public String returnSuggestions() {
		String wordList = Arrays.toString(WL);
		wordList = wordList.replaceAll("\0", "");
		System.out.println("wordList: " + wordList);
		return wordList;
	}
	
	public String[] returnWordList() {
		return WL;
	}
	
	public void search(String word, Node n, char[] w, int index) {
		// does it have a carrot? AND the string of characters in the char array is not in my large Word array?
		// then output the word
		String charArrayToString = new String(w);
		charArrayToString = charArrayToString.replaceAll("\0", "");
		//using down node from current
		System.out.println("Index = " + index);
		System.out.println("OpenIndex: " + openIndex);
		System.out.println("Found last node value is: " + n.data);
		// need to start looking for words by making sure we're at the last node of the prefix
		// is this correct?!!?
		// you want to pass the down node into carrot to see if it has a carrot. It will then check 
		// other sibling nodes if there is a carrot
		// if no carrot symbol then it will return false
		// if it returns true then we know it is a word and must be added to the WordList array
		// secondary check -- if it is already in word list array then move on to other words
		// -- this may mean that we fall backwards in a previous recursive step
		
		System.out.println("charArrayToString: " + charArrayToString);
		for (int i = 0; i<openIndex; i++) {	
			String wordList = new String(WL[i]).replaceAll("\0", "");
			System.out.println("WL[openIndex]: " + wordList + " at openIndex: " + i);
		}
		System.out.println("---------------------------------------------------");
		
		if (n.data != '^' && hasCarrot(n.down) && checkWordList(WL, openIndex, w)) {
			System.out.println("Has carrot and adding to word list");
			System.out.println("Before inputting data into w array");
			System.out.println("w[index]: " + w[index]);
			System.out.println("n.data: " + n.data);
			w[index] = n.data;
			System.out.println("After inputting data into w array");
			System.out.println("w[index]: " + w[index]);
			System.out.println("n.data: " + n.data);
			WL[openIndex] = new String(w);
			System.out.println("WL[openIndex]: " + WL[openIndex]);
			openIndex++;
		}

				
		//if the node is not null && next isn't null OR the node itself isn't a carrot
		if ((n.down !=null) && ((n.down.getData() != '^') || (n.down.next != null))) {
			char[] newArray = w.clone();
			System.out.println("cloning array...");
			newArray[index] = n.data;
			System.out.println("newArray[index]: " + newArray[index]);
			System.out.println("n.data: " + n.data);
			index++;
			System.out.println("Moving down...");
			search(word,n.down,newArray,index);
		}
		// if the next one is not null then go to the next one
		if (n.next != null) {
			System.out.println("Moving next...");
			search(word,n.next,w,index);
		}
		
	}
	public boolean checkWordList (String[] wordList, int openIndex, char[] charArray) {
		String word = new String(charArray);
		word = word.replace("\0", "");
		System.out.println("wordCheck: " + word);
		for (int i = 0; i < openIndex; i++) {
			if (word == wordList[i]) {
				return false;
			}
		}
		return true;
	}
	
	public Node reachLastNodeInPrefix (String s) {
		char[] prefix = s.toCharArray();
		Node current = root;
	
		System.out.println("Root value: " + current.data);
		for (int i = 0; i<prefix.length; i++) {
			System.out.println("Comparing current.data: "+ current.data + " to prefix["+ i + "]: " + prefix[i]);
			System.out.println(current.data == prefix[i]);
			if (current.data == prefix[i]) {
				//move down to see if it continues to be a prefix
				if (i == prefix.length-1){
					return current;
				}
				else {
					System.out.println("They equal!");
					System.out.println("Moving down...");
					current = current.down;
				}
				//else{
				//	return current;
				//}
				System.out.println("Current node value: " + current.data);
			}
			else if (current.down == null) {
				// down is null, meaning not a prefix
				break;
			}
			else if ((current.data != prefix[i]) && (current.next != null)) {
				System.out.println("Not equal to each other");
				System.out.println("Current node value: " + current.data);
				System.out.println("Moving next...");
				current = current.next;
				i--;
				System.out.println("Current node value: " + current.data);
	
			}
			else if ((current.data !=prefix[i]) && (current.next == null)) {
				System.out.println("The prefix at index does not equal the current node data, and next is null");
				//if doesn't exist, go to next and point it to a null node
				try {
					current = current.next;
				}catch (NullPointerException e){
					System.out.println("No suggestions");
					break;
				}
			}
		}
		return current;
	}
	
	//does the node 
	private boolean hasCarrot(Node curr) {
		System.out.println("In hasCarrot...");
		if (curr.data == '^') {
			System.out.println("In carrot, return true");
			return true;
		}
		else if (curr.next != null) {
			System.out.println("In hasCarrot but looking next nodes to see if there is carrot");
			return hasCarrot(curr.next);
		}
		else {
			System.out.println("returns false");
			return false;
		}
	}
	
}