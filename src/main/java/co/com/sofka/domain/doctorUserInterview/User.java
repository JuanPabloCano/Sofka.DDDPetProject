package co.com.sofka.domain.doctorUserInterview;

import co.com.sofka.domain.doctorUserInterview.values.Symptoms;
import co.com.sofka.domain.doctorUserInterview.values.UserID;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;
import java.util.Set;

public class User extends Entity<UserID> {

    protected PersonalData personalData;
    protected Set<Symptoms> symptoms;


    public User(UserID entityId, PersonalData personalData, Set<Symptoms> symptoms) {
        super(entityId);
        this.personalData = Objects.requireNonNull(personalData);
        this.symptoms = Objects.requireNonNull(symptoms);
    }

    public void addPersonalData(PersonalData personalData){
        this.personalData = personalData;
    }

    public void updatePersonalData(PersonalData personalData){
        this.personalData = personalData;
    }

    public void addSymptoms(Set<Symptoms> symptoms){
        this.symptoms = symptoms;
    }

    public PersonalData personalData() {
        return personalData;
    }

    public Set<Symptoms> symptoms() {
        return symptoms;
    }
}
