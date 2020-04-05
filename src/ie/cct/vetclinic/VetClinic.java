package ie.cct.vetclinic;

import ie.cct.vetclinic.animals.Animal;
import ie.cct.vetclinic.animals.Cat;
import ie.cct.vetclinic.animals.Dog;
import ie.cct.vetclinic.animals.Rabbit;
import ie.cct.vetclinic.staff.Staff;
import ie.cct.vetclinic.staff.admin.ItNerd;
import ie.cct.vetclinic.staff.admin.Receptionist;
import ie.cct.vetclinic.staff.medical.Nurse;
import ie.cct.vetclinic.staff.medical.TraineeVet;
import ie.cct.vetclinic.staff.medical.Veterinarian;
import ie.cct.vetclinic.util.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Main class of project
 */
public class VetClinic {

    private static int numberOfAdminStaff = 10;
    private static int numberOfMedicalStaff = 30;
    private static int numberOfVeterinarianStaff = 5;
    private static List<Staff> listAdminStaff;
    private static List<Staff> listMedicalStaff;
    private static List<Animal> listAnimal;
    private static List<Animal> listTypeAnimal;

    public static void main(String[] args) {
        System.out.println("*************** Vet Clicnic Application Starts Here ***************");
        listAdminStaff = new ArrayList<>();
        listMedicalStaff = new ArrayList<>();
        listAnimal = new ArrayList<>();
        listTypeAnimal = new ArrayList<>();

        populateListTypeAnimal(listTypeAnimal);

        createAdminStaff();

        listAdminStaff.stream().forEach(e -> System.out.println(e.toString()));

        System.out.println("---------------");

        createMedicalStaff();

        listMedicalStaff.stream().forEach(e -> System.out.println(e.toString()));

        System.out.println("---------------");
        createAnimals();
        listAnimal.stream().forEach(e -> System.out.println(e.toString()));
    }

    private static void createAdminStaff() {
        for (int i = 0; i < numberOfAdminStaff; i++){
            if(i % 2 == 0){
                listAdminStaff.add(new ItNerd(i, Generator.generateName(), "12"));
                continue;
            }
            listAdminStaff.add(new Receptionist(i, Generator.generateName(), "12"));
        }
    }

    private static void createMedicalStaff() {
        for (int i = 0; i < 5; i++){
            listMedicalStaff.add(new Veterinarian(i, Generator.generateName(), "12"));
        }


        for (int i = 0; i < numberOfMedicalStaff - numberOfVeterinarianStaff; i++){
            if(i % 2 == 0){
                listMedicalStaff.add(new Nurse(i, Generator.generateName(), "12"));
                continue;
            }
            listMedicalStaff.add(new TraineeVet(i, Generator.generateName(), "12"));
        }
    }

    private static void createAnimals() {
        Dog dog = new Dog(1, Generator.generateAnimalName(), ThreadLocalRandom.current().nextInt(1, 15),  Generator.getDiseases());
        Cat cat = new Cat(2, Generator.generateAnimalName(), ThreadLocalRandom.current().nextInt(1, 15),  Generator.getDiseases());
        Rabbit rabbit = new Rabbit(3, Generator.generateAnimalName(), ThreadLocalRandom.current().nextInt(1, 15), Generator.getDiseases());
        listAnimal.add(dog);
        listAnimal.add(cat);
        listAnimal.add(rabbit);

        for (int i = 4; i <= 1000; i++){
            int rnd = ThreadLocalRandom.current().nextInt(0, listTypeAnimal.size());
            int age = ThreadLocalRandom.current().nextInt(1, 15);

            Animal animal = listTypeAnimal.get(rnd);
            getTypeAnimal(i, age, animal);
        }
    }

    private static void getTypeAnimal(int i, int age, Animal animal) {
        if(animal instanceof Cat){
            listAnimal.add(new Cat(i, Generator.generateAnimalName(), age, Generator.getDiseases()));
            return;
        }
        if(animal instanceof Dog){
            listAnimal.add(new Dog(i, Generator.generateAnimalName(), age, Generator.getDiseases()));
            return;
        }
        if(animal instanceof Rabbit){
            listAnimal.add(new Rabbit(i, Generator.generateAnimalName(), age, Generator.getDiseases()));
            return;
        }
    }

    private static void populateListTypeAnimal(List<Animal> list) {
        list.add(new Cat());
        list.add(new Dog());
        list.add(new Rabbit());
    }
}
