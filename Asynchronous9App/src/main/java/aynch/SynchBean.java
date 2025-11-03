/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package aynch;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

/**
 *
 * @author DELL
 */
@Stateless
@LocalBean
public class SynchBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public int compute() {

        try {
            goLoopA();
            goLoopB();
        } catch (InterruptedException e) {

        }
        return 0;
    }

    void goLoopA() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            System.out.println("i= " + i);
        }
    }

    void goLoopB() throws InterruptedException {
        for (int j = 0; j < 100; j++) {
            Thread.sleep(1000);
            System.out.println("j= " + j);
        }
    }
}
