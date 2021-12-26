package co.com.sofka.useCase.doctorUserInterviewUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.doctorUserInterview.commands.AddDoctor;
import co.com.sofka.domain.doctorUserInterview.events.DoctorAdded;
import co.com.sofka.domain.doctorUserInterview.values.DoctorID;
import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;
import co.com.sofka.useCase.doctorUserInterviewUseCase.AddDoctorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddDoctorUseCaseTest {

    @Test
    void addDoctor(){

        //Arrange
        var doctorUserInterviewID = DoctorUserInterviewID.of("xxxx");
        var doctorID = new DoctorID();
        var personalData = new PersonalData("Enrique - 65 años");
        var description = new Description("Paciente de 78 años de edad, ingresa a consulta sin ayudas externas, " +
                "presenta ritmo cardiaco estable, " +
                "presión normal, en todo el espectro de consciencia, marcha regular. Requiere hemograma de control");
        var command = new AddDoctor(doctorUserInterviewID, doctorID, personalData, description);
        var useCase = new AddDoctorUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Assert
        DoctorAdded event = (DoctorAdded) events.getDomainEvents().get(1);
        Assertions.assertEquals("Enrique - 65 años", event.getPersonalData().value());
        Assertions.assertEquals("Paciente de 78 años de edad, ingresa a consulta sin ayudas externas, " +
                "presenta ritmo cardiaco estable, " +
                "presión normal, en todo el espectro de consciencia, marcha regular. Requiere hemograma de control",
                event.getPersonalData().value());
    }
}