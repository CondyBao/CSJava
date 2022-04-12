package intro.HouseModeling;

import java.util.ArrayList;

public class House {
    ArrayList<Room> rooms = new ArrayList<>();

    public int getVolume() {
        int totalVolume = 0;
        for (Room i : rooms) {
            totalVolume += i.volume();
        }
        return totalVolume;
    }

    public int getSquareFootage() {
        int totalFootage = 0;
        for (Room i : rooms) {
            totalFootage += i.squareFootage();
        }
        return totalFootage;
    }

    public int getCost() {
        int totalCost = 0;
        for (Room i : rooms) {
            totalCost += i.price();
        }
        return totalCost;
    }

    public String analyzer() {
        int bedCount = 0, kitCount = 0, dinCount = 0, bathCount = 0;
        for (Room i : rooms) {
            if (i.getName().equals("Bedroom")) bedCount++;
            if (i.getName().equals("Kitchen")) kitCount++;
            if (i.getName().equals("Dining Room")) dinCount++;
            if (i.getName().equals("Bathroom")) bathCount++;
        }
        boolean flag = false;
        String returnString = "";
        if (getVolume() > 3000) {
            returnString += " rich";
            flag = true;
        }
        if (bedCount >= 3) {
            returnString += " big";
            flag = true;
        }
        if (kitCount >= 2) {
            returnString += " culinary";
            flag = true;
        }
        if (dinCount >= 2) {
            returnString += " gluttonous";
            flag = true;
        }
        if (bathCount >= 3) {
            returnString += " bathroom loving";
            flag = true;
        }
        if (!flag) returnString += " normal";
        return "This house is suitable for a" + returnString + " family.";
    }

    public static void main(String[] args) {
        House newHouse = new House();
        newHouse.rooms.add(new Room("Bedroom", 10, 10, 5, 3, 7));
        newHouse.rooms.add(new Room("Kitchen", 10, 5, 5, 5, 6));
        newHouse.rooms.add(new Room("Bedroom", 20, 11, 5, 8, 2));
        newHouse.rooms.add(new Room("Living Room", 30, 30, 10, 7, 6));
        newHouse.rooms.add(new Room("Bathroom", 8, 7, 7, 6, 5));
        newHouse.rooms.add(new Room("Bedroom", 35, 35, 20, 0, 30));
        System.out.println("This house is " + newHouse.getSquareFootage() + "ft^2.");
        System.out.println("This house is " + newHouse.getVolume() + " ft^3.");
        System.out.println("This house costs " + newHouse.getCost() + " dollars");
        System.out.println(newHouse.analyzer());
    }
}
