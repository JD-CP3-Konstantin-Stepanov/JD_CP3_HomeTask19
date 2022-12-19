package Builder;

import java.util.Objects;
import java.util.OptionalInt;

import static java.util.OptionalInt.empty;

public class Person {
    private final String name;
    private final String surname;
    private OptionalInt age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = empty();
    }

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (age.isPresent()) {
            return age.getAsInt();
        } else return 0;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.age.isPresent()) {
            int age = this.age.getAsInt();
            age++;
            this.age = OptionalInt.of(age);
        } else {
            this.age = OptionalInt.of(1);
        }
    }

    @Override
    public String toString() {
        String strAge;
        if (age.isPresent()) {
            strAge = String.valueOf(age.getAsInt());
        } else {
            strAge = "0";
        }

        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + strAge +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(1)
                .setAddress(this.address);
    }

}