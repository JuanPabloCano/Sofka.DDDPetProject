package co.com.sofka.domain.mortuary.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.mortuary.Mortuary;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class UpdateCoroner extends Command {

    private final MortuaryID mortuaryID;
    private final CoronerID coronerID;
    private final PersonalData personalData;

    public UpdateCoroner(MortuaryID mortuaryID, CoronerID coronerID, PersonalData personalData) {
        this.mortuaryID = Objects.requireNonNull(mortuaryID);
        this.coronerID = Objects.requireNonNull(coronerID);
        this.personalData = Objects.requireNonNull(personalData);
    }

    public MortuaryID getMortuaryID() {
        return mortuaryID;
    }

    public CoronerID getCoronerID() {
        return coronerID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
}
