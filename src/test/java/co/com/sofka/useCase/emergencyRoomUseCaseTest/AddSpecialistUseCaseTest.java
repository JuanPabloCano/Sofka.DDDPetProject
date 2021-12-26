package co.com.sofka.useCase.emergencyRoomUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.emergencyRoom.commands.AddSpecialist;
import co.com.sofka.domain.emergencyRoom.events.SpecialistAdded;
import co.com.sofka.domain.emergencyRoom.values.EmergencyRoomID;
import co.com.sofka.domain.emergencyRoom.values.SpecialistID;
import co.com.sofka.domain.emergencyRoom.values.Specialization;
import co.com.sofka.generics.PersonalData;
import co.com.sofka.useCase.emergencyRoomUseCase.AddSpecialistUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddSpecialistUseCaseTest {

    @Test
    void addSpecialist(){

        //Arrange
        var emergencyRoomID = EmergencyRoomID.of("xxxx");
        var specialistID = new SpecialistID();
        var personalData = new PersonalData("Laura - 32 años");
        var specialization = new Specialization("Anestesiología", "Especialización médica", "18 meses");
        var command = new AddSpecialist(emergencyRoomID, specialistID, personalData, specialization);
        var useCase = new AddSpecialistUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Assert
        SpecialistAdded event = (SpecialistAdded) events.getDomainEvents().get(1);
        Assertions.assertEquals("Laura - 32 años", event.getPersonalData().value());
        Assertions.assertEquals("Anestesiología"+" Especialización médica"+" 18 meses", event.getSpecialization().value());
    }

}