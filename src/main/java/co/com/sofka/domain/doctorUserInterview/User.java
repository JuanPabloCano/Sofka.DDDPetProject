package co.com.sofka.domain.doctorUserInterview;

import co.com.sofka.domain.doctorUserInterview.values.Symptoms;
import co.com.sofka.domain.doctorUserInterview.values.UserID;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generics.PersonalData;
import java.util.Objects;

public class User extends Entity<UserID> {

    protected UserID userID;
    protected PersonalData personalData;
    protected Symptoms symptoms;


    public User(UserID entityId, PersonalData personalData, Symptoms symptoms) {
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

    public PersonalData personalData() {
        return personalData;
    }

    public Symptoms symptoms() {
        return symptoms;
    }

    public UserID userID() {
        return userID;
    }
}
