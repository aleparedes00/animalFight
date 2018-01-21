import sun.jvm.hotspot.oops.Array;
import sun.jvm.hotspot.oops.TypeArray;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by alejandraparedes on 1/11/18.
 */
public class Game {
    public static void main(String[] args) {

        new Game().gameEngine();
    }

    public void gameEngine() {
        System.out.println("Welcome! Ready to play?");
        int numberOfCreatures = numberOfAnimals();
        Animal collection[] = new Animal[numberOfCreatures];
        createCollection(collection, numberOfCreatures);
        printTeam(collection, numberOfCreatures);
        int fighters[] = new int[2];
        fighters[0] = 0;
        fighters[1] = 1;
        if (numberOfCreatures > 2) {
            System.out.println("Please select two players with a number one by one: ");
            fighters = selectTeam(numberOfCreatures);
            System.out.println("fighter[0] => " + fighters[0] + " and fighter[1] => " + fighters[1]);
        }
        while (collection[fighters[0]].getLife() > 0 && collection[fighters[1]].getLife() > 0) {
            collection[fighters[0]].attack(collection[fighters[1]]);
            collection[fighters[1]].attack(collection[fighters[0]]);
        }
        whoWon(collection, fighters[0], fighters[1]);
    }

    public int[] selectTeam(int numberOfCreatures) {
        int fighters[] = new int[2];
        fighters[0] = -1;
        fighters[1] = -1;
        for (int i = 0; i < 2; i++) {
            Boolean isNumber = false;
            int number = -1;
            while (!isNumber) {
                if (number != -1)
                    System.out.println("Only numbers between 0 and " + (numberOfCreatures - 1));
                try {
                    Scanner userInput = new Scanner(System.in);
                    number = userInput.nextInt();
                    fighters[i] = number;
                    isNumber = number < numberOfCreatures && number >= 0;
                } catch (InputMismatchException ignored) {
                    System.out.println("Only numbers between 0 and " + (numberOfCreatures - 1));
                }
            }
        }
        return fighters;
    }

    public void whoWon(Animal collection[], int player1, int player2) {
        if (collection[player1].getLife() < 0) {
            System.out.println("Your player 2 ** " + collection[player2].getName() + " ** has won. Congratulations");
        } else if (collection[player2].getLife() < 0) {
            System.out.println("Your player 1 ** " + collection[player1].getName() + " ** has won. Congratulations!");
        }
    }

    public void printTeam(Animal collection[], int numberOfCreatures) {
        System.out.println("Meet your team:");
        for (int j = 0; j < numberOfCreatures; j++) {
            System.out.printf("=> " + j + "%nThis is ** " + collection[j].getName() + " ** %n  type: " + collection[j].getType() + "%n  life : " + collection[j].getLife() + "%n  damage: " + collection[j].getDamage() + "%n");
        }
    }

    public void createCollection(Animal collection[], int nbrCreatures) {
        Scanner userInput;
        for (int i = 0; i < nbrCreatures; i++) {
            int creature = 0;
            while (creature <= 0 || creature > 3) {
                if (creature != 0)
                    System.out.println("Enter only digits.");
                try {
                    System.out.println((i + 1) + "th animals. What would you like to create? 1 = Cat, 2 = Dog, 3 = Ferret");
                    userInput = new Scanner(System.in);
                    creature = userInput.nextInt();
                } catch (InputMismatchException ignored) {
                    creature = 0;
                    System.out.println("Enter only digits.");
                }
            }
            System.out.println("Give to your new creature a name please");
            userInput = new Scanner(System.in);
            String name = userInput.next();
            if (creature == 1) {
                Animal animal = new Cat(name);
                collection[i] = animal;
            } else if (creature == 2) {
                Animal animal = new Dog(name);
                collection[i] = animal;
            } else if (creature == 3) {
                Animal animal = new Ferret(name);
                collection[i] = animal;
            }
        }
    }

    public int numberOfAnimals() {
        int numberOfCreatures = -1;
        while (numberOfCreatures % 2 != 0) {
            System.out.println("How many animals would you like to create? (even numbers)");
            try {
                Scanner userInput = new Scanner(System.in);
                numberOfCreatures = userInput.nextInt();
            } catch (InputMismatchException ignored) {
                System.out.println("Please enter number");
            }
        }
        return numberOfCreatures;
    }
}
