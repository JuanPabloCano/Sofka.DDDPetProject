package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.mortuary.Mortuary;
import co.com.sofka.domain.mortuary.commands.AddCoroner;

public class AddCoronerUseCase extends UseCase<RequestCommand<AddCoroner>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddCoroner> coronerAddedRequestCommand) {
        var command = coronerAddedRequestCommand.getCommand();
        var coroner = Mortuary.from(command.getMortuaryID(), retrieveEvents());
        coroner.addCoroner(command.getCoronerID(),
                command.getPersonalData(),
                command.getDescription());
        emit().onResponse(new ResponseEvents(coroner.getUncommittedChanges()));
    }
}
