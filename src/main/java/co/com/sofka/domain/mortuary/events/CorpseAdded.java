package co.com.sofka.domain.mortuary.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.domain.mortuary.values.DeathCause;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class CorpseAdded extends DomainEvent {

    private final CorpseID corpseID;
    private final PersonalData personalData;
    private final DeathCause deathCause;

    public CorpseAdded(CorpseID corpseID, PersonalData personalData, DeathCause deathCause) {
        super("sofka.mortuary.corpsecreated");
        this.corpseID = Objects.requireNonNull(corpseID);
        this.personalData = Objects.requireNonNull(personalData);
        this.deathCause = Objects.requireNonNull(deathCause);
    }

    public CorpseID getCorpseID() {
        return corpseID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public DeathCause getDeathCause() {
        return deathCause;
    }
}
