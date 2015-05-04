package Huffman;

//import java.util.*;

public class tree implements Comparable<tree> {
	public Node root; // first node of tree
	public int frequency = 0;

	// -------------------------------------------------------------
	public tree()// constructor
	{
		root = null;
	}// no nodes in tree yet
		// -------------------------------------------------------------

	// the PriorityQueue needs to be able to somehow rank the objects in it
	// thus, the objects in the PriorityQueue must implement an interface called
	// Comparable
	// the interface requires you to write a compareTo() method so here it is:

	public int compareTo(tree object) { //
		if (frequency - object.frequency > 0) { // compare the cumulative
												// frequencies of the tree
			return 1;
		} else if (frequency - object.frequency < 0) {
			return -1; // return 1 or -1 depending on whether these frequencies
						// are bigger or smaller
		} else {
			return 0; // return 0 if they're the same
		}
	}



	String path = ""; // this variable will track the path to the letter we're
						// looking for
	int flag = 0;
	String huffLetter[][] = new String[30][2];
	int pos = 0;

	public String getCode(Node current, String P) {
		if (current.leftChild != null) {
			path = P + "0";
			getCode(current.leftChild, path);
		}
		if (current.rightChild != null) {
			path = P + "1";
			getCode(current.rightChild, path);
		}
		if (current.leftChild == null && current.rightChild == null) {
			huffLetter[pos][0] = "" + current.letter;
			huffLetter[pos][1] = path;
			pos++;
		}

		return path;

		// return the path that results
	}

	public String getHuff(char letter) {
		for (int i = 0; i < huffLetter.length; i++) {
			if (huffLetter[i][0].charAt(0) == letter) {
				return huffLetter[i][1];
			}
		}

		return "";
	}

} 

