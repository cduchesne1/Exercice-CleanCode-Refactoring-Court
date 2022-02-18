package com.github.glo2003.payroll;


public abstract class Employee {
    private String name;
    private Role role;
    private int vacation_days;

    public Employee(String name, Role role, int vacation_days) {
        this.name = name;
        this.role = role;
        this.vacation_days = vacation_days;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public int getVacation_days() {
        return vacation_days;
    }

    public void setVacation_days(int vacation_days) {
        this.vacation_days = vacation_days;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", vacation_days=" + vacation_days +
                '}';
    }
}
