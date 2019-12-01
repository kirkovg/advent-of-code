package com.gjk.adventofcode.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Part2 {

  private static BigDecimal calculateFuel(BigDecimal mass) {
    BigDecimal divided = mass.divide(new BigDecimal("3"), RoundingMode.DOWN);
    return divided.subtract(new BigDecimal("2"));
  }

  private static BigDecimal calculateSubTotalFuel(BigDecimal mass, BigDecimal subTotal) {
    BigDecimal subFuel = calculateFuel(mass);
    if (calculateFuel(subFuel).compareTo(BigDecimal.ZERO) < 0) {
      return subFuel.add(subTotal);
    }
    subTotal = subTotal.add(subFuel);
    return calculateSubTotalFuel(subFuel, subTotal);
  }

  public static void main(String[] args) throws IOException {
    BigDecimal total = BigDecimal.ZERO;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    while (!line.equals("")) {
      BigDecimal currentFuel = calculateSubTotalFuel(new BigDecimal(line), BigDecimal.ZERO);
      total = total.add(currentFuel);
      line = reader.readLine();
    }

    System.out.println("The total is : " + total.toString());
  }
}
