# Searching & Sorting Algorithms in Java

This repository contains Java implementations of fundamental **Searching** and **Sorting-related** problems commonly asked in coding interviews and competitive programming.

The programs focus mainly on **Binary Search** and its variations, including:

* Standard Binary Search
* Binary Search on Characters and Strings
* Recursive Binary Search
* Ceiling and Floor problems
* First and Last Occurrence problems
* Searching in Rotated Sorted Arrays
* Rotation Count problems
* Median of Two Sorted Arrays

---

# Folder Structure

```text
Searching_Sorting/
│
├── BinarySearch.java
├── BinarySearchChar.java
├── BinarySearchInString.java
├── BinarySearchRecursion.java
├── CeilingInSortedArray.java
├── FindFirstAndLastOccurence.java
├── FindFirstOccurenceIndex.java
├── FindNumberOfOccurencesOfElement.java
├── FirstOccurrenceOfChar.java
├── FloorInSortedArray.java
├── FloorInSortedArraySolution.java
├── MedianOf2SortedArrays.java
├── RotationCountOfArray_2.java
├── RotationCountRotatedSortedArray.java
└── SearchInRotatedSortedArray.java
```

---

# Algorithms Included

## 1. BinarySearch.java

Implements the standard **Binary Search** algorithm on a sorted integer array.

### Concepts Covered

* Divide and Conquer
* Iterative Binary Search
* Time Complexity: `O(log n)`

---

## 2. BinarySearchChar.java

Performs Binary Search on a sorted character array.

### Concepts Covered

* Searching characters
* Character comparisons
* Binary Search logic with chars

---

## 3. BinarySearchInString.java

Uses Binary Search techniques with strings.

### Concepts Covered

* String comparison
* Lexicographical ordering
* Binary Search on string collections

---

## 4. BinarySearchRecursion.java

Recursive implementation of Binary Search.

### Concepts Covered

* Recursion
* Base conditions
* Recursive divide-and-conquer

### Time Complexity

`O(log n)`

---

## 5. CeilingInSortedArray.java

Finds the **ceiling** of a target element in a sorted array.

### Ceiling

The smallest element greater than or equal to the target.

### Example

```text
Array: [2, 3, 5, 9, 14, 16, 18]
Target: 15
Ceiling: 16
```

---

## 6. FindFirstAndLastOccurence.java

Finds the first and last occurrence of an element in a sorted array.

### Concepts Covered

* Modified Binary Search
* Range searching
* Duplicate handling

---

## 7. FindFirstOccurenceIndex.java

Finds the index of the first occurrence of a given element.

### Concepts Covered

* Left-bound Binary Search
* Duplicate element handling

---

## 8. FindNumberOfOccurencesOfElement.java

Counts the total number of occurrences of an element.

### Logic

```text
Count = Last Occurrence - First Occurrence + 1
```

---

## 9. FirstOccurrenceOfChar.java

Finds the first occurrence of a character in a sequence.

### Concepts Covered

* Character traversal
* Searching logic

---

## 10. FloorInSortedArray.java

Finds the **floor** of a target element in a sorted array.

### Floor

The greatest element smaller than or equal to the target.

### Example

```text
Array: [2, 3, 5, 9, 14, 16, 18]
Target: 15
Floor: 14
```

---

## 11. FloorInSortedArraySolution.java

Alternative or optimized solution for the floor problem.

### Concepts Covered

* Binary Search optimization
* Edge case handling

---

## 12. MedianOf2SortedArrays.java

Finds the median of two sorted arrays.

### Concepts Covered

* Partition-based Binary Search
* Efficient median calculation

### Time Complexity

`O(log(min(n, m)))`

---

## 13. RotationCountOfArray_2.java

Finds the number of rotations in a rotated sorted array.

### Concepts Covered

* Pivot finding
* Binary Search in rotated arrays

---

## 14. RotationCountRotatedSortedArray.java

Another implementation for finding rotation count.

### Concepts Covered

* Minimum element search
* Rotation index detection

---

## 15. SearchInRotatedSortedArray.java

Searches an element in a rotated sorted array.

### Concepts Covered

* Pivot detection
* Modified Binary Search

### Example

```text
Array: [4,5,6,7,0,1,2]
Target: 0
Output: Index 4
```

---

# Time Complexity Summary

| Algorithm                   | Time Complexity  |
| --------------------------- | ---------------- |
| Binary Search               | O(log n)         |
| Ceiling/Floor Search        | O(log n)         |
| First/Last Occurrence       | O(log n)         |
| Rotation Count              | O(log n)         |
| Search in Rotated Array     | O(log n)         |
| Median of Two Sorted Arrays | O(log(min(n,m))) |

---

# How to Run

## Compile

```bash
javac FileName.java
```

## Execute

```bash
java FileName
```

### Example

```bash
javac BinarySearch.java
java BinarySearch
```

---

# Prerequisites

* Java JDK 8 or above
* Basic understanding of arrays and Binary Search

---

# Learning Goals

This folder is useful for:

* Learning Binary Search variations
* Practicing interview problems
* Understanding optimized searching techniques
* Strengthening problem-solving skills in Java

---

# Topics Covered

* Arrays
* Binary Search
* Recursion
* Rotated Sorted Arrays
* Searching Algorithms
* Divide and Conquer
* Interview Preparation

---

# Author

**Lakshmi Prashanth**

GitHub Repository:

```text
Data_Structures_And_Algorithms
```

---

# License

This project is open source and available for learning and educational purposes.
