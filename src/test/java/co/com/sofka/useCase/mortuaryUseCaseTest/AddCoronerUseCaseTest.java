package co.com.sofka.useCase.mortuaryUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.mortuary.commands.AddCoroner;
import co.com.sofka.domain.mortuary.events.CoronerAdded;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;
import co.com.sofka.useCase.mortuaryUseCase.AddCoronerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddCoronerUseCaseTest {

    @Test
    void addCoroner(){

        //Arrange
        var mortuaryId = MortuaryID.of("xxxx");
        var coronerId = new CoronerID();
        var personalData = new PersonalData("Juan, 23 años");
        var description = new Description("El cadáver presenta heridas en todo el cuerpo");
        var command = new AddCoroner(mortuaryId, coronerId, personalData, description);
        var useCase = new AddCoronerUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Assert
        CoronerAdded event = (CoronerAdded) events.getDomainEvents().get(1);
        Assertions.assertEquals( "Juan, 23 años", event.getPersonalData().value());
        Assertions.assertEquals("El cadáver presenta heridas en todo el cuerpo", event.getDescription().value());
    }
}