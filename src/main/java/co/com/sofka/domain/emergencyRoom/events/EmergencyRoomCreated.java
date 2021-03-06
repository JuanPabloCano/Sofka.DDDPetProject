package co.com.sofka.domain.emergencyRoom.events;

import co.com.sofka.domain.emergencyRoom.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class EmergencyRoomCreated extends DomainEvent {

    private final EmergencyRoomID emergencyRoomID;
    private final SpecialistID specialistID;
    private final PatientID patientID;
    private final AccidentID accidentID;
    private final Rooms rooms;
    private final BusinessHours businessHours;

    public EmergencyRoomCreated(EmergencyRoomID emergencyRoomID, SpecialistID specialistID, PatientID patientID, AccidentID accidentID, Rooms rooms, BusinessHours businessHours) {
        super("sofka.emergencyroom.emergencyroomcreated");
        this.emergencyRoomID = Objects.requireNonNull(emergencyRoomID);
        this.specialistID = Objects.requireNonNull(specialistID);
        this.patientID = Objects.requireNonNull(patientID);
        this.accidentID = Objects.requireNonNull(accidentID);
        this.rooms = Objects.requireNonNull(rooms);
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public EmergencyRoomID getEmergencyRoomID() {
        return emergencyRoomID;
    }

    public SpecialistID getSpecialistID() {
        return specialistID;
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public AccidentID getAccidentID() {
        return accidentID;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
