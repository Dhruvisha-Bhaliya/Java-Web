/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsp;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author DELL
 */
public class Employee implements Serializable {

    int empno;
    String ename;
    double salary;
    HashMap errors;

    public Employee() {
        empno = 0;
        ename = "";
        salary = 0.0;

        errors = new HashMap();
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean validate() {
        boolean allOK = true;
        if (empno == 0) {
            allOK = false;
            errors.put("salary", "salary can not be less than 1000");
        }
        return allOK;
    }

    @Override
    public String toString() {
        return "Employee{" + "empno=" + empno + ",ename=" + ename + ",salary=" + salary + '}';
    }

    public String getError(String field) {
        Object err = errors.get(field.trim());
        return (err != null) ? err.toString() : "";
    }
}
