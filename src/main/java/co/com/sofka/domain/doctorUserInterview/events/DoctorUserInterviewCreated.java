package co.com.sofka.domain.doctorUserInterview.events;

import co.com.sofka.domain.doctorUserInterview.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class DoctorUserInterviewCreated extends DomainEvent {


    private final DoctorID doctorID;
    private final UserID userID;
    private final RoomID roomID;
    private final DateSchedule dateSchedule;
    private final BusinessHours businessHours;

    public DoctorUserInterviewCreated(DoctorID doctorID, UserID userID, RoomID roomID, DateSchedule dateSchedule,
                                      BusinessHours businessHours) {
        super("sofka.doctoruserinterview.doctoruserinterviewcreated");
        this.doctorID = Objects.requireNonNull(doctorID);
        this.userID = Objects.requireNonNull(userID);
        this.roomID = Objects.requireNonNull(roomID);
        this.dateSchedule = Objects.requireNonNull(dateSchedule);
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public UserID getUserID() {
        return userID;
    }

    public RoomID getRoomID() {
        return roomID;
    }

    public DateSchedule getDateSchedule() {
        return dateSchedule;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
