# neetcode-150-java
Solutions to NeetCode 150 problems with detailed explanations and optimised approaches, primarily implemented in Java.
# Contains Duplicate

🔗 **Question:** [NeetCode - Duplicate Integer](https://neetcode.io/problems/duplicate-integer/question)

---

## 📝 Problem Statement

Given an integer array `nums`, determine whether any value appears more than once.

**Return:**
- `true` if any value occurs at least twice.
- `false` if every value appears exactly once.

### Examples

**Example 1:**
```text
Input:  nums = [1, 2, 3, 1]
Output: true
Example 2:
textCopyCopiedInput:  nums = [1, 2, 3, 4]
Output: false

💡 Approaches
Approach 1 — Brute Force
Idea:
Compare every element with every other element in the array. For each element, check whether the same value exists at another position. If a duplicate is found, return true. If all pairs are checked without finding a duplicate, return false.

Time Complexity: $O(n^2)$
Space Complexity: $O(1)$


Approach 2 — Better (Sorting)
Idea:
Sort the array first. After sorting, duplicate values will be next to each other. Therefore, we only need to compare each element with the element immediately after it.

Time Complexity: O(n log n)
Space Complexity: O(1) auxiliary space (if sorting is performed in-place)

Approach 3 — Best (HashSet)
Idea:
Use a HashSet to keep track of the values that have already been encountered. For every element:

Check whether the value already exists in the set.
If it exists, a duplicate has been found → return true.
Otherwise, add the value to the set.

Time Complexity: $O(n)$ average
Space Complexity: $O(n)$

Approach 4 — Alternative (Java Streams)
Idea:
Use Java Streams with distinct() to remove duplicate values and compare the number of distinct elements with the original array length.
JavaCopyCopiedArrays.stream(nums).distinct().count()
If the number of unique elements is smaller than the original array length, at least one duplicate exists.

Time Complexity: O(n)
Space Complexity: O(n)

🎯 Conclusion
For this problem, HashSet is the best solution.
The HashSet approach is preferred in interviews because it clearly demonstrates an understanding of:

Data structures
Membership checking
Time/space complexity tradeoffs (achieving an $O(n)$ average-time solution)

While Java Streams with distinct() is clean and concise, it hides the actual duplicate-detection logic behind the built-in function, making it less ideal as a primary interview answer.
