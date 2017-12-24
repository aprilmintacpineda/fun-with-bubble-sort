var ten = 10,
		hundred = 100,
		thousand = 1000,
		ten_thousand = 10000,
		hundred_thousand = 100000,
		million = 1000000;

// very self-explanatory
// int numberOfTests, int max, int dataLength, boolean showSortedArray = false, runTest = true
doIt(ten, million, ten_thousand);

/**
 * NOTE from the developer:
 * You only need to manipulate the codes on the top, the codes below are the core
 * functionality of the program and requires no refactoring
 */

// generates random data for testing purpose
function generateRandomTestData(len, max) {
	var randomTestData = [];

	for (var c = 1; c <= len; c++) {
		randomTestData.push(Math.floor(Math.random() * max) + 1);
	}

	return randomTestData;
}

function bubbleSort(randomTestData) {
	for (var a = randomTestData.length - 1; a > 0; a--) {
		for (var b = 0; b < a; b++) {
			if (randomTestData[b] > randomTestData[b + 1]) {
				var temp = randomTestData[b];
				randomTestData[b] = randomTestData[b + 1];
				randomTestData[b + 1] = temp;
			}
		}
	}
	
	return randomTestData;
}

function assert(sorted) {
	for (var a = 0; a < sorted.length - 1; a++) {
		if (sorted[a] > sorted[a + 1]) {
			return false;
		}
	}

	return true;
}

function doIt(numberOfTests, max, dataLength, showSortedArray = false, runTest = true) {
	var startTime = 0,
			endTime = 0,
			average = 0,
			longestTime = 0,
			shortestTime = 0,
			timeConsumed = 0,
			randomTestData,
			sorted,
			failedTests = 0,
			passedTests = 0,
			message = '';

	for (var a = 1; a <= numberOfTests; a++) {
		// generate random data
		randomTestData = generateRandomTestData(dataLength, max);
		// get start time
		startTime = new Date().getTime();
		// run the sort
		sorted = bubbleSort(randomTestData);
		// get end time
		endTime = new Date().getTime();
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
			message = `${sorted}`;
		} else {
			message = `${timeConsumed} second(s)`;
		}

		if (runTest) {
			if (!assert(sorted)) {
				message = `test #${a}: FAILED : ${message}`;
				++failedTests;
			} else {
				message = `test #${a}: PASSED : ${message}`;
				++passedTests;
			}
		} else {
			message = `test #${$a}: ${message}`;
		}


		console.log(message);
	}

	// compute average time consumed
	average = average / numberOfTests;

	console.log(`-------------`);
	console.log(`Conducted ${numberOfTests} test(s).`);
	console.log(`language: JavaScript`);
	console.log(`Data length: ${dataLength}`);
	console.log(`Average time: ${average}`);
	console.log(`Shortest time: ${shortestTime}`);
	console.log(`Longest time: ${longestTime}`);
	console.log(`Failed Tests: ${failedTests}`);
	console.log(`Passed Tests: ${passedTests}`);
	console.log(`-------------`);
}