package com.github.glo2003.payroll.exception;

public class InvalidRaiseException extends Exception {
  public InvalidRaiseException(float raise) {
    super(raise + "is not a valid raise.");
  }
}
