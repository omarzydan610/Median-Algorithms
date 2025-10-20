package Median.Analyzer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import Median.MedianAlgorithms.DeterministicMedian;
import Median.MedianAlgorithms.MedianAlgorithm;
import Median.MedianAlgorithms.NaiveMedian;
import Median.MedianAlgorithms.RandomizedMedian;
import Median.Utils.DataGenerator;
import Median.Utils.ResultsPrinter;

public class PerformanceAnalyzer {

  public class Result {
    private String algorithmName;
    private long executionTime;

    public Result(String algorithmName, long executionTime) {
      this.algorithmName = algorithmName;
      this.executionTime = executionTime;
    }

    public String getAlgorithmName() {
      return algorithmName;
    }

    public long getExecutionTime() {
      return executionTime;
    }
  }

  private List<MedianAlgorithm> algorithms;
  private DataGenerator dataGenerator;
  private Map<Integer, List<Result>> results;
  private ResultsPrinter resultsPrinter;

  private int[] dataSizes = { 10, 100, 1000, 10000, 100000, 1000000, 10000000 };

  public PerformanceAnalyzer() {
    this.algorithms = Arrays.asList(
        new RandomizedMedian(),
        new DeterministicMedian(),
        new NaiveMedian());
    this.dataGenerator = new DataGenerator();
    this.results = new java.util.HashMap<>();
  }

  public void startAnalysis() {

    for (int size : dataSizes) {
      System.out.println("Start Analysis for " + size + " elements");
      int[] data = dataGenerator.generateRandomData(size);
      List<Result> sizeResults = new ArrayList<>();

      for (MedianAlgorithm algorithm : algorithms) {
        System.out.println("  Started " + algorithm.getName() + " algoritm");
        long totalExecutionTime = 0;
        int runs = 20;

        for (int i = 0; i < runs; i++) {
          int[] dataCopy = data.clone();

          long startTime = System.nanoTime();
          algorithm.calculateMedian(dataCopy);
          long endTime = System.nanoTime();

          totalExecutionTime += (endTime - startTime);
        }

        long averageExecutionTime = totalExecutionTime / runs;
        Result result = new Result(algorithm.getName(), averageExecutionTime);
        sizeResults.add(result);
      }

      results.put(size, sizeResults);
    }

    this.resultsPrinter = new ResultsPrinter(results);
    resultsPrinter.printFormatedResults();
  }

}
