package co.com.sofka.domain.mortuary.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.mortuary.values.EmbalmerID;
import co.com.sofka.domain.mortuary.values.Techniques;
import co.com.sofka.generics.PersonalData;

import java.util.Objects;

public class UpdateEmbalmer extends Command {

    private final EmbalmerID embalmerID;
    private final PersonalData personalData;
    private final Techniques techniques;

    public UpdateEmbalmer(EmbalmerID embalmerID, PersonalData personalData, Techniques techniques) {
        this.embalmerID = Objects.requireNonNull(embalmerID);
        this.personalData = Objects.requireNonNull(personalData);
        this.techniques = Objects.requireNonNull(techniques);
    }

    public EmbalmerID getEmbalmerID() {
        return embalmerID;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Techniques getTechniques() {
        return techniques;
    }
}
