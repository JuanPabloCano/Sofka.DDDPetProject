package co.com.sofka.domain.doctorUserInterview.events;

import co.com.sofka.domain.doctorUserInterview.Doctor;
import co.com.sofka.domain.doctorUserInterview.Room;
import co.com.sofka.domain.doctorUserInterview.User;
import co.com.sofka.domain.doctorUserInterview.values.DateSchedule;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class DoctorUserInterviewCreated extends DomainEvent {


    private final Doctor doctor;
    private final User user;
    private final Room room;
    private final DateSchedule dateSchedule;
    private final BusinessHours businessHours;

    public DoctorUserInterviewCreated(Doctor doctor, User user, Room room, DateSchedule dateSchedule, BusinessHours businessHours) {
        super("sofka.doctoruserinterview.doctoruserinterviewcreated");
        this.doctor = Objects.requireNonNull(doctor);
        this.user = Objects.requireNonNull(user);
        this.room = Objects.requireNonNull(room);
        this.dateSchedule = Objects.requireNonNull(dateSchedule);
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public DateSchedule getDateSchedule() {
        return dateSchedule;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
