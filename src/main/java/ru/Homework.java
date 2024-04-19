package ru;

import java.util.*;
import java.util.stream.Collectors;

public class Homework {

    /**
     * Используя классы Person и Department, реализовать методы ниже:
     */

    public static class Person {
        private String name;
        private int age;
        private double salary;
        private Department department;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", department=" + department +
                    '}';
        }
    }

    public static class Department {
        private String name;

        public Department(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Department that = (Department) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    /**
     * Найти количество сотрудников, старше x лет с зарплатой больше, чем d
     */
    static int countPersons(List<Person> persons, int x, double d) {
        // TODO: Реализовать метод

        return (int)persons.stream()
                .filter(person -> person.getAge()>x)
                .filter(person -> person.getSalary()>d)
                .count();
    }

    /**
     * Найти среднюю зарплату сотрудников, которые работают в департаменте X
     */
    static OptionalDouble averageSalary(List<Person> persons, String x) {
        // TODO: Реализовать метод
        return persons.stream()
                .filter(p-> p.getDepartment().getName().contains(x))
                .mapToDouble(Person::getSalary)
                .average();
    }

    /**
     * Сгруппировать сотрудников по департаментам
     */
    static Map<Department, List<Person>> groupByDepartment(List<Person> persons) {
// TODO: Реализовать метод
        return persons.stream()
                .collect(Collectors.groupingBy(person -> person.getDepartment()));


    }

    /**
     * Найти максимальные зарплаты по отделам
     */
    static Map<Department, Double> maxSalaryByDepartment(List<Person> persons) {
        // TODO: Реализовать метод
        return persons.stream()
                .collect(Collectors.toMap(Person::getDepartment,Person::getSalary, Math::max));
    }

    /**
     * ** Сгруппировать имена сотрудников по департаментам
     */
    static Map<Department, List<String>> groupPersonNamesByDepartment(List<Person> persons) {
        // TODO: Реализовать метод
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartment,
                        Collectors.mapping(Person::getName,Collectors.toList())));
    }

    /**
     * ** Найти сотрудников с минимальными зарплатами в своем отделе
     */
    static List<Person> minSalaryPersons(List<Person> persons) {
        // TODO: Реализовать метод
        return persons.stream()
                .collect(Collectors.toMap(Person::getDepartment, person -> person,(p1,p2)->p1.getSalary()<p2.getSalary()? p1:p2)).values().stream().toList();
    }

}