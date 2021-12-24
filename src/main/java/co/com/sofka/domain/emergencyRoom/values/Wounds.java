package co.com.sofka.domain.emergencyRoom.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Map;
import java.util.Objects;

public class Wounds implements ValueObject<Map<String, String>> {

    private final Map<String, String> wounds;

    public Wounds(Map<String, String> wounds) {
        this.wounds = Objects.requireNonNull(wounds, "Las heridas son requeridas");

        if (this.wounds.isEmpty()){
            throw new IllegalArgumentException("Las heridas no pueden estar vacías");
        }
    }

    @Override
    public Map<String, String> value() {
        return wounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wounds wounds1 = (Wounds) o;
        return Objects.equals(wounds, wounds1.wounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wounds);
    }
}
