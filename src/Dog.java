import java.util.Random;

/**
 * Created by alejandraparedes on 1/11/18.
 */
public class Dog extends Animal {
    Dog(String name) {
        super(name, "Furious Dog");
    }
    Random number = new Random();

    @Override
    int specialAttack() {
        setSpecialAttackName("Scoobidou");
        int chance = number.nextInt(3) + 1;
        if (chance == 1) {
            return (20 + number.nextInt(40));
        }
        return 0;
    }
}
