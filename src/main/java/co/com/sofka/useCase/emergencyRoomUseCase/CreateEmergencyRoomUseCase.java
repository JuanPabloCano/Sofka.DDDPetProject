package co.com.sofka.useCase.emergencyRoomUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.emergencyRoom.EmergencyRoom;
import co.com.sofka.domain.emergencyRoom.commands.CreateEmergencyRoom;

public class CreateEmergencyRoomUseCase extends UseCase<RequestCommand<CreateEmergencyRoom>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateEmergencyRoom> createEmergencyRoomRequestCommand) {
        var command = createEmergencyRoomRequestCommand.getCommand();
        var emergencyRoom = new EmergencyRoom(
                command.getEmergencyRoomID(),
                command.getSpecialistID(),
                command.getPatientID(),
                command.getAccidentID(),
                command.getRooms(),
                command.getBusinessHours()
        );
        emit().onResponse(new ResponseEvents(emergencyRoom.getUncommittedChanges()));
    }
}
