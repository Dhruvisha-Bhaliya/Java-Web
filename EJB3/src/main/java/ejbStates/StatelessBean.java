/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejbStates;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;

/**
 *
 * @author DELL
 */
@Stateless
public class StatelessBean implements StatelessBeanLocal {

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
