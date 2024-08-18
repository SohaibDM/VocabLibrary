// -----------------------------------------------------
// Assignment (3)
// Question: (1)
// Written by: (Sohaib Daami)
// -----------------------------------------------------

import java.util.ArrayList;

/**
* The SinglyLinkedList class creates a singlyLinkedList and provides various methods that help us navigate the list
*
* @author Sohaib Daami
* @version 1.0
* @see String
*/
public class SinglyLinkedList {

	//this stores the words that start with the same letter for option 8
	public static ArrayList<String> wordsOpt8 = new ArrayList<>();

	private class Node {
		private Node next;
		private String word;

		public Node(String word) {
			this(word, null);
		}

		public Node(String word, Node n) {
			this.word = word;
			this.next = n;
		}
	}

	private Node tail = null;
	private Node head = null;
	private int size = 0;

	
	/**
	* this method adds an element if the element does not already exist
	*
	*
	*@param String word
	*/
	public void addNew(String word) {
		if (search(word)) {
			System.out.println("the word " + word + " already exists");
			return;
		}
		head = new Node(word, head);

		if (tail == null) {
			tail = head;

		}
		size++;
	}

	/**
	* this method adds an element 
	*
	*
	*@param String word
	*/
	public void add(String word) {

		head = new Node(word, head);

		if (tail == null) {
			tail = head;

		}
		size++;
	}

	/**
	* this method returns the index of a word in the list
	*
	*
	*@param String word
	*@return int 
	*/
	public int indexOf(String word) {
		Node current = head;

		int index = 0;
		while (current != null && !word.equals(current.word)) {
			current = current.next;
			index++;
		}
		if (current == null) {
			return -1;
		} else
			return index;
	}

	/**
	* this method removes a word from the list
	*
	*
	*@param String word 
	*/
	public void remove(String word) {
		if (head == null) {
			return;
		}

		if (head.word.equals(word)) {
			head = head.next;
			size--;
			return;
		}

		Node current = head;
		while (current.next != null) {
			if (current.next.word.equals(word)) {
				current.next = current.next.next;
				size--;
				return;
			}
			current = current.next;
		}
	}

	/**
	* this method returns the node corresponding to the given index
	*
	*@param int index
	*@return Node
	*/
	public Node getNode(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	/**
	* this method changes a word in the list
	*
	*@param String word
	*@param String newWord
	*/
	public void change(String word, String newWord) {
		int index = indexOf(word);
		if (index == -1) {
			System.out.println(word + "isnt on the list");
			return;
		}
		Node current = getNode(index);
		current.word = newWord;
	}

	/**
	* this method searches if an word exists in the list or no 
	*
	*@param String searchItem
	*@return boolean
	*/
	public boolean search(String searchItem) {
		Node curr = head;

		boolean found = false;
		while (curr != null && !found) {
			if (curr.word.equals(searchItem))
				found = true;
			else
				curr = curr.next;
		}
		return found;
	}

	/**
	* this method writes to the arrayList every word that starts with the same given letter
	*
	*@param String searchItem
	*/
	public void searchFirst(String searchItem) {
		Node curr = head;

		while (curr != null) {
			if (Character.toUpperCase(curr.word.charAt(0)) == Character.toUpperCase(searchItem.charAt(0))) {
				wordsOpt8.add(curr.word);
				curr = curr.next;
			} else
				curr = curr.next;
		}

	}

	/**
	* this method prints the list
	*
	*/
	public void printListS() {
		Node current = head;
		int wordsPrinted = 0;
		int i = 1;

		while (current != null) {
			Node next = current.next;
			while (next != null) {
				String currentWord = current.word.toString();
				String nextWord = next.word.toString();
				if (compareWords(currentWord, nextWord) > 0) {

					String temp = current.word;
					current.word = next.word;
					next.word = temp;
				}
				next = next.next;
			}
			current = current.next;
		}

		current = head;
		while (current != null) {
			String word = current.word.toString();
			System.out.printf("%-3d%-20s", i++, word);
			wordsPrinted++;
			if (wordsPrinted % 4 == 0) {
				System.out.println();
			}
			current = current.next;
		}
		if (wordsPrinted % 4 != 0) {
			System.out.println();
		}
	}

	/**
	* this method compares two words based on alphabetical order and upperCase or lowerCase 
	*
	*@param String word1
	*@param String word2
	*@return int
	*/
	private int compareWords(String word1, String word2) {

		if (Character.isUpperCase(word1.charAt(0)) && Character.isLowerCase(word2.charAt(0))) {
			return -1;
		} else if (Character.isLowerCase(word1.charAt(0)) && Character.isUpperCase(word2.charAt(0))) {
			return 1;
		} else {
			return word1.compareTo(word2);
		}
	}

	@Override
	public String toString() {
		Node current = head;

		String str = "";
		while (current != null) {
			str += current.word + "\n";
			current = current.next;

		}
		return str;
	}

}
