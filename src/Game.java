import java.util.Scanner;

/**
 * Created by alejandraparedes on 1/11/18.
 */
public class Game {
    public static void main(String[] args) {
        //Animal dog = new Animal();
        //System.out.println(dog.getDamage());
        //System.out.print(dog.getLife());
        gameEngine();
    }

    public static void gameEngine() {
        System.out.println("Welcome! Ready to play?");
        int numberOfCreatures = numberOfAnimals();
        Animal collection[] = new         Animal[numberOfCreatures];
        Scanner userInput = new Scanner(System.in);
        for (int i = 0; i < numberOfCreatures; i++)
        {
            System.out.println(i + " animal. What would you like to create? 1 = Cat, 2 = Dog, 3 = Ferret");
            int creature = userInput.nextByte();
            System.out.println("Give to your new creature a name please");
            String name = userInput.next();
            if (creature == 1) {
                Animal animal = new Cat(name);
                collection[i] = animal;
            }
        }
        System.out.print(collection[0].getLife());

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
