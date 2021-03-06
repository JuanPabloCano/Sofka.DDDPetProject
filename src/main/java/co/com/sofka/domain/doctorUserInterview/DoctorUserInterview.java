package co.com.sofka.domain.doctorUserInterview;

import co.com.sofka.domain.doctorUserInterview.events.*;
import co.com.sofka.domain.doctorUserInterview.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class DoctorUserInterview extends AggregateEvent<DoctorUserInterviewID> {

    protected Doctor doctor;
    protected User user;
    protected Room room;
    protected DateSchedule dateSchedule;
    protected BusinessHours businessHours;
    protected Set<Doctor> doctors;
    protected Set<User> users;

    private DoctorUserInterview(DoctorUserInterviewID doctorUserInterviewID){
        super(doctorUserInterviewID);
        subscribe(new DoctorUserInterviewChange(this));
    }
    public DoctorUserInterview(DoctorUserInterviewID doctorUserInterviewID, DoctorID doctorID, UserID userID,
                               RoomID roomID,
                               DateSchedule dateSchedule, BusinessHours businessHours) {
        super(doctorUserInterviewID);
        appendChange(new DoctorUserInterviewCreated(doctorID, userID, roomID, dateSchedule, businessHours)).apply();
    }

    public static DoctorUserInterview from(DoctorUserInterviewID doctorUserInterviewID, List<DomainEvent> events){
        var doctorUserInterview = new DoctorUserInterview(doctorUserInterviewID);
        events.forEach(doctorUserInterview::applyEvent);
        return doctorUserInterview;
    }

    public void addDoctor(DoctorID doctorID, PersonalData personalData, Description description){
        Objects.requireNonNull(doctorID);
        Objects.requireNonNull(personalData);
        Objects.requireNonNull(description);
        appendChange(new DoctorAdded(doctorID, personalData, description)).apply();
    }

    public void updateDoctor(DoctorID doctorID, PersonalData personalData){
        Objects.requireNonNull(doctorID);
        Objects.requireNonNull(personalData);
        appendChange(new DoctorUpdated(doctorID, personalData)).apply();

    }

    public void addUser(UserID userID, PersonalData personalData, Symptoms symptoms){
        Objects.requireNonNull(userID);
        Objects.requireNonNull(personalData);
        Objects.requireNonNull(symptoms);
        appendChange(new UserAdded(userID, personalData, symptoms)).apply();
    }

    public void updateUser(UserID userID, PersonalData personalData){
        Objects.requireNonNull(userID);
        Objects.requireNonNull(personalData);
        appendChange(new UserUpdated(userID, personalData)).apply();
    }

    public void addRoom(RoomID roomID, Area area){
        Objects.requireNonNull(roomID);
        Objects.requireNonNull(area);
        appendChange(new RoomAdded(roomID, area)).apply();
    }

    public void addDate(DateSchedule dateSchedule){
        Objects.requireNonNull(dateSchedule);
        appendChange(new DateAdded(dateSchedule)).apply();
    }

    public void addBusinessHours(BusinessHours businessHours){
        Objects.requireNonNull(businessHours);
        appendChange(new BusinessHoursAdded(businessHours)).apply();
    }

    protected Optional<Doctor> getDoctorByID(DoctorID doctorID){
        return doctors.stream()
                .filter(doctorId -> doctorId
                        .identity()
                        .equals(doctorID))
                .findFirst();
    }

    protected Optional<User> getUserById(UserID userID){
        return users.stream()
                .filter(userId -> userId
                        .identity()
                        .equals(userID))
                .findFirst();
    }

    public Doctor doctor() {
        return doctor;
    }

    public User user() {
        return user;
    }

    public Room room() {
        return room;
    }

    public DateSchedule dateSchedule() {
        return dateSchedule;
    }

    public BusinessHours businessHours() {
        return businessHours;
    }

    public Set<Doctor> doctors() {
        return doctors;
    }

    public Set<User> users() {
        return users;
    }
}
