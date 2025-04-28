// Main class
import java.util.Scanner;

public class SuperheroRoster {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Declare and initialize arrays for hero names, abilities, and power levels
        String[] heroNames = {"Spider-Man", "Iron Man", "Black Widow"};
        String[] abilities = {"Web-slinging", "Flying and high-tech armor", "Stealth and combat"};
        int[] powerLevels = {85, 90, 80};

        // 2. Print each hero's details using a loop
        System.out.println("=== Superhero Details ===");
        for (int i = 0; i < heroNames.length; i++) {
            System.out.println("Name: " + heroNames[i]);
            System.out.println("Ability: " + abilities[i]);
            System.out.println("Power Level: " + powerLevels[i]);
            System.out.println("--------------------------");
        }

        // 3. Call the searchHero method to find a specific hero by name
        String userInput;
        do {
            System.out.println("\nEnter the name of the hero you want to search for (or type 'exit' to quit):");
            userInput = scanner.nextLine();

            if (!userInput.equalsIgnoreCase("exit")) {
                searchHero(heroNames, abilities, powerLevels, userInput);
            }

        } while (!userInput.equalsIgnoreCase("exit"));

        // 4. Calculate and display the average power level
        double averagePower = calculateAveragePower(powerLevels);
        System.out.println("\nAverage Power Level: " + averagePower);

        // 5. Superhero class and object array
        Superhero[] heroes = new Superhero[3];
        heroes[0] = new Superhero("Spider-Man", "Web-slinging", 85);
        heroes[1] = new Superhero("Iron Man", "Flying and high-tech armor", 90);
        heroes[2] = new Superhero("Black Widow", "Stealth and combat", 80);

        System.out.println("\n=== Displaying Heroes Using Superhero Class ===");
        for (Superhero hero : heroes) {
            hero.displayHero();
            System.out.println("--------------------------");
        }

        scanner.close();
    }

    // Method: searchHero
    public static void searchHero(String[] names, String[] abilities, int[] powerLevels, String target) {
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println("Hero Found!");
                System.out.println("Name: " + names[i]);
                System.out.println("Ability: " + abilities[i]);
                System.out.println("Power Level: " + powerLevels[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Hero not found: " + target);
        }
    }

    // Method: calculateAveragePower
    public static double calculateAveragePower(int[] powerLevels) {
        int sum = 0;
        for (int power : powerLevels) {
            sum += power;
        }
        return (double) sum / powerLevels.length;
    }
}

// Class: Superhero
class Superhero {
    // Attributes
    String name;
    String ability;
    int powerLevel;

    // Constructor
    public Superhero(String name, String ability, int powerLevel) {
        this.name = name;
        this.ability = ability;
        this.powerLevel = powerLevel;
    }

    // Method: displayHero
    public void displayHero() {
        System.out.println("Name: " + name);
        System.out.println("Ability: " + ability);
        System.out.println("Power Level: " + powerLevel);
    }
}
