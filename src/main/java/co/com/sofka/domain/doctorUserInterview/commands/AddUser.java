package co.com.sofka.domain.doctorUserInterview.commands;

import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.domain.doctorUserInterview.values.Symptoms;
import co.com.sofka.domain.doctorUserInterview.values.UserID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.PersonalData;

import java.util.Set;

public class AddUser extends Command {

    private final DoctorUserInterviewID doctorUserInterviewID;
    private final UserID userID;
    private final PersonalData personalData;
    private final Set<Symptoms> symptoms;

    public AddUser(DoctorUserInterviewID doctorUserInterviewID, UserID userID, PersonalData personalData, Set<Symptoms> symptoms) {
        this.doctorUserInterviewID = doctorUserInterviewID;
        this.userID = userID;
        this.personalData = personalData;
        this.symptoms = symptoms;
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

    public Set<Symptoms> getSymptoms() {
        return symptoms;
    }
}
