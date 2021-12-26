package co.com.sofka.useCase.doctorUserInterviewUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.doctorUserInterview.DoctorUserInterview;
import co.com.sofka.domain.doctorUserInterview.commands.AddUser;
import co.com.sofka.domain.doctorUserInterview.values.*;
import co.com.sofka.generics.BusinessHours;

public class AddUserUseCase extends UseCase<RequestCommand<AddUser>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddUser> addUserRequestCommand) {
        var command = addUserRequestCommand.getCommand();

        var doctorUserInterview = new DoctorUserInterview(
                new DoctorUserInterviewID(),
                new DoctorID(),
                new UserID(),
                new RoomID(),
                new DateSchedule(29, 12, 2021),
                new BusinessHours("Viernes - 9 .p.m."));

        doctorUserInterview.addUser(
                command.getUserID(),
                command.getPersonalData(),
                command.getSymptoms()
        );
        emit().onResponse(new ResponseEvents(doctorUserInterview.getUncommittedChanges()));
    }
}
