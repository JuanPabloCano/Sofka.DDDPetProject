package co.com.sofka.domain.mortuary;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.domain.mortuary.values.DeathCause;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class Corpse extends Entity<CorpseID> {

    protected CorpseID corpseID;
    protected PersonalData personalData;
    protected DeathCause deathCause;

    public Corpse(CorpseID corpseID, PersonalData personalData, DeathCause deathCause) {
        super(corpseID);
        this.corpseID = Objects.requireNonNull(corpseID);
        this.personalData = Objects.requireNonNull(personalData);
        this.deathCause = Objects.requireNonNull(deathCause);
    }

    public void addPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public void updatePersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public void addDeathCause(DeathCause deathCause) {
        this.deathCause = deathCause;
    }

    public CorpseID corpseID() {
        return corpseID;
    }

    public PersonalData personalData() {
        return personalData;
    }

    public DeathCause deathCause() {
        return deathCause;
    }
}
