import java.util.Random;

/**
 * Created by alejandraparedes on 1/11/18.
 */
public abstract class Animal implements AnimalFighter {
    private int damage;
    private int life;
    private String name;
    private String type;

    Random number = new Random();

    Animal(String name, String type) {
        life = number.nextInt(800 - 400) + 400;
        damage = number.nextInt(30);
        this.name = name;
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }
    public int getLife() {
        return life;
    }
    public String getName() { return name;}

    public void setLife(int life) {
        this.life = life;
    }
    public String getType() {
        return type;
    }

    public void attack(Animal defender) {
        int specialDamage = this.specialAttack();
        int localDamage = this.getDamage();
        if (specialDamage != 0)
        {
            localDamage = specialDamage;
            System.out.println(this.getName() + " is ready to apply Special Attack " + this.getSpecialAttackName() + ". The new damage points are => " + localDamage);
        }
        if (defender.getLife() > 0)
        {
            System.out.println("attacker => " + this.getType() + " and defender => " + defender.getType()); //testing
            defender.setLife(defender.getLife() - localDamage);
            System.out.println(this.getName() + " made " + getDamage() + " point of damage. " + defender.getName() + " has " + defender.getLife() + " point of life.");
        }
        else
        {
            System.out.println(this.getName() +"has wont.");
        }
    }

}
