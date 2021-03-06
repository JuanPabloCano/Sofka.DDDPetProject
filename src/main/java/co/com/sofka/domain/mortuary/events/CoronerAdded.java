package co.com.sofka.domain.mortuary.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class CoronerAdded extends DomainEvent {

    private final CoronerID coronerID;
    private final PersonalData personalData;
    private final Description description;

    public CoronerAdded(CoronerID coronerID, PersonalData personalData, Description description) {
        super("sofka.mortuary.coroneradded");
        this.coronerID = Objects.requireNonNull(coronerID);
        this.personalData = Objects.requireNonNull(personalData);
        this.description = Objects.requireNonNull(description);
    }

    public CoronerID getCoronerID() {
        return coronerID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Description getDescription() {
        return description;
    }
}
