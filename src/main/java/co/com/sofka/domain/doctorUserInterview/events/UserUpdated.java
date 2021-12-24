package co.com.sofka.domain.doctorUserInterview.events;

import co.com.sofka.domain.doctorUserInterview.values.UserID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class UserUpdated extends DomainEvent {

    private final UserID userID;
    private final PersonalData personalData;

    public UserUpdated(UserID userID, PersonalData personalData) {
        super("sofka.doctoruserinterview");
        this.userID = Objects.requireNonNull(userID);
        this.personalData = Objects.requireNonNull(personalData);
    }

    public UserID getUserID() {
        return userID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
}
