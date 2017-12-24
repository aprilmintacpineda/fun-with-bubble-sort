# Bubble Sort pseudocode

Bubble sort is composed of two loops, one inside the other, the idea is to push the largest number on the right most side of the list, one by one.

### Key factors

For the sake of discussion, we'll call `a` the outer loop and `b` the inner loop.

- `a` starts at `list.length - 1`, last step occurs at `0`.
- `b` starts at `0`, last step occurs at `a - 1`, i.e., if `a = 3`, then last step of `b` would be `2`.
- `b` is the pusher, pushing the largest number on the left most side to the right most side.
- The number of loops `b` would have to do is equal to `a - 1`, that means as you get closer to the answer `b` would have to loop lesser.

```
list   [5, 4, 3, 2, 1]
index   0  1  2  3  4
```

```
1st outer loop:
	a = 4
	1st inner loop:
		b = 0
		list[b] = list[0] = 5
		list[b + 1] = list[0 + 1] = list[1] = 4
		5 > 4? swap(5, 4)
		// updated list = [4, 5, 3, 2, 1]
	2nd inner loop:
		b = 1
		list[b] = list[1] = 5
		list[b + 1] = list[1 + 1] = list[2] = 3
		5 > 3? swap(5, 3)
		// updated list = [4, 3, 5, 2, 1]
	3rd inner loop:
		b = 2
		list[b] = list[2] = 5
		list[b + 1] = list[2 + 1] = list[3] = 2
		5 > 2? swap(5, 2)
		// updated list = [4, 3, 2, 5, 1]
	4th inner loop:
		b = 3
		list[b] = list[3] = 5
		list[b + 1] = list[3 + 1] = list[4] = 1
		5 > 1? swap(5, 1)
		// updated list = [4, 3, 2, 1, 5]
	end inner loop
2nd outer loop:
	a = 3
	// updated list = [4, 3, 2, 1, 5]
	1st inner loop:
		b = 0
		list[b] = list[0] = 4
		list[b + 1] = list[0 + 1] = list[1] = 3
		4 > 3? swap(4, 3)
		// updated list = [3, 4, 2, 1, 5]
	2nd inner loop:
		b = 1
		list[b] = list[1] = 4
		list[b + 1] = list[1 + 1] = list[2] = 2
		4 > 2? swap(4, 2)
		// updated list = [3, 2, 4, 1, 5]
	3rd inner loop:
		b = 2
		list[b] = list[2] = 4
		list[b + 1] = list[2 + 1] = list[3] = 1
		4 > 1? swap(4, 1)
		// updated list = [3, 2, 1, 4, 5]
	end inner loop
3rd outer loop:
	a = 2
	// updated list = [3, 2, 1, 4, 5]
	1st inner loop:
		b = 0
		list[b] = list[0] = 3
		list[b + 1] = list[0 + 1] = list[1] = 2
		3 > 2? FALSE
		// updated list = [2, 3, 1, 4, 5]
	2nd inner loop:
		b = 1
		list[b] = list[1] = 3
		list[b + 1] = list[1 + 1] = list[2] = 1
		3 > 1? swap(3, 1)
		// updated list = [2, 1, 3, 4, 5]
	end inner loop
4th outer loop:
	a = 1
	// updated list = [2, 1, 3, 4, 5]
	1st inner loop:
		b = 0
		list[b] = list[0] = 2
		list[b + 1] = list[0 + 1] = list[1] = 1
		2 > 1? swap(2, 1)
		// updated list = [1, 2, 3, 4, 5]
	end inner loop
end outer loop
```