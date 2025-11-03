/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SingletonEjbClass.java to edit this template
 */
package ejb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.ejb.ScheduleExpression;
import jakarta.ejb.Startup;
import jakarta.ejb.TimedObject;
import jakarta.ejb.Timer;
import jakarta.ejb.TimerService;
import java.util.Date;

/**
 *
 * @author DELL
 */
@Singleton
@Startup
public class TimerEJB implements TimerEJBRemote, TimedObject {

    @Resource
    TimerService ts;

    @PostConstruct
    void setTimer() {
        try {
            ScheduleExpression se = new ScheduleExpression();
            se.dayOfWeek("Sun");  // Every Sunday
            se.hour("0-17,23");   // Hours 0-17 and 23
            se.minute("18");  // At minute 18
            se.second("*/5");   // Every 5 seconds
            ts.createCalendarTimer(se);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void speakonTimeout() {
        System.out.println("My Time expired at " + new Date().toString());
        return;
    }

    @Override
    public void hi() {
        return;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void ejbTimeout(Timer timer) {
        System.out.println("Timer triggered at: " + new Date());
    }
}
