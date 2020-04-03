package ie.cct.vetclinic.staff.medical;

import ie.cct.vetclinic.staff.Staff;

/**
 * Veterinarian Class
 */
public class Veterinarian extends Staff {
    public Veterinarian(int id, String name, String salary) {
        super(id, name, salary);
    }

    @Override
    public String toString() {
        return "Veterinarian{"+ super.toString() +"} " ;
    }
}
