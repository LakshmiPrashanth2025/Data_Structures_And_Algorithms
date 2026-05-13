# Sorting Algorithms in Java

This directory contains implementations of classic sorting algorithms and related searching/sorting optimization problems in Java.

Sorting is one of the most fundamental topics in Data Structures and Algorithms because many advanced algorithms depend on efficient data organization.

---

# What is Sorting?

Sorting is the process of arranging elements in a specific order such as:

* Ascending order
* Descending order
* Lexicographical order

Sorting improves:

* Searching efficiency
* Data processing
* Duplicate detection
* Optimization problems

---

# Types of Sorting Algorithms Covered

| Type                       | Algorithms                                  |
| -------------------------- | ------------------------------------------- |
| Simple Sorting             | Bubble Sort, Selection Sort, Insertion Sort |
| Divide and Conquer         | Merge Sort, Quick Sort                      |
| Specialized Sorting        | Cycle Sort, Shell Sort Merge                |
| Binary Search Optimization | Koko Eating Bananas                         |

---

# 1. BubbleSort.java

## Problem

Sort an array by repeatedly swapping adjacent elements if they are in the wrong order.

---

## Programming Logic

Bubble Sort compares adjacent elements.

If:

```text
arr[i] > arr[i+1]
```

Then swap them.

Largest elements gradually move toward the end like bubbles rising to the surface.

---

## Algorithm

```text
Repeat for all elements:
    Compare adjacent elements
    Swap if needed
```

---

## Example

Input:

```text
5 1 4 2
```

Pass 1:

```text
1 4 2 5
```

Pass 2:

```text
1 2 4 5
```

---

## Time Complexity

| Case    | Complexity |
| ------- | ---------- |
| Best    | O(n)       |
| Average | O(n²)      |
| Worst   | O(n²)      |

---

# 2. CycleSort.java

## Problem

Sort an array with minimum number of writes/swaps.

Cycle Sort is useful when memory writes are expensive.

---

## Programming Logic

Each element is placed directly into its correct position.

The algorithm:

1. Counts smaller elements.
2. Determines correct index.
3. Swaps element into correct location.
4. Repeats cycle until element reaches proper position.

---

## Key Idea

Every number should go exactly where it belongs.

This reduces unnecessary swaps.

---

## Algorithm

```text
For every element:
    Find correct position
    Swap into position
    Continue cycle
```

---

## Time Complexity

```text
O(n²)
```

---

## Advantage

Minimum memory writes.

---

# 3. InsertionSort.java

## Problem

Sort elements by inserting each element into its correct position in the already sorted part of the array.

---

## Programming Logic

Insertion Sort works similarly to arranging playing cards.

The left side of the array is maintained as sorted.

For every element:

1. Pick current element.
2. Shift larger elements to the right.
3. Insert current element into correct position.

---

## Algorithm

```text
Start from second element
    Compare with previous elements
    Shift larger values
    Insert at correct position
```

---

## Example

Input:

```text
5 3 4 1
```

Steps:

```text
3 5 4 1
3 4 5 1
1 3 4 5
```

---

## Time Complexity

| Case    | Complexity |
| ------- | ---------- |
| Best    | O(n)       |
| Average | O(n²)      |
| Worst   | O(n²)      |

---

## Advantage

Efficient for small or nearly sorted arrays.

---

# 4. KokoBananasBinarySearch.java

## Problem

Koko wants to eat banana piles within H hours.

Find minimum eating speed.

This is a classic binary search optimization problem.

---

## Programming Logic

Observation:

* Smaller eating speed → More hours needed
* Larger eating speed → Fewer hours needed

This creates a monotonic condition suitable for binary search.

---

## Binary Search Logic

Search between:

```text
1 to maxPile
```

For every speed:

1. Calculate total hours needed.
2. If hours <= H:

   * Try smaller speed.
3. Else:

   * Increase speed.

---

## Algorithm

```text
low = 1
high = maxPile

While low <= high:
    mid = eating speed

    If possible:
        save answer
        search left
    Else:
        search right
```

---

## Time Complexity

```text
O(n log m)
```

Where:

* n = number of piles
* m = maximum pile size

---

# 5. KokoEatingBananasLinearSearch.java

## Problem

Same Koko banana problem solved using linear search.

---

## Programming Logic

Instead of binary search:

1. Try every eating speed from 1 onward.
2. Calculate hours needed.
3. Return first valid speed.

---

## Algorithm

```text
For speed from 1 to maxPile:
    Calculate total hours
    If valid:
        return speed
```

---

## Time Complexity

```text
O(n × m)
```

Less efficient than binary search.

---

## Comparison with Binary Search

| Approach      | Complexity |
| ------------- | ---------- |
| Linear Search | O(n × m)   |
| Binary Search | O(n log m) |

---

# 6. MergeSortExample.java

## Problem

Sort an array using Merge Sort.

Merge Sort uses Divide and Conquer.

---

## Programming Logic

1. Divide array into halves.
2. Recursively sort both halves.
3. Merge sorted halves.

---

## Divide and Conquer

```text
Divide → Sort → Merge
```

---

## Merge Step

Two sorted arrays are combined into one sorted array.

Pointers are used:

* Left pointer
* Right pointer

Smaller value is copied first.

---

## Algorithm

```text
Split array
Recursively sort left
Recursively sort right
Merge arrays
```

---

## Time Complexity

```text
O(n log n)
```

---

## Space Complexity

```text
O(n)
```

Because temporary arrays are used.

---

# 7. MergeSortedAraaysWithoutExtraSpace.java

## Problem

Merge two sorted arrays without using extra space.

---

## Programming Logic

Instead of using temporary arrays:

1. Compare elements from both arrays.
2. Swap larger/smaller values appropriately.
3. Re-sort affected portions if necessary.

The goal is in-place merging.

---

## Key Idea

Maintain sorted order without additional memory.

---

## Common Techniques

* Gap method
* Swapping and insertion
* Shell-sort-like comparisons

---

## Time Complexity

Depends on implementation.

Commonly:

```text
O((n+m) log(n+m))
```

---

# 8. MergeTwoArraysShellSort.java

## Problem

Merge two sorted arrays using Shell Sort gap method.

---

## Programming Logic

This approach uses a shrinking gap.

Steps:

1. Treat two arrays as a single virtual array.
2. Compare elements at distance = gap.
3. Swap if needed.
4. Reduce gap.
5. Continue until gap becomes 1.

---

## Gap Formula

```text
gap = ceil(gap / 2)
```

---

## Algorithm

```text
Initialize gap
Compare distant elements
Swap if needed
Reduce gap
Repeat
```

---

## Time Complexity

Approximate:

```text
O((n+m) log(n+m))
```

---

## Advantage

Efficient in-place merging.

---

# 9. MergeTwoSortedArrays.java

## Problem

Merge two sorted arrays into one sorted array.

---

## Programming Logic

Use two pointers:

* One for first array
* One for second array

Compare elements:

* Smaller element goes into result array.

Continue until all elements are merged.

---

## Algorithm

```text
Compare elements from both arrays
Insert smaller element
Move corresponding pointer
Copy remaining elements
```

---

## Example

Input:

```text
[1,3,5]
[2,4,6]
```

Output:

```text
[1,2,3,4,5,6]
```

---

## Time Complexity

```text
O(n + m)
```

---

# 10. QuickSort.java

## Problem

Sort an array using Quick Sort.

Quick Sort is a Divide and Conquer algorithm.

---

## Programming Logic

1. Choose a pivot element.
2. Partition array:

   * Smaller elements left
   * Larger elements right
3. Recursively sort left and right parts.

---

## Partitioning

The pivot reaches its correct sorted position.

Then recursion continues on subarrays.

---

## Algorithm

```text
Choose pivot
Partition array
Recursively sort left
Recursively sort right
```

---

## Example

Input:

```text
4 2 7 1
```

Pivot:

```text
4
```

Partition:

```text
2 1 4 7
```

---

## Time Complexity

| Case    | Complexity |
| ------- | ---------- |
| Best    | O(n log n) |
| Average | O(n log n) |
| Worst   | O(n²)      |

---

## Space Complexity

```text
O(log n)
```

Due to recursion stack.

---

# 11. SelectionSort.java

## Problem

Sort an array by repeatedly selecting the minimum element.

---

## Programming Logic

For every position:

1. Find smallest element in unsorted part.
2. Swap with current position.

Sorted portion grows from left to right.

---

## Algorithm

```text
Find minimum element
Swap with current index
Repeat for remaining array
```

---

## Example

Input:

```text
5 3 1 4
```

Steps:

```text
1 3 5 4
1 3 5 4
1 3 4 5
```

---

## Time Complexity

```text
O(n²)
```

---

## Advantage

Performs fewer swaps compared to Bubble Sort.

---

# Summary Table

| File                                    | Algorithm Type             | Time Complexity    |
| --------------------------------------- | -------------------------- | ------------------ |
| BubbleSort.java                         | Simple comparison sort     | O(n²)              |
| CycleSort.java                          | Minimum write sort         | O(n²)              |
| InsertionSort.java                      | Incremental insertion sort | O(n²)              |
| KokoBananasBinarySearch.java            | Binary Search Optimization | O(n log m)         |
| KokoEatingBananasLinearSearch.java      | Linear Search Optimization | O(n × m)           |
| MergeSortExample.java                   | Divide and Conquer         | O(n log n)         |
| MergeSortedAraaysWithoutExtraSpace.java | In-place merging           | Varies             |
| MergeTwoArraysShellSort.java            | Gap method merge           | O((n+m) log(n+m))  |
| MergeTwoSortedArrays.java               | Two-pointer merge          | O(n+m)             |
| QuickSort.java                          | Divide and Conquer         | O(n log n) average |
| SelectionSort.java                      | Selection-based sorting    | O(n²)              |

---

# Key Concepts Learned

This repository demonstrates:

* Sorting fundamentals
* Divide and Conquer
* Recursion
* Partitioning
* Binary Search optimization
* Two-pointer technique
* In-place sorting
* Space optimization

---

# Comparison of Sorting Algorithms

| Algorithm      | Stable | In-Place | Best Use                 |
| -------------- | ------ | -------- | ------------------------ |
| Bubble Sort    | Yes    | Yes      | Learning basics          |
| Selection Sort | No     | Yes      | Minimal swaps            |
| Insertion Sort | Yes    | Yes      | Nearly sorted arrays     |
| Merge Sort     | Yes    | No       | Large datasets           |
| Quick Sort     | No     | Yes      | Fast average performance |
| Cycle Sort     | No     | Yes      | Minimize writes          |

---

# Conclusion

These implementations provide a strong understanding of:

* Basic sorting techniques
* Efficient divide-and-conquer algorithms
* Optimization using binary search
* Array manipulation strategies
* Space-efficient merging approaches

Sorting is one of the most important foundations for advanced Data Structures and Algorithms, and mastering these algorithms helps build efficient problem-solving skills.
