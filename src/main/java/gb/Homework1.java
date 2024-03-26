package gb;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Homework1 {

    public static void main(String[] args) {

        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            departments.add(new Department("Department #" + i));
        }

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    "Person #" + i,
                    ThreadLocalRandom.current().nextInt(25, 65),
                    ThreadLocalRandom.current().nextInt(35_000, 100_000) * 1.0,
                    departments.get(ThreadLocalRandom.current().nextInt(departments.size()))
            ));
        }
        //printNamesOrdered(persons);
        //printDepartmentOldestPerson(persons);
        //findFirstPersons(persons);
        System.out.println(findTopDepartment(persons));



    }

    /**
     * Вывести на консоль отсортированные (по алфавиту) имена персонов
     */
    public static void printNamesOrdered(List<Person> persons) {
        persons.stream()
                .map(Person::getName)
                .sorted()
                .toList()
                .forEach(System.out::println);
    }

    /**
     * В каждом департаменте найти самого взрослого сотрудника.
     * Вывести на консоль мапипнг department -> personName
     * Map<Department, Person>
     */
    public static void printDepartmentOldestPerson(List<Person> persons) {
        Comparator<Person> ageComparator = Comparator.comparing(Person::getAge);
        Map<String, Person> maxAge = persons.stream()
                .collect(Collectors.toMap(it -> it.getDepartment().getName(), Function.identity(), (first, second) -> {
                    if (ageComparator.compare(first, second) > 0) {
                        return first;
                    }

                    return second;
                }));
        maxAge.forEach((key, value) -> System.out.println(value.getDepartment() + ", personName: " + value.getName()));
    }

    /**
     * Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
     */
    public static void findFirstPersons(List<Person> persons) {
        persons.stream()
                .filter(it -> it.getAge() < 30)
                .filter(it -> it.getSalary() > 50_000)
                .limit(10)
                .forEach(System.out::println);
    };

    /**
     * Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
     */
    public static Optional<Department> findTopDepartment(List<Person> persons) {
        Map<Department, Double> departmentTotalSalaryMap = persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.summingDouble(Person::getSalary)));

        return departmentTotalSalaryMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }





    public static class Person {
        private String name;
        private int age;
        private double salary;
        private Department department;

        public Person(String name, int age, double salary, Department department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        public Department getDepartment() {
            return department;
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

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }




}


















