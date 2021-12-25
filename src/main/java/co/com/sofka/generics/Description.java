package co.com.sofka.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Description implements ValueObject<String> {

    private final String description;

    public Description(String description) {
        this.description = Objects.requireNonNull(description, "La descripción es requerida");

        if (this.description.isBlank()){
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }

        if (this.description.length() <= 0 || this.description.length() > 300){
            throw new IllegalArgumentException("El tamaño de la descripción no puede ser igual a cero ni mayor a 300");
        }
    }

    @Override
    public String value() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
