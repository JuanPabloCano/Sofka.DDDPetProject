package co.com.sofka.domain.doctorUserInterview.commands;

import co.com.sofka.domain.doctorUserInterview.values.*;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class CreateDoctorUserInterview extends Command {

    private final DoctorUserInterviewID doctorUserInterviewID;
    private final DoctorID doctorID;
    private final UserID userID;
    private final RoomID roomID;
    private final DateSchedule dateSchedule;
    private final BusinessHours businessHours;

    public CreateDoctorUserInterview(DoctorUserInterviewID doctorUserInterviewID, DoctorID doctorID, UserID userID, RoomID roomID, DateSchedule dateSchedule, BusinessHours businessHours) {
        this.doctorUserInterviewID = Objects.requireNonNull(doctorUserInterviewID);
        this.doctorID = Objects.requireNonNull(doctorID);
        this.userID = Objects.requireNonNull(userID);
        this.roomID = Objects.requireNonNull(roomID);
        this.dateSchedule = Objects.requireNonNull(dateSchedule);
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public DoctorUserInterviewID getDoctorUserInterviewID() {
        return doctorUserInterviewID;
    }

    public DoctorID getDoctor() {
        return doctorID;
    }

    public UserID getUser() {
        return userID;
    }

    public RoomID getRoom() {
        return roomID;
    }

    public DateSchedule getDateSchedule() {
        return dateSchedule;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
