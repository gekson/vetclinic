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

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public VetClinic() {
        int choice = 0;

        basicMenu();

    }

    /**
     * BASIC FUNCTIONALITY
     */
    private void basicMenu() {
        int choice;
        do {
            choice = getUserOption();

            //decide which operation to use - call a method to do the work each time

            if (choice == 1) {
                listAllStaff();
            }
            else if ( choice == 2) {
                staffByCategorieSubMenu();
            }
            else if (choice == 3) {

                System.out.println("choice 3");
            }
            else if (choice == 4) {

                int userNum = getUserInt("Please enter a number, 1 for Nurse or 2 for TraineeVet or 3 for Veterinarian.");

                System.out.println(userNum);
            }
            else if (choice == 5) {

                System.out.println("choice 3");
            }
            else if (choice == 6) {

                System.out.println("choice 3");
            }
            else if (choice == 7) {

                System.out.println("choice 3");
            }
            else {
                //choice must be 8. nothing to do here
            }

        } while (choice != 8);

        System.out.println("Thank you for using this program. Please make cheques payable to Ken Healy.");
    }

    /**
     * List staff by categories (e.g. list all Nurses) SubMenu
     */
    private void staffByCategorieSubMenu() {
        int userNum = 0;
        do {
            userNum = getUserInt("\tPlease enter a number: \n\t1: - list all Nurses" +
                    "\n\t2: - list all TraineeVet\n\t3: - list all Veterinarians\n\t4: - Return");
            switch (userNum) {
                case 1 :
                    listStaffByCategorie("Nurse");
                    break;
                case 2 :
                    listStaffByCategorie("TraineeVet");
                    break;
                case 3 :
                    listStaffByCategorie("Veterinarian");
                    break;
                default :
                    System.out.println("Enter ONLY numbers between 1 and 3!");
                    break;
            }
        } while (userNum != 4);
    }

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

//        listAdminStaff.stream().forEach(e -> System.out.println(e.toString()));

//        System.out.println("---------------");

        createMedicalStaff();

        listAllStaff.addAll(listAdminStaff);
        listAllStaff.addAll(listMedicalStaff);

//        System.out.println("*************** List Medical Staff ***************");
//        listMedicalStaff.stream().forEach(e -> System.out.println(e.toString()));


        createAnimals();

        assignAnimal();

        new VetClinic();


//        System.out.println("*************** List Animals ***************");
//        listAnimal.stream().forEach(e -> System.out.println(e.toString()));

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
     * Menu
     */
    public int getUserOption() {
        // display menu and return a VALID choice.
        // keep asking until valid choice made

        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));

        int input;

        do {
            //display menu
            System.out.println("\n\nPlease choose an option from the list below.\n\n");	// the \n create a blank line. this is just to space the output a bit

            System.out.println("1: - List all staff.");
            System.out.println("2: - List staff by categories (e.g. list all Nurses).");
            System.out.println("3: - List all Admin staff performing a certain task.");
            System.out.println("4: - Search for a specific member of staff by name.");
            System.out.println("5: - List all animals.");
            System.out.println("6: - List animals by various types (e.g. list all dogs.");
            System.out.println("7: - Search for a specific animal by name.");
            System.out.println("8: Exit.");

            try {

                input = Integer.parseInt(myReader.readLine()); //convert to an int - will trigger 'catch' if user enters non-integer

                if ((input<1) || (input>8)) {
                    //user selection invalid
                    System.out.println("Please enter a number 1-8 corresponding to your choice");
                }

            }catch (Exception e) {
                //user did not enter a number at all
                System.out.println("Please enter a number 1-8 corresponding to your choice");
                input = 0; //ensures loop keeps going
            }

        }while ((input<1) || (input > 8));

        //user selection MUST be between 1 and 5

        return input;
    }

    /**
     * Return a number input from user
     * @param myPrompt
     * @return
     */
    public int getUserInt(String myPrompt) {
        //prompt user with message myPrompt
        //return a number input from user

        BufferedReader myInput = new BufferedReader(new InputStreamReader (System.in));
        int userInput = 0;
        boolean valid = false;

        do {
            try {
                //using try-catch for user input
                //in case there is an error

                //prompt user & get input
                System.out.println(myPrompt);
                userInput = Integer.parseInt(myInput.readLine());
                valid = true; //must be valid - otherwise the 'catch' would have been triggered

            }
            catch( Exception e) {
                //because it is possible that there will be an error, must return something here
                //just an empty string
                System.out.println("That was not a number! Please enter an integer!");
                valid = false;
            }

        }while (!valid); //keep going until an integer is entered

        //we have an integer value - return it
        return userInput;
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
        System.out.println("*************** List "+categorie+" Staff ***************");
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
