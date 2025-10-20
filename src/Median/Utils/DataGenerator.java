package Median.Utils;

import java.util.Random;

public class DataGenerator {
  private Random random;

  public DataGenerator() {
    this.random = new Random();
  }

  public int[] generateRandomData(int size) {
    int[] data = new int[size];
    int maxValue = size * 10;

    for (int i = 0; i < size; i++) {
      data[i] = random.nextInt(maxValue);
    }
    return data;
  }

}