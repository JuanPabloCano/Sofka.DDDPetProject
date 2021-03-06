package co.com.sofka.domain.mortuary.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.mortuary.Coroner;
import co.com.sofka.domain.mortuary.Corpse;
import co.com.sofka.domain.mortuary.Embalmer;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.domain.mortuary.values.EmbalmerID;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class MortuaryCreated extends DomainEvent {

    private final MortuaryID mortuaryID;
    private final CorpseID corpseID;
    private final CoronerID coronerID;
    private final EmbalmerID embalmerID;
    private final BusinessHours businessHours;

    public MortuaryCreated(MortuaryID mortuaryID, CorpseID corpseID,CoronerID coronerID, EmbalmerID embalmerID, BusinessHours businessHours) {
        super("sofka.mortuary.mortuarycreated");
        this.mortuaryID = Objects.requireNonNull(mortuaryID);
        this.corpseID = Objects.requireNonNull(corpseID);
        this.coronerID = Objects.requireNonNull(coronerID);
        this.embalmerID = Objects.requireNonNull(embalmerID);
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public MortuaryID getMortuaryID() {
        return mortuaryID;
    }

    public CorpseID getCorpseID() {
        return corpseID;
    }

    public CoronerID getCoronerID() {
        return coronerID;
    }

    public EmbalmerID getEmbalmerID() {
        return embalmerID;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
