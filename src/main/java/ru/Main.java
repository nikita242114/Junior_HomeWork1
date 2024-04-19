package ru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Predicate;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Homework.Department> departments = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            departments.add(new Homework.Department("Department #" + i));
        }

        List<Homework.Person> persons = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            int randomDepartmentIndex = ThreadLocalRandom.current().nextInt(departments.size());
            Homework.Department department = departments.get(randomDepartmentIndex);

            Homework.Person person = new Homework.Person();
            person.setName("Person #" + i);
            person.setAge(ThreadLocalRandom.current().nextInt(20, 65));
            person.setSalary(ThreadLocalRandom.current().nextInt(20_000, 100_000) * 1.0);
            person.setDepartment(department);

            persons.add(person);
        }
        System.out.println(Homework.countPersons(persons,30,35));
        System.out.println(Homework.averageSalary(persons,"3"));
        System.out.println(Homework.groupByDepartment(persons));
        System.out.println(Homework.maxSalaryByDepartment(persons));
        System.out.println(Homework.groupPersonNamesByDepartment(persons));
    }

}