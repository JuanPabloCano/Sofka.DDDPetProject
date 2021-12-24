package co.com.sofka.domain.emergencyRoom;

import co.com.sofka.domain.emergencyRoom.values.SpecialistID;
import co.com.sofka.domain.emergencyRoom.values.Specialization;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class Specialist extends Entity<SpecialistID> {

    protected SpecialistID specialistID;
    protected PersonalData personalData;
    protected Specialization specialization;

    public Specialist(SpecialistID specialistID, PersonalData personalData, Specialization specialization) {
        super(specialistID);
        this.specialistID = Objects.requireNonNull(specialistID);
        this.personalData = Objects.requireNonNull(personalData);
        this.specialization = Objects.requireNonNull(specialization);
    }

    public void addPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public void updatePersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public void addSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public SpecialistID specialistID() {
        return specialistID;
    }

    public PersonalData personalData() {
        return personalData;
    }

    public Specialization specialization() {
        return specialization;
    }
}
