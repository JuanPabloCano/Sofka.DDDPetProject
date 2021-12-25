package co.com.sofka.domain.mortuary.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class CorpseUpdated extends DomainEvent {

    private final CorpseID corpseID;
    private final PersonalData personalData;

    public CorpseUpdated(CorpseID corpseID, PersonalData personalData) {
        super("sofka.mortuary.corpseupdated");
        this.corpseID = Objects.requireNonNull(corpseID);
        this.personalData = Objects.requireNonNull(personalData);
    }

    public CorpseID getCorpseID() {
        return corpseID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
}
