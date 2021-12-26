package co.com.sofka.useCase.emergencyRoomUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.domain.emergencyRoom.commands.AddPatient;
import co.com.sofka.domain.emergencyRoom.events.PatientAdded;
import co.com.sofka.domain.emergencyRoom.values.Consciousness;
import co.com.sofka.domain.emergencyRoom.values.PatientID;
import co.com.sofka.domain.emergencyRoom.values.Wounds;
import co.com.sofka.generics.PersonalData;
import co.com.sofka.useCase.emergencyRoomUseCase.AddPatientUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;
import java.util.HashMap;
import java.util.Map;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

class AddPatientUseCaseTest {

    @Test
    void addPatient(){

        //Arrange
        var doctorUserInterview = DoctorUserInterviewID.of("xxxx");
        var patientID = new PatientID();
        var personalData = new PersonalData("Sara - 20 años");

        Map<String, String> addConsciousness = new HashMap<>();
        addConsciousness.put("Motora", "2");
        var consciousness = new Consciousness(addConsciousness);

        Map<String, String> addWounds = new HashMap<>();
        addWounds.put("Fisura", "Radio y cúbito derecho");
        addWounds.put("Fractura bi-maleolar", "Pierna derecha");
        addWounds.put("Hemorragia sub-aracnoidea", "Cabeza");
        addWounds.put("Perforación pulmonar", "Pulmón izquierdo");
        addWounds.put("Laceración grave", "Región palmar derecha");
        var wounds = new Wounds(addWounds);

        var command = new AddPatient(patientID, personalData, consciousness, wounds);
        var useCase = new AddPatientUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Assert
        PatientAdded event = (PatientAdded) events.getDomainEvents().get(1);
        Assertions.assertEquals("Sara - 20 años", event.getPersonalData().value());

        //Consciousness Assert
        for(Map.Entry<String, String> consciousnessMap : consciousness.value().entrySet()){
            assertReflectionEquals((Object) consciousnessMap.getValue(),
                    addConsciousness.get(consciousnessMap.getKey()),
                    ReflectionComparatorMode.LENIENT_ORDER);
        }
        //Wounds Assert
        for(Map.Entry<String, String> woundsMap : wounds.value().entrySet()){
            assertReflectionEquals((Object) woundsMap.getValue(),
                    addWounds.get(woundsMap.getKey()),
                    ReflectionComparatorMode.LENIENT_ORDER);
        }
    }
}