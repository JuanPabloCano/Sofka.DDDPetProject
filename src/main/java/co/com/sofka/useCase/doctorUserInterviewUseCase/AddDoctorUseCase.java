package co.com.sofka.useCase.doctorUserInterviewUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.doctorUserInterview.DoctorUserInterview;
import co.com.sofka.domain.doctorUserInterview.commands.AddDoctor;
import co.com.sofka.domain.doctorUserInterview.values.*;
import co.com.sofka.generics.BusinessHours;

public class AddDoctorUseCase extends UseCase<RequestCommand<AddDoctor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddDoctor> addDoctorRequestCommand) {

        var command = addDoctorRequestCommand.getCommand();
        var doctorUserInterview = new DoctorUserInterview(
                new DoctorUserInterviewID(),
                new DoctorID(),
                new UserID(),
                new RoomID(),
                new DateSchedule(24, 12, 2021),
                new BusinessHours("Lunes - 8 .pm.")
        );

        doctorUserInterview.addDoctor(
                command.getDoctorID(),
                command.getPersonalData(),
                command.getDescription()
        );
        emit().onResponse(new ResponseEvents(doctorUserInterview.getUncommittedChanges()));
    }
}
