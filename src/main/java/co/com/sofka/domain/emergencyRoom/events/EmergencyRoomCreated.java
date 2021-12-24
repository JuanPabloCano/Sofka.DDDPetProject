package co.com.sofka.domain.emergencyRoom.events;

import co.com.sofka.domain.emergencyRoom.Accident;
import co.com.sofka.domain.emergencyRoom.Patient;
import co.com.sofka.domain.emergencyRoom.Specialist;
import co.com.sofka.domain.emergencyRoom.values.EmergencyRoomID;
import co.com.sofka.domain.emergencyRoom.values.Rooms;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class EmergencyRoomCreated extends DomainEvent {

    private final EmergencyRoomID emergencyRoomID;
    private final Specialist specialist;
    private final Patient patient;
    private final Rooms rooms;
    private final BusinessHours businessHours;

    public EmergencyRoomCreated(EmergencyRoomID emergencyRoomID, Specialist specialist, Patient patient, Accident accident, Rooms rooms, BusinessHours businessHours) {
        super("sofka.emergencyroom.emergencyroomcreated");
        this.emergencyRoomID = Objects.requireNonNull(emergencyRoomID);
        this.specialist = Objects.requireNonNull(specialist);
        this.patient = Objects.requireNonNull(patient);
        this.rooms = Objects.requireNonNull(rooms);
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public EmergencyRoomID getEmergencyRoomID() {
        return emergencyRoomID;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public Patient getPatient() {
        return patient;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
