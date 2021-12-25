package co.com.sofka.domain.emergencyRoom;

import co.com.sofka.domain.emergencyRoom.events.*;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.generics.BusinessHoursAdded;

public class EmergencyRoomChange extends EventChange {

    public EmergencyRoomChange(EmergencyRoom emergencyRoom) {

        apply((EmergencyRoomCreated event) -> {
            emergencyRoom.specialist.specialistID = event.getSpecialistID();
            emergencyRoom.patient.patientID = event.getPatientID();
            emergencyRoom.accident.accidentID = event.getAccidentID();
            emergencyRoom.rooms = event.getRooms();
            emergencyRoom.businessHours = event.getBusinessHours();
        });

        apply((AccidentAdded event) -> {
            emergencyRoom.accident.accidentID = event.getAccidentID();
            emergencyRoom.accident.place = event.getPlace();
            emergencyRoom.accident.timeOfAccident = event.getTimeOfAccident();
            emergencyRoom.accident.description = event.getDescription();
        });

        apply((PatientAdded event) -> {
            emergencyRoom.patient.personalData = event.getPersonalData();
            emergencyRoom.patient.consciousness.put(event.getConsciousness(), 0);
            emergencyRoom.patient.wounds.put(event.getWounds(), "");
        });

        apply((PatientUpdated event) -> {
            var patient = emergencyRoom.getPatientById(event.getPatientID())
                    .orElseThrow(() -> new IllegalArgumentException("El ID del paciente no fue encontrado"));
            patient.updatePersonalData(event.getPersonalData());
        });

        apply((RoomAdded event) -> emergencyRoom.rooms = event.getRooms());

        apply((SpecialistCreated event) -> {
            emergencyRoom.specialist.specialistID = event.getSpecialistID();
            emergencyRoom.specialist.personalData = event.getPersonalData();
            emergencyRoom.specialist.specialization = event.getSpecialization();
        });

        apply((SpecialistUpdated event) -> {
            var specialist = emergencyRoom.getSpecialistById(event.getSpecialistID())
                    .orElseThrow(() -> new IllegalArgumentException("El ID del especialista no fue encontrado"));
            specialist.updatePersonalData(event.getPersonalData());
        });

        apply((BusinessHoursAdded event) -> emergencyRoom.businessHours = event.getBusinessHours());

    }
}
