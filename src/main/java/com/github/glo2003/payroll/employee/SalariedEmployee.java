package com.github.glo2003.payroll.employee;

public class SalariedEmployee extends Employee {
    private float biweekly;

    public SalariedEmployee(String name, Role role, float biweekly) {
        super(name, role);
        this.biweekly = biweekly;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
            "name='" + this.getName() + '\'' +
            ", role='" + this.getRole() + '\'' +
            ", monthly=" + biweekly +
            '}';
    }

    @Override
    public void giveRaise(float raise) {
        biweekly += raise;
    }

    @Override
    public float getPayForTwoWeeks() {
        return biweekly;
    }
}
