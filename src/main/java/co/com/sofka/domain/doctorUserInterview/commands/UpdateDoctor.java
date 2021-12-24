package co.com.sofka.domain.doctorUserInterview.commands;

import co.com.sofka.domain.doctorUserInterview.values.DoctorID;
import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.PersonalData;

public class UpdateDoctor extends Command {

    private final DoctorUserInterviewID doctorUserInterviewID;
    private final DoctorID doctorID;
    private final PersonalData personalData;

    public UpdateDoctor(DoctorUserInterviewID doctorUserInterviewID, DoctorID doctorID, PersonalData personalData) {
        this.doctorUserInterviewID = doctorUserInterviewID;
        this.doctorID = doctorID;
        this.personalData = personalData;
    }

    public DoctorUserInterviewID getDoctorUserInterviewID() {
        return doctorUserInterviewID;
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
}
