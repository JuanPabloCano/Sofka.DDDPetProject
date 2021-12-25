package co.com.sofka.domain.mortuary.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.Set;

public class Techniques implements ValueObject<Set<String>> {

    private final Set<String> techniques;

    public Techniques(Set<String> techniques) {
        this.techniques = Objects.requireNonNull(techniques, "La lista es requerida");

        if (this.techniques.isEmpty()){
            throw new IllegalArgumentException("Las técnicas no pueden estar vacías");
        }
    }

    @Override
    public Set<String> value() {
        return techniques;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Techniques that = (Techniques) o;
        return Objects.equals(techniques, that.techniques);
    }

    @Override
    public int hashCode() {
        return Objects.hash(techniques);
    }
}
