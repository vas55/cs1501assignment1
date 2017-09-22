import java.util.*;
import java.io.*;

public class DLB {

	long startTime; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create dictionary DLB and user DLB
		//userDLB();
		//dictionaryDLB();
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your first character: ");
		String letter = sc.next();
		if (!letter.matches("[a-zA-Z]+")){
			System.out.println("Please enter only letters");
		}
		else if (letter.length() > 1 || letter.length() == 0) {
			System.out.println("Please enter one character at a time");
		}
		else {
			//startTime = System.nanoTime();
			//search userDLB
			//searchUserDLB();
			//search dictionaryDLB
			//searchDictionaryDLB();
			System.out.println("Seems fine for now");
		}
		
	}

}
