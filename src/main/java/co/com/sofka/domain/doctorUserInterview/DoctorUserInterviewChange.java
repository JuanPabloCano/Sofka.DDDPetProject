package co.com.sofka.domain.doctorUserInterview;

import co.com.sofka.domain.doctorUserInterview.events.*;
import co.com.sofka.domain.generic.EventChange;

public class DoctorUserInterviewChange extends EventChange {

    public DoctorUserInterviewChange(DoctorUserInterview doctorUserInterview) {

        apply((DoctorUserInterviewCreated event) -> {
            doctorUserInterview.doctor = event.getDoctor();
            doctorUserInterview.user = event.getUser();
            doctorUserInterview.room = event.getRoom();
            doctorUserInterview.dateSchedule = event.getDateSchedule();
            doctorUserInterview.businessHours = event.getBusinessHours();
        });

        apply((DoctorAdded event) -> {
            doctorUserInterview.doctor = event.getDoctorID();
            doctorUserInterview.doctor = event.getPersonalData();
            doctorUserInterview.doctor = event.getDescription();
        });

        apply((DoctorUpdated event) -> {
            var doctor = doctorUserInterview.getDoctorByID(event.getDoctorID())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró el ID del doctor"));
            doctor.updatePersonalData(event.getPersonalData());
        });

        apply((UserAdded event) -> {
            doctorUserInterview.user = event.getUserId();
            doctorUserInterview.user = event.getPersonalData();
            doctorUserInterview.user = event.getSymptoms();
        });

        apply((UserUpdated event) -> {
            var user = doctorUserInterview.getUserById(event.getUserID())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró el ID del usuario"));
            user.updatePersonalData(event.getPersonalData());
        });

        apply((RoomAdded event) -> {
            doctorUserInterview.room = event.getRoom();
        });

        apply((DateAdded event) -> {
            doctorUserInterview.dateSchedule = event.getDateSchedule();
        });

        apply((BusinessHoursAdded event) -> {
            doctorUserInterview.businessHours = event.getBusinessHours();
        });
    }
}
