package ie.cct.vetclinic.animals;

/**
 * Rabbit class
 */

public class Rabbit extends Animal {
    public Rabbit(int id, String name, int age, String medicalCondition) {
        super(id, name, age, medicalCondition);
    }

    @Override
    public String toString() {
        return "Rabbit{"+ super.toString() +"} " ;
    }
}
