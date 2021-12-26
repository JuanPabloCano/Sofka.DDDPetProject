package co.com.sofka.useCase.emergencyRoomUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.emergencyRoom.EmergencyRoom;
import co.com.sofka.domain.emergencyRoom.commands.AddAccident;
import co.com.sofka.domain.emergencyRoom.values.*;
import co.com.sofka.generics.BusinessHours;


public class AddAccidentUseCase extends UseCase<RequestCommand<AddAccident>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddAccident> addAccidentRequestCommand) {
        var command = addAccidentRequestCommand.getCommand();

        var emergencyRoom = new EmergencyRoom(
                new EmergencyRoomID(),
                new SpecialistID(),
                new PatientID(),
                new AccidentID(),
                new Rooms(),
                new BusinessHours("24/7")
        );

        emergencyRoom.addAccident(command.getAccidentID(),
                command.getPlace(),
                command.getTimeOfAccident(),
                command.getDescription());
        emit().onResponse(new ResponseEvents(emergencyRoom.getUncommittedChanges()));
    }
}
