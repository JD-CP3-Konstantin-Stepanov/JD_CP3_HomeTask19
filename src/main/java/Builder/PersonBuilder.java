package Builder;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (age != null && age.getAsInt() <= 0) {
            throw new IllegalArgumentException("Задано некорректно значение возраста!");
        } else if (name == null || surname == null) {
            throw new IllegalStateException("Не задано имя или фамилия!");
        } else if (age == null && address == null) {
            return new Person(name, surname);
        } else {
            return new Person(name, surname, age, address);
        }
    }

}
