package Median.MedianAlgorithms;

public interface MedianAlgorithm {
  /**
   * @return the name of the algorithm
   */
  String getName();

  /**
   * Finds the median of the given array
   * 
   * @param array the input array
   * @return the median value
   */
  int calculateMedian(int[] array);
}
