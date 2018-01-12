import java.util.Scanner;

/**
 * Created by alejandraparedes on 1/11/18.
 */
public class Game {
    //Animal team[] = new Animal[numberOfAnimals()];
    public static void main(String[] args) {
        //Animal dog = new Animal();
        //System.out.println(dog.getDamage());
        //System.out.print(dog.getLife());
        gameEngine();
    }
    public static void gameEngine() {
        System.out.println("Welcome! Ready to play?");
        int numberOfCreatures = numberOfAnimals();
        Animal collection[] = new Animal[numberOfCreatures];
        Scanner userInput = new Scanner(System.in);
        int creature = 0;
        collection[numberOfCreatures] = createCollection(collection, numberOfCreatures);
        for (int j = 0; j < numberOfCreatures; j++) {
            System.out.println("special attack is => " + collection[j].specialAttack());
            System.out.print(collection[j].getLife());
        }
    }
    public static Animal createCollection(Animal collection[], int nbrCreatures) {
        Scanner userInput = new Scanner(System.in);
        int creature;
        for (int i = 0; i < nbrCreatures; i++) {
                do {
                    System.out.println((i+1) + " animal. What would you like to create? 1 = Cat, 2 = Dog, 3 = Ferret");
                    creature = userInput.nextByte();
                } while (creature < 1 || creature > 3);

                System.out.println("Give to your new creature a name please");
                String name = userInput.next();
                if (creature == 1) {
                    Animal animal = new Cat(name);
                    collection[i] = animal;
                }
                else if (creature == 2) {
                    Animal animal = new Dog(name);
                    collection[i] = animal;
                }
                else if (creature == 3) {
                    Animal animal = new Ferret(name);
                    collection[i] = animal;
                }
            }
        return collection[];
    }

    public static int numberOfAnimals() {
        int numberOfCreatures = 0;
        Scanner userInput = new Scanner(System.in);
        while (numberOfCreatures < 1) {
            System.out.println("How many animals would you like to create?");
            numberOfCreatures = userInput.nextByte();
        }
        return numberOfCreatures;
    }
}
