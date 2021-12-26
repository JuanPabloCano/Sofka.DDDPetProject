package co.com.sofka.domain.emergencyRoom;

import co.com.sofka.domain.emergencyRoom.events.*;
import co.com.sofka.domain.emergencyRoom.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.BusinessHours;
import co.com.sofka.generics.BusinessHoursAdded;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;

import java.util.*;

public class EmergencyRoom extends AggregateEvent<EmergencyRoomID> {

    protected Specialist specialist;
    protected Patient patient;
    protected Accident accident;
    protected Rooms rooms;
    protected BusinessHours businessHours;
    protected Set<Specialist> specialists;
    protected Set<Patient> patients;


    private EmergencyRoom(EmergencyRoomID emergencyRoomID) {
        super(emergencyRoomID);
        subscribe(new EmergencyRoomChange(this));
    }

    public EmergencyRoom(EmergencyRoomID emergencyRoomID, SpecialistID specialistID, PatientID patientID,
                         AccidentID accidentID, Rooms rooms, BusinessHours businessHours) {
        super(emergencyRoomID);
        appendChange(new EmergencyRoomCreated(emergencyRoomID, specialistID, patientID, accidentID, rooms, businessHours)).apply();
    }

    public static EmergencyRoom from(EmergencyRoomID emergencyRoomID, List<DomainEvent> events) {
        var emergencyRoom = new EmergencyRoom(emergencyRoomID);
        events.forEach(emergencyRoom::applyEvent);
        return emergencyRoom;
    }

    public void addSpecialist(SpecialistID specialistID, PersonalData personalData, Specialization specialization) {
        Objects.requireNonNull(specialistID);
        Objects.requireNonNull(personalData);
        Objects.requireNonNull(specialization);
        appendChange(new SpecialistAdded(specialistID, personalData, specialization)).apply();
    }

    public void updateSpecialist(SpecialistID specialistID, PersonalData personalData) {
        Objects.requireNonNull(specialistID);
        Objects.requireNonNull(personalData);
        appendChange(new SpecialistUpdated(specialistID, personalData)).apply();
    }

    public void addPatient(PatientID patientID, PersonalData personalData, Consciousness consciousness,
                           Wounds wounds) {
        Objects.requireNonNull(patientID);
        Objects.requireNonNull(personalData);
        Objects.requireNonNull(consciousness);
        Objects.requireNonNull(wounds);
        appendChange(new PatientAdded(patientID, personalData, consciousness, wounds)).apply();
    }

    public void updatePatient(PatientID patientID, PersonalData personalData) {
        Objects.requireNonNull(patientID);
        Objects.requireNonNull(personalData);
        appendChange(new PatientUpdated(patientID, personalData)).apply();
    }

    public void addAccident(AccidentID accidentID, Place place, TimeOfAccident timeOfAccident,
                            Description description) {
        Objects.requireNonNull(accidentID);
        Objects.requireNonNull(place);
        Objects.requireNonNull(timeOfAccident);
        Objects.requireNonNull(description);
        appendChange(new AccidentAdded(accidentID, place, timeOfAccident, description)).apply();
    }

    public void addRoom(Rooms rooms) {
        Objects.requireNonNull(rooms);
        appendChange(new RoomAdded(rooms)).apply();
    }

    public void addBusinessHours(BusinessHours businessHours) {
        Objects.requireNonNull(businessHours);
        appendChange(new BusinessHoursAdded(businessHours)).apply();
    }

    protected Optional<Specialist> getSpecialistById(SpecialistID specialistID) {
        return specialists.stream()
                .filter(specialistid -> specialistid
                        .identity()
                        .equals(specialistID))
                .findFirst();
    }

    protected Optional<Patient> getPatientById(PatientID patientID) {
        return patients.stream()
                .filter(patientid -> patientid
                        .identity()
                        .equals(patientID))
                .findFirst();
    }

    public Specialist specialist() {
        return specialist;
    }

    public Patient patient() {
        return patient;
    }

    public Accident accident() {
        return accident;
    }

    public Rooms rooms() {
        return rooms;
    }

    public BusinessHours businessHours() {
        return businessHours;
    }

    public Set<Specialist> specialists() {
        return specialists;
    }

    public Set<Patient> patients() {
        return patients;
    }
}
