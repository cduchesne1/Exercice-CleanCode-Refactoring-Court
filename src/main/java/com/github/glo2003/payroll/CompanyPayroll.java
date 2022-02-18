package com.github.glo2003.payroll;

import com.github.glo2003.payroll.employee.Employee;
import com.github.glo2003.payroll.employee.Role;
import com.github.glo2003.payroll.exception.EmployeeIsNotWorkingHereException;
import com.github.glo2003.payroll.exception.InvalidRaiseException;
import com.github.glo2003.payroll.exception.NoEmployeeException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyPayroll {
  final private List<Employee> employees;
  private List<Paycheck> pendingPaychecks;

  public CompanyPayroll() {
    employees = new ArrayList<>();
    pendingPaychecks = new ArrayList<>();
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
  }

  public void createPendingPaychecks() {
    for (Employee employee : employees) {
      pendingPaychecks.add(new Paycheck(employee.getName(), employee.getPayForTwoWeeks()));
    }
  }

  public void processPendingPaychecks() {
    for (Paycheck paycheck : pendingPaychecks) {
      System.out.println("Sending " + paycheck.getAmount() + "$ to " + paycheck.getTo());
    }
    pendingPaychecks.clear();
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

  private List<Employee> findByRole(Role role) {
    return employees.stream().filter(employee -> employee.getRole().equals(role))
        .collect(Collectors.toList());
  }

  public void giveRaise(Employee employee, float raise)
      throws InvalidRaiseException, EmployeeIsNotWorkingHereException {
    if (raise < 0) {
      throw new InvalidRaiseException(raise);
    }

    if (!employees.contains(employee)) {
      throw new EmployeeIsNotWorkingHereException(employee);
    }

    employee.giveRaise(raise);
  }

  public float getPendingPaychecksAverage() throws NoEmployeeException {
    if (pendingPaychecks.isEmpty()) {
      throw new NoEmployeeException();
    }
    float totalMoney = getTotalMoney();
    return totalMoney / pendingPaychecks.size();
  }

  public float getTotalMoney() {
    return pendingPaychecks.stream().map(Paycheck::getAmount).reduce(0.f, Float::sum);
  }

  public List<Paycheck> getPendings() {
    return pendingPaychecks;
  }
}
