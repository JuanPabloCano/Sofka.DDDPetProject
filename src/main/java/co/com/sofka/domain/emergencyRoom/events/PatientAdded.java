package co.com.sofka.domain.emergencyRoom.events;

import co.com.sofka.domain.emergencyRoom.values.Consciousness;
import co.com.sofka.domain.emergencyRoom.values.PatientID;
import co.com.sofka.domain.emergencyRoom.values.Wounds;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.PersonalData;

import java.util.Map;
import java.util.Objects;

public class PatientAdded extends DomainEvent {

    private final PatientID patientID;
    private final PersonalData personalData;
    private final Consciousness consciousness;
    private final Wounds wounds;

    public PatientAdded(PatientID patientID, PersonalData personalData, Consciousness consciousness, Wounds
            wounds) {
        super("sofka.emergencyroom.patientadded");
        this.patientID = Objects.requireNonNull(patientID);
        this.personalData = Objects.requireNonNull(personalData);
        this.consciousness = Objects.requireNonNull(consciousness);
        this.wounds = Objects.requireNonNull(wounds);
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public  Consciousness getConsciousness() {
        return consciousness;
    }

    public Wounds getWounds() {
        return wounds;
    }
}
