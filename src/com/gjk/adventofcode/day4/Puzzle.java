package com.gjk.adventofcode.day4;

public class Puzzle {

  private static boolean checkPassword(String s) {
    boolean hasTwo = false;
    boolean decreasing = false;
    char previous = s.charAt(0);
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) < previous) {
        decreasing = true;
      }
      if (s.charAt(i) == previous) {
        hasTwo = true;
      }
      previous = s.charAt(i);
    }
    return hasTwo && !decreasing;
  }

  private static boolean checkPasswordPart2(String s) {
    char[] chars = s.toCharArray();
    boolean increasing = true;
    for (int i = 0; i < chars.length - 1; i++) {
      increasing = increasing & chars[i] <= chars[i + 1];
    }
    boolean hasTwo = chars[0] == chars[1] && chars[1] != chars[2];
    for (int i = 1; i < chars.length - 2; i++) {
      hasTwo = hasTwo | (chars[i] == chars[i + 1] && chars[i + 1] != chars[i + 2] && chars[i] != chars[i - 1]);
    }
    hasTwo = hasTwo | (chars[4] == chars[5] && chars[4] != chars[3]);
    return hasTwo && increasing;
  }

  public static void main(String[] args) {
    int count = 0;
    for (int i = 307237; i <= 769058; i++) {
      if (checkPasswordPart2(Integer.toString(i))) {
        count++;
      }
    }
    System.out.println(count);
  }
}
