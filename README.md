# 🧩 DSA Patterns Java

> **Solving Data Structures & Algorithms problems in Java — organized by patterns, not random topics.**

[![Language](https://img.shields.io/badge/Language-Java-orange?logo=openjdk)](https://www.java.com/)
[![Problems](https://img.shields.io/badge/Problems-LeetCode%20%7C%20GFG-blue)](https://leetcode.com/)
[![DSA](https://img.shields.io/badge/Focus-DSA-green)](https://en.wikipedia.org/wiki/Data_structure)
[![Interview](https://img.shields.io/badge/Target-Technical%20Interviews-purple)](https://leetcode.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

A **pattern-based Data Structures & Algorithms repository in Java**, designed to help recognize the underlying technique behind coding interview problems instead of memorizing individual solutions.

The goal is simple:

> **Recognize the pattern → Understand the technique → Implement the solution → Apply it to new problems.**

---

## 📚 Table of Contents

* [🎯 Why Pattern-Based DSA?](#-why-pattern-based-dsa)
* [🧠 How to Use This Repository](#-how-to-use-this-repository)
* [🗂️ Repository Structure](#️-repository-structure)
* [🧩 Pattern Cheat Sheet](#-pattern-cheat-sheet)
* [📖 Pattern Details](#-pattern-details)
* [📁 Problem Structure](#-problem-structure)
* [⏱️ Complexity Notation](#️-complexity-notation)
* [🚀 Learning Roadmap](#-learning-roadmap)
* [🎯 Interview Strategy](#-interview-strategy)
* [🛠️ Tech Stack](#️-tech-stack)
* [📈 Progress Tracker](#-progress-tracker)
* [🤝 Contributing](#-contributing)
* [⭐ Support](#-support)

---

# 🎯 Why Pattern-Based DSA?

Most coding interview problems are not completely new problems.

They are usually **variations of a small number of recurring patterns**.

For example:

```text
Two Sum II
3Sum
Container With Most Water
Valid Palindrome
Remove Duplicates
```

These problems may look different, but several of them can be solved using the same fundamental idea:

```text
                    Problem
                       │
                       ▼
               Identify Pattern
                       │
                       ▼
              Choose Data Structure
                       │
                       ▼
               Apply Technique
                       │
                       ▼
                  Optimize
                       │
                       ▼
                  Solution
```

Instead of memorizing:

> "This exact problem uses this exact code."

The goal is to learn:

> "When I see this type of problem, I should think of this pattern."

---

# 🧠 How to Use This Repository

For every problem, follow this process:

### 1. Understand the problem

Identify:

* Input
* Output
* Constraints
* Edge cases

### 2. Identify the pattern

Ask:

```text
What type of problem is this?

Can I use:
- Two Pointers?
- Sliding Window?
- Binary Search?
- Hashing?
- Stack?
- Heap?
- Graph traversal?
- Dynamic Programming?
```

### 3. Start with the brute-force approach

Understand the obvious solution first.

### 4. Find the bottleneck

Ask:

```text
What makes the brute-force solution slow?
```

### 5. Apply the pattern

Use the appropriate data structure or algorithm to remove the bottleneck.

### 6. Analyze complexity

Always identify:

```text
Time Complexity
Space Complexity
```

### 7. Re-solve without looking

The real objective is **pattern recognition**, not code memorization.

---

# 🗂️ Repository Structure

```text
dsa-patterns-java/
│
├── 01-two-pointers/
│
├── 02-sliding-window/
│
├── 03-fast-slow-pointers/
│
├── 04-merge-intervals/
│
├── 05-cyclic-sort/
│
├── 06-linked-list-reversal/
│
├── 07-tree-bfs/
│
├── 08-tree-dfs/
│
├── 09-two-heaps/
│
├── 10-subsets-backtracking/
│
├── 11-modified-binary-search/
│
├── 12-bitwise-xor/
│
├── 13-top-k-elements/
│
├── 14-k-way-merge/
│
├── 15-monotonic-stack/
│
├── 16-greedy/
│
├── 17-graphs-bfs-dfs/
│
├── 18-union-find/
│
├── 19-topological-sort/
│
├── 20-trie/
│
└── 21-dynamic-programming/
    │
    ├── 01-knapsack/
    ├── 02-unbounded-knapsack/
    ├── 03-lcs/
    ├── 04-lis/
    └── 05-palindromic-subsequence/
```

---

# 🧩 Pattern Cheat Sheet

|  # | Pattern                    | Recognize When You See                   | Example Problems                               |
| -: | -------------------------- | ---------------------------------------- | ---------------------------------------------- |
| 01 | **Two Pointers**           | Sorted array, pairs, opposite ends       | Two Sum II, 3Sum                               |
| 02 | **Sliding Window**         | Contiguous subarray/substring            | Longest Substring Without Repeating Characters |
| 03 | **Fast & Slow Pointers**   | Cycle detection, middle of list          | Linked List Cycle, Happy Number                |
| 04 | **Merge Intervals**        | Overlapping ranges                       | Merge Intervals, Insert Interval               |
| 05 | **Cyclic Sort**            | Numbers in range `1..n`                  | Find Missing Number                            |
| 06 | **Linked List Reversal**   | Reverse nodes in-place                   | Reverse Linked List II                         |
| 07 | **Tree BFS**               | Level-by-level tree traversal            | Binary Tree Level Order Traversal              |
| 08 | **Tree DFS**               | Paths, subtrees, recursive tree problems | Path Sum, Diameter of Binary Tree              |
| 09 | **Two Heaps**              | Median / two-sided ordering              | Find Median from Data Stream                   |
| 10 | **Backtracking**           | All combinations, permutations, choices  | Subsets, Permutations, N-Queens                |
| 11 | **Modified Binary Search** | Sorted / rotated search space            | Search in Rotated Sorted Array                 |
| 12 | **Bitwise XOR**            | Unique / missing values                  | Single Number                                  |
| 13 | **Top K Elements**         | K largest/smallest/frequent              | Kth Largest, Top K Frequent                    |
| 14 | **K-Way Merge**            | Multiple sorted arrays/lists             | Merge K Sorted Lists                           |
| 15 | **Monotonic Stack**        | Next greater/smaller                     | Daily Temperatures                             |
| 16 | **Greedy**                 | Local optimal decisions                  | Jump Game, Gas Station                         |
| 17 | **Graph BFS/DFS**          | Connectivity / traversal                 | Number of Islands, Clone Graph                 |
| 18 | **Union-Find**             | Dynamic connectivity                     | Redundant Connection                           |
| 19 | **Topological Sort**       | Dependencies / ordering                  | Course Schedule                                |
| 20 | **Trie**                   | Prefix / dictionary problems             | Implement Trie, Word Search II                 |
| 21 | **Dynamic Programming**    | Overlapping subproblems                  | Knapsack, LCS, LIS                             |

---

# 📖 Pattern Details

## 01. Two Pointers

### 🔍 Recognize

Use two pointers when:

* The array is sorted
* You need a pair
* You need to compare both ends
* You need to remove duplicates in-place
* You need to partition data

### 🧠 Core Idea

```text
left  ───────────────►
right ◄───────────────
```

### Typical Problems

* Two Sum II
* 3Sum
* Valid Palindrome
* Container With Most Water
* Remove Duplicates from Sorted Array
* Move Zeroes

---

## 02. Sliding Window

### 🔍 Recognize

Look for:

* Subarray
* Substring
* Contiguous elements
* Longest
* Shortest
* Maximum/minimum window
* At most / exactly `K`

### 🧠 Core Idea

```text
[left ........ right]
       WINDOW
```

Expand the right pointer and shrink the left pointer when the window becomes invalid.

### Typical Problems

* Longest Substring Without Repeating Characters
* Minimum Window Substring
* Maximum Sum Subarray of Size K
* Longest Repeating Character Replacement
* Max Consecutive Ones III

---

## 03. Fast & Slow Pointers

### 🔍 Recognize

Useful for:

* Linked-list cycles
* Finding the middle
* Cycle-based problems
* Repeated state transitions

### Typical Problems

* Linked List Cycle
* Linked List Cycle II
* Middle of the Linked List
* Happy Number
* Palindrome Linked List

---

## 04. Merge Intervals

### 🔍 Recognize

Look for:

```text
[start, end]
```

and overlapping ranges.

### Typical Problems

* Merge Intervals
* Insert Interval
* Non-overlapping Intervals
* Meeting Rooms
* Meeting Rooms II

---

## 05. Cyclic Sort

### 🔍 Recognize

Especially useful when:

```text
1 <= nums[i] <= n
```

and the array contains values that should map naturally to indices.

### Typical Problems

* Missing Number
* Find All Numbers Disappeared in an Array
* Find the Duplicate Number
* First Missing Positive

---

## 06. Linked List Reversal

### 🔍 Recognize

Use when the problem asks you to:

* Reverse an entire linked list
* Reverse a section
* Reverse every K nodes
* Manipulate links in-place

### Typical Problems

* Reverse Linked List
* Reverse Linked List II
* Reverse Nodes in K-Group
* Swap Nodes in Pairs

---

## 07. Tree BFS

### 🔍 Recognize

Think BFS when the problem involves:

* Levels
* Minimum depth
* Level order
* Nearest node
* Distance by levels

### Core Data Structure

```text
Queue
```

### Typical Problems

* Binary Tree Level Order Traversal
* Binary Tree Zigzag Level Order Traversal
* Minimum Depth of Binary Tree
* Right Side View

---

## 08. Tree DFS

### 🔍 Recognize

Think DFS when the problem involves:

* Root-to-leaf paths
* Subtrees
* Recursive tree relationships
* Height/depth
* Path calculations

### Core Techniques

```text
Preorder
Inorder
Postorder
```

### Typical Problems

* Maximum Depth
* Path Sum
* Diameter of Binary Tree
* Lowest Common Ancestor
* Validate Binary Search Tree

---

## 09. Two Heaps

### 🔍 Recognize

Useful when you need to maintain:

```text
Smaller half  ←→  Larger half
```

Usually implemented using:

```text
Max Heap + Min Heap
```

### Typical Problems

* Find Median from Data Stream
* Sliding Window Median
* IPO
* Maximize Capital

---

## 10. Subsets & Backtracking

### 🔍 Recognize

Use when you need:

* All subsets
* All permutations
* All combinations
* Decision trees
* Multiple possible choices

### Core Structure

```text
                 Start
               /      \
            Choose   Skip
             /          \
          Choose       Skip
```

### Typical Problems

* Subsets
* Permutations
* Combination Sum
* Letter Combinations
* N-Queens
* Sudoku Solver

---

## 11. Modified Binary Search

### 🔍 Recognize

Think binary search whenever the search space has an ordering property.

Not limited to:

```text
sorted array
```

It can also be:

```text
rotated array
monotonic answer space
minimum possible answer
maximum possible answer
```

### Typical Problems

* Binary Search
* Search in Rotated Sorted Array
* Find Minimum in Rotated Sorted Array
* Search a 2D Matrix
* Koko Eating Bananas

---

## 12. Bitwise XOR

### 🔍 Recognize

Useful when:

* Numbers appear in pairs
* One value is unique
* A number is missing
* XOR cancellation can simplify the problem

### Important Properties

```text
x ^ x = 0
x ^ 0 = x
x ^ y ^ x = y
```

### Typical Problems

* Single Number
* Missing Number
* Single Number II
* Find the Difference

---

## 13. Top K Elements

### 🔍 Recognize

Look for:

```text
K largest
K smallest
K most frequent
K closest
```

### Common Data Structures

```text
Min Heap
Max Heap
HashMap + Heap
Quickselect
```

### Typical Problems

* Kth Largest Element
* Top K Frequent Elements
* K Closest Points to Origin
* Kth Smallest Element

---

## 14. K-Way Merge

### 🔍 Recognize

Use when you have:

```text
K sorted arrays
K sorted lists
multiple sorted streams
```

### Core Data Structure

```text
Min Heap
```

### Typical Problems

* Merge K Sorted Lists
* Kth Smallest Element in a Sorted Matrix
* Smallest Range Covering Elements from K Lists

---

## 15. Monotonic Stack

### 🔍 Recognize

Think monotonic stack when you see:

* Next greater element
* Next smaller element
* Previous greater/smaller
* Temperature problems
* Histogram problems
* Maintaining increasing/decreasing order

### Typical Problems

* Daily Temperatures
* Next Greater Element
* Largest Rectangle in Histogram
* Stock Span
* Trapping Rain Water

---

## 16. Greedy

### 🔍 Recognize

Think greedy when:

> Making the best local decision can lead to a globally optimal solution.

### Typical Problems

* Jump Game
* Gas Station
* Assign Cookies
* Activity Selection
* Partition Labels

> ⚠️ Greedy requires proof or strong reasoning. Not every locally optimal choice produces a globally optimal solution.

---

## 17. Graph BFS / DFS

### 🔍 Recognize

Look for:

* Nodes and edges
* Connectivity
* Components
* Reachability
* Traversal
* Shortest path in an unweighted graph

### Typical Problems

* Number of Islands
* Clone Graph
* Flood Fill
* Number of Connected Components
* Rotting Oranges

---

## 18. Union-Find

### 🔍 Recognize

Use Union-Find when the problem involves:

* Dynamic connectivity
* Connecting components
* Detecting cycles
* Group membership

### Core Operations

```text
find(x)
union(x, y)
```

### Optimizations

```text
Path Compression
Union by Rank
Union by Size
```

### Typical Problems

* Redundant Connection
* Number of Provinces
* Accounts Merge
* Kruskal's Algorithm

---

## 19. Topological Sort

### 🔍 Recognize

Think Topological Sort when you see:

```text
Prerequisites
Dependencies
Ordering
Build systems
Task scheduling
```

The graph must be a **DAG — Directed Acyclic Graph**.

### Common Approaches

```text
Kahn's Algorithm
DFS + Cycle Detection
```

### Typical Problems

* Course Schedule
* Course Schedule II
* Alien Dictionary
* Parallel Courses

---

## 20. Trie

### 🔍 Recognize

Use a Trie when the problem involves:

* Prefix matching
* Dictionary lookup
* Autocomplete
* Word search
* String prefixes

### Typical Problems

* Implement Trie
* Design Add and Search Words
* Word Search II
* Replace Words
* Longest Common Prefix

---

# 21. Dynamic Programming

Dynamic Programming is divided into several important patterns.

```text
21-dynamic-programming/
│
├── 01-knapsack/
├── 02-unbounded-knapsack/
├── 03-lcs/
├── 04-lis/
└── 05-palindromic-subsequence/
```

---

## 21.1 0/1 Knapsack

### 🔍 Recognize

Each item can generally be:

```text
Take
OR
Skip
```

### Common Problems

* 0/1 Knapsack
* Subset Sum
* Partition Equal Subset Sum
* Target Sum

---

## 21.2 Unbounded Knapsack

### 🔍 Recognize

An item can be selected **multiple times**.

### Common Problems

* Coin Change
* Coin Change II
* Rod Cutting
* Unbounded Knapsack

---

## 21.3 Longest Common Subsequence

### 🔍 Recognize

Compare two sequences/strings while maintaining relative order.

### Common Problems

* Longest Common Subsequence
* Shortest Common Supersequence
* Delete Operation for Two Strings
* Longest Palindromic Subsequence

---

## 21.4 Longest Increasing Subsequence

### 🔍 Recognize

Look for:

```text
Increasing sequence
Subsequence
Maximum length
```

### Common Problems

* Longest Increasing Subsequence
* Number of Longest Increasing Subsequence
* Russian Doll Envelopes

---

## 21.5 Palindromic Subsequence

### 🔍 Recognize

Problems involving:

```text
Palindrome
Subsequence
Minimum insertions/deletions
Longest palindromic sequence
```

### Common Problems

* Longest Palindromic Subsequence
* Palindromic Substrings
* Minimum Insertion Steps to Make a String Palindrome

---

# 📁 Problem Structure

Each problem should follow a consistent structure.

```text
01-two-pointers/
│
├── 01-two-sum-ii/
│   ├── Solution.java
│   └── README.md
│
├── 02-three-sum/
│   ├── Solution.java
│   └── README.md
│
└── 03-container-with-most-water/
    ├── Solution.java
    └── README.md
```

Each problem README should contain:

```text
Problem
Pattern
Approach
Algorithm
Complexity
Edge Cases
Problem Link
```

### Example

```markdown
# Two Sum II

## Pattern
Two Pointers

## Approach
Use left and right pointers on the sorted array.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Problem
LeetCode

## Link
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
```

---

# ⏱️ Complexity Notation

| Complexity   | Meaning      |
| ------------ | ------------ |
| `O(1)`       | Constant     |
| `O(log n)`   | Logarithmic  |
| `O(n)`       | Linear       |
| `O(n log n)` | Linearithmic |
| `O(n²)`      | Quadratic    |
| `O(n³)`      | Cubic        |
| `O(2ⁿ)`      | Exponential  |
| `O(n!)`      | Factorial    |

### Goal

Whenever possible:

```text
Brute Force
    ↓
Better
    ↓
Optimal
```

For example:

```text
O(n²)
  ↓
O(n log n)
  ↓
O(n)
```

---

# 🚀 Learning Roadmap

Recommended order:

```text
Phase 01
│
├── Arrays
├── Strings
├── Hashing
└── Two Pointers
        │
        ▼
Phase 02
│
├── Sliding Window
├── Prefix Sum
├── Fast & Slow Pointers
└── Binary Search
        │
        ▼
Phase 03
│
├── Linked Lists
├── Stack
├── Queue
├── Monotonic Stack
└── Heap
        │
        ▼
Phase 04
│
├── Trees
├── Tree BFS
├── Tree DFS
├── BST
└── Backtracking
        │
        ▼
Phase 05
│
├── Graph BFS/DFS
├── Union-Find
├── Topological Sort
└── Shortest Path
        │
        ▼
Phase 06
│
├── Trie
├── Greedy
├── Advanced Binary Search
└── Advanced Heap Patterns
        │
        ▼
Phase 07
│
└── Dynamic Programming
```

---

# 🎯 Interview Strategy

Don't measure progress only by the number of problems solved.

Measure:

### Pattern Recognition

Can you identify the pattern within a few minutes?

### Implementation

Can you implement it without copying?

### Complexity

Can you explain why your solution is:

```text
O(n)
O(log n)
O(n log n)
```

etc.?

### Variations

Can you solve a slightly modified version of the same problem?

---

## 🔄 Recommended Problem Cycle

For every problem:

```text
Understand
    ↓
Brute Force
    ↓
Identify Bottleneck
    ↓
Identify Pattern
    ↓
Optimize
    ↓
Code
    ↓
Test
    ↓
Analyze Complexity
    ↓
Re-solve Later
```

---

# 📈 Progress Tracker

## Core Patterns

* [ ] Two Pointers
* [ ] Sliding Window
* [ ] Fast & Slow Pointers
* [ ] Merge Intervals
* [ ] Cyclic Sort
* [ ] Linked List Reversal
* [ ] Tree BFS
* [ ] Tree DFS
* [ ] Two Heaps
* [ ] Backtracking
* [ ] Modified Binary Search
* [ ] Bitwise XOR
* [ ] Top K Elements
* [ ] K-Way Merge
* [ ] Monotonic Stack
* [ ] Greedy
* [ ] Graph BFS/DFS
* [ ] Union-Find
* [ ] Topological Sort
* [ ] Trie
* [ ] Dynamic Programming

---

# 🛠️ Tech Stack

| Technology        | Purpose                        |
| ----------------- | ------------------------------ |
| **Java**          | Implementation                 |
| **LeetCode**      | Problem Solving                |
| **GeeksforGeeks** | Additional Practice            |
| **Git**           | Version Control                |
| **GitHub**        | Repository & Progress Tracking |

---

# 📌 Repository Philosophy

This repository follows a few simple principles:

### 1. Learn the pattern, not the answer

```text
Problem ≠ Solution

Pattern → Technique → Solution
```

### 2. Prefer clarity over cleverness

Code should be:

* Readable
* Simple
* Maintainable
* Interview-friendly

### 3. Understand before optimizing

Don't jump directly to the optimal solution.

Understand:

```text
Why brute force works
        ↓
Why it is slow
        ↓
What pattern removes the bottleneck
        ↓
Why the optimized solution works
```

### 4. Repetition creates pattern recognition

Solving multiple variations of the same pattern is more valuable than solving unrelated problems randomly.

---

# 📚 Recommended Practice Strategy

For each pattern, aim for:

```text
1–2 Easy
     ↓
3–5 Medium
     ↓
1–2 Hard
     ↓
Revisit after 7 days
```

The objective is not:

> ❌ Solve 500 problems and forget them.

The objective is:

> ✅ Solve enough variations that the pattern becomes automatic.

---

# ⭐ The Ultimate Goal

By the end of this repository, you should be able to look at a new problem and think:

```text
"What pattern is hiding here?"
```

rather than:

```text
"Have I seen this exact problem before?"
```

That shift from **problem memorization → pattern recognition** is the core purpose of this repository.

---

## 🤝 Contributing

Contributions are welcome.

If you find:

* Incorrect solutions
* Better approaches
* Missing edge cases
* Complexity improvements
* Useful problem variations
* Documentation improvements

feel free to open an issue or submit a pull request.

---

# ⭐ Support

If this repository helps you prepare for coding interviews, consider giving it a ⭐ on GitHub.

It helps the project grow and encourages continued development.

---

<div align="center">

### 🧩 Recognize the Pattern.

### 🧠 Understand the Technique.

### 💻 Write the Code.

### 🚀 Crack the Interview.

**DSA Patterns Java**

</div>
