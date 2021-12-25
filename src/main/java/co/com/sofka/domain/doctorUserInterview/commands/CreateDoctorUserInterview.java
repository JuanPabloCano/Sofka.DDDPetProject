package co.com.sofka.domain.doctorUserInterview.commands;

import co.com.sofka.domain.doctorUserInterview.Doctor;
import co.com.sofka.domain.doctorUserInterview.Room;
import co.com.sofka.domain.doctorUserInterview.User;
import co.com.sofka.domain.doctorUserInterview.values.DateSchedule;
import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class CreateDoctorUserInterview extends Command {

    private final DoctorUserInterviewID doctorUserInterviewID;
    private final Doctor doctor;
    private final User user;
    private final Room room;
    private final DateSchedule dateSchedule;
    private final BusinessHours businessHours;

    public CreateDoctorUserInterview(DoctorUserInterviewID doctorUserInterviewID, Doctor doctor, User user, Room room, DateSchedule dateSchedule, BusinessHours businessHours) {
        this.doctorUserInterviewID = Objects.requireNonNull(doctorUserInterviewID);
        this.doctor = Objects.requireNonNull(doctor);
        this.user = Objects.requireNonNull(user);
        this.room = Objects.requireNonNull(room);
        this.dateSchedule = Objects.requireNonNull(dateSchedule);
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public DoctorUserInterviewID getDoctorUserInterviewID() {
        return doctorUserInterviewID;
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
