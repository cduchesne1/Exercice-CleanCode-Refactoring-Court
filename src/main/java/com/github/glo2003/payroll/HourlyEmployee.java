package com.github.glo2003.payroll;

public class HourlyEmployee extends Employee {
    private float rate;
    private float amount;

    // TODO constructor

    public HourlyEmployee(String name, Role role, int vacation_days, float rate, float amount) {
        super(name, role, vacation_days);
        this.rate = rate;
        this.amount = amount;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "name='" + this.getName() + '\'' +
                ", role='" + this.getRole() + '\'' +
                ", vacation_days=" + this.getVacation_days() +
                ", hourlyRate=" + rate +
                ", amount=" + amount +
                '}';
    }
}
