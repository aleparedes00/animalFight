import java.util.Scanner;

/**
 * Created by alejandraparedes on 1/11/18.
 */
public class Game {
    public static void main(String[] args) {
        Animal dog = new Animal();
        System.out.println(dog.getDamage());
        System.out.print(dog.getLife());
        gameEngine();
    }

    public static void gameEngine() {

        System.out.println("Welcome! Ready to play?");
        int numberOfCreatures = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many animals would you like to create?");
        while (numberOfCreatures < 1) {
            numberOfCreatures = userInput.nextByte();
        }

    }
}
