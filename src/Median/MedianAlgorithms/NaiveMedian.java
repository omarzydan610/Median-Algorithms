package Median.MedianAlgorithms;

public class NaiveMedian implements MedianAlgorithm {

  private String name = "Naive Median";

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int calculateMedian(int[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("Array cannot be null or empty");
    }
    int size = array.length;
    int medianIndex = (size - 1) / 2;
    java.util.Arrays.sort(array);
    return array[medianIndex];
  }
}
