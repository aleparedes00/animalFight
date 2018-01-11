import java.util.Random;

/**
 * Created by alejandraparedes on 1/11/18.
 */
class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
    Random number = new Random();
    @Override
    boolean specialAttack() {
        //this function
        System.out.println("Special attack");
        return true;
    }

}
