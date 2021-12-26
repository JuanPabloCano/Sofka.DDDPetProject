package co.com.sofka.domain.emergencyRoom;

import co.com.sofka.domain.emergencyRoom.values.PatientID;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generics.PersonalData;

import java.util.Map;
import java.util.Objects;

public class Patient extends Entity<PatientID> {

    protected PatientID patientID;
    protected PersonalData personalData;
    protected Map<String, String> consciousness;
    protected Map<String, String> wounds;

    public Patient(PatientID patientID, PersonalData personalData, Map<String, String> consciousness,
                   Map<String, String> wounds) {
        super(patientID);
        this.patientID = Objects.requireNonNull(patientID);
        this.personalData = Objects.requireNonNull(personalData);
        this.consciousness = Objects.requireNonNull(consciousness);
        this.wounds = Objects.requireNonNull(wounds);
    }

    public void addPersonalData(PersonalData personalData){
        this.personalData = personalData;
    }

    public void updatePersonalData(PersonalData personalData){
        this.personalData = personalData;
    }

    public void addConsciousness(String consciousness, String score){
        if (!this.consciousness.isEmpty()){
            throw new IllegalArgumentException("Ya existe un estado de consciencia");
        }
        this.consciousness.put(consciousness, score);
    }

    public void updateConsciousness(String consciousness, String score){
        this.consciousness.put(consciousness, score);
    }

    public void addWounds(String wounds, String bodyPart){
        this.wounds.put(wounds, bodyPart);
    }

    public PatientID patientID() {
        return patientID;
    }

    public PersonalData personalData() {
        return personalData;
    }

    public Map<String, String> consciousness() {
        return consciousness;
    }

    public Map<String, String> wounds() {
        return wounds;
    }
}
