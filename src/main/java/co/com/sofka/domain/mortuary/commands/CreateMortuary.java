package co.com.sofka.domain.mortuary.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.mortuary.values.CoronerID;
import co.com.sofka.domain.mortuary.values.CorpseID;
import co.com.sofka.domain.mortuary.values.EmbalmerID;
import co.com.sofka.domain.mortuary.values.MortuaryID;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class CreateMortuary extends Command {

    private final MortuaryID mortuaryID;
    private final CorpseID corpseID;
    private final CoronerID coronerID;
    private final EmbalmerID embalmerID;
    private final BusinessHours businessHours;

    public CreateMortuary(MortuaryID mortuaryID, CorpseID corpseID, CoronerID coronerID, EmbalmerID embalmerID, BusinessHours businessHours) {
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
