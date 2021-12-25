package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.emergencyRoom.EmergencyRoom;
import co.com.sofka.domain.emergencyRoom.commands.AddAccident;


public class AddAccidentUseCase extends UseCase<RequestCommand<AddAccident>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddAccident> addAccidentRequestCommand) {
        var command = addAccidentRequestCommand.getCommand();
        var accident = EmergencyRoom.from(command.getEmergencyRoomID(), retrieveEvents());

        accident.addAccident(command.getAccidentID(),
                command.getPlace(),
                command.getTimeOfAccident(),
                command.getDescription());
        emit().onResponse(new ResponseEvents(accident.getUncommittedChanges()));
    }
}
