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

### Logic

Binary Search works by repeatedly dividing the search space into two halves.

1. Find the middle element of the array.
2. Compare the middle element with the target.
3. If the target is equal to the middle element, return the index.
4. If the target is smaller, search in the left half.
5. If the target is greater, search in the right half.
6. Repeat until the element is found or the search space becomes empty.

### Pseudocode

```text
start = 0
end = array.length - 1

while(start <= end)
    mid = start + (end - start) / 2

    if(array[mid] == target)
        return mid

    else if(target < array[mid])
        end = mid - 1

    else
        start = mid + 1
```

### Concepts Covered

* Divide and Conquer
* Iterative Binary Search
* Efficient searching in sorted arrays

### Time Complexity

`O(log n)`

---

## 2. BinarySearchChar.java

Performs Binary Search on a sorted character array.

### Logic

1. Initialize `start` and `end` pointers.
2. Find the middle character.
3. Compare the target character with the middle character.
4. Move left or right depending on alphabetical order.
5. Repeat until the character is found.

### Pseudocode

```text
while(start <= end)
    mid = start + (end - start) / 2

    if(arr[mid] == target)
        return mid

    else if(target < arr[mid])
        end = mid - 1

    else
        start = mid + 1
```

### Concepts Covered

* Searching characters
* Character comparisons
* Binary Search logic with chars

---

## 3. BinarySearchInString.java

Uses Binary Search techniques with strings.

### Logic

1. Store strings in sorted order.
2. Find the middle string.
3. Compare the target string lexicographically.
4. Move left or right based on comparison result.
5. Continue until the string is found.

### Concepts Covered

* String comparison
* Lexicographical ordering
* Binary Search on string collections

---

## 4. BinarySearchRecursion.java

Recursive implementation of Binary Search.

### Logic

1. Find the middle element.
2. If target equals middle element, return index.
3. If target is smaller, recursively search left half.
4. If target is greater, recursively search right half.
5. Stop recursion when `start > end`.

### Pseudocode

```text
binarySearch(arr, start, end, target)

if(start > end)
    return -1

mid = start + (end - start) / 2

if(arr[mid] == target)
    return mid

if(target < arr[mid])
    return binarySearch(arr, start, mid - 1, target)

return binarySearch(arr, mid + 1, end, target)
```

### Concepts Covered

* Recursion
* Base conditions
* Recursive divide-and-conquer

### Time Complexity

`O(log n)`

---

## 5. CeilingInSortedArray.java

Finds the **ceiling** of a target element in a sorted array.

### Logic

1. Perform Binary Search.
2. If target is found, return it.
3. If target is greater than middle element, move right.
4. Otherwise move left.
5. At the end, `start` points to the ceiling element.

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

### Logic

1. Use Binary Search to find first occurrence.
2. Continue searching toward left after finding target.
3. Use another Binary Search for last occurrence.
4. Continue searching toward right after finding target.
5. Return both indexes.

### Concepts Covered

* Modified Binary Search
* Range searching
* Duplicate handling

---

## 7. FindFirstOccurenceIndex.java

Finds the index of the first occurrence of a given element.

### Logic

1. Perform Binary Search.
2. When target is found, store index.
3. Continue searching left side.
4. Final stored index becomes first occurrence.

### Concepts Covered

* Left-bound Binary Search
* Duplicate element handling

---

## 8. FindNumberOfOccurencesOfElement.java

Counts the total number of occurrences of an element.

### Logic

1. Find first occurrence using Binary Search.
2. Find last occurrence using Binary Search.
3. Apply formula:

```text
Occurrences = lastIndex - firstIndex + 1
```

### Logic

```text
Count = Last Occurrence - First Occurrence + 1
```

---

## 9. FirstOccurrenceOfChar.java

Finds the first occurrence of a character in a sequence.

### Logic

1. Traverse the character sequence.
2. Compare each character with target.
3. Return the index when first match is found.
4. If no match exists, return `-1`.

### Concepts Covered

* Character traversal
* Searching logic

---

## 10. FloorInSortedArray.java

Finds the **floor** of a target element in a sorted array.

### Logic

1. Perform Binary Search.
2. If target is found, return it.
3. If target is greater than middle element, move right.
4. Otherwise move left.
5. At the end, `end` points to floor element.

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

### Logic

1. Use optimized Binary Search.
2. Keep track of possible floor value.
3. Update floor when current element is less than target.
4. Continue searching until search space ends.

### Concepts Covered

* Binary Search optimization
* Edge case handling

---

## 12. MedianOf2SortedArrays.java

Finds the median of two sorted arrays.

### Logic

1. Apply Binary Search on smaller array.
2. Partition both arrays into left and right halves.
3. Ensure left half elements are smaller than right half elements.
4. Calculate median based on total length being even or odd.
5. Continue adjusting partitions until valid partition is found.

### Concepts Covered

* Partition-based Binary Search
* Efficient median calculation

### Time Complexity

`O(log(min(n, m)))`

---

## 13. RotationCountOfArray_2.java

Finds the number of rotations in a rotated sorted array.

### Logic

1. Find the minimum element using Binary Search.
2. The index of minimum element equals rotation count.
3. Compare middle element with neighbors.
4. Move search space based on sorted halves.

### Concepts Covered

* Pivot finding
* Binary Search in rotated arrays

---

## 14. RotationCountRotatedSortedArray.java

Another implementation for finding rotation count.

### Logic

1. Detect pivot element.
2. Pivot index + 1 gives rotation count.
3. Use Binary Search conditions to find pivot efficiently.

### Concepts Covered

* Minimum element search
* Rotation index detection

---

## 15. SearchInRotatedSortedArray.java

Searches an element in a rotated sorted array.

### Logic

1. Find pivot point in rotated array.
2. Determine which half is sorted.
3. Apply Binary Search on the correct half.
4. Return index if target exists.

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



GitHub Repository:

```text
Data_Structures_And_Algorithms
```

---

# License

This project is open source and available for learning and educational purposes.
