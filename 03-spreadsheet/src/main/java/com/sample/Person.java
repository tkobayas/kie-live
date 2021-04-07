package com.sample;

public class Person {

    private String name;

    private int salary;
    private int grade;

    public Person() {}

    public Person(String name, int salary, int grade) {
        super();
        this.name = name;
        this.salary = salary;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void promotion() {
        this.grade++;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", salary=" + salary + ", grade=" + grade + "]";
    }

}
