package co.com.sofka.domain.mortuary.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DeathCause implements ValueObject<String> {

    private final String deathCause;

    public DeathCause(String deathCause) {
        this.deathCause = Objects.requireNonNull(deathCause, "La causa de muerte es requerida");

        if (this.deathCause.isBlank()){
            throw new IllegalArgumentException("La causa de muerte no puede estar en blanco");
        }
        if (this.deathCause.length() <= 0 || this.deathCause.length() > 300){
            throw new IllegalArgumentException("La causa de muerte no puede ser igual a cero ni mayor a 300");
        }
    }

    @Override
    public String value() {
        return deathCause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeathCause that = (DeathCause) o;
        return Objects.equals(deathCause, that.deathCause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deathCause);
    }
}
