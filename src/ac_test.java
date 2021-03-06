import java.util.*;
import java.io.*;

public class ac_test {
	
	static FileWriter fw = null;
	static BufferedWriter bw = null;
	
	public static void main(String[] args) throws IOException {
		long sumOfTime = 0; 
		long startTime = 0; 
		long estimatedTime = 0; 
		//String nextLetter = "";
		LinkedList dictLL = new LinkedList();
		LinkedList userDLB = new LinkedList();
		char[] w = new char[100];
		int index = 0;
		File file = new File("user_history.txt");
		  
		//Create the file
		if (file.createNewFile()){
			//System.out.println("User History file is created!");
		}else{
			//System.out.println("User history file already exists.");
		}
		
		// create dictionary DLB and user DLB
		//System.out.println("Started scanning dictionary file");
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
		//System.out.println("Done inputting dictionary!");
		
		System.out.println("Enter your character: ");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine().toLowerCase();
		
		// create DLB for user_history
		//System.out.println("Printing user_history file if prefix matches...");
		Scanner userHistory = new Scanner(new File("user_history.txt"));
		System.out.println("Printing out user_history suggestions...");
		startTime = System.nanoTime();
		while (userHistory.hasNext()) {
			String userWord = userHistory.nextLine();
			userDLB.add(userWord.toLowerCase());
			userInput = userInput.replace("$", "");
			if (userWord.startsWith(userInput)) {
				System.out.println(userWord);
			}
			userInput = userInput + "$";
		}
		userHistory.close();
		//System.out.println("Done inputting user_history!");

		
		//System.out.println("Enter your character: ");
		//Scanner sc = new Scanner(System.in);
		//String userInput = sc.nextLine().toLowerCase();
		// user will input by one character, so we will enter the user input into an array and convert to a full string when searching
		// DO THIS
		
		//System.out.println("userInput=" + userInput);
		if (userInput.contains("$")) {
			if (userInput.contains("!")){
				estimatedTime = System.nanoTime() - startTime;
				double estimatedTimeInSeconds = estimatedTime/(Math.pow(10, 9));
				
				System.out.println("Average time: (" + estimatedTimeInSeconds + " s)" );
				System.out.println("End of program");
				System.exit(0);
			}
			else {
				enterPrefixIntoUserApproach(userInput);
				userInput = userInput.replace("$", "");
			}
			//System.out.println("End of word");
			//System.out.println("Enters here...");
			//System.out.println("userInput = " + userInput);
			

		}
		
		if (userInput.contains("!")){
			System.out.println("End of program. Bye");
		}
		else {
			//System.out.println("Enters here...");
			if (userInput.contains("$")) {
				userInput.replaceAll("$", "");
			}
			Node n = dictLL.reachLastNodeInPrefix(userInput);
			//using one down node from prefix
			//need to keep track of WordLIst index 
			System.out.println("Printing out dictionary suggestions...");

			if (n == null) {
				System.out.println("No dictionary suggestions");
				//enterPrefixIntoUserApproach(userInput);
				
			}
			else {
				dictLL.search(userInput, n.down, w, index);
			}
			int count = 0;
			String[] wordList = dictLL.returnWordList();
			for (int i=0; i<wordList.length; i++) {
				//only 5 suggestions from the dictionary
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
		estimatedTime = System.nanoTime() - startTime;
		double estimatedTimeInSeconds = estimatedTime/(Math.pow(10, 9));
		System.out.println("(" + estimatedTimeInSeconds + " s)");
		System.out.println("Done running...");
		//create DLB for user
		//userDLB();
		//dictionaryDLB();
		//userInput();
	} // end main
	
	public static void enterPrefixIntoUserApproach(String word) throws IOException{
		//the word will have a $ at the end because that's the last input
		word = word.replace("$", "");
		//System.out.println("Entering prefix user approach...");
		fw = new FileWriter("user_history.txt", true);
		bw = new BufferedWriter(fw);
	
				bw.write(word);
				bw.newLine();
				//System.out.println("Entered letter into user history");
				bw.close();
			
		
	}
	
}
