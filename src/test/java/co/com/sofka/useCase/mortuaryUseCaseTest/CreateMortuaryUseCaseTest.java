package co.com.sofka.useCase.mortuaryUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.mortuary.commands.CreateMortuary;
import co.com.sofka.domain.mortuary.events.MortuaryCreated;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.domain.mortuary.values.EmbalmerID;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.BusinessHours;
import co.com.sofka.useCase.mortuaryUseCase.CreateMortuaryUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateMortuaryUseCaseTest {

    @Test
    void createMortuary() {

        // Arrange
        MortuaryID mortuaryID = MortuaryID.of("xxxx");
        CorpseID corpseID = CorpseID.of("aaaa");
        CoronerID coronerID = CoronerID.of("bbbb");
        EmbalmerID embalmerID = EmbalmerID.of("cccc");
        BusinessHours businessHours = new BusinessHours("Lunes a viernes de 8 .a.m. - 7 .p.m.");

        var command = new CreateMortuary(mortuaryID, corpseID, coronerID, embalmerID, businessHours);
        var useCase = new CreateMortuaryUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Assert
        MortuaryCreated event = (MortuaryCreated) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("aaaa", event.getCorpseID().value());
        Assertions.assertEquals("bbbb", event.getCoronerID().value());
        Assertions.assertEquals("cccc", event.getEmbalmerID().value());
        Assertions.assertEquals("Lunes a viernes de 8 .a.m. - 7 .p.m.", event.getBusinessHours().value());
    }
}