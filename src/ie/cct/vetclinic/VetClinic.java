package ie.cct.vetclinic;

import ie.cct.vetclinic.animals.Animal;
import ie.cct.vetclinic.animals.Cat;
import ie.cct.vetclinic.animals.Dog;
import ie.cct.vetclinic.staff.Staff;
import ie.cct.vetclinic.staff.admin.ItNerd;
import ie.cct.vetclinic.staff.admin.Receptionist;
import ie.cct.vetclinic.staff.medical.Nurse;
import ie.cct.vetclinic.staff.medical.TraineeVet;
import ie.cct.vetclinic.staff.medical.Veterinarian;
import ie.cct.vetclinic.util.GeneratorName;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        System.out.println("*************** Vet Clicnic Application Starts Here ***************");
        listAdminStaff = new ArrayList<>();
        listMedicalStaff = new ArrayList<>();
        listAnimal = new ArrayList<>();

        Dog dog = new Dog(1, "Totó", 5,  "velho");
        System.out.println(dog);

        System.out.println("---------------");
        Cat cat = new Cat(1, "Mingau", 1,  "novo");

        System.out.println(cat);
        System.out.println("---------------");

        createAdminStaff();

        listAdminStaff.stream().forEach(e -> System.out.println(e.toString()));

        System.out.println("---------------");

        createMedicalStaff();

        listMedicalStaff.stream().forEach(e -> System.out.println(e.toString()));

        System.out.println("---------------");
        createAnimals();
//        listAnimal.stream().forEach(e -> System.out.println(e.toString()));
    }

    public static void createAdminStaff() {
        for (int i = 0; i < numberOfAdminStaff; i++){
            if(i % 2 == 0){
                listAdminStaff.add(new ItNerd(i, GeneratorName.generate(), "12"));
                continue;
            }
            listAdminStaff.add(new Receptionist(i, GeneratorName.generate(), "12"));
        }
    }

    public static void createMedicalStaff() {
        for (int i = 0; i < 5; i++){
            listMedicalStaff.add(new Veterinarian(i, GeneratorName.generate(), "12"));
        }


        for (int i = 0; i < numberOfMedicalStaff - numberOfVeterinarianStaff; i++){
            if(i % 2 == 0){
                listMedicalStaff.add(new Nurse(i, GeneratorName.generate(), "12"));
                continue;
            }
            listMedicalStaff.add(new TraineeVet(i, GeneratorName.generate(), "12"));
        }
    }

    public static void createAnimals() {
        for (int i = 0; i < 1000; i++){
            if(i % 2 == 0){
                listAnimal.add(new Cat(i, GeneratorName.generateAnimalName(), 12, "Sick"));
                continue;
            }
            listAnimal.add(new Dog(i, GeneratorName.generateAnimalName(), 5, "12"));
        }
    }
}
