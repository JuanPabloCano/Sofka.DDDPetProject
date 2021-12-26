package co.com.sofka.domain.emergencyRoom.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Map;
import java.util.Objects;

public class Consciousness implements ValueObject<Map<String, String>> {

    private final Map<String, String> glasgowScore;

    public Consciousness(Map<String, String> glasgowScore) {
        this.glasgowScore = Objects.requireNonNull(glasgowScore, "La escala de consciencia es requerida");
        if (this.glasgowScore.isEmpty()){
            throw new IllegalArgumentException("La escala de consciencia no puede estar vacía");
        }
    }

    @Override
    public Map<String, String> value() {
        return glasgowScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consciousness that = (Consciousness) o;
        return Objects.equals(glasgowScore, that.glasgowScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(glasgowScore);
    }
}
