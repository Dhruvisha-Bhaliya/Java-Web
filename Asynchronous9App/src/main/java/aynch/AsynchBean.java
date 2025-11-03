/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package aynch;

import jakarta.annotation.Resource;
import jakarta.ejb.Asynchronous;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import jakarta.ejb.SessionContext;

/**
 *
 * @author DELL
 */
@Stateless
@LocalBean
public class AsynchBean {

    @Resource
    SessionContext ctx;

    public int compute() {
        AsynchBean me = ctx.getBusinessObject(AsynchBean.class);
        try {
            me.goLoopA();
            me.goLoopB();
        } catch (Exception e) {
        }
        return 0;
    }

    @Asynchronous
    public void goLoopA() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            System.out.println("i=" + i);
        }
    }

    @Asynchronous
    public void goLoopB() throws InterruptedException {
        for (int j = 0; j < 100; j++) {
            Thread.sleep(1000);
            System.out.println("j=" + j);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
