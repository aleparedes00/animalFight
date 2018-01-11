import java.util.Random;

/**
 * Created by alejandraparedes on 1/11/18.
 */
abstract class Animal {
    private int damage;
    private int life;
    private String name;
    Random number = new Random();
    Animal(String name) {
        life = number.nextInt(800 - 400) + 400;
        damage = number.nextInt(30);
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }
    public int getLife() {
        return life;
    }
    public String getName() { return name;}
    abstract boolean specialAttack();

}
