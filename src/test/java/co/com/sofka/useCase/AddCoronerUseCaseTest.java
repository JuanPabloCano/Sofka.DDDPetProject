package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.mortuary.commands.AddCoroner;
import co.com.sofka.domain.mortuary.events.CoronerAdded;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddCoronerUseCaseTest {

    @Test
    void addCoroner(){

        //Arrange
        var mortuaryId = MortuaryID.of("xxxx");
        var coronerId = CoronerID.of("aaaa");
        var personalData = new PersonalData("Juan", "juan@gmail.com", 23);
        var description = new Description("El cadáver presenta heridas en todo el cuerpo");
        var command = new AddCoroner(mortuaryId, coronerId, personalData, description);
        var useCase = new AddCoronerUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Assert
        CoronerAdded event = (CoronerAdded) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("aaaa", event.getCoronerID().value());
        Assertions.assertEquals("Juan", event.getPersonalData().value());
        Assertions.assertEquals("El cadáver presenta heridas en todo el cuerpo", event.getDescription().value());
    }
}