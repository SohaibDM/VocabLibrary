// -----------------------------------------------------
// Assignment (3)
// Question: (1)
// Written by: (Sohaib Daami)
// -----------------------------------------------------


/**
* The Vocab class creates Vocab objects
*
* @author Sohaib Daami
* @version 1.0
* @see String
*/
public class Vocab {

	String topic;
	SinglyLinkedList wordsList;

	public Vocab(String topic, SinglyLinkedList wordsList) {
		this.topic = topic;
		this.wordsList = wordsList;
	}

	@Override
	public String toString() {
		return topic + " : \n " + wordsList;
	}
}
