package ie.cct.vetclinic;

import ie.cct.vetclinic.animals.Cat;
import ie.cct.vetclinic.animals.Dog;

/**
 * Main class of project
 */
public class VetClinic {

    public static void main(String[] args) {
        System.out.println("*************** Vet Clicnic Application Starts Here ***************");
        Dog dog = new Dog(1, "Totó", 5,  "velho");
        System.out.println(dog);

        System.out.println("---------------");
        Cat cat = new Cat(1, "Mingau", 1,  "novo");
        System.out.println(cat);
    }
}
