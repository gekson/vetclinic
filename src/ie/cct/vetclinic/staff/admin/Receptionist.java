package ie.cct.vetclinic.staff.admin;

import ie.cct.vetclinic.staff.Staff;

/**
 * Receptionist Class
 */
public class Receptionist extends Staff {
    public Receptionist(int id, String name, String salary) {
        super(id, name, salary);
    }

    @Override
    public String toString() {
        return "Receptionist{"+ super.toString() +"} " ;
    }
}
