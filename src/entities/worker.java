/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.enums.WorkerLevel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Iago
 */
public class worker {

    public String name;
    private WorkerLevel level;
    private double baseSalary;

    private department depar;
    private List<contractForHour> contract = new ArrayList<>();

    public worker() {
    }

    public worker(String name, WorkerLevel level, double baseSalary, department depar) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.depar = depar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public department getDepar() {
        return depar;
    }

    public void setDepar(department depar) {
        this.depar = depar;
    }

    public List<contractForHour> getContract() {
        return contract;
    }

    public void addContract(contractForHour contracts) {

        contract.add(contracts);

    }

    public void removeContract(contractForHour contracts) {

        contract.remove(contracts);
    }

    public double income(int year, int month) {

        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (contractForHour c : contract) {
            cal.setTime(c.getDate());

            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if (year == c_year && month == c_month) {

                sum += c.totalValue();
            }
        }
        return sum;

    }
}
