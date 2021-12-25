package co.com.sofka.domain.mortuary;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.mortuary.events.*;
import co.com.sofka.domain.mortuary.values.*;
import co.com.sofka.generics.BusinessHours;
import co.com.sofka.generics.BusinessHoursAdded;
import co.com.sofka.generics.Description;
import co.com.sofka.generics.PersonalData;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Mortuary extends AggregateEvent<MortuaryID> {

    protected Corpse corpse;
    protected Coroner coroner;
    protected Embalmer embalmer;
    protected BusinessHours businessHours;
    protected Set<Corpse> corpses;
    protected Set<Coroner> coroners;
    protected Set<Embalmer> embalmers;

    private Mortuary(MortuaryID mortuaryID) {
        super(mortuaryID);
        subscribe(new MortuaryChange(this));
    }

    public Mortuary(MortuaryID mortuaryID, CorpseID corpseID, CoronerID coronerID, EmbalmerID embalmerID,
                    BusinessHours businessHours) {
        super(mortuaryID);
        appendChange(new MortuaryCreated(mortuaryID, corpseID, coronerID, embalmerID, businessHours)).apply();
    }

    public static Mortuary from(MortuaryID mortuaryID, List<DomainEvent> events) {
        var mortuary = new Mortuary(mortuaryID);
        events.forEach(mortuary::applyEvent);
        return mortuary;
    }

    public void addCorpse(CorpseID corpseID, PersonalData personalData, DeathCause deathCause) {
        Objects.requireNonNull(corpseID);
        Objects.requireNonNull(personalData);
        Objects.requireNonNull(deathCause);
        appendChange(new CorpseAdded(corpseID, personalData, deathCause)).apply();
    }

    public void updateCorpse(CorpseID corpseID, PersonalData personalData) {
        Objects.requireNonNull(corpseID);
        Objects.requireNonNull(personalData);
        appendChange(new CorpseUpdated(corpseID, personalData)).apply();
    }

    public void addCoroner(CoronerID coronerID, PersonalData personalData, Description description) {
        Objects.requireNonNull(coronerID);
        Objects.requireNonNull(personalData);
        Objects.requireNonNull(description);
        appendChange(new CoronerAdded(coronerID, personalData, description)).apply();
    }

    public void updateCoroner(CoronerID coronerID, PersonalData personalData) {
        Objects.requireNonNull(coronerID);
        Objects.requireNonNull(personalData);
        appendChange(new CoronerUpdated(coronerID, personalData)).apply();
    }

    public void addEmbalmer(EmbalmerID embalmerID, PersonalData personalData, Techniques techniques) {
        Objects.requireNonNull(embalmerID);
        Objects.requireNonNull(personalData);
        Objects.requireNonNull(techniques);
        appendChange(new EmbalmerAdded(embalmerID, personalData, techniques)).apply();
    }

    public void updateEmbalmer(EmbalmerID embalmerID, PersonalData personalData, Techniques techniques) {
        Objects.requireNonNull(embalmerID);
        Objects.requireNonNull(personalData);
        Objects.requireNonNull(techniques);
        appendChange(new EmbalmerUpdated(embalmerID, personalData, techniques)).apply();
    }

    public void addBusinessHours(BusinessHours businessHours) {
        Objects.requireNonNull(businessHours);
        appendChange(new BusinessHoursAdded(businessHours)).apply();
    }

    protected Optional<Corpse> getCorpseById(CorpseID corpseID) {
        return corpses.stream()
                .filter(corpseId -> corpseId
                        .identity()
                        .equals(corpseID))
                .findFirst();
    }

    protected Optional<Coroner> getCoronerByID(CoronerID coronerID) {
        return coroners.stream()
                .filter(coronerId -> coronerId
                        .identity()
                        .equals(coronerID))
                .findFirst();
    }

    protected Optional<Embalmer> getEmbalmerByID(EmbalmerID embalmerID) {
        return embalmers.stream()
                .filter(embalmerId -> embalmerId
                        .identity()
                        .equals(embalmerID))
                .findFirst();
    }

    public Corpse corpse() {
        return corpse;
    }

    public Coroner coroner() {
        return coroner;
    }

    public Embalmer embalmer() {
        return embalmer;
    }

    public BusinessHours businessHours() {
        return businessHours;
    }

    public Set<Corpse> corpses() {
        return corpses;
    }

    public Set<Coroner> coroners() {
        return coroners;
    }

    public Set<Embalmer> embalmers() {
        return embalmers;
    }
}
