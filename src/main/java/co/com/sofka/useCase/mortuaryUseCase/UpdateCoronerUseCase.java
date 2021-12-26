package co.com.sofka.useCase.mortuaryUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.mortuary.Mortuary;
import co.com.sofka.domain.mortuary.commands.UpdateCoroner;

public class UpdateCoronerUseCase extends UseCase<RequestCommand<UpdateCoroner>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateCoroner> updateCoronerRequestCommand) {
        var command = updateCoronerRequestCommand.getCommand();

        Mortuary mortuary = Mortuary.from(command.getMortuaryID(), retrieveEvents());

        mortuary.updateCoroner(
                command.getCoronerID(),
                command.getPersonalData()
        );
        emit().onResponse(new ResponseEvents(mortuary.getUncommittedChanges()));
    }
}
