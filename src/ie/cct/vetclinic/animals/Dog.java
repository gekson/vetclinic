package ie.cct.vetclinic.animals;

/**
 * Dog class
 */

public class Dog extends Animal {

    public Dog(int id, String name, int age, String medicalCondition) {
        super(id, name, age, medicalCondition);
    }

    @Override
    public String toString() {
        return "Dog{"+ super.toString() +"} " ;
    }
}
