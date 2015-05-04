package Huffman;

import java.util.*;

public class FrequencyEncode {

	public static void main(String[] args) {

		FileIO reader = new FileIO();
		Scanner scan = new Scanner(System.in);

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

		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				mystery[i] = ((array[i] / count) * 100);
				

				// MAKE THE FOREST OF TREES AND ADD THEM TO THE PQ
				Node n = new Node();
				n.letter = (char) i;
				tree t = new tree();
				t.root = n;
				t.frequency = array[i];
				PQ.add(t);

			}
		}

		// bubble sort mystery frequencies from high to low
		for (int m = 0; m < mystery.length; m++) {

			int outer, inner;
			for (outer = mystery.length - 1; outer > 0; outer--) {

				for (inner = 0; inner < outer; inner++) {

					if (mystery[inner + 1] > mystery[inner]) {

						double temp = mystery[inner];
						mystery[inner] = mystery[inner + 1];
						mystery[inner + 1] = temp;
					}
				}
			}

		}

		for (int i = 0; i < 5; i++) {
			System.out.println((mystery[i]));

		}

		double french[] = new double[] { 14.72, 7.95, 7.64, 7.53, 7.24 };
		double finnish[] = new double[] { 12.22, 10.82, 8.83, 8.75, 7.97 };
		double german[] = new double[] { 16.4, 9.78, 7.27, 7.00, 6.55 };
		double italian[] = new double[] { 11.79, 11.75, 10.14, 9.83, 6.88 };
		double spanish[] = new double[] { 12.68, 11.53, 8.68, 7.98, 6.87 };
		double danish[] = new double[] { 15.45, 8.96, 7.24, 6.86, 6.03 };
		

		
		double fre = 0;
		double fin = 0;
		double ger = 0;
		double ital = 0;
		double spa = 0;
		double dan = 0;
		

		for (int i = 0; i < 5; i++) {
			fre += Math.abs(mystery[i] - french[i]);

		}
		
		for (int i = 0; i < 5; i++) {
			fin += Math.abs(mystery[i] - finnish[i]);

		}
		
		for (int i = 0; i < 5; i++) {
			ger += Math.abs(mystery[i] - german[i]);

		}
		
		for (int i = 0; i < 5; i++) {
			ital += Math.abs(mystery[i] - italian[i]);

		}
		
		for (int i = 0; i < 5; i++) {
			dan += Math.abs(mystery[i] - danish[i]);

		}
		
		for (int i = 0; i < 5; i++) {
			spa += Math.abs(mystery[i] - spanish[i]);

		}
		String ans = "french";
		double smallest = fre;
		if (smallest > fin){ smallest = fin;ans = "finnish";}
		if (smallest > ger){smallest = ger;ans = "german";}
		if (smallest > ital){smallest = ital;ans = "italian";}
		if (smallest > spa){smallest = spa;ans = "spanish";}
		if (smallest > dan){smallest = dan;ans = "danish";}
		System.out.println("The lowest difference in frequency is " + smallest + "%");
		System.out.println("The language should be " + ans);
		


		

	}

}
