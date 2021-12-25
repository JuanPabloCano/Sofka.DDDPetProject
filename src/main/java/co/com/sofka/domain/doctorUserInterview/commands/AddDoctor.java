package co.com.sofka.domain.doctorUserInterview.commands;

import co.com.sofka.domain.doctorUserInterview.values.DoctorID;
import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class AddDoctor extends Command {

    private final DoctorUserInterviewID doctorUserInterviewID;
    private final DoctorID doctorID;
    private final PersonalData personalData;
    private final Description description;

    public AddDoctor(DoctorUserInterviewID doctorUserInterviewID, DoctorID doctorID, PersonalData personalData, Description description) {
        this.doctorUserInterviewID = Objects.requireNonNull(doctorUserInterviewID);
        this.doctorID = Objects.requireNonNull(doctorID);
        this.personalData = Objects.requireNonNull(personalData);
        this.description = Objects.requireNonNull(description);
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

    public Description getDescription() {
        return description;
    }
}
