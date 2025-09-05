package com.github.ajg_iz;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Exercise ENUM
        System.out.println(isWeekday(DayOfWeek.MONDAY));
        System.out.println(isWeekday(DayOfWeek.SUNDAY));

        PersonRepo personRepo = new PersonRepo();
        personRepo.addPerson(new Person(1, "John", DayOfWeek.MONDAY));
        personRepo.addPerson(new Person(2, "Jane", DayOfWeek.SUNDAY));
        personRepo.addPerson(new Person(3, "Jim", DayOfWeek.TUESDAY));
        personRepo.addPerson(new Person(4, "Jena", DayOfWeek.WEDNESDAY));
        System.out.println(personRepo);

        //Exercise Optional
        Optional<Person> personOpt = personRepo.getPerson(1);
        Person person1 = personOpt.orElse(null);
        personOpt = personRepo.getPerson(10);
        Person person2 = personOpt.orElse(null);

        printPerson(person1);
        printPerson(person2);

        //Exercise Streams
        List<Integer> listInt = Stream.of(1,2,3,4,5,6,7,8,9,10).toList();
        listInt.stream()
                .filter(each -> each % 2 == 0)
                .forEach(System.out::println);
        Map<Integer,Integer> mapInt = Stream.of(new Object[][] {
                {1,1},
                {2,2},
                {3,3},
                {4,4},
                {5,5}}).collect(Collectors.toMap(data->(Integer)data[0],data->(Integer)data[1]));
        mapInt.values().stream().map(each -> each * 2).forEach(System.out::println);
        System.out.println(mapInt);

        listInt = listInt.stream().map(each -> each * 2).toList();
        System.out.println(listInt);

        int result = listInt.stream().reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(result);
    }

    public static void printPerson(Person person) {
        if (person != null) {
            System.out.println(person.name()+" - "+person.favouriteDay());
        } else {
            System.out.println("Person not found.");
        }
    }

    public static String isWeekday(DayOfWeek dayOfWeek) {
        if (dayOfWeek.isWeekend()) {
            return "Weekend";
        } else  {
            return dayOfWeek.name();
        }
    }
}