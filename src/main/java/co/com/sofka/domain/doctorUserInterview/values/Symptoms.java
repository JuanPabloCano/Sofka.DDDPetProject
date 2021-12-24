package co.com.sofka.domain.doctorUserInterview.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.Set;

public class Symptoms implements ValueObject<Set<String>> {

    private final Set<String> symptoms;

    public Symptoms(Set<String> symptoms) {
        this.symptoms = Objects.requireNonNull(symptoms, "Los síntomas son requeridos");
        if (this.symptoms.isEmpty()){
            throw new IllegalArgumentException("El set de síntomas no puede estar vacío");
        }
    }

    public void addSymptoms(String symptom){
        symptoms.add(symptom);
    }

    @Override
    public Set<String> value() {
        return symptoms;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptoms symptoms1 = (Symptoms) o;
        return Objects.equals(symptoms, symptoms1.symptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symptoms);
    }
}
