package com.github.glo2003;

import com.github.glo2003.payroll.CompanyPayroll;
import com.github.glo2003.payroll.employee.ContractEmployee;
import com.github.glo2003.payroll.employee.Employee;
import com.github.glo2003.payroll.employee.HourlyEmployee;
import com.github.glo2003.payroll.employee.Role;
import com.github.glo2003.payroll.employee.SalariedEmployee;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        CompanyPayroll companyPayroll = new CompanyPayroll();

        Employee e1 = new HourlyEmployee("Alice", Role.VICE_PRESIDENT, 25, 35.5f * 4);
        Employee e2 = new SalariedEmployee("Bob", Role.ENGINEER, 1500);
        Employee e3 = new SalariedEmployee("Charlie", Role.MANAGER, 2000);
        Employee e4 = new HourlyEmployee("Ernest", Role.INTERN, 5, 50 * 4);
        Employee e5 = new HourlyEmployee("Fred", Role.INTERN, 5, 50 * 4);
        LinkedList<Float> payouts = new LinkedList<Float>() {{
            add(100f);
            add(200f);
            add(300f);
        }};
        Employee e6 = new ContractEmployee("Joe", Role.MANAGER, payouts);

        companyPayroll.addEmployee(e1);
        companyPayroll.addEmployee(e2);
        companyPayroll.addEmployee(e3);
        companyPayroll.addEmployee(e4);
        companyPayroll.addEmployee(e5);
        companyPayroll.addEmployee(e6);

        System.out.println("----- Listing employees -----");
        companyPayroll.findVicePresidents().forEach(System.out::println);
        companyPayroll.findManagers().forEach(System.out::println);
        companyPayroll.findSoftwareEngineer().forEach(System.out::println);
        companyPayroll.findInterns().forEach(System.out::println);

        System.out.println("----- Giving raises -----");
        companyPayroll.giveRaise(e1, 10);
        companyPayroll.giveRaise(e2, 100);

        System.out.println("\n----- Create paychecks -----");
        companyPayroll.createPendingPaychecks();

        System.out.println("\n----- Pay statistics -----");
        float t = companyPayroll.getTotalMoney();
        System.out.println("Total money spent: ");
        float avg = companyPayroll.getPendingPaychecksAverage();
        System.out.println("Average paycheck: " + avg);

        System.out.println("\n----- Pay -----");
        companyPayroll.processPendingPaychecks();
    }
}
