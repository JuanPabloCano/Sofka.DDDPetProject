package co.com.sofka.useCase.emergencyRoomUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.emergencyRoom.EmergencyRoom;
import co.com.sofka.domain.emergencyRoom.commands.AddPatient;
import co.com.sofka.domain.emergencyRoom.values.*;
import co.com.sofka.generics.BusinessHours;

public class AddPatientUseCase extends UseCase<RequestCommand<AddPatient>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPatient> addPatientRequestCommand) {
        var command = addPatientRequestCommand.getCommand();

        var emergencyRoom = new EmergencyRoom(
                new EmergencyRoomID(),
                new SpecialistID(),
                new PatientID(),
                new AccidentID(),
                new Rooms(),
                new BusinessHours("24/7")
        );

        emergencyRoom.addPatient(
                command.getPatientID(),
                command.getPersonalData(),
                command.getConsciousness(),
                command.getWounds()
        );

        emit().onResponse(new ResponseEvents(emergencyRoom.getUncommittedChanges()));
    }
}
