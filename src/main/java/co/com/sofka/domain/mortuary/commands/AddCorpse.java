package co.com.sofka.domain.mortuary.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.domain.mortuary.values.DeathCause;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class AddCorpse extends Command {

    private final MortuaryID mortuaryID;
    private final CorpseID corpseID;
    private final PersonalData personalData;
    private final DeathCause deathCause;

    public AddCorpse(MortuaryID mortuaryID, CorpseID corpseID, PersonalData personalData, DeathCause deathCause) {
        this.mortuaryID = Objects.requireNonNull(mortuaryID);
        this.corpseID = Objects.requireNonNull(corpseID);
        this.personalData = Objects.requireNonNull(personalData);
        this.deathCause = Objects.requireNonNull(deathCause);
    }

    public MortuaryID getMortuaryID() {
        return mortuaryID;
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
