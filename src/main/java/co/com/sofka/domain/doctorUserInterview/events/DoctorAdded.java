package co.com.sofka.domain.doctorUserInterview.events;

import co.com.sofka.domain.doctorUserInterview.values.DoctorID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class DoctorAdded extends DomainEvent {

    private final DoctorID doctorID;
    private final PersonalData personalData;
    private final Description description;

    public DoctorAdded(DoctorID doctorID, PersonalData personalData, Description description) {
        super("sofka.doctoruserinterview.doctoradded");
        this.doctorID = Objects.requireNonNull(doctorID);
        this.personalData = Objects.requireNonNull(personalData);
        this.description = Objects.requireNonNull(description);
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Description getDescription() {
        return description;
    }
}
