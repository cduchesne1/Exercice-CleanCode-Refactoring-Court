package com.github.glo2003.payroll.exception;

import com.github.glo2003.payroll.employee.Employee;

public class EmployeeIsNotWorkingHereException extends Exception {
  public EmployeeIsNotWorkingHereException(Employee employee) {
    super(employee.getName() + "is not working here.");
  }
}
