# NOTE from the developer:
# You only need to manipulate the codes BELOW, the rest of the codes
# are the core functionality of the program and requires no refactoring

import time
import math
from random import randint

# generates random data for testing purpose
def generateRandomTestData(dataLength, maxNumber):
	randomTestData = []
	for a in range(1, dataLength): randomTestData.append(randint(1, maxNumber))
	return randomTestData

def bubbleSort(randomTestData):
	for a in range(len(randomTestData) - 1, 0, -1):
		for b in range(0, a):
			if (randomTestData[b] > randomTestData[b + 1]):
				temp = randomTestData[b]
				randomTestData[b] = randomTestData[b + 1]
				randomTestData[b + 1] = temp
	return randomTestData

def assertTests(sortedArr):
	for a in range(0, len(sortedArr) - 1):
		if (sortedArr[a] > sortedArr [a + 1]):
			return False
	return True

def doIt(numberOfTests, maxNumber, dataLength, showSortedArray = False, runTest = True):
	startTime = 0
	endTime = 0
	average = 0
	longestTime = 0
	shortestTime = 0
	timeConsumed = 0
	failedTests = 0
	passedTests = 0

	for a in range(0, numberOfTests):
		# generate random data
		randomTestData = generateRandomTestData(dataLength, maxNumber);
		# get start time
		startTime = math.ceil(time.time())
		# run the sort
		sortedArr = bubbleSort(randomTestData)
		# get end time
		endTime = math.ceil(time.time())
		# calculate how much time was consumed
		timeConsumed = (endTime - startTime)

		# change the longest time
		if (timeConsumed > longestTime): longestTime = timeConsumed

		# change the shortest time
		if (a == 1 or timeConsumed < shortestTime): shortestTime = timeConsumed

		# add the time consumed to the average for later use
		average += timeConsumed

		if (showSortedArray):
			message = ', '.join(str(a) for a in sortedArr)
		else:
			message = str(timeConsumed) +" second(s)"

		if (runTest):
			if (not assertTests(sortedArr)):
				message = "test #"+ str(a) +": FAILED : "+ message
				failedTests += 1
			else:
				message = "test #"+ str(a) +": PASSED : "+ message
				passedTests += 1
		else:
				message = "test #"+ str(a) +": "+ message

		print(message)

	# compute average time consumed
	average = average / numberOfTests

	print("-------------")
	print("Conducted: "+ str(numberOfTests) +" test(s).")
	print("language: Python")
	print("Data length: "+ str(dataLength))
	print("Average time: " + str(average))
	print("Shortest time:" + str(shortestTime))
	print("Longest time:" + str(longestTime))
	print("Failed tests:" + str(failedTests))
	print("Passed tests:" + str(passedTests))
	print("-------------")

# BELOW

ten = 10
hundred = 100
thousand = 1000
ten_thousand = 10000
hundred_thousand = 100000
million = 1000000

# very self-explanatory
# int numberOfTests, int maxNumber, int dataLength, boolean showSortedArray = False, boolean runTest = True
doIt(ten, million, hundred_thousand, runTest = False)