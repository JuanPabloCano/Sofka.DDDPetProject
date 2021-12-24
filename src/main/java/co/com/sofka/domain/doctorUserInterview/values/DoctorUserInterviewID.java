package co.com.sofka.domain.doctorUserInterview.values;

import co.com.sofka.domain.generic.Identity;

public class DoctorUserInterviewID extends Identity {

    public DoctorUserInterviewID(String uuid) {
        super(uuid);
    }
    public DoctorUserInterviewID() {}

    public DoctorUserInterviewID of(String uuid){
        return new DoctorUserInterviewID(uuid);
    }
}
