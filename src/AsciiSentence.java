import java.util.*;

public class AsciiSentence {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		int[] AsciiArray = new int[256];

		System.out.println("Please enter a sentence:");
		String s1 = scan.nextLine();

		char[] charArray = s1.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
			String s2 = Integer.toBinaryString((int) charArray[i]);
			AsciiArray[(int) charArray[i]]++;

			if (s2.length() < 7) {
				s2 = "0" + s2;

			}

		}

		for (int i = 0; i < AsciiArray.length; i++) {
			if (AsciiArray[i] > 0) {
				System.out.println("'" + (char) i + "'" + " occurs "
						+ AsciiArray[i] + " times");
			}
		}

		scan.close();

	}

}
