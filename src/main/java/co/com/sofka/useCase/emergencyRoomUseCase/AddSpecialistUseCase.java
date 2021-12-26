package co.com.sofka.useCase.emergencyRoomUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.emergencyRoom.EmergencyRoom;
import co.com.sofka.domain.emergencyRoom.commands.AddSpecialist;
import co.com.sofka.domain.emergencyRoom.values.*;
import co.com.sofka.generics.BusinessHours;

public class AddSpecialistUseCase extends UseCase<RequestCommand<AddSpecialist>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddSpecialist> addSpecialistRequestCommand) {
        var command = addSpecialistRequestCommand.getCommand();

        var emergencyRoom = new EmergencyRoom(
                new EmergencyRoomID(),
                new SpecialistID(),
                new PatientID(),
                new AccidentID(),
                new Rooms(),
                new BusinessHours("24/7")
        );
        emergencyRoom.addSpecialist(
                command.getSpecialistID(),
                command.getPersonalData(),
                command.getSpecialization());
        emit().onResponse(new ResponseEvents(emergencyRoom.getUncommittedChanges()));
    }
}
