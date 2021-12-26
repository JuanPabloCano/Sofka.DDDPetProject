package co.com.sofka.domain.doctorUserInterview.commands;

import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.domain.doctorUserInterview.values.Symptoms;
import co.com.sofka.domain.doctorUserInterview.values.UserID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class AddUser extends Command {

    private final DoctorUserInterviewID doctorUserInterviewID;
    private final UserID userID;
    private final PersonalData personalData;
    private final Symptoms symptoms;

    public AddUser(DoctorUserInterviewID doctorUserInterviewID, UserID userID, PersonalData personalData, Symptoms symptoms) {
        this.doctorUserInterviewID = Objects.requireNonNull(doctorUserInterviewID);
        this.userID = Objects.requireNonNull(userID);
        this.personalData = Objects.requireNonNull(personalData);
        this.symptoms = Objects.requireNonNull(symptoms);
    }

    public DoctorUserInterviewID getDoctorUserInterviewID() {
        return doctorUserInterviewID;
    }

    public UserID getUserID() {
        return userID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Symptoms getSymptoms() {
        return symptoms;
    }
}
