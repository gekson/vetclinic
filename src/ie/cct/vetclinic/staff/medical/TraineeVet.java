package ie.cct.vetclinic.staff.medical;

import ie.cct.vetclinic.staff.Staff;

/**
 * TraineeVet Class
 */
public class TraineeVet extends Staff {
    public TraineeVet(int id, String name, String salary) {
        super(id, name, salary);
    }

    @Override
    public String toString() {
        return "TraineeVet{"+ super.toString() +"} " ;
    }
}
