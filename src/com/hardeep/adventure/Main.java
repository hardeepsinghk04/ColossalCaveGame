package com.hardeep.adventure;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // STEP 1: Create locations and directions
        Map<String, Map<String, String>> locations = new HashMap<>();

        // ROAD (center)
        Map<String, String> roadExits = new HashMap<>();
        roadExits.put("N", "FOREST");
        roadExits.put("S", "VALLEY");
        roadExits.put("E", "WELL HOUSE");
        roadExits.put("W", "HILL");
        locations.put("ROAD", roadExits);

        // FOREST
        Map<String, String> forestExits = new HashMap<>();
        forestExits.put("S", "ROAD");
        locations.put("FOREST", forestExits);

        // VALLEY
        Map<String, String> valleyExits = new HashMap<>();
        valleyExits.put("N", "ROAD");
        locations.put("VALLEY", valleyExits);

        // WELL HOUSE
        Map<String, String> wellHouseExits = new HashMap<>();
        wellHouseExits.put("W", "ROAD");
        locations.put("WELL HOUSE", wellHouseExits);

        // HILL
        Map<String, String> hillExits = new HashMap<>();
        hillExits.put("E", "ROAD");
        locations.put("HILL", hillExits);

        // STEP 2: Game loop
        String currentLocation = "ROAD";

        while (true) {
            System.out.println("\n📍 You are at: " + currentLocation);
            Map<String, String> exits = locations.get(currentLocation);

            System.out.println("Available directions:");
            for (String dir : exits.keySet()) {
                System.out.println("  " + dir + " → " + exits.get(dir));
            }

            System.out.print("\nEnter direction (N/S/E/W) or Q to quit: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Q")) {
                System.out.println("\n👋 Thanks for playing, Hardeep!");
                break;
            }

            if (exits.containsKey(input)) {
                currentLocation = exits.get(input);
            } else {
                System.out.println("❌ Invalid direction! You can't go that way.");
            }
        }

        scanner.close();
    }
}
