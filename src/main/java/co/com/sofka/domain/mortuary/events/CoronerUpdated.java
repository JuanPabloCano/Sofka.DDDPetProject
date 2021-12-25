package co.com.sofka.domain.mortuary.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class CoronerUpdated extends DomainEvent {

    private final CoronerID coronerID;
    private final PersonalData personalData;

    public CoronerUpdated(CoronerID coronerID, PersonalData personalData) {
        super("sofka.mortuary.coronerupdated");
        this.coronerID = Objects.requireNonNull(coronerID);
        this.personalData = Objects.requireNonNull(personalData);
    }

    public CoronerID getCoronerID() {
        return coronerID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
}
