package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.emergencyRoom.commands.CreateEmergencyRoom;
import co.com.sofka.domain.emergencyRoom.events.EmergencyRoomCreated;
import co.com.sofka.domain.emergencyRoom.values.*;
import co.com.sofka.generics.BusinessHours;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateEmergencyRoomUseCaseTest {

    @Test
    void createEmergencyRoom(){

        //Arrange
        EmergencyRoomID emergencyRoomID = EmergencyRoomID.of("xxxx");
        SpecialistID specialistID = SpecialistID.of("aaaa");
        PatientID patientID = PatientID.of("bbbb");
        AccidentID accidentID = AccidentID.of("cccc");
        var rooms = new Rooms();
        rooms.addRooms("Room 1");
        rooms.addRooms("Room 2");
        rooms.addRooms("Room 3");
        BusinessHours businessHours = new BusinessHours("24/7");

        var command = new CreateEmergencyRoom(emergencyRoomID, specialistID, patientID, accidentID, rooms,
                businessHours);
        var useCase = new CreateEmergencyRoomUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Assert
        EmergencyRoomCreated event = (EmergencyRoomCreated) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("aaaa", event.getSpecialistID().value());
        Assertions.assertEquals("bbbb", event.getPatientID().value());
        Assertions.assertEquals("cccc", event.getAccidentID().value());
        Assertions.assertEquals("24/7", event.getBusinessHours().value());
    }
}