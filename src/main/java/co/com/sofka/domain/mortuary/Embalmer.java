package co.com.sofka.domain.mortuary;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.mortuary.values.EmbalmerID;
import co.com.sofka.domain.mortuary.values.Techniques;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;
import java.util.Set;

public class Embalmer extends Entity<EmbalmerID> {

    protected EmbalmerID embalmerID;
    protected PersonalData personalData;
    protected Set<Techniques> techniques;

    public Embalmer(EmbalmerID embalmerID, PersonalData personalData, Set<Techniques> techniques) {
        super(embalmerID);
        this.personalData = Objects.requireNonNull(personalData);
        this.techniques = Objects.requireNonNull(techniques);
    }

    public void addPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public void updatePersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public void AddTechniques(Techniques techniques) {
        this.techniques.add(techniques);
    }

    public PersonalData personalData() {
        return personalData;
    }

    public Set<Techniques> techniques() {
        return techniques;
    }

    public EmbalmerID embalmerID() {
        return embalmerID;
    }
}
