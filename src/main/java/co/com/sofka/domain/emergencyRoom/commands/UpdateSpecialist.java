package co.com.sofka.domain.emergencyRoom.commands;

import co.com.sofka.domain.emergencyRoom.values.SpecialistID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class UpdateSpecialist extends Command {

    private final SpecialistID specialistID;
    private final PersonalData personalData;

    public UpdateSpecialist(SpecialistID specialistID, PersonalData personalData) {
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
