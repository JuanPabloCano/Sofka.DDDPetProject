package co.com.sofka.useCase.doctorUserInterviewUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.doctorUserInterview.DoctorUserInterview;
import co.com.sofka.domain.doctorUserInterview.commands.UpdateDoctor;

public class UpdateDoctorUseCase extends UseCase<RequestCommand<UpdateDoctor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateDoctor> updateDoctorRequestCommand) {
        var command = updateDoctorRequestCommand.getCommand();

        DoctorUserInterview doctorUserInterview = DoctorUserInterview.from(command.getDoctorUserInterviewID(),
                retrieveEvents());

        doctorUserInterview.updateDoctor(
                command.getDoctorID(),
                command.getPersonalData()
        );
        emit().onResponse(new ResponseEvents(doctorUserInterview.getUncommittedChanges()));
    }
}
