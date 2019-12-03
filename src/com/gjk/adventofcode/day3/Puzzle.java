package com.gjk.adventofcode.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Point {
  Integer x;
  Integer y;

  Point(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return Objects.equals(x, point.x) &&
        Objects.equals(y, point.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}

public class Puzzle {
  private static HashMap<Point, Integer> getPath(String line) {
    HashMap<Point, Integer> pathMap = new HashMap<>();
    int x = 0;
    int y = 0;
    int pathLength = 0;
    for (String path : line.split(",")) {
      char direction = path.charAt(0);
      int distance = Integer.valueOf(path.substring(1));
      for (int d = 0; d < distance; d++) {
        Point point;
        switch (direction) {
          case 'R':
            point = new Point(++x, y);
            break;
          case 'D':
            point = new Point(x, --y);
            break;
          case 'L':
            point = new Point(--x, y);
            break;
          case 'U':
            point = new Point(x, ++y);
            break;
          default:
            throw new IllegalStateException("Not a valid direction: " + direction);
        }
        pathMap.put(point, ++pathLength);
      }
    }

    return pathMap;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String firstLine = reader.readLine();
    String secondLine = reader.readLine();

    HashMap<Point, Integer> path1 = getPath(firstLine);
    HashMap<Point, Integer> path2 = getPath(secondLine);

    Set<Point> result = new HashSet<>(path1.keySet());
    result.retainAll(path2.keySet());

    // part 1
    System.out.println(result.stream().map(point -> Math.abs(point.x) + Math.abs(point.y))
        .min(Integer::compareTo));

    // part 2
    System.out.println(result.stream().map(point -> path1.get(point) + path2.get(point))
        .min(Integer::compareTo));
  }
}
