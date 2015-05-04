package Countdown;

import java.util.*;

public class longestWord {
	public static void main(String args[]) {

		FileIO reader = new FileIO();
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter a list of letters");
	
		
		

		String word = scan.nextLine();
		final long startTime = System.currentTimeMillis();
		char[] letters = word.toCharArray();

		Arrays.sort(letters);
		String sortedWord = String.valueOf(letters);
		System.out.println(sortedWord);

		String[] inputs = reader
				.load("/Users/deangilmore/Dropbox/Eclipse/Cs211/src/Countdown/dictionary.txt");

		Arrays.sort(inputs, new StringLengthComparator());
		
		
		List<String> wordList = Arrays.asList(inputs);
		Collections.reverse(wordList);
		String[] working = wordList.toArray(new String[wordList.size()]);
		
		
		for (int i = 0; i < working.length; i++) {
			char[] check = working[i].toCharArray();
			Arrays.sort(check);
			String sortDict = String.valueOf(check);

			if (sortedWord.contains(sortDict)) {
				System.out.println("..." + sortDict + "...");
				System.out.println("The longest word that can be made is: " + "'" + working[i] + "'");
				break;
			}
			
			

		}

		scan.close();
		
		
		
		final long endTime = System.currentTimeMillis();

		System.out.println("Total execution time: " + (endTime - startTime) );

	}
}
