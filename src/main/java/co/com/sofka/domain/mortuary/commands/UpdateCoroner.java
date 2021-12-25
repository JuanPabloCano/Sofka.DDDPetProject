package co.com.sofka.domain.mortuary.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class UpdateCoroner extends Command {

    private final CoronerID coronerID;
    private final PersonalData personalData;

    public UpdateCoroner(CoronerID coronerID, PersonalData personalData) {
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
