import java.util.*;
import java.io.*;

public class DLB {
	
	public static void main(String[] args) throws IOException {
		long sumOfTime = 0; 
		String nextLetter = "";
		LinkedList dictLL = new LinkedList();
		LinkedList userDLB = new LinkedList();
		char[] w = new char[100];
		int index = 0;
		
		// create dictionary DLB and user DLB
		System.out.println("Started scanning dictionary file");
		Scanner dictionary = new Scanner(new File("dictionary.txt"));
		String firstWord = dictionary.nextLine();
		//System.out.println("Enter first word: " + firstWord);
		dictLL.addFirstWord(firstWord.toLowerCase());
		//System.out.println("entered first word");
		while (dictionary.hasNext()){
			String dictionaryWord = dictionary.nextLine();
			//System.out.println("Adding next word...");
			//System.out.println("Word being input...: " + dictionaryWord);
			
			dictLL.add(dictionaryWord.toLowerCase());
		}
		
		dictionary.close();
		System.out.println("Done inputting dictionary!");
				
		// create DLB for user_history
		Scanner userHistory = new Scanner(new File("user_history.txt"));
		while (userHistory.hasNext()) {
			String userWord = userHistory.nextLine();
			userDLB.add(userWord.toLowerCase());
		}
		userHistory.close();
		System.out.println("Done inputting user_history!");

		System.out.println("Enter your character: ");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine().toLowerCase();
		// user will input by one character, so we will enter the user input into an array and convert to a full string when searching
		// DO THIS
		
		//System.out.println("userInput=" + userInput);
		if (userInput.equals("$")) {
			System.out.println("End of word");
		}
		else if (userInput.equals("!")){
			System.out.println("End of program. Bye");
		}
		else {
			Node n = dictLL.reachLastNodeInPrefix(userInput);
			//using one down node from prefix
			//need to keep track of WordLIst index 
			if (n == null) {
				//System.out.println("No suggestions");
				//add to user history directly
				//DO THIS STILL
			}else {
				dictLL.search(userInput, n.down, w, index);
			}
	
			int count = 0;
			String[] wordList = dictLL.returnWordList();
			for (int i=0; i<wordList.length; i++) {
				
				if (count < 5){
					try {
						if (wordList[i] == null) {
							break;
						}
						else {
							//check if contained in user history
							String outputSuggestion = wordList[i].replaceAll("\0", "");
							System.out.println(userInput + outputSuggestion);
							count++;
						}
					}catch (NullPointerException e) {
						System.out.println("");
					}
				}
				else {
					break;
				}
			} // end for loop
		} // end else 
		System.out.println("Done running...");
		//create DLB for user
		//userDLB();
		//dictionaryDLB();
		//userInput();
	} // end main
	
	public static void userInput () throws IOException {
		Scanner sc = new Scanner(System.in);
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		System.out.println("Enter your character: ");
		String letter = sc.next();
		System.out.println("Letter equals = " + letter);
		/*if (letter.length() > 1 || letter.length() == 0) {
			System.out.println("Please enter one character at a time");
		}
		else */
		if (letter == "$") {
			System.out.println("Bye");
			bw.close();
			return;
		}
		//if end of word then put new line in document and close
		else if (letter == "!"){
			bw.newLine();
			bw.close();
			System.out.println("End of word");
		}
		else {
			fw = new FileWriter("user_history.txt");
			bw = new BufferedWriter(fw);
			bw.write(letter);
			System.out.println("Entered letter into user history");
		}
		
	}

}
