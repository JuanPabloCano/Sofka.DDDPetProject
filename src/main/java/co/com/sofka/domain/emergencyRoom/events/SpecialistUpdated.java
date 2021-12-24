package co.com.sofka.domain.emergencyRoom.events;

import co.com.sofka.domain.emergencyRoom.values.SpecialistID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class SpecialistUpdated extends DomainEvent {

    private final SpecialistID specialistID;
    private final PersonalData personalData;

    public SpecialistUpdated(SpecialistID specialistID, PersonalData personalData) {
        super("sofka.emergencyroom.specialistupdated");
        this.specialistID = Objects.requireNonNull(specialistID);
        this.personalData = Objects.requireNonNull(personalData);
    }

    public SpecialistID getSpecialistID() {
        return specialistID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
}
