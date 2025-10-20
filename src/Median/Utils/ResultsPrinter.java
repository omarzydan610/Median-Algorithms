package Median.Utils;

import java.util.List;
import java.util.Map;

import Median.Analyzer.PerformanceAnalyzer.Result;

public class ResultsPrinter {
  private Map<Integer, List<Result>> data;

  public ResultsPrinter(Map<Integer, List<Result>> data) {
    this.data = data;
  }

  public void printFormatedResults() {
    if (data == null || data.isEmpty()) {
      System.out.println("No results to display.");
      return;
    }

    // Print header
    System.out.println("\n" + "=".repeat(120));
    System.out.println("MEDIAN ALGORITHM PERFORMANCE COMPARISON");
    System.out.println("=".repeat(120));

    // Print table header
    System.out.print("Data Size");

    // Get algorithm names from first data size entry
    List<Result> firstResults = data.values().iterator().next();
    for (Result result : firstResults) {
      System.out.print("     " + result.getAlgorithmName());
    }
    System.out.println();

    System.out.println("-".repeat(120));

    // Print results for each data size
    for (Integer dataSize : data.keySet().stream().sorted().toArray(Integer[]::new)) {
      System.out.printf("%-15s", formatNumber(dataSize));

      List<Result> results = data.get(dataSize);
      for (Result result : results) {
        System.out.printf("%-25s", formatTime(result.getExecutionTime()));
      }
      System.out.println();
    }
  }

  private String formatNumber(int number) {
    if (number >= 1_000_000) {
      return String.format("%.1fM", number / 1_000_000.0);
    } else if (number >= 1_000) {
      return String.format("%.1fK", number / 1_000.0);
    } else {
      return String.valueOf(number);
    }
  }

  private String formatTime(long nanoseconds) {
    if (nanoseconds >= 1_000_000_000L) {
      return String.format("%.3fs", nanoseconds / 1_000_000_000.0);
    } else if (nanoseconds >= 1_000_000L) {
      return String.format("%.3fms", nanoseconds / 1_000_000.0);
    } else if (nanoseconds >= 1_000L) {
      return String.format("%.3fμs", nanoseconds / 1_000.0);
    } else {
      return nanoseconds + "ns";
    }
  }
}
