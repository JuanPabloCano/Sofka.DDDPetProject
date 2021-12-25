package co.com.sofka.domain.mortuary.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class UpdateCorpse extends Command {

    private final CorpseID corpseID;
    private final PersonalData personalData;

    public UpdateCorpse(CorpseID corpseID, PersonalData personalData) {
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
