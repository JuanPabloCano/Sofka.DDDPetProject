package co.com.sofka.domain.emergencyRoom.values;

import co.com.sofka.domain.generic.Identity;

public class PatientID extends Identity {

    public PatientID(String uuid) {
        super(uuid);
    }
    public PatientID() {}

    public PatientID of(String uuid){
        return new PatientID(uuid);
    }

}
