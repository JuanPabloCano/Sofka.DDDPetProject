package co.com.sofka.domain.mortuary.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.mortuary.values.EmbalmerID;
import co.com.sofka.domain.mortuary.values.Techniques;
import co.com.sofka.generics.PersonalData;

public class EmbalmerAdded extends DomainEvent {

    private final EmbalmerID embalmerID;
    private final PersonalData personalData;
    private final Techniques techniques;

    public EmbalmerAdded(EmbalmerID embalmerID, PersonalData personalData, Techniques techniques) {
        super("sofka.mortuary.embalmeradded");
        this.embalmerID = embalmerID;
        this.personalData = personalData;
        this.techniques = techniques;
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
