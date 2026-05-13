# Two Pointer & Sliding Window Algorithms

This folder contains classic problems solved using:

* Two Pointer Technique
* Sliding Window Technique
* Hashing
* Prefix Sum
* Greedy Approaches
* Sorting

These patterns are widely used in coding interviews and competitive programming because they help optimize brute-force solutions into efficient linear or near-linear time complexity.

---

# Algorithms Covered

## 1. ContainerWithMostWater.java

### Pattern

Two Pointer

### Problem

Find two lines that together with the x-axis form a container that can hold the maximum amount of water.

### Logic

* Place one pointer at the beginning and another at the end.
* Calculate the area using:

```text
Area = min(height[left], height[right]) * (right - left)
```

* Move the pointer with the smaller height because:

  * The width decreases every step.
  * To get a larger area, we need a potentially taller line.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(1)
```

---

## 2. CountSubArraysNotExceedingM_SlidingWindow.java

### Pattern

Sliding Window

### Problem

Count subarrays where the sum does not exceed a given value `M`.

### Logic

* Expand the window by moving the right pointer.
* Keep adding elements to the current sum.
* If the sum exceeds `M`, shrink the window from the left.
* Every valid window contributes:

```text
(right - left + 1)
```

subarrays.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(1)
```

---

## 3. CountSubArraysWithSumK.java

### Pattern

Prefix Sum + HashMap

### Problem

Count the number of subarrays whose sum equals `K`.

### Logic

* Maintain a running prefix sum.
* If:

```text
prefixSum - K
```

exists in the hashmap, then a valid subarray exists.

### Formula

```text
CurrentSum - PreviousPrefixSum = K
```

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(n)
```

---

## 4. CountSubarraysWithAverageK.java

### Pattern

Sliding Window / Prefix Transformation

### Problem

Count subarrays having average equal to `K`.

### Logic

Average condition:

```text
sum / length = K
```

Transform into:

```text
sum = K * length
```

Then convert elements using:

```text
arr[i] = arr[i] - K
```

Now the problem becomes counting subarrays with sum `0`.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(n)
```

---

## 5. DutchNationalFlag.java

### Pattern

Two Pointer / Three Pointer Partitioning

### Problem

Sort an array containing only `0s`, `1s`, and `2s`.

### Logic

Maintain three pointers:

* `low` → next position for `0`
* `mid` → current element
* `high` → next position for `2`

Rules:

* If element is `0` → swap with `low`
* If element is `1` → move `mid`
* If element is `2` → swap with `high`

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(1)
```

---

## 6. EquilibriumIndex.java

### Pattern

Prefix Sum

### Problem

Find an index where:

```text
Left Sum = Right Sum
```

### Logic

* Compute total sum.
* Traverse the array while maintaining left sum.
* Right sum becomes:

```text
totalSum - leftSum - currentElement
```

If left sum equals right sum, that index is the equilibrium index.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(1)
```

---

## 7. MaxSumOfSubArraysOfSizeK.java

### Pattern

Fixed Size Sliding Window

### Problem

Find the maximum sum of any subarray of size `K`.

### Logic

* Compute the sum of the first `K` elements.
* Slide the window:

```text
windowSum += arr[right]
windowSum -= arr[left]
```

* Track maximum sum.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(1)
```

---

## 8. MinimizeMaxPairSum.java

### Pattern

Two Pointer + Sorting

### Problem

Pair elements such that the maximum pair sum is minimized.

### Logic

* Sort the array.
* Pair:

  * smallest element
  * largest element

This balances pair sums and minimizes the maximum pair value.

### Time Complexity

```text
O(n log n)
```

### Space Complexity

```text
O(1)
```

---

## 9. MinimizeMaxPairSumInArray.java

### Pattern

Greedy + Two Pointer

### Problem

Another variation of minimizing the maximum pair sum.

### Logic

* Sort the array.
* Use two pointers:

  * one from the start
  * one from the end
* Track the largest pair sum among all pairs.

### Time Complexity

```text
O(n log n)
```

### Space Complexity

```text
O(1)
```

---

## 10. RemoveDuplicatesFromSortedArray.java

### Pattern

Two Pointer

### Problem

Remove duplicates from a sorted array in-place.

### Logic

* One pointer tracks unique positions.
* Another pointer scans the array.
* When a new unique element is found:

  * place it at the unique index.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(1)
```

---

## 11. ReverseVowels.java

### Pattern

Two Pointer

### Problem

Reverse only the vowels in a string.

### Logic

* Use two pointers:

  * one from the beginning
  * one from the end
* Move pointers until vowels are found.
* Swap vowels.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(n)
```

---

## 12. SmallestDistinctWindow.java

### Pattern

Sliding Window + HashMap

### Problem

Find the smallest substring containing all distinct characters.

### Logic

* Count all unique characters in the string.
* Expand the window until all distinct characters are included.
* Shrink the window while maintaining validity.
* Track the minimum length.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(k)
```

where `k` is the number of distinct characters.

---

## 13. SmallestDistinctWindow1.java

### Pattern

Sliding Window

### Problem

Alternative implementation for the smallest distinct window problem.

### Logic

* Similar to `SmallestDistinctWindow.java`
* Uses optimized frequency tracking and window shrinking.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(k)
```

---

## 14. SmallestSubarrayWithSumGreaterThanX.java

### Pattern

Variable Size Sliding Window

### Problem

Find the minimum length subarray whose sum is greater than `X`.

### Logic

* Expand the window until the sum exceeds `X`.
* Shrink the window from the left while maintaining the condition.
* Track the minimum window length.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(1)
```

---

## 15. SubSequencesOfArrayWithSumEqualToK.java

### Pattern

Recursion / Backtracking

### Problem

Generate all subsequences whose sum equals `K`.

### Logic

At every index:

* Include the current element.
* Exclude the current element.

Use recursion to explore all possibilities.

### Time Complexity

```text
O(2^n)
```

### Space Complexity

```text
O(n)
```

---

## 16. TwoSumInSortedArray.java

### Pattern

Two Pointer

### Problem

Find two numbers in a sorted array whose sum equals a target.

### Logic

* Use two pointers:

  * left at start
  * right at end

Rules:

* If sum is too small → move left pointer.
* If sum is too large → move right pointer.
* If sum equals target → answer found.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(1)
```

---

## 17. TwoSumUnsortedArray.java

### Pattern

HashMap

### Problem

Find whether a pair exists with the target sum in an unsorted array.

### Logic

* Store visited elements in a hashmap/set.
* For each element:

```text
target - current
```

is checked in the hashmap.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(n)
```

---

## 18. TwoSumUnsortedArray_GetPair.java

### Pattern

HashMap

### Problem

Return the actual pair whose sum equals the target.

### Logic

* Traverse the array.
* Store elements and indices in a hashmap.
* If complement exists:

```text
target - current
```

return the pair.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(n)
```

---

# Key Concepts Used

| Technique      | Description                                                    |
| -------------- | -------------------------------------------------------------- |
| Two Pointer    | Efficiently process sorted arrays or strings using two indices |
| Sliding Window | Optimize subarray/substring problems                           |
| Prefix Sum     | Quickly calculate cumulative sums                              |
| HashMap        | Fast lookup for complements and frequencies                    |
| Greedy         | Make locally optimal choices                                   |
| Recursion      | Explore all combinations/subsequences                          |

---

# Recommended Learning Order

1. TwoSumInSortedArray
2. RemoveDuplicatesFromSortedArray
3. ReverseVowels
4. MaxSumOfSubArraysOfSizeK
5. SmallestSubarrayWithSumGreaterThanX
6. ContainerWithMostWater
7. DutchNationalFlag
8. CountSubArraysWithSumK
9. SmallestDistinctWindow
10. SubSequencesOfArrayWithSumEqualToK

---

# Summary

This repository demonstrates important interview-focused array and string techniques using:

* Two Pointer
* Sliding Window
* Hashing
* Prefix Sum
* Greedy Algorithms
* Recursion

Mastering these patterns significantly improves problem-solving speed and optimization skills for coding interviews and competitive programming.
