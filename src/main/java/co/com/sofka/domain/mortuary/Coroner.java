package co.com.sofka.domain.mortuary;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class Coroner extends Entity<CoronerID> {

    protected CoronerID coronerID;
    protected PersonalData personalData;
    protected Description description;

    public Coroner(CoronerID coronerID, PersonalData personalData, Description description) {
        super(coronerID);
        this.personalData = Objects.requireNonNull(personalData);
        this.description = Objects.requireNonNull(description);
    }

    public void addPersonalData(PersonalData personalData){
        this.personalData = personalData;
    }

    public void updatePersonalData(PersonalData personalData){
        this.personalData = personalData;
    }

    public void addDescription(Description description){
        this.description = description;
    }

    public PersonalData personalData() {
        return personalData;
    }

    public Description description() {
        return description;
    }

    public CoronerID coronerID() {
        return coronerID;
    }
}
