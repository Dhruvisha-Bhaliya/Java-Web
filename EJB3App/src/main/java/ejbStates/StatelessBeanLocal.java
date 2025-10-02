/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejbStates;

import jakarta.ejb.Local;

/**
 *
 * @author DELL
 */
@Local
public interface StatelessBeanLocal {

    int increment();
}
