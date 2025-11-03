/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SingletonEjbClass.java to edit this template
 */
package ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Schedule;
import jakarta.ejb.Startup;
import java.util.Date;

/**
 *
 * @author DELL
 */
@Singleton
@LocalBean
@Startup
public class SchedulerBean {

    @PostConstruct
    void initialize() {
     //   speakOnSchedule();
    }

    public void hi() {
      //  System.out.println("executing on my schedule " + new Date());
        return;
    }

    @Schedule(dayOfWeek = "*", year = "*", hour="*", minute="*", second="*/5", persistent=false)
    void speakOnSchedule() {
        System.out.println("executing on my schedule " + new Date());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
