# Median Algorithms Analysis

A Java-based performance analysis tool that compares different median-finding algorithms across various input sizes.

## Overview

This project implements and benchmarks three different median-finding algorithms:

1. **Naive Median** - Uses built-in sorting (O(n log n))
2. **Randomized Median** - Quickselect algorithm with random pivot selection (O(n) average case)
3. **Deterministic Median** - Median of Medians algorithm (O(n) worst case)

The performance analyzer tests each algorithm with datasets of varying sizes (10 to 10,000,000 elements) and provides detailed performance metrics.

## Project Structure

```
MedianAnalysis/
├── src/
│   ├── Main.java                           # Entry point
│   ├── Median/
│   │   ├── Analyzer/
│   │   │   └── PerformanceAnalyzer.java    # Benchmarking engine
│   │   ├── MedianAlgorithms/
│   │   │   ├── MedianAlgorithm.java        # Interface for algorithms
│   │   │   ├── NaiveMedian.java            # Sorting-based approach
│   │   │   ├── RandomizedMedian.java       # Quickselect algorithm
│   │   │   └── DeterministicMedian.java    # Median of Medians
│   │   └── Utils/
│   │       ├── DataGenerator.java          # Random data generation
│   │       └── ResultsPrinter.java         # Formatted output
│   └── META-INF/
│       └── MANIFEST.MF
├── MedianAnalysis.jar                       # Executable JAR
└── Median Analysis Report.pdf               # Detailed analysis report
```

## Algorithms

### 1. Naive Median

- **Implementation**: Sorts the entire array and returns the middle element
- **Time Complexity**: O(n log n)
- **Space Complexity**: O(1) or O(n) depending on sort implementation
- **Use Case**: Simple implementation, good for small datasets

### 2. Randomized Median (Quickselect)

- **Implementation**: Uses random pivot selection to partition the array
- **Time Complexity**: O(n) average case, O(n²) worst case
- **Space Complexity**: O(log n) due to recursion
- **Use Case**: Fast in practice, excellent average-case performance

### 3. Deterministic Median (Median of Medians)

- **Implementation**: Guarantees O(n) performance by selecting pivot deterministically
- **Time Complexity**: O(n) worst case
- **Space Complexity**: O(log n) due to recursion
- **Use Case**: Guaranteed linear time, suitable for worst-case scenarios

## Requirements

- Java Development Kit (JDK) 8 or higher
- No external dependencies required

## Building from Source

### Compile the project:

```bash
javac -d bin src/Main.java src/Median/**/*.java
```

### Create JAR file:

```bash
jar cfm MedianAnalysis.jar src/META-INF/MANIFEST.MF -C bin .
```

## Running the Program

### Using the pre-built JAR:

```bash
java -jar MedianAnalysis.jar
```

### Running from source:

```bash
cd src
javac Main.java
java Main
```

## Performance Testing

The analyzer tests each algorithm with the following data sizes:

- 10 elements
- 100 elements
- 1,000 elements
- 10,000 elements
- 100,000 elements
- 1,000,000 elements
- 10,000,000 elements

Each algorithm runs 20 times per dataset size, and the average execution time is calculated to ensure statistical reliability.

## Sample Output

The program outputs performance results showing:

- Dataset size
- Algorithm name
- Average execution time (in nanoseconds)
- Comparative analysis across algorithms
