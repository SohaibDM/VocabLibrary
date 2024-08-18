// -----------------------------------------------------
// Assignment (3)
// Question: (1)
// Written by: (Sohaib Daami)
// -----------------------------------------------------

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


/**
* The DoublyLinkedList class creates a doublyLinkedList and provides various methods that help us navigate the list
*
* @author Sohaib Daami
* @version 1.0
* @see String
*/
public class DoublyLinkedList {

	class Node {
		Vocab vocab;
		Node next;
		Node prev;

		public Node(Vocab vocab) {
			this(vocab, null, null);
		}

		Node(Vocab vocab, Node next, Node prev) {
			this.vocab = vocab;
			this.next = next;
			this.prev = prev;
		}
	}

	private Node tail;
	private Node head;
	private int size;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	* this method adds an element before a certain element
	*
	*@param int index
	*@param Vocab vocab
	*/
	public void addBefore(int index, Vocab vocab) {
		if (index == 1) {
			Node newHead = new Node(vocab);

			if (head == null) {
				head = newHead;
				tail = newHead;
			} else {
				newHead.next = head;
				head.prev = newHead;
				head = newHead;
			}
			return;
		}

		Node prev = getNode(index - 2);

		Node succ = prev.next;
		Node mid = new Node(vocab, succ, prev);
		size++;
		prev.next = mid;
		if (succ == null) {
			tail = mid;

		} else
			succ.prev = mid;
	}

	/**
	* this method returns the node corresponding to the given index
	*
	*@param int index
	*@return Node
	*/
	public Node getNode(int n) {

		Node current = head;
		for (int k = 0; k <= n - 1; k++) {
			current = current.next;
		}
		return current;
	}

	/**
	* this method adds an element after a certain element in the list
	*
	*@param int index
	*@param Vocab vocab
	*/
	public void addAfter(int index, Vocab vocab) {
		Node prev = getNode(index - 1);
		Node succ = prev.next;
		Node mid = new Node(vocab, succ, prev);
		size++;
		prev.next = mid;
		if (succ == null) {
			tail = mid;

		} else
			succ.prev = mid;

	}

	/**
	* this method saves all the elements on a text file
	*
	*@param DoublyLinkedList vocabList
	*@param String path
	*/
	public void save(DoublyLinkedList vocabList, String path) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(path, true));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file: " + path);
			System.exit(0);
		}

		Node curr = head;

		while (curr != null) {

			pw.println("#" + curr.vocab.topic);
			pw.println(curr.vocab.wordsList);

			curr = curr.next;
		}

		pw.close();

	}

	/**
	* this method prints the list
	*
	*
	*/
	public void printListD() {
		Node curr = head;
		int i = 1;
		while (curr != null) {
			System.out.println(i + " " + curr.vocab.topic);
			curr = curr.next;
			i++;
		}
	}

	/**
	* this method removes an element from the list
	*
	*@param int index
	*@return boolean
	*/
	public boolean removeTopic(int index) {
		Node target = getNode(index - 1);
		Node before = target.prev;
		Node after = target.next;
		if (before == null)
			head = after;
		else
			before.next = after;

		if (after == null)
			tail = before;
		else
			after.prev = before;

		return true;

	}

	/**
	* this method searches for elements that have words that equal the given word
	*
	*@param String searchItem
	*/
	public void searchD(String searchItem) {
		Node curr = head;
		String output = "the word " + searchItem + " is found in ";

		while (curr != null) {
			if (curr.vocab.wordsList.search(searchItem)) {
				output += curr.vocab.topic + ", ";
				curr = curr.next;
			} else
				curr = curr.next;
		}
		if (output.equals("the word " + searchItem + " is found in ")) {
			System.out.println("the word is no in any topic.");
			return;
		}
		System.out.println(output);

	}

	/**
	* this method searches for elements that have words that start with the same letter given
	*
	*@param String searchItem
	*/
	public void searchDFirst(String searchItem) {

		Node curr = head;

		while (curr != null) {
			curr.vocab.wordsList.searchFirst(searchItem);
			curr = curr.next;
		}
	}

	/**
	* this method adds an element to the end of the list
	*
	*@param Vocab vocab
	*/
	public void addToEnd(Vocab vocab) {
		if (head == null) {
			Node newHead = new Node(vocab);

			if (head == null) {
				head = newHead;
				tail = newHead;
			} else {
				newHead.next = head;
				head.prev = newHead;
				head = newHead;
			}
			return;
		} else {
			tail.next = new Node(vocab, null, tail);
			tail = tail.next;
		}
		size++;
	}

	/**
	* this method checks if a list is empty
	*
	* @return boolean
	*/
	public boolean isEmpty() {
		return head == null;
	}

}
