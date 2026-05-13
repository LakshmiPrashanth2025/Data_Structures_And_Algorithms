# Dynamic Programming Algorithms

This folder contains classic Dynamic Programming (DP) problems implemented using multiple approaches such as:

* Recursion
* Memoization (Top-Down DP)
* Tabulation (Bottom-Up DP)
* Space Optimization
* Greedy Techniques

Dynamic Programming is a powerful optimization technique used when problems have:

1. Overlapping Subproblems
2. Optimal Substructure

---

# Topics Covered

* Fibonacci Problems
* Climbing Stairs
* Knapsack Variants
* Coin Change Problems
* Longest Common Subsequence
* Longest Palindromic Subsequence
* Subset Sum
* Frog Jump
* Greedy Optimization

---

# Algorithms Explained

## 1. ClimbingStairs_Recursion.java

### Pattern

Recursion

### Problem

Count the number of ways to reach the `n-th` stair when you can climb either 1 or 2 steps.

### Logic

At every stair:

* Either take 1 step
* Or take 2 steps

Recursive relation:

```text
f(n) = f(n-1) + f(n-2)
```

### Drawback

Repeated calculations cause exponential complexity.

### Time Complexity

```text
O(2^n)
```

### Space Complexity

```text
O(n)
```

---

## 2. ClimbingStairs_Memoization.java

### Pattern

Top-Down Dynamic Programming

### Logic

* Store already computed answers in a DP array.
* Avoid recomputation.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(n)
```

---

## 3. ClimbingStairs_BottomUpTabulation.java

### Pattern

Bottom-Up Dynamic Programming

### Logic

* Build the answer iteratively from smaller subproblems.
* Start from base cases.

### Transition

```text
dp[i] = dp[i-1] + dp[i-2]
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

## 4. ClimbingStairs_DPWithOnlyPrev2Variables.java

### Pattern

Space Optimized DP

### Logic

Instead of storing the entire DP array:

* Keep only the previous two values.

This works because the current state depends only on:

```text
previous1 and previous2
```

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(1)
```

---

## 5. FibonacciByDP.java

### Pattern

Bottom-Up DP

### Problem

Find the `n-th` Fibonacci number.

### Logic

Use iterative DP:

```text
dp[i] = dp[i-1] + dp[i-2]
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

## 6. FibonacciByMemoization.java

### Pattern

Memoization

### Logic

* Cache already computed Fibonacci values.
* Avoid repeated recursion.

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(n)
```

---

## 7. Coinchange_CountWays_Recursion.java

### Pattern

Recursion

### Problem

Count the number of ways to make a target amount using given coins.

### Logic

At every coin:

* Include the coin
* Exclude the coin

### Time Complexity

```text
Exponential
```

### Space Complexity

```text
O(n)
```

---

## 8. CoinChange_CountWays_SpaceOptimizedDP.java

### Pattern

Dynamic Programming

### Logic

Use a 1D DP array where:

```text
dp[i] = number of ways to form amount i
```

Transition:

```text
dp[i] += dp[i - coin]
```

### Time Complexity

```text
O(n * amount)
```

### Space Complexity

```text
O(amount)
```

---

## 9. CoinChange_MinCoins.java

### Pattern

Dynamic Programming

### Problem

Find the minimum number of coins required to make a target amount.

### Logic

For each amount:

```text
dp[i] = min(dp[i], dp[i - coin] + 1)
```

### Time Complexity

```text
O(n * amount)
```

### Space Complexity

```text
O(amount)
```

---

## 10. FrogJump.java

### Pattern

Dynamic Programming

### Problem

Minimize the energy required for a frog to reach the last stone.

### Logic

The frog can:

* Jump 1 step
* Jump 2 steps

Transition:

```text
cost[i] = min(
    cost[i-1] + abs(height[i]-height[i-1]),
    cost[i-2] + abs(height[i]-height[i-2])
)
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

## 11. LongestCommonSubSequence_Memoization.java

### Pattern

Memoization

### Problem

Find the length of the Longest Common Subsequence (LCS).

### Logic

If characters match:

```text
1 + LCS(i-1, j-1)
```

Else:

```text
max(LCS(i-1, j), LCS(i, j-1))
```

### Time Complexity

```text
O(n * m)
```

### Space Complexity

```text
O(n * m)
```

---

## 12. LongestPalindromicSubsequence.java

### Pattern

Dynamic Programming

### Problem

Find the longest subsequence that is also a palindrome.

### Logic

This can be solved by:

```text
LCS(string, reverse(string))
```

### Time Complexity

```text
O(n^2)
```

### Space Complexity

```text
O(n^2)
```

---

## 13. LongestPalindromicSubsequencePrint.java

### Pattern

DP + Backtracking

### Problem

Print the longest palindromic subsequence.

### Logic

* Build DP table.
* Backtrack through the table to reconstruct the subsequence.

### Time Complexity

```text
O(n^2)
```

### Space Complexity

```text
O(n^2)
```

---

## 14. SubsetSum_Memoization.java

### Pattern

Memoization

### Problem

Determine whether a subset exists with a given sum.

### Logic

At every element:

* Include it
* Exclude it

Store computed states:

```text
(index, target)
```

### Time Complexity

```text
O(n * target)
```

### Space Complexity

```text
O(n * target)
```

---

## 15. UnboundedKnapsack_Memoization.java

### Pattern

Memoization

### Problem

Maximize value when items can be selected multiple times.

### Logic

Choices:

* Take current item again
* Skip current item

Transition:

```text
max(
    value + solve(remainingWeight),
    skip
)
```

### Time Complexity

```text
O(n * W)
```

### Space Complexity

```text
O(n * W)
```

---

## 16. UnboundedKnapsack_SpaceOptimizedDP.java

### Pattern

Space Optimized DP

### Logic

Use a 1D DP array:

```text
dp[w] = max value for weight w
```

### Time Complexity

```text
O(n * W)
```

### Space Complexity

```text
O(W)
```

---

## 17. Zero_01KnapsackSolver_ByRecursion.java

### Pattern

Recursion

### Problem

0/1 Knapsack Problem.

### Logic

For every item:

* Include it once
* Exclude it

### Time Complexity

```text
O(2^n)
```

### Space Complexity

```text
O(n)
```

---

## 18. Zero_01KnapsackSolver_ByRecursionAndMemoization.java

### Pattern

Memoization

### Logic

Store states:

```text
(index, remainingWeight)
```

Avoid recomputation.

### Time Complexity

```text
O(n * W)
```

### Space Complexity

```text
O(n * W)
```

---

## 19. Zero_01_Knapsack_DP_BottomUpTabulation.java

### Pattern

Bottom-Up DP

### Logic

Build DP table iteratively.

Transition:

```text
dp[i][w] = max(
    include,
    exclude
)
```

### Time Complexity

```text
O(n * W)
```

### Space Complexity

```text
O(n * W)
```

---

## 20. Zero_01_Knapsack_SortedSelection.java

### Pattern

Greedy / Sorting

### Problem

A variation involving sorted item selection.

### Logic

* Sort items based on a condition.
* Select optimal items while satisfying weight constraints.

### Time Complexity

```text
O(n log n)
```

### Space Complexity

```text
O(1)
```

---

## 21. FractionalKnapSack_ByGreedy.java

### Pattern

Greedy Algorithm

### Problem

Maximize knapsack value when fractions of items are allowed.

### Logic

* Compute:

```text
value / weight
```

ratio.

* Sort items in descending ratio.
* Pick the highest ratio items first.
* Take fractions if needed.

### Time Complexity

```text
O(n log n)
```

### Space Complexity

```text
O(1)
```

---

# Important DP Concepts

| Concept            | Description                                  |
| ------------------ | -------------------------------------------- |
| Recursion          | Solve problems using repeated function calls |
| Memoization        | Cache recursive results                      |
| Tabulation         | Build solutions iteratively                  |
| Space Optimization | Reduce DP memory usage                       |
| Greedy             | Make locally optimal choices                 |
| State Transition   | Relation between current and previous states |

---

# Common DP Patterns

## 1. Fibonacci Pattern

Used in:

* Climbing Stairs
* Fibonacci
* Frog Jump

---

## 2. Include / Exclude Pattern

Used in:

* Knapsack
* Subset Sum
* Coin Change

---

## 3. String DP Pattern

Used in:

* LCS
* Longest Palindromic Subsequence

---

# Recommended Learning Order

1. FibonacciByDP
2. ClimbingStairs_Recursion
3. ClimbingStairs_Memoization
4. ClimbingStairs_BottomUpTabulation
5. FrogJump
6. SubsetSum_Memoization
7. CoinChange_MinCoins
8. Zero_01KnapsackSolver_ByRecursion
9. Zero_01_Knapsack_DP_BottomUpTabulation
10. LongestCommonSubSequence_Memoization
11. LongestPalindromicSubsequence
12. UnboundedKnapsack_Memoization

---

# Summary

This repository demonstrates important Dynamic Programming techniques using:

* Recursion
* Memoization
* Bottom-Up Tabulation
* Space Optimization
* Greedy Algorithms

These problems form the foundation for solving advanced optimization problems commonly asked in:

* Coding Interviews
* Competitive Programming
* System Optimization Problems
* Algorithm Design

Mastering these patterns significantly improves problem-solving efficiency and helps in identifying optimal substructure relationships in complex problems.
