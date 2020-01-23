/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Iago
 */
public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner s = new Scanner(System.in);
        SimpleDateFormat sd1 = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println(" Enter dapartment's name: ");
        String departmentName = s.nextLine();
        System.out.println(" Enter Worker Data: ");
        System.out.println("Name: ");
        String name = s.nextLine();
        System.out.println("Level: ");
        String levelName = s.nextLine();
        System.out.println("Base Salary: ");
        double baseSalary = s.nextDouble();
        worker work = new worker(name, WorkerLevel.valueOf(levelName), baseSalary, new department(departmentName));

        System.out.println(" How many contracts to this worker ? ");
        int n = s.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("Enter contract mumber: " + i);
            System.out.println("Date (DD/MM/YYYY)");
            Date contractDate = sd1.parse(s.next());
            System.out.println("Value for hour: ");
            double hourForValue = s.nextDouble();
            System.out.println("Duration Hours: ");
            int durationHours = s.nextInt();
            contractForHour contracts = new contractForHour(contractDate, hourForValue, durationHours);
            work.addContract(contracts);
        }
        System.out.println();
        System.out.println("Enter month and year to calculate income (MM/YYYY)");
        String monthAndYear = s.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3,7));

        System.out.println("Name: " + work.getName());
        System.out.println("Department: " + work.getDepar().getName());
        System.out.printf("Salary for: " + monthAndYear + ": " + String.format("%.2f", work.income(year, month)));
        System.out.println();
    }

}

