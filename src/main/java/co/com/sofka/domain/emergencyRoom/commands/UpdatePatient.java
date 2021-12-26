package co.com.sofka.domain.emergencyRoom.commands;

import co.com.sofka.domain.emergencyRoom.values.EmergencyRoomID;
import co.com.sofka.domain.emergencyRoom.values.PatientID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class UpdatePatient extends Command {

    private final EmergencyRoomID emergencyRoomID;
    private final PatientID patientID;
    private final PersonalData personalData;

    public UpdatePatient(EmergencyRoomID emergencyRoomID, PatientID patientID, PersonalData personalData) {
        this.emergencyRoomID = Objects.requireNonNull(emergencyRoomID);
        this.patientID = Objects.requireNonNull(patientID);
        this.personalData = Objects.requireNonNull(personalData);
    }

    public EmergencyRoomID getEmergencyRoomID() {
        return emergencyRoomID;
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
}
