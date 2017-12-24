# Fun with JS, PHP, PY, and Java

Lots of developers argue about which programming language should be used to do this and that, in reality, all their answers are hugely affected by `self bias`, most of the time, programmers would use something in favor of something else because of `comfortability`, they are simply more comfortable using whatever they chose.

All high-level programming languages are pretty much alike, they were built on top of the same concepts, there's `MVC` in `PHP`, `Java`, `JavaScript`, `Python`, `.NET`, etc., they may differ in syntax, but at their very core, they are alike. Much like humans, we differ in color, height, body size, etc., but at our very core, we're all alike, but they differ in terms of speed, like humans differ in intelligence.

So, I made a `bubble sort` implementation in `Java`, `JavaScript`, `PHP`, and `Python`. If you don't know the `bubble sort` algorithm yet and you want to know, then read the [pseudocode](https://gist.github.com/aprilmintacpineda/7800a989f1f494ee8d8b442342ab5973) that I wrote.

## Links to the codes

- [Bubblesort JavaScript implementation](https://gist.github.com/aprilmintacpineda/c1ef0e21622789accfc01d0ab14651eb)
- [Bubblesort PHP implementation](https://gist.github.com/aprilmintacpineda/00025be12c5a05641696f36975ba7475)
- [Bubble sort Python implementation](https://gist.github.com/aprilmintacpineda/81a571a40500982015a8ae87947298d8)
- [Bubble sort Java implementation](https://gist.github.com/aprilmintacpineda/d9b85ee0b8afc12ef42b3cea84a96ca6)

## Notes

- NodeJS v8.6.0
- Python v3.5
- PHP 7.0.22
- Java 1.8.0_151

## Results

The `test data` that I used is an array of length 10 to 100,000. It contains a random number from 1 - 1,000,000.

I used their `longest time`.

I used Acer Laptop Aspire E 14, 4GB DDR4 Memory, intel Core i3-6100U (2.3 GHz).

I wanted to do 10 to 1,000,000 data but 1,000,000 seems too much for them to handle that it really takes a lot of time which I don't have right now, so I will just do upto 100,000. I think running assertions against the sorted array makes each tests longer, so I added a feature to disable it when desired.

Also note that the `tests` are used only to see if the results were correct. It will fail if the array was not properly sorted, in which case there is a problem with the algorithm or with my implementation.

#### Summary

###### With 10,000 data

```
JavaScript: 0.204 seconds
PHP: 4 seconds
Java: 0 seconds
Python: 14 seconds
```

![graph with 10000 data](http://oi66.tinypic.com/1zciblf.jpg)

###### With 100,000 data

Note for Python: Every test takes about 19 minutes, so I decided to just use the first result, I don't have 2 hours to lend for it so... Yeah.

```
JavaScript: 25.966 seconds
PHP: 348 seconds
Java: 24 seconds
Python: 1177 seconds
```

![graph with 100000](http://oi66.tinypic.com/27ywt4p.jpg)

#### Detailed results with 100,000 data

###### JavaScript

```
Conducted 10 test(s).
language: JavaScript
Data length: 10
Average time: 0
Shortest time: 0
Longest time: 0
Failed Tests: 0
Passed Tests: 10
-------------
Conducted 10 test(s).
language: JavaScript
Data length: 100
Average time: 0.0005
Shortest time: 0
Longest time: 0.003
Failed Tests: 0
Passed Tests: 10
-------------
Conducted 10 test(s).
language: JavaScript
Data length: 1000
Average time: 0.0019000000000000002
Shortest time: 0.001
Longest time: 0.005
Failed Tests: 0
Passed Tests: 10
-------------
Conducted 10 test(s).
language: JavaScript
Data length: 10000
Average time: 0.20179999999999998
Shortest time: 0.2
Longest time: 0.204
Failed Tests: 0
Passed Tests: 10
-------------
Conducted 10 test(s).
language: JavaScript
Data length: 100000
Average time: 25.2542
Shortest time: 24.764
Longest time: 25.966
Failed Tests: 0
Passed Tests: 10
```

###### PHP

```
Conducted 10 test(s).
language: PHP
Data length: 10
Average time: 0
Shortest time: 0
Longest time: 0
Failed tests: 0
Passed tests: 10
-------------
Conducted 10 test(s).
language: PHP
Data length: 100
Average time: 0
Shortest time: 0
Longest time: 0
Failed tests: 0
Passed tests: 10
-------------
Conducted 10 test(s).
language: PHP
Data length: 1000
Average time: 0
Shortest time: 0
Longest time: 0
Failed tests: 0
Passed tests: 10
-------------
Conducted 10 test(s).
language: PHP
Data length: 10000
Average time: 3.3
Shortest time: 3
Longest time: 4
Failed tests: 0
Passed tests: 10
-------------
Conducted 10 test(s).
language: PHP
Data length: 100000
Average time: 333
Shortest time: 319
Longest time: 348
Failed tests: 0
Passed tests: 10
```

###### Python

```
-------------
Conducted: 10 test(s).
language: Python
Data length: 10
Average time: 0.0
Shortest time:0
Longest time:0
Failed tests:0
Passed tests:10
-------------
Conducted: 10 test(s).
language: Python
Data length: 100
Average time: 0.0
Shortest time:0
Longest time:0
Failed tests:0
Passed tests:10
-------------
Conducted: 10 test(s).
language: Python
Data length: 1000
Average time: 0.1
Shortest time:0
Longest time:1
Failed tests:0
Passed tests:10
-------------
Conducted: 10 test(s).
language: Python
Data length: 10000
Average time: 11.5
Shortest time:11
Longest time:14
Failed tests:0
Passed tests:10
-------------
// TODO: 100,000
```

###### Java

```
Conducted 10 test(s).
language: Java
Data length: 10
Average time: 0
Shortest time: 0
Longest time: 0
Failed Tests: 0
Passed Tests: 10
-------------
Conducted 10 test(s).
language: Java
Data length: 100
Average time: 0
Shortest time: 0
Longest time: 0
Failed Tests: 0
Passed Tests: 10
-------------
Conducted 10 test(s).
language: Java
Data length: 1000
Average time: 0
Shortest time: 0
Longest time: 0
Failed Tests: 0
Passed Tests: 10
-------------
Conducted 10 test(s).
language: Java
Data length: 10000
Average time: 0
Shortest time: 0
Longest time: 0
Failed Tests: 0
Passed Tests: 10
-------------
Conducted 10 test(s).
language: Java
Data length: 100000
Average time: 21
Shortest time: 21
Longest time: 24
Failed Tests: 0
Passed Tests: 10
```