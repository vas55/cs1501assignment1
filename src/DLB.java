import java.util.*;
import java.io.*;

public class DLB {
	
	public static void main(String[] args) throws IOException {
		long sumOfTime = 0; 
		String nextLetter = "";
		LinkedList dictLL = new LinkedList();

		// create dictionary DLB and user DLB
		System.out.println("Started inputting dictionary file into DLB");
		Scanner dictionary = new Scanner(new File("dictionary.txt"));
		while (dictionary.hasNext()){
			String dictionaryWord = dictionary.nextLine();
			dictLL.add(dictionaryWord);
			System.out.println("Inputting dictionary.txt file into DLB...");
		}
		System.out.println("Done inputting!");
		
		
		// create DLB for dictionary
		Scanner userWord = new Scanner(new File("user_history.txt"));
		while (userWord.hasNext()) {
			String line = userWord.nextLine();
		}
		
		
		
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
