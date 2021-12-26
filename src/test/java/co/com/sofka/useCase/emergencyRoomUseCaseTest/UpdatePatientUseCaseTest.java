package co.com.sofka.useCase.emergencyRoomUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.emergencyRoom.commands.UpdatePatient;
import co.com.sofka.domain.emergencyRoom.events.PatientAdded;
import co.com.sofka.domain.emergencyRoom.events.PatientUpdated;
import co.com.sofka.domain.emergencyRoom.values.Consciousness;
import co.com.sofka.domain.emergencyRoom.values.EmergencyRoomID;
import co.com.sofka.domain.emergencyRoom.values.PatientID;
import co.com.sofka.domain.emergencyRoom.values.Wounds;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.PersonalData;
import co.com.sofka.useCase.emergencyRoomUseCase.UpdatePatientUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdatePatientUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void updatePatient() {

        //Arrange
        var emergencyRoomID = EmergencyRoomID.of("xxxx");
        var patientID = PatientID.of("1");
        var command = new UpdatePatient(emergencyRoomID, patientID,
                new PersonalData("Sara - 19 años"));
        var useCase = new UpdatePatientUseCase();

        //Act
        when(repository.getEventsBy("xxxx")).thenReturn(eventsList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Asserts
        PatientUpdated event = (PatientUpdated) events.getDomainEvents().get(0);
        Assertions.assertEquals("1", event.getPatientID().value());
        Assertions.assertEquals("Sara - 19 años", event.getPersonalData().value());
    }

    private List<DomainEvent> eventsList() {

        Map<String, String> addConsciousness = new HashMap<>();
        addConsciousness.put("Motora", "2");

        Map<String, String> addWounds = new HashMap<>();
        addWounds.put("Fisura", "Radio y cúbito derecho");
        addWounds.put("Fractura bi-maleolar", "Pierna derecha");
        addWounds.put("Hemorragia sub-aracnoidea", "Cabeza");
        addWounds.put("Perforación pulmonar", "Pulmón izquierdo");
        addWounds.put("Laceración grave", "Región palmar derecha");

        return List.of(new PatientAdded(PatientID.of("1"),
                new PersonalData("Juan, 23 años"),
                new Consciousness(addConsciousness),
                new Wounds(addWounds)
        ));
    }

}