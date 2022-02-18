package com.github.glo2003.payroll.employee;

public class HourlyEmployee extends Employee {
    private final float workedHoursForTwoWeeks;
    private float hourlyRate;

    public HourlyEmployee(String name, Role role, float rate, float workedHoursForTwoWeeks) {
        super(name, role);
        this.hourlyRate = rate;
        this.workedHoursForTwoWeeks = workedHoursForTwoWeeks;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
            "name='" + this.getName() + '\'' +
            ", role='" + this.getRole() + '\'' +
            ", hourlyRate=" + hourlyRate +
            ", workedHoursForTwoWeeks=" + workedHoursForTwoWeeks +
            '}';
    }

    @Override
    public void giveRaise(float raise) {
        hourlyRate += raise;
    }

    @Override
    public float getPayForTwoWeeks() {
        return hourlyRate * workedHoursForTwoWeeks;
    }
}
