package com.github.glo2003.payroll.exception;

public class NoEmployeeException extends Exception {
  public NoEmployeeException() {
    super("There is no employee.");
  }
}
