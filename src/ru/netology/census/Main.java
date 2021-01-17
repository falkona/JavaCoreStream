package ru.netology.census;

import ru.netology.census.personInfo.Education;
import ru.netology.census.personInfo.Person;
import ru.netology.census.personInfo.Sex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Collection<Person> persons = getData();
        long underage = persons.stream()
                               .filter(person -> person.getAge() < 18)
                               .count();
        List<String> recruits = persons.stream()
                                       .filter(person -> person.getSex() == Sex.MALE)
                                       .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                                       .map(Person::getFamily)
                                       .collect(Collectors.toList());
        List<Person> employees = persons.stream()
                                        .filter(person -> person.getEducation() == Education.HIGHER)
                                        .filter(person -> person.getAge() >= 18 && person.getAge() <= 65)
                                        .filter(person -> !(person.getSex() == Sex.FEMALE && person.getAge() > 60))
                                        .sorted(Comparator.comparing(Person::getFamily))
                                        .collect(Collectors.toList());
    }

    public static Collection<Person> getData() {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        return persons;
    }

}