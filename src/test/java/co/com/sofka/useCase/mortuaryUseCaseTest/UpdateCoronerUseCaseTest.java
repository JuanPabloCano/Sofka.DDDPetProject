package co.com.sofka.useCase.mortuaryUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.mortuary.commands.UpdateCoroner;
import co.com.sofka.domain.mortuary.events.CoronerAdded;
import co.com.sofka.domain.mortuary.events.CoronerUpdated;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;
import co.com.sofka.useCase.mortuaryUseCase.UpdateCoronerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateCoronerUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void updateCoroner(){

        //Arrange
        var mortuaryID = MortuaryID.of("xxxx");
        var coronerID = CoronerID.of("1");
        var command = new UpdateCoroner(mortuaryID, coronerID,
                new PersonalData("Juan, 24 años"));
        var useCase = new UpdateCoronerUseCase();

        //Act
        when(repository.getEventsBy("xxxx")).thenReturn(eventsList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Asserts
        CoronerUpdated event = (CoronerUpdated) events.getDomainEvents().get(0);
        Assertions.assertEquals("1", event.getCoronerID().value());
        Assertions.assertEquals("Juan, 24 años", event.getPersonalData().value());
    }

    private List<DomainEvent> eventsList(){
        return List.of(new CoronerAdded(CoronerID.of("1"),
                new PersonalData("Juan, 23 años"),
                new Description("El cadáver presenta heridas en todo el cuerpo")
        ));
    }
}