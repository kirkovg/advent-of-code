package com.gjk.adventofcode.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Puzzle {
  private static List<String> getOrInitializeOuterPlanets(Map<String, List<String>> orbits, String planet) {
    List<String> outerPlanets;
    if (orbits.containsKey(planet)) {
      outerPlanets = orbits.get(planet);
    } else {
      outerPlanets = new ArrayList<>();
      orbits.put(planet, outerPlanets);
    }
    return outerPlanets;
  }

  private static Map<String, List<String>> getOrbits() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    Map<String, List<String>> orbits = new HashMap<>();
    while (!(line = bufferedReader.readLine()).equals("")) {
      String[] planets = line.split("\\)");
      List<String> outerPlanets = getOrInitializeOuterPlanets(orbits, planets[0]);
      outerPlanets.add(planets[1]);
    }

    return orbits;
  }

  private static int calculateNumberOfOrbits(String start, int depth, Map<String, List<String>> orbits) {
    int numberOfOrbits = 0;
    if (orbits.containsKey(start)) {
      List<String> orbitingPlanets = orbits.get(start);
      for (String orbitingPlanet : orbitingPlanets) {
        numberOfOrbits += depth + calculateNumberOfOrbits(orbitingPlanet, depth + 1, orbits);
      }
    }
    return numberOfOrbits;
  }

  public static void main(String[] args) throws IOException {
    System.out.println(calculateNumberOfOrbits("COM", 1, getOrbits()));
  }
}
