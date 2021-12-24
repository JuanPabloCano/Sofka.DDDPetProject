package co.com.sofka.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PersonalData implements ValueObject<String> {

    private final String name;
    private final String email;
    private final Integer age;

    public PersonalData(String name, String email, Integer age) {
        this.name = Objects.requireNonNull(name, "El nombre es requerido");
        this.email = Objects.requireNonNull(email, "El email es requerido");
        this.age = Objects.requireNonNull(age, "La edad es requerida");
        nameValidation(name);
        emailValidation(email);
        ageValidation(age);
    }

    private void nameValidation(String name) {
        if (this.name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }
        if (this.name.length() <= 0 || this.name.length() > 100) {
            throw new IllegalArgumentException("El tamaño nombre no puede ser igual a cero ni mayor a 100");
        }
    }

    private void emailValidation(String email) {
        if (this.email.isBlank()) {
            throw new IllegalArgumentException("EL email no puede estar vacío");
        }
        if (this.email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\" +
                ".[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$")) {
            throw new IllegalArgumentException("El email no es válido");
        }
    }

    private void ageValidation(Integer age) {
        if (this.age <= 0) {
            throw new IllegalArgumentException("La edad no puede ser menor o igual a cero");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String value() {
        return name + " " + email + " " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalData that = (PersonalData) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age);
    }
}
