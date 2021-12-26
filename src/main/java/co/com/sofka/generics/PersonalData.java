package co.com.sofka.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PersonalData implements ValueObject<String> {

    private final String data;

    public PersonalData(String data) {
        this.data = Objects.requireNonNull(data, "Los datos es requeridos");
        nameValidation(data);
    }

    private void nameValidation(String data) {
        if (this.data.isBlank()) {
            throw new IllegalArgumentException("Los datos no pueden estar en blanco");
        }
        if (this.data.length() <= 0 || this.data.length() > 100) {
            throw new IllegalArgumentException("El tamaño no puede ser igual a cero ni mayor a 100");
        }
    }

    @Override
    public String value() {
        return data;
    }
}
