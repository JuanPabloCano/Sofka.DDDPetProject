package co.com.sofka.domain.mortuary;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.mortuary.events.*;
import co.com.sofka.domain.mortuary.values.Techniques;
import co.com.sofka.generics.BusinessHoursAdded;

public class MortuaryChange extends EventChange {

    public MortuaryChange(Mortuary mortuary) {

        apply((MortuaryCreated event) -> {
            mortuary.corpse.corpseID = event.getCorpseID();
            mortuary.coroner.coronerID = event.getCoronerID();
            mortuary.embalmer.embalmerID = event.getEmbalmerID();
            mortuary.businessHours = event.getBusinessHours();
        });

        apply((CorpseAdded event) -> {
            mortuary.corpse.corpseID = event.getCorpseID();
            mortuary.corpse.personalData = event.getPersonalData();
            mortuary.corpse.deathCause = event.getDeathCause();
        });

        apply((CorpseUpdated event) -> {
            var corpse = mortuary.getCorpseById(event.getCorpseID())
                    .orElseThrow(() -> new IllegalArgumentException("ID del cadáver no encontrado"));
            corpse.updatePersonalData(event.getPersonalData());
        });

        apply((CoronerAdded event) -> {
            mortuary.coroner.coronerID = event.getCoronerID();
            mortuary.coroner.personalData = event.getPersonalData();
            mortuary.coroner.description = event.getDescription();
        });

        apply((CoronerUpdated event) -> {
            var coroner = mortuary.getCoronerByID(event.getCoronerID())
                    .orElseThrow(() -> new IllegalArgumentException("ID del forense no encontrado"));
            coroner.updatePersonalData(event.getPersonalData());
        });

        apply((EmbalmerAdded event) -> {
            mortuary.embalmer.embalmerID = event.getEmbalmerID();
            mortuary.embalmer.personalData = event.getPersonalData();
            mortuary.embalmer.techniques.add(event.getTechniques());
        });

        apply((EmbalmerUpdated event) -> {
            var embalmer = mortuary.getEmbalmerByID(event.getEmbalmerID())
                    .orElseThrow(() -> new IllegalArgumentException("Id del embalsamador no encontrado"));
            embalmer.updatePersonalData(event.getPersonalData());
        });

        apply((BusinessHoursAdded event) -> mortuary.businessHours = event.getBusinessHours());
    }
}
