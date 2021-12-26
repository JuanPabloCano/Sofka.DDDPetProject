package co.com.sofka.useCase.mortuaryUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.mortuary.Mortuary;
import co.com.sofka.domain.mortuary.commands.CreateMortuary;

public class CreateMortuaryUseCase extends UseCase<RequestCommand<CreateMortuary>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateMortuary> createMortuaryRequestCommand) {
        var command = createMortuaryRequestCommand.getCommand();
        var mortuary = new Mortuary(
                command.getMortuaryID(),
                command.getCorpseID(),
                command.getCoronerID(),
                command.getEmbalmerID(),
                command.getBusinessHours()
        );
        emit().onResponse(new ResponseEvents(mortuary.getUncommittedChanges()));
    }
}
