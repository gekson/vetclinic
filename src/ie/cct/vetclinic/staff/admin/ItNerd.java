package ie.cct.vetclinic.staff.admin;

import ie.cct.vetclinic.staff.Staff;

/**
 * IT Nerd Class
 */
public class ItNerd extends Staff {

    public ItNerd(int id, String name, String salary) {
        super(id, name, salary);
    }

    @Override
    public String toString() {
        return "ItNerd{"+ super.toString() +"} " ;
    }
}
