package ie.cct.vetclinic.animals;

/**
 * Animal main class
 */
public class Animal {
    private int id;
    private String name;
    private int age;
    private String medicalCondition;

    public Animal(int id, String name, int age, String medicalCondition) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.medicalCondition = medicalCondition;
    }

    public Animal() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    @Override
    public String toString() {
        return  "id=" + id + '\n' +
                "name='" + name + '\'' + '\n' +
                "age=" + age + '\n' +
                "medicalCondition='" + medicalCondition + '\'' + '\n' ;
    }
}
