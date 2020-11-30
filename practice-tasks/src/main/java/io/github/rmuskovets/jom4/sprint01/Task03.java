package io.github.rmuskovets.jom4.sprint01;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }
}
class Worker extends Person {
    public String workPosition;
    public int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}
class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
        Map<Class<? extends Person>, List<Person>> everyone = new HashMap<>();
        persons.forEach(person -> everyone.compute(person.getClass(), (cls, old) -> old == null
                ? new ArrayList<>()
                : Stream.concat(old.stream(), Stream.of(person)).collect(Collectors.toList())));
        return everyone.keySet().stream() // Stream<Class<? extends Person>>
                .map(everyone::get) // Stream<List<Person>>
                .map(List::stream) // Stream<Stream<Person>>
                .map(s -> s.max(Comparator.comparingInt(p -> // Stream<Person>; Person
                        p instanceof Student ? ((Student) p).getStudyYears()
                        : p instanceof Worker ? ((Worker) p).getExperienceYears()
                        : 0)))
                .map(p -> p.orElse(null)) // Stream<Optional<Person>>
                .collect(Collectors.toList()); // Stream<Person>
    }
}
