package co.com.sofka.domain.emergencyRoom.commands;

import co.com.sofka.domain.emergencyRoom.values.EmergencyRoomID;
import co.com.sofka.domain.emergencyRoom.values.SpecialistID;
import co.com.sofka.domain.emergencyRoom.values.Specialization;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class AddSpecialist extends Command {

    private final EmergencyRoomID emergencyRoomID;
    private final SpecialistID specialistID;
    private final PersonalData personalData;
    private final Specialization specialization;

    public AddSpecialist(EmergencyRoomID emergencyRoomID, SpecialistID specialistID, PersonalData personalData,
                         Specialization specialization) {
        this.emergencyRoomID = Objects.requireNonNull(emergencyRoomID);
        this.specialistID = Objects.requireNonNull(specialistID);
        this.personalData = Objects.requireNonNull(personalData);
        this.specialization = Objects.requireNonNull(specialization);
    }

    public EmergencyRoomID getEmergencyRoomID() {
        return emergencyRoomID;
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
