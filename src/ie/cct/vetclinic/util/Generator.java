package ie.cct.vetclinic.util;

import java.util.*;

public class Generator {

    private static String[] arrayOfFirstNames = {"Joe", "Donna", "Ronald", "Sarah", "David", "Courtney", "Irwin", "Linda", "Michael", "Cindy", "Tom", "Rebekah", "Todd", "Tracy", "Peter", "Nicole", "Marcelo", "Jennifer", "Rick", "Andrea", "Bruce", "Jaclyn", "Doug", "Shirley", "Steve", "Liz", "Waldo", "Theresa", "Scott", "Colby", "Beth", "Larry", "Emily", "Paul", "Kate", "Sam", "Dianne", "Dustin", "Alethea", "Wayne", "Kristina", "Christian", "Danny", "Breya", "Andrew", "Alison", "Tim", "Mary", "Chris", "Susie", "Jeremy", "Willy", "Jessica", "Marcus", "Kelly", "Kyle", "Stephanie", "Isaiah", "Hillary", "Eric", "Julia", "Donald", "Meredith", "Kevin", "Leslie", "Blake", "Angela", "Cliff", "Debbie", "Dylan", "Erin", "Alex", "Monica", "Nathan", "Wendy", "Josh", "Megan", "Adam", "Michelle", "Carey", "Ashley", "Brian", "Jason", "Melanie", "Jim", "Monica", "Jamie", "Rhonda", "Steven", "Perry", "Byron", "Laura", "Harry", "Brooke", "Drew", "Vicki", "Gary", "Anita", "Felipe", "Josie"};
    private static String[] arrayOfLastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Washington", "Jefferson", "Lincoln", "Hamilton", "Jackson", "Grant", "Franklin", "McKinley", "Cleveland", "Madison", "Chase", "Nicholson", "Fauver", "Doe", "Southard", "Schmidt", "Hodson", "McDonald", "Stickley", "Miller", "Combs", "Bohus", "Krippner", "Amtower", "Banks", "Wallace", "Bannister", "Dehaven", "Yost", "Still", "Timbrook", "Peters", "Vaught", "Shellhammer", "Andrews", "Krippner", "McAlister", "Wright", "Kensinger", "McClellan", "Ganoe", "Shiley", "Layman", "Gearhart", "Yost", "Kushnir", "Bush", "Lowder", "Connolly", "Lowman", "Terveen", "Staton", "Settle", "Tinsman", "Nichols", "Baker", "Walters", "Dawe", "Renner", "Michaels", "Faircloth", "Looker", "Hastings", "Vaughan", "Anderson", "Zimmerman", "Deere", "Daher", "Lauck", "Stottlemyer", "Clinton", "Obama", "Reagan", "Montgomery", "Pugh", "Gavis", "Clark", "Bowers"};
    private static String[] arrayOfDiseases = {"Kidney disease", "Diabetes", "Arthritis", "Fleas and ticks", "Rabies", "Distemper", "Parvovirus", "Dental disease", "Heartworm", "Obesity", "Lyme disease", "Psittacosis", "Plague", "Q fever", "Campylobacteriosis", "Leptospirosis", "Salmonellosis", "Toxoplasmosis", "Ringworm", "Roundworm", "Tapeworm", "Hookworm", "Capnocytophaga", "Strep zoo"};

//    private static void generate() {
//        // capital letters 65 - 90
//        // small letters 97 - 122
//
//        ThreadLocalRandom generator = ThreadLocalRandom.current();
//
//        int lengthName = generator.nextInt(3, 10);
//        int lengthSurname = generator.nextInt(3, 10);
//
//        char firstLetterName = (char) generator.nextInt(65, 90);
//        char firstLetterSurname = (char) generator.nextInt(65, 90);
//
//        StringBuilder name = new StringBuilder().append(firstLetterName);
//        StringBuilder surname = new StringBuilder().append(firstLetterName);
//
//
//        for (int i = 1; i < lengthName; i++) {
//            char letter = (char) generator.nextInt(97, 122);
//            name.append(letter);
//        }
//
//        for (int i = 1; i < lengthSurname; i++) {
//            char letter = (char) generator.nextInt(97, 122);
//            surname.append(letter);
//        }
//
//        System.out.println(name + " " + surname);
//    }

    public static String generateName() {
        String first = get(arrayOfFirstNames);
        String last = get(arrayOfLastNames);
        return first + " " + last;
    }

    private static String get(String[] array) {
        Random generator = new Random();
        int rnd = generator.nextInt(array.length);
        return array[rnd];
    }

    public static String generateAnimalName() {
        // A List to hold all the names
        List<String> namesList = new ArrayList<>();

// Create the full list of names
        String[] names = {"mike", "Dragon", "jason", "freddy", "john", "mic", "Duck", "Pig", "Phoenix", "Behemoth",
                "Slayer", "Brusher", "Companion", "Rider", "Food", "Rex" };

// Store them into the List
        namesList = new ArrayList(Arrays.asList(names));

// Randomly get the first part of the name
        int randomIndex = new Random().nextInt(names.length - 1);
        String firstName = namesList.get(randomIndex);
        String lastName = null;

// Figure out the size remaining
        int remainSize = 12 - firstName.length();

// If desired, remove the element from the List so you don't get "DragonDragon"
        namesList.remove(randomIndex);

// Randomly shuffle the list
        long seed = System.nanoTime();
        Collections.shuffle(namesList, new Random(seed));

// For each name, grab the first one that will complete the size 12
        for (String name : namesList) {
            int nameSize = name.length();

            if (nameSize <= remainSize) {
                lastName = name;
                break;
            }
        }

        String newName = firstName + lastName;
//        System.out.println("Generated name: " + newName + ", with size " + newName.length());
        return newName;
    }

    public static String getDiseases() {
        return get(arrayOfDiseases);
    }
}
