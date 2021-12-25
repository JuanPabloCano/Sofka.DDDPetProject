package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.emergencyRoom.commands.AddAccident;
import co.com.sofka.domain.emergencyRoom.events.AccidentAdded;
import co.com.sofka.domain.emergencyRoom.values.AccidentID;
import co.com.sofka.domain.emergencyRoom.values.EmergencyRoomID;
import co.com.sofka.domain.emergencyRoom.values.Place;
import co.com.sofka.domain.emergencyRoom.values.TimeOfAccident;
import co.com.sofka.generics.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

class AddAccidentUseCaseTest {

    @Test
    void addAccident() {

        //Arrange
        var emergencyRoomID = EmergencyRoomID.of("xxxx");
        var accidentID = AccidentID.of("aaaa");
        var place = new Place("Carrera 43 # 45", "Choque automovilistico");
        var timeOfAccident = new TimeOfAccident(LocalDateTime.now());
        var description = new Description("El accidente ocurrió por un conductor en estado de embriaguez");
        var command = new AddAccident(emergencyRoomID, accidentID, place, timeOfAccident, description);
        var useCase = new AddAccidentUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Assert
        AccidentAdded event = (AccidentAdded) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("aaaa", event.getAccidentID().value());
        Assertions.assertEquals("Carrera 43 # 45", event.getPlace().value());
        Assertions.assertEquals(LocalDateTime.now(), event.getTimeOfAccident().value());
        Assertions.assertEquals("El accidente ocurrió por un conductor en estado de embriaguez",
                event.getDescription().value());
    }
}