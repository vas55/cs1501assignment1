import java.util.*;
import java.io.*;

public class DLB {
	
	public static void main(String[] args) throws IOException {
		long sumOfTime = 0; 
		String nextLetter = "";
		LinkedList dictLL = new LinkedList();

		// create dictionary DLB and user DLB
		System.out.println("Started scanning dictionary file");
		Scanner dictionary = new Scanner(new File("sample.txt"));
		String firstWord = dictionary.nextLine();
		System.out.println("Enter first word: " + firstWord);
		dictLL.addFirstWord(firstWord.toLowerCase());
		System.out.println("entered first word");
		while (dictionary.hasNext()){
			String dictionaryWord = dictionary.nextLine();
			System.out.println("Adding next word...");
			System.out.println("Word being input...: " + dictionaryWord);
			
			dictLL.add(dictionaryWord.toLowerCase());
		}
		
		dictionary.close();
		System.out.println("Done inputting!");
		
		
		// create DLB for user_history
		Scanner userHistory = new Scanner(new File("user_history.txt"));
		while (userHistory.hasNext()) {
			String userWord = userHistory.nextLine();
		}
		userHistory.close();
		
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next().toLowerCase();

		char[] w = new char[100];
		int index = 0;
		Node n = dictLL.reachLastNodeInPrefix(userInput);
		//using one down node from prefix
		//need to keep track of WordLIst index 
		int openIndex = 0;
		dictLL.search(userInput, n, w, index, openIndex);
		
		
		//create DLB for user
		//userDLB();
		//dictionaryDLB();
		//userInput();
	}
	
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
