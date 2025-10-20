package Median.MedianAlgorithms;

public class DeterministicMedian implements MedianAlgorithm {

  private String name = "Deterministic Median";
  private int groupSize = 5;

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
    return medianOfMedians(array, 0, size - 1, medianIndex);
  }

  private int medianOfMedians(int[] array, int low, int high, int k) {
    int n = high - low + 1;

    if (n <= groupSize) {
      insertionSort(array, low, high);
      return array[low + k];
    }

    int numOfGroups = (n + groupSize - 1) / groupSize;
    int[] medians = new int[numOfGroups];

    for (int i = 0; i < numOfGroups; i++) {
      int currLow = low + i * groupSize;
      int currHigh = Math.min(currLow + groupSize - 1, high);
      insertionSort(array, currLow, currHigh);
      medians[i] = array[currLow + (currHigh - currLow) / 2];
    }

    int medianOfMedians = medianOfMedians(medians, 0, numOfGroups - 1, numOfGroups / 2);

    int pivotIndex = partition(array, low, high, medianOfMedians);

    if (pivotIndex - low == k) {
      return array[pivotIndex];
    } else if (pivotIndex - low > k) {
      return medianOfMedians(array, low, pivotIndex - 1, k);
    } else {
      return medianOfMedians(array, pivotIndex + 1, high, k - (pivotIndex - low + 1));
    }
  }

  private int partition(int[] array, int low, int high, int pivot) {
    int pivotIndex = findPivotIndex(array, low, high, pivot);
    swap(array, pivotIndex, high);

    int pivotValue = array[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (array[j] <= pivotValue) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, high);
    return i + 1;
  }

  private int findPivotIndex(int[] array, int low, int high, int pivot) {
    for (int i = low; i <= high; i++) {
      if (array[i] == pivot) {
        return i;
      }
    }
    return low;
  }

  private void insertionSort(int[] array, int low, int high) {
    for (int i = low + 1; i <= high; i++) {
      int key = array[i];
      int j = i - 1;
      while (j >= low && array[j] > key) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = key;
    }
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
