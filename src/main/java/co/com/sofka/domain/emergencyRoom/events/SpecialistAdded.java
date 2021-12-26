package co.com.sofka.domain.emergencyRoom.events;

import co.com.sofka.domain.emergencyRoom.values.SpecialistID;
import co.com.sofka.domain.emergencyRoom.values.Specialization;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class SpecialistAdded extends DomainEvent {

    private final SpecialistID specialistID;
    private final PersonalData personalData;
    private final Specialization specialization;

    public SpecialistAdded(SpecialistID specialistID, PersonalData personalData, Specialization specialization) {
        super("sofka.emergencyroom.specialistcreated");
        this.specialistID = Objects.requireNonNull(specialistID);
        this.personalData = Objects.requireNonNull(personalData);
        this.specialization = Objects.requireNonNull(specialization);
    }

    public SpecialistID getSpecialistID() {
        return specialistID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Specialization getSpecialization() {
        return specialization;
    }
}
