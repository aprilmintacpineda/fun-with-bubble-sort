<?php

$ten = 10;
$hundred = 100;
$thousand = 1000;
$ten_thousand = 10000;
$hundred_thousand = 100000;
$million = 1000000;

// very self-explanatory
// int numberOfTests, int max,  int dataLength, boolean showSortedArray = false, boolean runTest = true
doIt($ten, $million, $ten_thousand);

/**
 * NOTE from the developer:
 * You only need to manipulate the codes on the top, the codes below are the core
 * functionality of the program and requires no refactoring
 */

// generates random data for testing purpose
function generateRandomTestData($len, $max) {
	$randomTestData = [];

	for ($c = 1; $c <= $len; $c++) {
		$randomTestData[] = rand(1, $max);
	}

	return $randomTestData;
}

function bubbleSort($randomTestData) {
	for ($a = count($randomTestData) - 1; $a > 0; $a--) {
		for ($b = 0; $b < $a; $b++) {
			if ($randomTestData[$b] > $randomTestData[$b + 1]) {
				$temp = $randomTestData[$b];
				$randomTestData[$b] = $randomTestData[$b + 1];
				$randomTestData[$b + 1] = $temp;
			}
		}
	}
	
	return $randomTestData;
}

function assertTests($sorted) {
	for ($a = 0; $a < count($sorted) - 1; $a++) {
		if ($sorted[$a] > $sorted[$a + 1]) {
			return false;
		}
	}

	return true;
}

function doIt($numberOfTests, $max, $dataLength, $showSortedArray = false, $runTest = true) {
	$startTime = 0;
	$endTime = 0;
	$average = 0;
	$longestTime = 0;
	$shortestTime = 0;
	$timeConsumed = 0;
	$failedTests = 0;
	$passedTests = 0;

	for ($a = 1; $a <= $numberOfTests; $a++) {
		// generate random data
		$randomTestData = generateRandomTestData($dataLength, $max);
		// get start time
		$startTime = time();
		// run the sort
		$sorted = bubbleSort($randomTestData);
		// get end time
		$endTime = time();
		// calculate how much time was consumed
		$timeConsumed = ($endTime - $startTime);

		if ($showSortedArray) {
			$message = implode(',', $sorted);
		} else {
			$message = "$timeConsumed second(s)";
		}

		if ($runTest) {
			if (!assertTests($sorted)) {
				$message = "test #$a: FAILED : $message\n";
				++$failedTests;
			} else {
				$message = "test #$a: PASSED : $message\n";
				++$passedTests;
			}
		} else {
			$message = "test #$a: $message\n";
		}

		// change the longest time
		if ($timeConsumed > $longestTime) {
			$longestTime = $timeConsumed;
		}

		// change the shortest time
		if ($a == 1 || $timeConsumed < $shortestTime) {
			$shortestTime = $timeConsumed;
		}

		// add the time consumed to the average for later use
		$average += $timeConsumed;
		echo $message;
	}

	// compute average time consumed
	$average = $average / $numberOfTests;

	echo "-------------\n";
	echo "Conducted $numberOfTests test(s).\n";
	echo "language: PHP\n";
	echo "Data length: $dataLength\n";
	echo "Average time: $average\n";
	echo "Shortest time: $shortestTime\n";
	echo "Longest time: $longestTime\n";
	echo "Failed tests: $failedTests\n";
	echo "Passed tests: $passedTests\n";
	echo "-------------\n";
}