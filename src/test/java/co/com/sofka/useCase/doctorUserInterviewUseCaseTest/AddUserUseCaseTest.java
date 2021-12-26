package co.com.sofka.useCase.doctorUserInterviewUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.doctorUserInterview.commands.AddUser;
import co.com.sofka.domain.doctorUserInterview.events.UserAdded;
import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.domain.doctorUserInterview.values.Symptoms;
import co.com.sofka.domain.doctorUserInterview.values.UserID;
import co.com.sofka.generics.PersonalData;
import co.com.sofka.useCase.doctorUserInterviewUseCase.AddUserUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class AddUserUseCaseTest {

    @Test
    void addUser(){

        //Arrange
        var doctorUserInterviewID = DoctorUserInterviewID.of("xxxx");
        var userID = new UserID();
        var personalData = new PersonalData("Julia - 45 años");

        Set<String> addSymptoms = new HashSet<>();
        addSymptoms.add("Fiebre");
        addSymptoms.add("Dolor de estomago");
        addSymptoms.add("Diarrea");
        addSymptoms.add("Vómito");
        var symptoms = new Symptoms(addSymptoms);

        var command = new AddUser(doctorUserInterviewID, userID, personalData, symptoms);
        var useCase = new AddUserUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Asserts
        UserAdded event = (UserAdded) events.getDomainEvents().get(1);
        Assertions.assertEquals("Julia - 45 años", event.getPersonalData().value());
        addSymptoms.forEach(symptom -> symptom.equals(event.getSymptoms()));
    }
}