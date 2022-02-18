package com.github.glo2003.payroll.employee;


public abstract class Employee {
    private String name;
    private Role role;

    public Employee(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "name='" + name + '\'' +
            ", role='" + role + '\'' +
            '}';
    }

    public abstract void giveRaise(float raise);

    public abstract float getPayForTwoWeeks();
}
