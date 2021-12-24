package co.com.sofka.domain.doctorUserInterview.events;

import co.com.sofka.domain.doctorUserInterview.values.DoctorID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class DoctorUpdated extends DomainEvent {

    private final DoctorID doctorID;
    private final PersonalData personalData;

    public DoctorUpdated(DoctorID doctorID, PersonalData personalData) {
        super("sofka.doctoruserinterview.doctorupdated");
        this.doctorID = Objects.requireNonNull(doctorID);
        this.personalData = Objects.requireNonNull(personalData);
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
}
