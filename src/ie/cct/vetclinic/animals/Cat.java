package ie.cct.vetclinic.animals;

/**
 * Cat class
 */
public class Cat extends Animal {
    public Cat(int id, String name, int age, String medicalCondition) {
        super(id, name, age, medicalCondition);
    }

    @Override
    public String toString() {
        return "Cat{"+ super.toString() +"} " ;
    }
}
