package co.com.sofka.useCase.emergencyRoomUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.emergencyRoom.EmergencyRoom;
import co.com.sofka.domain.emergencyRoom.commands.UpdatePatient;

public class UpdatePatientUseCase extends UseCase<RequestCommand<UpdatePatient>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdatePatient> updatePatientRequestCommand) {
        var command = updatePatientRequestCommand.getCommand();

        EmergencyRoom emergencyRoom = EmergencyRoom.from(
                command.getEmergencyRoomID(), retrieveEvents());

        emergencyRoom.updatePatient(
                command.getPatientID(),
                command.getPersonalData()
        );
        emit().onResponse(new ResponseEvents(emergencyRoom.getUncommittedChanges()));
    }
}
