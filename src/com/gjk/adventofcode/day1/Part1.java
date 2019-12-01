package com.gjk.adventofcode.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Part1 {

  private static BigDecimal calculateFuelConsumption(BigDecimal mass) {
    BigDecimal divided = mass.divide(new BigDecimal("3"), RoundingMode.DOWN);
    return divided.subtract(new BigDecimal("2"));
  }

  public static void main(String[] args) throws IOException {
    BigDecimal total = BigDecimal.ZERO;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    while (!line.equals("")) {
      total = total.add(calculateFuelConsumption(new BigDecimal(line)));
      line = reader.readLine();
    }
    System.out.println("The total is : " + total.toString());
  }
}
