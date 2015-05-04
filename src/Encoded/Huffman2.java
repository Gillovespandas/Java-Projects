package Encoded;

import java.util.*;
import Countdown.FileIO;
import Huffman.Node;
import Huffman.tree;

public class Huffman2 {

	public static void main(String[] args) {

		FileIO reader = new FileIO();

		String[] sentence = reader
				.load("/Users/deangilmore/Dropbox/Eclipse/Cs211/src/Encoded/encoded.txt"); // Reading
																							// the
																							// File
																							// as
																							// a
																							// String
																							// array

		double count = 0;
		int[] array = new int[256]; // an array to store all the frequencies
		double[] mystery = new double[256];

		for (int j = 0; j < sentence.length; j++) {

			for (int i = 0; i < sentence[j].length(); i++) { // go through the
																// sentence
				array[(int) sentence[j].charAt(i)]++; // increment the
														// appropriate
														// frequencies
			}

			count += sentence[j].length();
		}

		PriorityQueue<tree> PQ = new PriorityQueue<tree>(); // make a priority
															// queue to hold the
															// forest of trees

		for (int i = 0; i < array.length; i++) { // go through frequency array
			if (array[i] > 0) { // print out non-zero frequencies - cast to a
								// char
				mystery[i] = ((array[i] / count) * 100);
				// System.out.println("'"+(char)i+"' has a frequency: " +
				// ((array[i]/count)*100) );

				// MAKE THE FOREST OF treeS AND ADD THEM TO THE PQ
				Node n = new Node();
				n.letter = (char) i;
				tree t = new tree(); // create a new tree
				t.root = n; // insert the letter as the root node
				t.frequency = array[i]; // set the cumulative frequency of that
										// tree
				PQ.add(t); // add the tree into the PQ

			}
		}

		// bubble sort mystery frequencies from high to low
		for (int m = 0; m < mystery.length; m++) {

			int outer, inner;
			for (outer = mystery.length - 1; outer > 0; outer--) {
				// bubbles from end of the array to front
				for (inner = 0; inner < outer; inner++) {
					// checks if element is bigger than next element
					if (mystery[inner + 1] > mystery[inner]) {
						// swapping method swapping smaller elements to the
						// front
						double temp = mystery[inner];
						mystery[inner] = mystery[inner + 1];
						mystery[inner + 1] = temp;
					}
				}
			}

		}

		int temp;
		while (PQ.size() > 1) { // while there are two or more trees left in the
								// forest

			// IMPLEMENT THE HUFFMAN ALGORITHM
			temp = 0;
			Node rootNode = new Node();

			if (PQ.peek().root != null) { // checks the root isnt empty
				temp += PQ.peek().frequency; // saves frequency
				rootNode.leftChild = PQ.poll().root; // makes the root value the
														// left childs
			}

			if (PQ.peek().root != null) { // takes next node
				temp += PQ.peek().frequency; // adds the frequency to that of
												// the left child
				rootNode.rightChild = PQ.poll().root; // saves as right child
			}

			// when you're making the new combined tree, don't forget to assign
			// a
			// default root node (or else you'll get a null pointer exception)

			tree combined = new tree();
			combined.frequency = temp; // sum of left and right nodes
			combined.root = rootNode; // default root node
			PQ.add(combined); // adds the tree back into the PQ

		}

		tree Huffmantree = PQ.poll(); // now there's only one tree left - get
										// its codes

		Huffmantree.getCode(Huffmantree.root, "");

		// System.out.println("total " + count );

	}

}
