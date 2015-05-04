import java.util.*;

public class Lotto {

	public static void main(String[] args) {

		int counter = 0;

		for (int i = 0; i < 1000000; i++) {

			counter += sortAndCompare();
		}
		double result = (1000000 - counter);
		System.out.println("number of consecutive numbers per million: " + counter);
		System.out.println("probability: " + result/1000000);

	}

	public static int sortAndCompare() {

		final int[] array = new Random().ints(1, 45).distinct().limit(6)
				.toArray();

		int count = 0;
		Arrays.sort(array); // Array sort function in java

		/*int a, b, swap;
		for (a = 0; a < array.length; a++) {
			for (b = 0; b < array.length - a - 1; b++) {     // Bubble sort
				if (array[b] > array[b + 1]) {
					swap = array[b];
					array[b] = array[b + 1];
					array[b + 1] = swap;
				}
			}
		}*/
		boolean flag = false;
		for (int i = 0; i < 5; i++) {

			if (array[i] + 1 == array[i + 1])
				flag = true;

		}

		if (flag == true)
			count++;

		/*for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println();
		System.out.println("***" + count + "***");*/

		return count;
	}

}
