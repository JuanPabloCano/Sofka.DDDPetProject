package co.com.sofka.domain.mortuary.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.domain.mortuary.values.DeathCause;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class AddCorpse extends Command {

    private final CorpseID corpseID;
    private final PersonalData personalData;
    private final DeathCause deathCause;

    public AddCorpse(CorpseID corpseID, PersonalData personalData, DeathCause deathCause) {
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
