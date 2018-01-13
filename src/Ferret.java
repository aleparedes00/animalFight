import java.util.Random;

/**
 * Created by alejandraparedes on 1/11/18.
 */
class Ferret extends Animal {
    Ferret(String name) {
        super(name, "Angry Ferret!");
    }
    Random number = new Random();
    @Override
    public String getSpecialAttackName() {
        return "Boule Puante";
    }
    @Override
    public int specialAttack() {
        int chance = number.nextInt(1) + 1;
        if (chance == 1) {
            return (15 + number.nextInt(35) + 15);
        }
        return 0;
    }
}
