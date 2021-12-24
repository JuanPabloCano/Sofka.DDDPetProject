package co.com.sofka.domain.doctorUserInterview.values;

import co.com.sofka.domain.generic.Identity;

public class DoctorID extends Identity {

    public DoctorID(String uuid) {
        super(uuid);
    }

    public DoctorID(){}

    public static DoctorID of(String uuid){
        return new DoctorID(uuid);
    }
}
