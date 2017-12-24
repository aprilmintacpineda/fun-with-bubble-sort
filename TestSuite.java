/**
 * NOTE from the developer:
 * You only need to manipulate the codes inside the main function, the rest of the codes are
 * the core functionality of the program and requires no refactoring
 */

import java.util.Random;

public class TestSuite {
	public static void main(String [] args) {
		int ten = 10,
				hundred = 100,
				thousand = 1000,
				ten_thousand = 10000,
				hundred_thousand = 100000,
				million = 1000000;

		// very self-explanatory
		// int numberOfTests, int max, int dataLength, boolean showSortedArray, boolean runTest
		doIt(ten, million, ten_thousand, false, true);
	}

	public static void doIt(int numberOfTests, int max, int dataLength, boolean showSortedArray, boolean runTest) {
		long startTime = 0,
				endTime = 0,
				average = 0,
				longestTime = 0,
				shortestTime = 0,
				timeConsumed = 0;
		int passedTests = 0, failedTests = 0;
		int[] randomTestData,
					sorted;
		String message;

		for (int a = 1; a <= numberOfTests; a++) {
			// generate random data
			randomTestData = generateRandomTestData(dataLength, max);
			// get start time
			startTime = System.currentTimeMillis();
			// run the sort
			sorted = bubbleSort(randomTestData);
			// get end time
			endTime = System.currentTimeMillis();
			// calculate how much time was consumed
			timeConsumed = (endTime - startTime) / 1000;

			// change the longest time
			if (timeConsumed > longestTime) {
				longestTime = timeConsumed;
			}

			// change the shortest time
			if (a == 1 || timeConsumed < shortestTime) {
				shortestTime = timeConsumed;
			}

			// add the time consumed to the average for later use
			average += timeConsumed;
			
			if (showSortedArray) {
				message = showSortedArray(sorted);
			} else {
				message = timeConsumed + " second(s)";
			}

			if (runTest) {
				if (!testAssert(sorted)) {
					message = "test #" + a + " : FAILED : " + message;
					++failedTests;
				} else {
					message = "test #" + a + " : PASSED : " + message;
					++passedTests;
				}
			} else {
					message = "test #" + a + " : " + message;
			}


			System.out.println(message);
		}

		// compute average time consumed
		average = average / numberOfTests;

		System.out.println("-------------");
		System.out.println("Conducted "+ numberOfTests +" test(s).");
		System.out.println("language: Java");
		System.out.println("Data length: "+ dataLength);
		System.out.println("Average time: "+ average);
		System.out.println("Shortest time: "+ shortestTime);
		System.out.println("Longest time: "+ longestTime);
		System.out.println("Failed Tests: " + failedTests);
		System.out.println("Passed Tests: " + passedTests);
		System.out.println("-------------");
	}

	public static int[] generateRandomTestData(int len, int max) {
		int[] randomTestData = new int[len];
		Random rand = new Random();

		for (int c = 1; c <= len; c++) {
			randomTestData[c - 1] = rand.nextInt(max) + 1;
		}

		return randomTestData;
	}

	public static int[] bubbleSort(int[] randomTestData) {
		for (int a = randomTestData.length - 1; a > 0; a--) {
			for (int b = 0; b < a; b++) {
				if (randomTestData[b] > randomTestData[b + 1]) {
					int temp = randomTestData[b];
					randomTestData[b] = randomTestData[b + 1];
					randomTestData[b + 1] = temp;
				}
			}
		}
		
		return randomTestData;
	}

	public static String showSortedArray(int[] sorted) {
		String sortedArray = "";

		for (int a = 0; a < sorted.length; a++) {
			sortedArray += sorted[a];

			if (a != sorted.length - 1) {
				sortedArray += ", ";
			}
		}

		return sortedArray;
	}

	public static boolean testAssert(int[] sorted) {
		for (int a = 0; a < sorted.length - 1; a++) {
			if (sorted[a] > sorted[a + 1]) {
				return false;
			}
		}

		return true;
	}
}