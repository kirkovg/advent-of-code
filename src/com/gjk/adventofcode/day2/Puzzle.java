package com.gjk.adventofcode.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Puzzle {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    String[] parts = line.split(",");
    List<Integer> integers = Arrays.stream(parts).map(Integer::valueOf).collect(Collectors.toList());

    for (int i = 0; i < integers.size(); i+=4) {
      int firstElementPosition = integers.get(i + 1);
      int secondElementPosition = integers.get(i + 2);
      int targetElementPosition = integers.get(i + 3);
      if (integers.get(i) == 1) {
        integers.set(targetElementPosition,
            integers.get(firstElementPosition) + integers.get(secondElementPosition));
      }
      if (integers.get(i) == 2) {
        integers.set(targetElementPosition,
            integers.get(firstElementPosition) * integers.get(secondElementPosition));
      }
      if (integers.get(i) == 99) {
        break;
      }
    }

    System.out.println(integers);
  }
}
