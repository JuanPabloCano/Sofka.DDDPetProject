package co.com.sofka.domain.doctorUserInterview.events;

import co.com.sofka.domain.doctorUserInterview.values.Symptoms;
import co.com.sofka.domain.doctorUserInterview.values.UserID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;
import java.util.Set;

public class UserAdded extends DomainEvent {

    private final UserID userID;
    private final PersonalData personalData;
    private final Symptoms symptoms;

    public UserAdded(UserID userID, PersonalData personalData, Symptoms symptoms) {
        super("sofka.doctoruserinterview.useradded");
        this.userID = Objects.requireNonNull(userID);
        this.personalData = Objects.requireNonNull(personalData);
        this.symptoms = Objects.requireNonNull(symptoms);
    }

    public UserID getUserId() {
        return userID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Symptoms getSymptoms() {
        return symptoms;
    }
}
