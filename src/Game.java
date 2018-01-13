import java.util.Scanner;

/**
 * Created by alejandraparedes on 1/11/18.
 */
public class Game {
    //Animal team[] = new Animal[numberOfAnimals()];
    public static void main(String[] args) {

        new Game().gameEngine();
    }

    public void gameEngine() {
        System.out.println("Welcome! Ready to play?");
        int numberOfCreatures = numberOfAnimals();
        Animal collection[] = new Animal[numberOfCreatures];
        createCollection(collection, numberOfCreatures);
        printTeam(collection, numberOfCreatures);
        int player1 = 0;
        int player2 = 1;
        if (numberOfCreatures > 2) {
            /*selectPlayer(collection, player1, player2);*/
            System.out.println("Please select two players with a number one by one: ");
            Scanner userInput = new Scanner(System.in);
            player1 = userInput.nextInt();
            System.out.println("The first player is => " + collection[player1].getName());
            player2 = userInput.nextInt();
            System.out.println("The second player is" + collection[player2].getName());
        }
        while (collection[player1].getLife() > 0 && collection[player2].getLife() > 0) {
            if (collection[player1].attack(collection[player2]) <= 0) {
                System.out.println("Winner \n" + collection[player1]);
                break;
            } else if (collection[player2].attack(collection[player1]) <= 0) {
                System.out.println("Winner \n" + collection[player2]);
                break;
            }
        }
    }

    public void printTeam(Animal collection[], int numberOfCreatures) {
        System.out.println("Meet your team:");
        for (int j = 0; j < numberOfCreatures; j++) {
            System.out.printf("=> " + j + "%nThis is **" + collection[j].getName() + "** %n  type: " + collection[j].getType() + "%n  life : " + collection[j].getLife() + "%n  damage: " + collection[j].getDamage() + "%n");
        }
    }
    /*public void selectPlayer(Animal collection[], Integer player1, Integer player2) {
        System.out.println("Please select two players with a number one by one: ");
        Scanner userInput = new Scanner(System.in);
        player1 = userInput.nextInt();
        System.out.println("The first player is => " + collection[player1].getName());
        player2 = userInput.nextInt();
        System.out.println("The second player is" + collection[player2].getName());
    }*/

    public void createCollection(Animal collection[], int nbrCreatures) {
        Scanner userInput = new Scanner(System.in);
        int creature;
        for (int i = 0; i < nbrCreatures; i++) {
            do {
                System.out.println((i + 1) + " animal. What would you like to create? 1 = Cat, 2 = Dog, 3 = Ferret");
                creature = userInput.nextByte();
            } while (creature < 1 || creature > 3);

            System.out.println("Give to your new creature a name please");
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
        Scanner userInput = new Scanner(System.in);
        while (numberOfCreatures % 2 != 0) {
            System.out.println("How many animals would you like to create? (even numbers)");
            numberOfCreatures = userInput.nextByte();
        }
        return numberOfCreatures;
    }
}
