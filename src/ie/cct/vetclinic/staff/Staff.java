package ie.cct.vetclinic.staff;

/**
 * Staff main class
 */
public class Staff {
    private int id;
    private String name;
    private String salary;

    public Staff(int id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "id=" + id + '\n' +
                "   name='" + name + '\'' + '\n' +
                "   salary='" + salary + '\'' + '\n' ;
    }
}
