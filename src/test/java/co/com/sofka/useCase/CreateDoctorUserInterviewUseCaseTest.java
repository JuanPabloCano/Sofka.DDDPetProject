package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.doctorUserInterview.commands.CreateDoctorUserInterview;
import co.com.sofka.domain.doctorUserInterview.events.DoctorUserInterviewCreated;
import co.com.sofka.domain.doctorUserInterview.values.*;
import co.com.sofka.generics.BusinessHours;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateDoctorUserInterviewUseCaseTest {

    @Test
    void createDoctorUserInterview() {

        // Arrange
        DoctorUserInterviewID doctorUserInterviewID = DoctorUserInterviewID.of("xxxx");
        DoctorID doctorId = DoctorID.of("aaaa");
        UserID userId = UserID.of("bbbb");
        RoomID roomId = RoomID.of("cccc");
        DateSchedule dateSchedule = new DateSchedule(26, 12, 2021);
        BusinessHours businessHours = new BusinessHours("Lunes a sábado de 6 .a.m. - 9 .p.m.");

        var command = new CreateDoctorUserInterview(doctorUserInterviewID, doctorId, userId, roomId, dateSchedule,
                businessHours);
        var useCase = new CreateDoctorUserInterviewUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        //Assert
        DoctorUserInterviewCreated event = (DoctorUserInterviewCreated) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("aaaa", event.getDoctorID().value());
        Assertions.assertEquals("bbbb", event.getUserID().value());
        Assertions.assertEquals("cccc", event.getRoomID().value());
        Assertions.assertEquals(26, 12, 2021, event.getDateSchedule().value());
        Assertions.assertEquals("Lunes a sábado de 6 .a.m. - 9 .p.m.", event.getBusinessHours().value());
    }

    @Test
    void createDoctorUserInterview_WrongDate(){

        // Arrange
        DoctorUserInterviewID doctorUserInterviewID = DoctorUserInterviewID.of("xxxx");
        DoctorID doctorId = DoctorID.of("aaaa");
        UserID userId = UserID.of("bbbb");
        RoomID roomId = RoomID.of("cccc");
        DateSchedule dateSchedule = new DateSchedule(2, 7, 2021);
        BusinessHours businessHours = new BusinessHours("Lunes a sábado");

        var command = new CreateDoctorUserInterview(doctorUserInterviewID, doctorId, userId, roomId, dateSchedule,
                businessHours);
        var useCase = new CreateDoctorUserInterviewUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));
        DoctorUserInterviewCreated event = (DoctorUserInterviewCreated) events.getDomainEvents().get(0);
        Assertions.assertEquals(2, 7, 2021, event.getDateSchedule().value());
    }
}