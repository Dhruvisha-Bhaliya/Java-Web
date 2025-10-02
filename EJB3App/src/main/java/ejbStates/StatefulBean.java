/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatefulEjbClass.java to edit this template
 */
package ejbStates;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateful;

/**
 *
 * @author DELL
 */
@Stateful
public class StatefulBean implements StatefulBeanLocal {

    int i;

    @PostConstruct
    void initialize() {
        i = 0;
    }

    @Override
    public int increment() {
        return ++i;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
