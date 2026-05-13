# BackTracking Algorithms in Java

This repository contains classic **Backtracking** and **Recursion-based** algorithm problems implemented in Java. These problems are widely used in coding interviews, competitive programming, and algorithm learning.

---

# What is Backtracking?

Backtracking is a recursive problem-solving technique where:

1. We build a solution step-by-step.
2. If a choice leads to an invalid solution, we undo the choice.
3. Then we try another possibility.

This approach is commonly used in:

* Permutations and combinations
* Puzzle solving
* Constraint satisfaction problems
* Path finding
* Recursive search problems

General Backtracking Pattern:

```java
void backtrack(parameters) {
    if (baseCondition) {
        saveSolution();
        return;
    }

    for (all possible choices) {
        makeChoice();

        backtrack(nextState);

        undoChoice();
    }
}
```

---

# 1. CombinationsOfString.java

## Problem

Generate all possible combinations/subsets of characters from a string.

Example:

Input:

```text
ABC
```

Output:

```text
A
B
C
AB
AC
BC
ABC
```

---

## Programming Logic

The algorithm recursively decides:

* Include the current character
* Exclude the current character

At every index, there are two choices.

This forms a recursion tree.

---

## Algorithm Steps

1. Start from index 0.
2. Add current character to the combination.
3. Recurse for next index.
4. Remove the character (backtrack).
5. Recurse again without including it.

---

## Time Complexity

```text
O(2^n)
```

Because every character has two choices.

---

# 2. NQueens.txt

## Purpose

This file  contains:

* Problem explanation
* Notes for the N-Queens problem

---

# 3. NQueensByBackTracking.java

## Problem

Place N queens on an N × N chessboard such that:

* No two queens attack each other.
* Queens cannot share:

  * Row
  * Column
  * Diagonal

---

## Programming Logic

The algorithm places queens row-by-row.

For each row:

1. Try placing a queen in every column.
2. Check whether the position is safe.
3. If safe:

   * Place the queen.
   * Move to next row.
4. If no valid position exists:

   * Remove previously placed queen.
   * Try another column.

This is classic backtracking.

---

## Safety Check

Before placing a queen:

* Check upper column
* Check left diagonal
* Check right diagonal

---

## Algorithm

```text
Place queen in row
    Try every column
        If safe:
            Place queen
            Solve next row
            Remove queen
```

---

## Time Complexity

Approximate:

```text
O(N!)
```

---

# 4. NQueensByRecursion.java

## Problem

Solve N-Queens using recursion.

This version focuses more on recursive traversal than explicit backtracking explanation.

---

## Programming Logic

* Recursively process one row at a time.
* Try all columns.
* Use recursive calls to explore valid configurations.
* Return when all queens are placed.

---

## Difference from Backtracking Version

| Recursion                 | Backtracking                    |
| ------------------------- | ------------------------------- |
| Focuses on recursive flow | Focuses on undoing choices      |
| Simpler explanation       | More optimized search           |
| Uses recursive calls      | Uses recursion + state reversal |

---

## Time Complexity

```text
O(N!)
```

---

# 5. PalindromePartitioning.java

## Problem

Partition a string such that every substring is a palindrome.

Example:

Input:

```text
aab
```

Output:

```text
[a, a, b]
[aa, b]
```

---

## Programming Logic

The algorithm recursively:

1. Chooses a substring.
2. Checks whether it is palindrome.
3. If valid:

   * Add to current partition.
   * Continue partitioning remaining string.
4. Backtrack after recursion.

---

## Palindrome Check

Two-pointer technique:

```text
Compare left and right characters
Move inward
```

---

## Algorithm

```text
Start from index
    Generate substring
    If palindrome:
        Add substring
        Recurse for remaining string
        Remove substring
```

---

## Time Complexity

Worst case:

```text
O(2^n)
```

---

# 6. Permutations.java

## Problem

Generate all permutations of a string or array.

Example:

Input:

```text
ABC
```

Output:

```text
ABC
ACB
BAC
BCA
CAB
CBA
```

---

## Programming Logic

The algorithm swaps elements recursively.

For each position:

1. Swap current element with every possible element.
2. Recurse for next position.
3. Swap back (backtrack).

---

## Algorithm

```text
Fix character at current index
    Swap with remaining characters
    Recurse
    Undo swap
```

---

## Time Complexity

```text
O(n!)
```

---

# 7. PrintAllSubsets.java

## Problem

Print all subsets of a set.

Example:

Input:

```text
[1,2,3]
```

Output:

```text
[]
[1]
[2]
[3]
[1,2]
[1,3]
[2,3]
[1,2,3]
```

---

## Programming Logic

At every element:

* Include it
* Exclude it

This creates all possible subsets.

---

## Algorithm

```text
For every index:
    Include current element
    Recurse

    Exclude current element
    Recurse
```

---

## Time Complexity

```text
O(2^n)
```

---

# 8. QueensAttackKing.java

## Problem

Given positions of queens and a king on a chessboard, find all queens that can attack the king.

---

## Programming Logic

A queen attacks in:

* Horizontal
* Vertical
* Diagonal directions

The algorithm explores all 8 directions from the king.

---

## Directions Checked

```text
Up
Down
Left
Right
4 Diagonals
```

---

## Algorithm

1. Store queen positions.
2. Start from king position.
3. Move in all 8 directions.
4. First queen encountered in a direction can attack the king.

---

## Time Complexity

```text
O(8 × boardSize)
```

Efficient because only directional scanning is used.

---

# 9. RatInAMaze.java

## Problem

Find all possible paths for a rat to move from source to destination in a maze.

Allowed movements usually:

* Up
* Down
* Left
* Right

---

## Programming Logic

The algorithm recursively explores paths.

At each cell:

1. Check whether move is valid.
2. Mark cell as visited.
3. Explore all directions.
4. Unmark cell during backtracking.

---

## Algorithm

```text
If destination reached:
    Print path

Mark current cell visited

Move in all directions

Unmark current cell
```

---

## Time Complexity

Worst case:

```text
O(4^(N×N))
```

---

# 10. SudokuSolver.java

## Problem

Solve a Sudoku puzzle using backtracking.

Rules:

* Digits 1–9 only once per row
* Digits 1–9 only once per column
* Digits 1–9 only once per 3×3 grid

---

## Programming Logic

1. Find empty cell.
2. Try digits 1–9.
3. Check whether digit placement is valid.
4. Recurse for next empty cell.
5. If no digit works:

   * Remove digit.
   * Backtrack.

---

## Validity Checks

* Row check
* Column check
* 3×3 subgrid check

---

## Algorithm

```text
Find empty cell
    Try digits 1–9
        If valid:
            Place digit
            Solve recursively
            Remove digit
```

---

## Time Complexity

Worst case:

```text
O(9^(emptyCells))
```

But pruning significantly improves performance.

---

# 11. UniquePermutations.java

## Problem

Generate unique permutations when duplicate elements exist.

Example:

Input:

```text
AAB
```

Output:

```text
AAB
ABA
BAA
```

---

## Programming Logic

Duplicate permutations are avoided using:

* Sorting
* HashSet
* Visited array

The algorithm skips already-used duplicate characters.

---

## Algorithm

```text
Sort input
For each character:
    Skip duplicates
    Choose character
    Recurse
    Backtrack
```

---

## Time Complexity

Approximately:

```text
O(n!)
```

But duplicate pruning reduces unnecessary recursion.

---

# 12. ValidSudoku.java

## Problem

Check whether a Sudoku board configuration is valid.

Unlike SudokuSolver:

* This class validates the board.
* It does not solve the puzzle.

---

## Programming Logic

The algorithm checks:

1. Every row
2. Every column
3. Every 3×3 subgrid

No digit should repeat.

---

## Algorithm

```text
For every cell:
    Check row validity
    Check column validity
    Check subgrid validity
```

HashSet is commonly used for duplicate detection.

---

## Time Complexity

```text
O(9 × 9)
```

Efficient because Sudoku size is fixed.

---

# Summary Table

| File                        | Problem Type                | Technique          |
| --------------------------- | --------------------------- | ------------------ |
| CombinationsOfString.java   | String combinations         | Recursion          |
| NQueensByBackTracking.java  | Chess constraint problem    | Backtracking       |
| NQueensByRecursion.java     | Recursive queen placement   | Recursion          |
| PalindromePartitioning.java | String partitioning         | Backtracking       |
| Permutations.java           | Permutation generation      | Backtracking       |
| PrintAllSubsets.java        | Subset generation           | Recursion          |
| QueensAttackKing.java       | Chess attack detection      | Directional search |
| RatInAMaze.java             | Path finding                | Backtracking       |
| SudokuSolver.java           | Sudoku solving              | Backtracking       |
| UniquePermutations.java     | Duplicate-safe permutations | Backtracking       |
| ValidSudoku.java            | Sudoku validation           | Hashing/Validation |

---

# Key Concepts Learned

This repository demonstrates:

* Recursion
* Backtracking
* Constraint checking
* State management
* Depth First Search (DFS)
* Permutations and combinations
* Matrix traversal
* Puzzle solving

---

# Conclusion

These implementations provide a strong foundation for mastering:

* Recursive thinking
* Search-space exploration
* Constraint satisfaction problems
* Interview-level algorithm design

Backtracking is one of the most important problem-solving techniques in Data Structures and Algorithms, and these examples cover many standard interview problems.
