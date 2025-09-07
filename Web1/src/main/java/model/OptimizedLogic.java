/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class OptimizedLogic {

    Connection con;
    ResultSet rs;

    public OptimizedLogic() {

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbemp?useSSL=false", "root", "");
            System.out.println("connect");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
        } catch (SQLException sq) {
            System.out.println("Could not connect to Database");
        }
    }

    public Collection<Employee> getAllEmployees() {

        Collection<Employee> employees = new ArrayList<>();

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("select * from employee where salary");

            while (rs.next()) {
                Employee e = new Employee();
                e.setEmpno(rs.getInt("empno"));
                e.setEname(rs.getString("ename"));
                e.setSalary(rs.getDouble("salary"));

                employees.add(e);

            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }

        return employees;

    }

    public void insertEmployee(int empno, String ename, double salary) {

        try {

            String insert = "insert into employee values(?,?,?)";

            PreparedStatement psmt = con.prepareStatement(insert);

            psmt.setInt(1, empno);
            psmt.setString(2, ename);
            psmt.setDouble(3, salary);

            // String insert = "insert into employee values("+empno+",'"+ ename+"',"+salary+")";
            psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataLogic.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeEmployee(int empno) {

        try {
            String del = "delete from employee where empno=?";
            PreparedStatement stmt = con.prepareStatement(del);

            stmt.setInt(1, empno);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataLogic.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public double getGrossSal() {
        double x = 0;

        try {
            CallableStatement cstmt = con.prepareCall("{call gross_sal(?)}");

            cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);

            ResultSet rs1 = cstmt.executeQuery();
// . . . retrieve result set values with rs.getter methods
            x = cstmt.getDouble(1);
        } catch (SQLException sge) {
            sge.printStackTrace();

        }
        return x;
    }

    public double getMaxSal() {
        double msal = 0;
        try {
            CallableStatement cstmt1 = con.prepareCall(
                    "{?=call maxsal()}");
            cstmt1.registerOutParameter(1, java.sql.Types.DOUBLE);
            cstmt1.execute();

            msal = cstmt1.getDouble(1);

        } catch (SQLException x) {
            x.printStackTrace();
        }
        return msal;
    }

//        public static void main(String[] args) {
//        OptimizedLogic opt = new OptimizedLogic();
//    }

}


