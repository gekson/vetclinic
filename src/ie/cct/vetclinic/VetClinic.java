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

import java.util.*;
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
    private static List<Staff> listAllStaff;
    private static List<Animal> listAnimal;
    private static List<Animal> listTypeAnimal;
    private static int idStaff = 1;
    private static Map<Integer, List<Animal>> treatmentMap;

    public static void main(String[] args) {
        System.out.println("*************** Vet Clicnic Application Starts Here ***************");
        listAdminStaff = new ArrayList<>();
        listMedicalStaff = new ArrayList<>();
        listAllStaff = new ArrayList<>();
        listAnimal = new ArrayList<>();
        listTypeAnimal = new ArrayList<>();
        treatmentMap = new HashMap();

        populateListTypeAnimal(listTypeAnimal);

        createAdminStaff();

        System.out.println("*************** List Admin Staff ***************");
//        listAdminStaff.stream().forEach(e -> System.out.println(e.toString()));

//        System.out.println("---------------");

        createMedicalStaff();

        listAllStaff.addAll(listAdminStaff);
        listAllStaff.addAll(listMedicalStaff);

//        System.out.println("*************** List Medical Staff ***************");
//        listMedicalStaff.stream().forEach(e -> System.out.println(e.toString()));


        System.out.println("---------------");
        createAnimals();

        assignAnimal();


//        System.out.println("*************** List Animals ***************");
//        listAnimal.stream().forEach(e -> System.out.println(e.toString()));

        //Put in menu
        listAllStaff();
        listStaffByCategorie("Nurse");
    }

    private static void createAdminStaff() {
        for (int i = 0 ; i < numberOfAdminStaff; i++){
            if(i % 2 == 0){
                listAdminStaff.add(new ItNerd(idStaff++, Generator.generateName(), "12"));
                continue;
            }
            listAdminStaff.add(new Receptionist(idStaff++, Generator.generateName(), "12"));
        }
    }

    private static void createMedicalStaff() {
        for (int i = 0; i < 5; i++){
            listMedicalStaff.add(new Veterinarian(idStaff++, Generator.generateName(), "12"));
        }


        for (int i = 0; i < numberOfMedicalStaff - numberOfVeterinarianStaff; i++){
            if(i % 2 == 0){
                listMedicalStaff.add(new Nurse(idStaff++, Generator.generateName(), "12"));
                continue;
            }
            listMedicalStaff.add(new TraineeVet(idStaff++, Generator.generateName(), "12"));
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

    private static void assignAnimal(){
        Random generator = new Random();
        for (Animal animal: listAnimal) {
            int rnd = ThreadLocalRandom.current().nextInt(11, 41);
            if(treatmentMap.containsKey(rnd)) {
                treatmentMap.get(rnd).add(animal);
                continue;
            }
            List listAnimalTreatment = new ArrayList<>();
            listAnimalTreatment.add(animal);
            treatmentMap.put(rnd, listAnimalTreatment);
        }
    }

    /**
     * BASIC FUNCTIONALITY
     */

    /**
     * List All Staffs
     */
    private static void listAllStaff() {
        for (Staff staff: listAllStaff) {
            System.out.println(staff);
        }
    }

    /**
     *
     * @param categorie
     */
    private static void listStaffByCategorie(String categorie){

        List<Staff> listFinal = new ArrayList<>();
        for (Staff staff: listAllStaff) {
            if(staff.getClass().getSimpleName().equals(categorie)){
                listFinal.add(staff);
            }
        }

        for (Staff staff: listFinal) {
            System.out.println(staff);
        }
    }
}
