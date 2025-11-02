/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SingletonEjbClass.java to edit this template
 */
package ejb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.ConcurrencyManagement;
import jakarta.ejb.ConcurrencyManagementType;
import jakarta.ejb.Singleton;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Lock;
import jakarta.ejb.LockType;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@TransactionManagement(TransactionManagementType.BEAN)
@Singleton
@LocalBean
public class SingleBean {

    String fname;
    String lname;

    @Resource
    UserTransaction utx;

    @PostConstruct
    void initialize() {
        fname = "Dhruvisha";
        lname = "Bhaliya";
        System.out.println("Singleton Bean Initialized....");
    }

    @Lock(LockType.READ)
    public String getFname() {
        return fname;
    }

    @Lock(LockType.READ)
    public String getLname() {
        return lname;
    }

    @Lock(LockType.WRITE)
    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFullName() {
        String fullName = "";
        try {
            utx.begin();
            fullName = fname + " " + lname;
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (IllegalStateException ex) {
                Logger.getLogger(SingleBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex1) {
                Logger.getLogger(SingleBean.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (SystemException ex2) {
                Logger.getLogger(SingleBean.class.getName()).log(Level.SEVERE, null, ex2);
            }
        }
        return fullName;
    }

}
