package Median.MedianAlgorithms;

import java.util.Random;

public class RandomizedMedian implements MedianAlgorithm {

  private String name = "Randomized Median";
  private Random random = new Random();

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
    return quickSelect(array, 0, size - 1, medianIndex);
  }

  private int quickSelect(int[] array, int low, int high, int k) {
    if (low == high) {
      return array[low];
    }
    int pivotIndex = partition(array, low, high);
    if (pivotIndex == k) {
      return array[k];
    } else if (pivotIndex < k) {
      return quickSelect(array, pivotIndex + 1, high, k);
    } else {
      return quickSelect(array, low, pivotIndex - 1, k);
    }
  }

  int partition(int[] array, int low, int high) {
    randomPivoting(array, low, high);
    int pivot = array[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, high);
    return i + 1;
  }

  void randomPivoting(int[] array, int low, int high) {
    int rand = low + random.nextInt(high - low + 1);
    swap(array, rand, high);
  }

  void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
