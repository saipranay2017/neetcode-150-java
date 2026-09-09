# Contains Duplicate — Four Approaches

A comparison of four different techniques for detecting duplicate values in an array, ranging from brute force to a modern Streams-based solution.

---

## 1. 💡 Brute Force — Nested Loops

**Idea**
- Compare every element with every other element.
- For each element, check whether the same value exists at another position. If a matching value is found, a duplicate exists.
- If all possible pairs are checked without finding a match, the array contains no duplicates.

**⏱️ Complexity**

| Metric | Value |
|--------|-------|
| Time   | O(n²) |
| Space  | O(1)  |

**💻 Implementation:** [`BruteForce.java`](https://github.com/saipranay2017/neetcode-150-java/blob/main/1.%20Contains%20Duplicate/BruteForce.java)

---

## 2. ⚙️ Better — Sorting

**Idea**
- First, sort the array.
- After sorting, duplicate values will appear next to each other. Therefore, we only need to compare each element with the element immediately after it.

```text
Before sorting: [4, 2, 1, 3, 2]
After sorting:  [1, 2, 2, 3, 4]
                       ↑
                   duplicate
```

**⏱️ Complexity**

| Metric | Value |
|--------|-------|
| Time   | O(n log n) |
| Space  | O(1)* |

**💻 Implementation:** [`Sorting.java`](Sorting.java)

---

## 3. 🚀 Best — HashSet

**Idea**
- Use a HashSet to keep track of elements that have already been encountered.
- For every element:
  1. Check whether the element already exists in the HashSet.
  2. If it exists, a duplicate has been found → return `true`.
  3. Otherwise, add the element to the set.
- If all elements are processed without finding a duplicate, return `false`.

**Example**

```text
Input: [1, 2, 3, 1]

Set:
1 → add
2 → add
3 → add
1 → already exists → duplicate found
```

**🧠 When to Use**

This is the preferred approach for interviews when:
- Fast duplicate detection is required.
- Extra memory is acceptable.
- You want an average O(n) solution.
- The order of elements does not matter.

**⏱️ Complexity**

| Complexity | Value |
|------------|-------|
| Time       | O(n) average |
| Space      | O(n) |

**💻 Implementation:** [`HashSet.java`](HashSet.java)

---

## 4. 🌊 Alternative — Java Streams

**💡 Idea**

Java Streams can solve the problem concisely using `distinct()`.

`distinct()` removes duplicate values from the stream. We can then compare the number of distinct elements with the original array length.

```java
Arrays.stream(nums).distinct().count();
```

If:

```
number of distinct elements < original array length
```

then at least one duplicate exists.

**🧠 When to Use**
- Useful when writing concise and declarative Java code.
- Suitable when working in a codebase that already uses Streams.
- Good as an alternative solution after understanding the HashSet approach.

**⏱️ Complexity**

| Complexity | Value |
|------------|-------|
| Time       | O(n) |
| Space      | O(n) |

**💻 Implementation:** [`Streams.java`](Streams.java)

---

## 📊 Complexity Comparison

| Approach    | Technique              | Time         | Space | Interview Value |
|-------------|-------------------------|--------------|-------|------------------|
| Brute Force | Nested loops             | O(n²)        | O(1)  | ⭐ |
| Better      | Sorting                  | O(n log n)   | O(1)* | ⭐⭐ |
| Best        | HashSet                  | O(n) average | O(n)  | ⭐⭐⭐⭐⭐ |
| Alternative | Java Streams + `distinct()` | O(n)      | O(n)  | ⭐⭐⭐ |

> \* The sorting space complexity assumes an in-place sorting algorithm. Java's actual sorting implementation may use additional memory depending on the array type and implementation.
