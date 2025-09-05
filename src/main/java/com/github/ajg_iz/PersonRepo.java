package com.github.ajg_iz;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class PersonRepo {
    Map<Integer, Person> personMap;

    public PersonRepo() {
        this.personMap = new HashMap<>();
    }

    public boolean addPerson(Person person) {
        if (!Objects.isNull(person) && !personMap.containsKey(person.id())) {
            return (!Objects.isNull(personMap.put(person.id(), person)));
        }
        return false;
    }

    public Optional<Person> getPerson(int id) {
        return Optional.ofNullable(personMap.get(id));
    }

    public void setPersonMap(Map<Integer, Person> personMap) {
        this.personMap = personMap;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonRepo that)) return false;
        return Objects.equals(personMap, that.personMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personMap);
    }

    @Override
    public String toString() {
        return "PersonRepo{" +
                "personMap=" + personMap +
                '}';
    }
}
