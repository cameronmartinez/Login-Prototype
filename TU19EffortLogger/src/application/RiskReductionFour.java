package application;

import java.util.LinkedList;

public class RiskReductionFour{
	
	public static LinkedList<Integer>[] hashTable; // hash table to store hashed credentials
	
	public RiskReductionFour() {
		hashTable = new LinkedList[11];
		
		for (int i = 0; i < 11; i++) {
			hashTable[i] = new LinkedList<>();
		}
	}
	
	public static int[] hashCredentials(String username, String password) { // takes the username and password as inputs
		
		int usernameHash = 0;
		int passwordHash = 0;
		
		for (int i = 0; i < username.length(); i++) { // simple hash code for username
			usernameHash = usernameHash + username.charAt(i);
		}
		
		for (int i = 0; i < password.length(); i++) { // simple hash code for password
			passwordHash = passwordHash + password.charAt(i);
		}
		
		int slot = (usernameHash + passwordHash) % 11;
		int[] result = new int[]{slot, usernameHash, passwordHash};
		
		return result;
	}
	
	public static void insert(String username, String password) { // inserts credentials into hash table
		
		int[] hashResult = hashCredentials(username, password);
		System.out.println("What was saved : " + hashResult[0] + ", " + hashResult[1] + ", " + hashResult[2]);
		
		hashTable[hashResult[0]].add(hashResult[1] + hashResult[2]);
	}
	
	// this search method is the method used for checking if the encrypted credentials are valid
	// this allows us to align with our design that prioritizes security and privacy for the application
	public static boolean search(String username, String password) { // searches for hashed data
		
		int[] hashResult = hashCredentials(username, password);
		
		if (hashTable[hashResult[0]].contains(hashResult[1] + hashResult[2])) {
			System.out.println("What was found : " + hashResult[1] + ", " + hashResult[2]);
			return true;
		} else {
			System.out.println("Nothing found");
			return false;
		}
	}
	
	
	
	
}