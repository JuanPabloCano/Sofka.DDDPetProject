package co.com.sofka.domain.doctorUserInterview;

import co.com.sofka.domain.doctorUserInterview.values.DoctorID;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class Doctor extends Entity<DoctorID> {

    protected DoctorID doctorID;
    protected PersonalData personalData;
    protected Description description;

    public Doctor(DoctorID doctorID, PersonalData personalData, Description description) {
        super(doctorID);
        this.personalData = Objects.requireNonNull(personalData);
        this.description = Objects.requireNonNull(description);
    }

    public void addPersonalData(PersonalData personalData){
        this.personalData = Objects.requireNonNull(personalData);
    }

    public void updatePersonalData(PersonalData personalData){
        this.personalData = Objects.requireNonNull(personalData);
    }

    public void addDescription(Description description){
        this.description = Objects.requireNonNull(description);
    }

    public PersonalData personalData() {
        return personalData;
    }

    public Description description() {
        return description;
    }

    public DoctorID doctorID() {
        return doctorID;
    }
}
