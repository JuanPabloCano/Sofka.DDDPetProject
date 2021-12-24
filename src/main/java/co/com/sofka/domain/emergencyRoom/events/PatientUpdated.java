package co.com.sofka.domain.emergencyRoom.events;

import co.com.sofka.domain.emergencyRoom.values.PatientID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class PatientUpdated extends DomainEvent {

    private final PatientID patientID;
    private final PersonalData personalData;

    public PatientUpdated(PatientID patientID, PersonalData personalData) {
        super("sofka.emergencyroom.patientupdated");
        this.patientID = Objects.requireNonNull(patientID);
        this.personalData = Objects.requireNonNull(personalData);
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
}
