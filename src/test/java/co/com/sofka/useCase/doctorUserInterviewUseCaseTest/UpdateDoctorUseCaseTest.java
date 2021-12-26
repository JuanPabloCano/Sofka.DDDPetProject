package co.com.sofka.useCase.doctorUserInterviewUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.doctorUserInterview.commands.UpdateDoctor;
import co.com.sofka.domain.doctorUserInterview.events.DoctorAdded;
import co.com.sofka.domain.doctorUserInterview.events.DoctorUpdated;
import co.com.sofka.domain.doctorUserInterview.values.DoctorID;
import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;
import co.com.sofka.useCase.doctorUserInterviewUseCase.UpdateDoctorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateDoctorUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void updateDoctor() {

        //Arrange
        var doctorUserInterviewID = DoctorUserInterviewID.of("xxxx");
        var doctorID = DoctorID.of("1");
        var command = new UpdateDoctor(doctorUserInterviewID, doctorID,
                new PersonalData("Enrique - 67 años"));
        var useCase = new UpdateDoctorUseCase();

        //Act
        when(repository.getEventsBy("xxxx")).thenReturn(eventsList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Asserts
        DoctorUpdated event = (DoctorUpdated) events.getDomainEvents().get(0);
        Assertions.assertEquals("1", event.getDoctorID().value());
        Assertions.assertEquals("Enrique - 67 años", event.getPersonalData().value());
    }

    private List<DomainEvent> eventsList() {
        return List.of(new DoctorAdded(DoctorID.of("1"),
                new PersonalData("Enrique - 65 años"),
                new Description("Paciente de 78 años de edad, ingresa a consulta sin ayudas externas,presenta ritmo cardiaco estable,presión normal, en todo el espectro de consciencia, marcha regular. Requiere hemograma de control")
        ));
    }
}