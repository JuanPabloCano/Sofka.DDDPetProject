package co.com.sofka.useCase.mortuaryUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.mortuary.Mortuary;
import co.com.sofka.domain.mortuary.commands.AddCoroner;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.domain.mortuary.values.EmbalmerID;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.BusinessHours;

public class AddCoronerUseCase extends UseCase<RequestCommand<AddCoroner>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddCoroner> coronerAddedRequestCommand) {
        var command = coronerAddedRequestCommand.getCommand();

        var mortuary = new Mortuary(
                new MortuaryID(),
                new CorpseID(),
                new CoronerID(),
                new EmbalmerID(),
                new BusinessHours("Lunes a sábado de 7 .a.m - 8 .p.m")
        );

        mortuary.addCoroner(
                command.getCoronerID(),
                command.getPersonalData(),
                command.getDescription()
        );

        emit().onResponse(new ResponseEvents(mortuary.getUncommittedChanges()));
    }
}
