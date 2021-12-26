package co.com.sofka.domain.emergencyRoom.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Specialization implements ValueObject<String> {

    private final String name;
    private final String field;
    private final String duration;

    public Specialization(String name, String field, String duration) {
        this.name = Objects.requireNonNull(name, "El nombre es requerido");
        this.field = Objects.requireNonNull(field, "El campo es requerido");
        this.duration = Objects.requireNonNull(duration, "La duración es requerida");

        if (this.name.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (this.field.isBlank()){
            throw new IllegalArgumentException("El campo no puede estar vacío");
        }

        if (greaterThan100()){
            throw new IllegalArgumentException("No puede ser mayor a 100 caracteres");
        }

        if (this.duration.length() == 0){
            throw new IllegalArgumentException("La duración no puede ser igual a cero");
        }
    }

    private boolean greaterThan100() {
        return this.name.length() >= 100 || this.field.length() >= 100;
    }

    @Override
    public String value() {
        return name + " " + field + " " + duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialization that = (Specialization) o;
        return Objects.equals(name, that.name) && Objects.equals(field, that.field) && Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, field, duration);
    }
}
