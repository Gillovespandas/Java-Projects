package Huffman;

import java.util.*;

public class Huffman {

	public static void main(String[] args) {
		double asciiTotal = 0.0;
		double huffTotal = 0.0;
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your sentence: ");
		String sentence = scan.nextLine();
		String binaryString = ""; // this stores the string of binary code

		for (int i = 0; i < sentence.length(); i++) {// go through the sentence
			int decimalValue = (int) sentence.charAt(i);// convert to decimal
			String binaryValue = Integer.toBinaryString(decimalValue);// convert
																		// to
																		// binary
			asciiTotal += binaryValue.length();
			for (int j = 7; j > binaryValue.length(); j--) {// this loop adds in
															// those pesky
															// leading zeroes
				binaryString += "0";
				asciiTotal++;
			}
			binaryString += binaryValue + "\n";// add to the string of binary
		}
		System.out.println();
		System.out.println(binaryString);// print out the binary

		int[] array = new int[256];// an array to store all the frequencies

		for (int i = 0; i < sentence.length(); i++) {// go through the sentence
			array[(int) sentence.charAt(i)]++;// increment the appropriate
												// frequencies

		}

		PriorityQueue<tree> PQ = new PriorityQueue<tree>();// make a priority
															// queue to hold the
															// forest of trees

		for (int i = 0; i < array.length; i++) { // go through frequency array
			if (array[i] > 0) { // print out non-zero frequencies - cast to a
								// char
				System.out.println("'" + (char) i + "' appeared " + array[i]
						+ ((array[i] == 1) ? " time" : " times"));


				// .......................................................................................................
				// .......................................................................................................
				// .......................................................................................................

				Node N = new Node();// creates node
				N.letter = (char) i;// sets the nodes letter
				tree T = new tree();// creates new tree
				T.root = N;// sets root of tree
				T.frequency = array[i];// saves frequency
				PQ.add(T);// adds tree to priority queue

			}
		}
		int temp;

		while (PQ.size() > 1) {// while there are two or more Trees left in the
								// forest
			temp = 0;
			Node R = new Node();

			if (PQ.peek().root != null) {
				temp += PQ.peek().frequency;
				R.leftChild = PQ.poll().root;

			}

			if (PQ.peek().root != null) {
				temp += PQ.peek().frequency;
				R.rightChild = PQ.poll().root;

			}
			tree C = new tree();
			C.frequency = temp;
			C.root = R;
			PQ.add(C);
			// when you're making the new combined tree, don't forget to assign
			// a default root node (or else you'll get a null pointer exception)
			// if you like, to check if everything is working so far, try
			// printing out the letter of the roots of the two trees you're
			// combining
		}

		tree HuffmanTree = PQ.poll(); // now there's only one tree left - get
										// its codes

		System.out.println();

		// ............................................................................/
		// ............................................................................/
		// ............................................................................/

		HuffmanTree.getCode(HuffmanTree.root, "");

		for (int i = 0; i < sentence.length(); i++) {
			System.out.println(HuffmanTree.getHuff(sentence.charAt(i)));
			huffTotal += HuffmanTree.getHuff(sentence.charAt(i)).length();
		}

		System.out.println();

		/*
		 * System.out.println("Ascii bit total : " + asciiTotal +
		 * " Huffman bit total : " + huffTotal);
		 */
		System.out.println("Compressed from " + (int) asciiTotal + " bits to "
				+ (int) huffTotal + " bits");

		//System.out.println("Compression Rate : "
				//+ (int) (100 - ((huffTotal / asciiTotal) * 100)) + "%");

		scan.close();

	}

}
