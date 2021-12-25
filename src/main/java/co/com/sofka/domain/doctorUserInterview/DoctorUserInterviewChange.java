package co.com.sofka.domain.doctorUserInterview;

import co.com.sofka.domain.doctorUserInterview.events.*;
import co.com.sofka.domain.doctorUserInterview.values.Symptoms;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.generics.BusinessHoursAdded;
import co.com.sofka.domain.doctorUserInterview.events.RoomAdded;

public class DoctorUserInterviewChange extends EventChange {

    public DoctorUserInterviewChange(DoctorUserInterview doctorUserInterview) {

        apply((DoctorUserInterviewCreated event) -> {
            doctorUserInterview.doctor.doctorID = event.getDoctorID();
            doctorUserInterview.user.userID = event.getUserID();
            doctorUserInterview.room.roomID = event.getRoomID();
            doctorUserInterview.dateSchedule = event.getDateSchedule();
            doctorUserInterview.businessHours = event.getBusinessHours();
        });

        apply((DoctorAdded event) -> {
            doctorUserInterview.doctor.doctorID = event.getDoctorID();
            doctorUserInterview.doctor.personalData = event.getPersonalData();
            doctorUserInterview.doctor.description = event.getDescription();
        });

        apply((DoctorUpdated event) -> {
            var doctor = doctorUserInterview.getDoctorByID(event.getDoctorID())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró el ID del doctor"));
            doctor.updatePersonalData(event.getPersonalData());
        });

        apply((UserAdded event) -> {
            doctorUserInterview.user.userID = event.getUserId();
            doctorUserInterview.user.personalData = event.getPersonalData();
            doctorUserInterview.user.symptoms.add(event.getSymptoms());
        });

        apply((UserUpdated event) -> {
            var user = doctorUserInterview.getUserById(event.getUserID())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró el ID del usuario"));
            user.updatePersonalData(event.getPersonalData());
        });

        apply((RoomAdded event) -> {
            doctorUserInterview.room.roomID = event.getRoomID();
            doctorUserInterview.room.area = event.getArea();
        });

        apply((DateAdded event) -> doctorUserInterview.dateSchedule = event.getDateSchedule());

        apply((BusinessHoursAdded event) -> doctorUserInterview.businessHours = event.getBusinessHours());
    }
}
