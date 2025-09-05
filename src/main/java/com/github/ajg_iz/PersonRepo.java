package com.github.ajg_iz;

import java.util.Map;
import java.util.Objects;

public class PersonRepo {
    Map<Integer, Person> personMap;

    public PersonRepo(Map<Integer, Person> personMap) {
        this.personMap = personMap;
    }

    public Person getPerson(int id) {
        return personMap.get(id);
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
