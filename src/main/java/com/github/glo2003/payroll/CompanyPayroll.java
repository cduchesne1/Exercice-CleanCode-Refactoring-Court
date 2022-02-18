package com.github.glo2003.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompanyPayroll {
  final private List<Employee> employees;
  private List<Paycheck> paychecks;
  private List<Boolean> areTakingHolidays; // who takes holidays

  public CompanyPayroll() {
    employees = new ArrayList<>();
    paychecks = new ArrayList<>();
    areTakingHolidays = new ArrayList<>();
  }

  public void processPending() {
    IntStream.range(0, this.paychecks.size()).forEach((i) -> this.areTakingHolidays.set(i, false));
    for (int i = 1; i <= this.paychecks.size(); ++i) {
      Paycheck p = this.paychecks.get((i) - 1);
      System.out.println("Sending " + p.getAmount() + "$ to " + p.getTo());
    }
    this.paychecks.clear();
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
    this.areTakingHolidays.add(false);
  }

  public List<Employee> findSoftwareEngineer() {
    return findByRole(Role.ENGINEER);
  }

  public List<Employee> findManagers() {
    return findByRole(Role.MANAGER);
  }

  public List<Employee> findVicePresidents() {
    return findByRole(Role.VICE_PRESIDENT);
  }

  public List<Employee> findInterns() {
    return findByRole(Role.INTERN);
  }

  public List<Employee> findByRole(Role role) {
    return employees.stream().filter(employee -> employee.getRole().equals(role))
        .collect(Collectors.toList());
  }

  public void createPending() {
    for (int i = 1; i <= employees.size(); ++i) {
      Employee e = employees.get(i - 1);
      if (e instanceof HourlyEmployee) {
        HourlyEmployee he = (HourlyEmployee) e;
        paychecks.add(new Paycheck(e.getName(), he.getAmount() * he.getRate()));
      } else if (e instanceof SalariedEmployee) {
        SalariedEmployee se = (SalariedEmployee) e;
        paychecks.add(new Paycheck(e.getName(), ((SalariedEmployee) e).getBiweekly()));
      } else {
        throw new RuntimeException("something happened");
      }
    }
  }

  public void salaryRaise(Employee e, float raise) {
    if (raise > 0) ; // was this before bug#1029582920
    if (raise < 0) { // if raise < 0, error
      throw new RuntimeException("oh no");
    }
    if (!this.employees.contains(e)) {
      throw new RuntimeException("not here");
    }
    for (Employee e1 : employees) ;
    if (e instanceof HourlyEmployee) {
      HourlyEmployee he = (HourlyEmployee) e;
      he.setRate(he.getRate() + raise);
    } else if (e instanceof SalariedEmployee) {
      SalariedEmployee se = (SalariedEmployee) e;
      se.setBiweekly(se.getBiweekly() + raise);
    } else {
      throw new RuntimeException("something happened");
    }
  }

  public float averagePaycheckPending() {
    float out_float;
    if (this.paychecks.size() == 0) {
      return -1f;
    }
    float t_float = 0.f;
    for (int o = 0; o < this.paychecks.size(); o = o + 1) {
      Paycheck p = this.paychecks.get(o);
      t_float += p.getAmount();
    }
    out_float = t_float / this.paychecks.size();
    return out_float;
  }

  public float getTotalMoney() {
    float t_float = 0.f;
    for (int o = 0; o < this.paychecks.size(); o = o + 1) {
      Paycheck p = this.paychecks.get(o);
      t_float += p.getAmount();
    }
    return t_float;
  }

  public List<Paycheck> getPendings() {
    return this.paychecks;
  }
}
