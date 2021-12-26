package co.com.sofka.useCase.mortuaryUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.mortuary.commands.AddCorpse;
import co.com.sofka.domain.mortuary.events.CorpseAdded;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.domain.mortuary.values.DeathCause;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.PersonalData;
import co.com.sofka.useCase.mortuaryUseCase.AddCorpseUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddCorpseUseCaseTest {

    @Test
    void addCorpse(){

        //Arrange
        var morutaryId = MortuaryID.of("xxxx");
        var corpseId = new CorpseID();
        var personalData = new PersonalData("Camila - 21 años");
        var deathCause = new DeathCause("Camila murió por hemorragia de la arteria cerebral media, ocasionada por " +
                "sobreuso de drogas");
        var command = new AddCorpse(morutaryId, corpseId, personalData, deathCause);
        var useCase = new AddCorpseUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        CorpseAdded event = (CorpseAdded) events.getDomainEvents().get(1);
        Assertions.assertEquals("Camila - 21 años", event.getPersonalData().value());
        Assertions.assertEquals("Camila murió por hemorragia de la arteria cerebral media, ocasionada por sobreuso de" +
                " drogas", event.getDeathCause().value());
    }
}