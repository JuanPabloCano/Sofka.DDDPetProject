package co.com.sofka.useCase.doctorUserInterviewUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.doctorUserInterview.DoctorUserInterview;
import co.com.sofka.domain.doctorUserInterview.commands.CreateDoctorUserInterview;

public class CreateDoctorUserInterviewUseCase extends UseCase<RequestCommand<CreateDoctorUserInterview>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateDoctorUserInterview> createDoctorUserInterviewRequestCommand) {
        var command = createDoctorUserInterviewRequestCommand.getCommand();
        var doctorUserInterview = new DoctorUserInterview(
                command.getDoctorUserInterviewID(),
                command.getDoctor(),
                command.getUser(),
                command.getRoom(),
                command.getDateSchedule(),
                command.getBusinessHours());
        emit().onResponse(new ResponseEvents(doctorUserInterview.getUncommittedChanges()));
    }
}
