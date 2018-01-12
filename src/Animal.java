import java.util.Random;

/**
 * Created by alejandraparedes on 1/11/18.
 */
abstract class Animal {
    private int damage;
    private int life;
    private String name;
    private String type;
    private String specialAttackName;

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

    public void setSpecialAttackName(String specialAttackName) {
        this.specialAttackName = specialAttackName;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    abstract int specialAttack();

    public String getSpecialAttackName() {
        return specialAttackName;
    }

    public void attack(Animal attacker, Animal defender) {
        int specialDamage = attacker.specialAttack();
        if (specialDamage != 0)
        {
            attacker.setDamage(specialDamage);
            System.out.println("Ready to apply Special Attack " + getSpecialAttackName() + ". The new damage is => " + getDamage());
        }
        if (defender.getLife() > 0)
        {
            defender.setLife(defender.getLife() - attacker.getDamage());
            System.out.println(attacker.getName() + " made " + getDamage() + " point of damage. " + defender.getName() + " has " + defender.getLife() + " point of life.");
        }
        else
        {
            System.out.println( attacker.getName() +"has wont.");
        }
    }

}
