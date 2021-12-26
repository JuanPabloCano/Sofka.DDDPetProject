package co.com.sofka.useCase.mortuaryUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.mortuary.Mortuary;
import co.com.sofka.domain.mortuary.commands.AddCorpse;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.domain.mortuary.values.EmbalmerID;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.BusinessHours;

public class AddCorpseUseCase extends UseCase<RequestCommand<AddCorpse>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddCorpse> addCorpseRequestCommand) {
        var command = addCorpseRequestCommand.getCommand();

        var mortuary = new Mortuary(
                new MortuaryID(),
                new CorpseID(),
                new CoronerID(),
                new EmbalmerID(),
                new BusinessHours("Lunes a sábado de 7 .a.m - 8 .p.m")
        );

        mortuary.addCorpse(
                command.getCorpseID(),
                command.getPersonalData(),
                command.getDeathCause()
        );

        emit().onResponse(new ResponseEvents(mortuary.getUncommittedChanges()));
    }
}
