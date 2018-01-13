import java.util.Random;

/**
 * Created by alejandraparedes on 1/11/18.
 */
class Cat extends Animal {
    Cat(String name) {
        super(name, "Grumpy Cat");
    }
    Random number = new Random();
    //Question: I could declare this function in Animal and pass the parameter: chance, basic number attack, name of attack and the int to make random of return. 4 param to make the function abstract?
    @Override
    public String getSpecialAttackName() {
        return "Calin Chat Potte";
    }
    @Override
    public int specialAttack() {
        int chance = number.nextInt(2) + 1;
        if (chance == 1) {
            return (30 + number.nextInt(20));
        }
        return 0;
    }

}
