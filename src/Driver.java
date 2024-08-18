// -----------------------------------------------------
// Assignment (3)
// Question: (1)
// Written by: (Sohaib Daami)
// -----------------------------------------------------

//this program creates a navigable database of topics with different words related to each topic for Mrs.Jones to use

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
* The Driver class contains the main method as well as all the other methods
* needed to create the menu
* 
*
* @author Sohaib Daami
* @version 1.0
* @see String
*/
public class Driver {

	static DoublyLinkedList vocabList = new DoublyLinkedList();
	
	
	public static void main(String[] args) {
		
		
		Scanner keyin = new Scanner(System.in);
		String filePath;
		int choice;
		int topic;
		String newTopic;
		
		choice = display();
		while (true) {
			switch (choice) {
			case 0:
				System.out.println("have a good Day!");
				System.exit(0);
				break;
			case 1:
				display1(vocabList);
				choice = display();
				break;
			case 2:
				System.out.println("------------------------------"+"\n"
						+ "Pick a topic\n"+
						"------------------------------");
				if (vocabList.isEmpty()) {
					System.out.println("there are no topics yet");
				}
				else {
					vocabList.printListD();
				}
				System.out.print("0 Exit\n"
						+ "------------------------------\n"
						+ "Enter Your Choice: ");
				
				topic = readInt(keyin);
				if (topic == 0) {
					choice = display();
					break;
				}
				System.out.print("Enter topic name : ");
				keyin.nextLine();
				newTopic = keyin.nextLine();
				System.out.println("Enter a word - to quit press Enter: ");
				SinglyLinkedList newWords1 = new SinglyLinkedList();
				while (true) {
					String word = keyin.nextLine();
					if (word.isEmpty()) {
						break;
					}
					newWords1.add(word);
					
				}
				vocabList.addBefore(topic, new Vocab(newTopic, newWords1));
				choice = display();
				break;
			case 3:
				System.out.println("------------------------------"+"\n"
						+ "Pick a topic\n"+
						"------------------------------");
				if (vocabList.isEmpty()) {
					System.out.println("there are no topics yet");
				}
				else {
					vocabList.printListD();
				}
				System.out.print("0 Exit\n"
						+ "------------------------------\n"
						+ "Enter Your Choice: ");
				
				topic = readInt(keyin);
				if (topic == 0) {
					choice = display();
					break;
				}
				System.out.print("Enter topic name : ");
				keyin.nextLine();
				newTopic = keyin.nextLine();
				System.out.println("Enter a word - to quit press Enter: ");
				SinglyLinkedList newWords2 = new SinglyLinkedList();
				while (true) {
					String word = keyin.nextLine();
					if (word.isEmpty()) {
						break;
					}
					newWords2.add(word);
				}
				vocabList.addAfter(topic, new Vocab(newTopic, newWords2));
				choice = display();
				break;
			case 4:
				System.out.println("------------------------------"+"\n"
						+ "Pick a topic\n"+
						"------------------------------");
				if (vocabList.isEmpty()) {
					System.out.println("there are no topics yet");
				}
				else {
					vocabList.printListD();
				}
				System.out.print("0 Exit\n"
						+ "------------------------------\n"
						+ "Enter Your Choice: ");
				
				topic = readInt(keyin);
				if (topic == 0) {
					choice = display();
					break;
				}
				if (vocabList.removeTopic(topic)) {
					System.out.println("topic removed.");
					
				}
				else 
					System.out.println("topic not removed.");
				
				choice = display();
				break;
			case 5:
				System.out.println("------------------------------"+"\n"
						+ "Pick a topic\n"+
						"------------------------------");
				if (vocabList.isEmpty()) {
					System.out.println("there are no topics yet");
				}
				else {
					vocabList.printListD();
				}
				System.out.print("0 Exit\n"
						+ "------------------------------\n"
						+ "Enter Your Choice: ");
				
				topic = readInt(keyin);
				if (topic == 0) {
					choice = display();
					break;
				}
				display5(topic-1);
				choice = display();
				break;
			case 6:
				System.out.println("Type a word and press Enter : ");
				String word = keyin.next();
				vocabList.searchD(word);
				choice = display();
				break;
			case 7:
				System.out.print("enter the name of the input file : ");
				filePath = keyin.next();
				vocabList = loadFile(filePath);
				System.out.println("Done loading");
				choice = display();
				break;
			case 8:
				System.out.println("Enter the letter : ");
				String firstLet = keyin.next();
				vocabList.searchDFirst(firstLet);
				sortArrayList(SinglyLinkedList.wordsOpt8);
				 for (String word2 : SinglyLinkedList.wordsOpt8) {
			            System.out.println(word2);
			        }
				 SinglyLinkedList.wordsOpt8.clear();
				 choice = display();
				 break;
				
				
			case 9:
				System.out.println("Enter the name of the file : ");
				String saveFile = keyin.next();
				vocabList.save(vocabList, saveFile);
				choice = display();
				break;
				
			}
		}

	}
	
	

	/**
	* this method makes sure that the user enters an integer when prompted
	*
	* @param Scanner keyin
	* @return int
	*/
	public static int readInt(Scanner keyin) {
		
		while (!keyin.hasNextInt()) {
			String badInput = keyin.next();
			System.out.print("Bad input : " + badInput + "\nEnter Your Choice: ");
		}
		int choice = keyin.nextInt();
		return choice;
	}
	
	/**
	* this method displays the main menu and returns the user's choice
	*
	* @return int
	*/
	public static int display() {
		Scanner keyin = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.print("===========================\r\n"
					+ "Vocabulary Control Center\r\n"
					+ "===========================\r\n"
					+ "1 browse a topic\r\n"
					+ "2 insert a new topic before another one\r\n"
					+ "3 insert a new topic after another one\r\n"
					+ "4 remove a topic\r\n"
					+ "5 modify a topic\r\n"
					+ "6 search topics for a word\r\n"
					+ "7 load from a file\r\n"
					+ "8 show all words starting with a given letter\r\n"
					+ "9 save to file\r\n"
					+ "0 exit\r\n"
					+ "===========================\r\n"
					+ "Enter Your Choice: ");
			choice = readInt(keyin);
		} while (choice < 0 || choice >9);

		return choice;
	}
	
	/**
     * Displays the words of a selected topic.
     *
     * @param vocabList The Doubly Linked List containing the vocabulary list
     */
	public static void display1(DoublyLinkedList vocabList) {
		Scanner keyin = new Scanner(System.in);
		
		int topic;
		do {
			System.out.println("------------------------------"+"\n"
					+ "Pick a topic\n"+
					"------------------------------");
			if (vocabList.isEmpty()) {
				System.out.println("there are no topics yet");
			}
			else {
				
				vocabList.printListD();
			}
			System.out.print("0 Exit\n"
					+ "------------------------------\n"
					+ "Enter Your Choice: ");
			
			topic = readInt(keyin);
			if (topic == 0) {
				break;
			}
			vocabList.getNode(topic-1).vocab.wordsList.printListS();
			System.out.println();
			}while (topic!= 0);
		
	}
	
	/**
     * loads the doublyLinkedList using info from the file 
     *
     * @param String path
     * @return DoublyLinkedList
     */
	public static DoublyLinkedList loadFile(String path) {
		int i = 0;
		DoublyLinkedList vocabList = new DoublyLinkedList();
		while(i<fileLength(path)) {
			
			if (reader(path,i).equals("")) {
				
				i++;
			}
			else if(reader(path, i).charAt(0) == '#') {
				vocabList.addToEnd(new Vocab(reader(path,i).substring(1), fillSL(i, path)));
				
				i++;
			}
			else 
				i++;
		}
		
		return vocabList;
		
	}
	
	/**
	* this method reads a string from a file
	*
	* @param String path
	* @param int i
	* @return String
	*/
	public static String reader(String path, int i) {
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			System.out.println("File " + path + " was not found");
			System.out.println("or could not be opened.");
			System.exit(0);
		}
		for (int j = 0; j < i; j++) {
			fileScanner.nextLine();
		}
		String str = null;
		if (fileScanner.hasNextLine()) {
			str = fileScanner.nextLine();
		}
		else 
			return null;
		fileScanner.close();
		return str;
	}
	
	/**
	* this method fills the singLinkedList with input from the file
	*
	* @param String path
	* @param int i
	* @return SinglyLinkedList
	*/
	public static SinglyLinkedList fillSL(int i, String path) {
		SinglyLinkedList SLList = new SinglyLinkedList();
		
		while (!(reader(path, i+1) == null || reader(path, i+1).equals(""))) {
			SLList.add(reader(path, i+1));
			i++;
		}
		return SLList;
	}
	
	
	/**
	* this method returns the length of given file
	*
	* @param String filePath
	* @return int
	*/
	public static int fileLength(String filePath) {
		int totalLines = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                totalLines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalLines;
	}
	
	/**
	* this method displays option 5 menu and performs whatever the user wants
	*
	* @param int index
	*/
	public static void display5(int index) {
		Scanner keyin = new Scanner(System.in);
		String choice;
		do {
			System.out.println("-----------------------------\r\n"
				+ "Modify Topics Menu\r\n"
				+ "-----------------------------\r\n"
				+ "a add a word\r\n"
				+ "r remove a word\r\n"
				+ "c change a word\r\n"
				+ "0 Exit\r\n"
				+ "-----------------------------\r\n"
				+ "Enter your choice : ");
			choice = keyin.next();
		}while (!(choice.equals("a") || choice.equals("r") || choice.equals("c") || choice.equals("0")));
		switch(choice) {
		
		case "a":
			System.out.println("Type a word and press Enter : ");
			vocabList.getNode(index).vocab.wordsList.addNew(keyin.next());
			break;
		case "r":
			System.out.println("Type a word and press Enter : ");
			vocabList.getNode(index).vocab.wordsList.remove(keyin.next());
			break;
		case "c":
			System.out.println("Enter the word you want to change followed by the new word and press enter : ");
			vocabList.getNode(index).vocab.wordsList.change(keyin.next(), keyin.next());
			break;
		case "0":
			break;
		}
}
	
	/**
	* this method sorts an arrayList according to alphabetical order
	*
	* @param ArrayList<String> list
	*/
	 public static void sortArrayList(ArrayList<String> list) {
	        int n = list.size();
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                String word1 = list.get(j+1);
	                String word2 = list.get(j );

	                
	                int cmp = Character.compare(Character.toLowerCase(word1.charAt(0)), Character.toLowerCase(word2.charAt(0)));
	                if (cmp > 0 || (cmp == 0 && Character.isUpperCase(word1.charAt(0)) && Character.isLowerCase(word2.charAt(0)))) {
	                    swap(list, j, j + 1);
	                }
	            }
	        }
	    }

	 /**
		* this method swaps elements in an arrayList
		*
		* @param ArrayList<String> list
		* @param int i
		* @param int j
		*/
	 public static void swap(ArrayList<String> list, int i, int j) {
	        String temp = list.get(i);
	        list.set(i, list.get(j));
	        list.set(j, temp);
	    }

}