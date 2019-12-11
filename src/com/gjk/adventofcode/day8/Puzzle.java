package com.gjk.adventofcode.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    char[] chars = reader.readLine().toCharArray();
    List<Integer[][]> layers = getLayers(chars);
    Integer[][] minLayer = findMinLayer(layers);

    long minLayerOnesCount = Arrays.stream(minLayer).flatMap(Arrays::stream)
        .filter(num -> num.equals(1)).count();
    long minLayerTwosCount = Arrays.stream(minLayer).flatMap(Arrays::stream)
        .filter(num -> num.equals(2)).count();
    System.out.println(minLayerOnesCount * minLayerTwosCount);
  }

  private static Integer[][] findMinLayer(List<Integer[][]> layers) {
    Integer[][] minLayer = layers.get(0);
    long minZeroCount = Arrays.stream(minLayer).flatMap(Arrays::stream)
        .filter(num -> num.equals(0)).count();
    for (Integer[][] layer : layers) {
      long currentZeroCount = Arrays.stream(layer).flatMap(Arrays::stream)
          .filter(num -> num.equals(0)).count();
      if (currentZeroCount < minZeroCount) {
        minZeroCount = currentZeroCount;
        minLayer = layer;
      }
    }
    return minLayer;
  }

  private static List<Integer[][]> getLayers(char[] chars) {
    List<Integer[][]> layers = new ArrayList<>();
    Integer[][] layer = new Integer[6][25];
    int i = 0, j = 0;

    for (int x = 0; x < chars.length; x++) {
      int num = Integer.parseInt(String.valueOf(chars[x]));
      layer[j][i] = num;
      i++;
      if (i % 25 == 0 && i > 0) {
        j++;
        i = 0;
      }
      if (j == 6) {
        j = 0;
        layers.add(layer);
        layer = new Integer[6][25];
      }
    }
    return layers;
  }
}
