package com.github.glo2003.payroll.employee;

import java.util.List;

public class ContractEmployee extends Employee {
  private final List<Float> payouts;
  private int currentMilestone;

  public ContractEmployee(String name, Role role, List<Float> payouts) {
    super(name, role);
    this.currentMilestone = 0;
    this.payouts = payouts;
  }

  @Override
  public void giveRaise(float raise) {
    if (currentMilestone < payouts.size()) {
      float newAmount = payouts.get(currentMilestone) + raise;
      payouts.set(currentMilestone, newAmount);
    }
  }

  @Override
  public float getPayForTwoWeeks() {
    if (currentMilestone < payouts.size()) {
      int milestone = currentMilestone;
      currentMilestone += 1;
      return payouts.get(milestone);
    }
    return 0;
  }
}
