package co.com.sofka.domain.mortuary.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.mortuary.Coroner;
import co.com.sofka.domain.mortuary.Corpse;
import co.com.sofka.domain.mortuary.Embalmer;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class MortuaryCreated extends DomainEvent {

    private final MortuaryID mortuaryID;
    private final Corpse corpse;
    private final Coroner coroner;
    private final Embalmer embalmer;
    private final BusinessHours businessHours;

    public MortuaryCreated(MortuaryID mortuaryID, Corpse corpse, Coroner coroner, Embalmer embalmer, BusinessHours businessHours) {
        super("sofka.mortuary.mortuarycreated");
        this.mortuaryID = Objects.requireNonNull(mortuaryID);
        this.corpse = Objects.requireNonNull(corpse);
        this.coroner = Objects.requireNonNull(coroner);
        this.embalmer = Objects.requireNonNull(embalmer);
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public MortuaryID getMortuaryID() {
        return mortuaryID;
    }

    public Corpse getCorpse() {
        return corpse;
    }

    public Coroner getCoroner() {
        return coroner;
    }

    public Embalmer getEmbalmer() {
        return embalmer;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
