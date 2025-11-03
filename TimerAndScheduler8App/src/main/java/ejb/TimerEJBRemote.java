/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejb;

import jakarta.ejb.Remote;

/**
 *
 * @author DELL
 */
@Remote
public interface TimerEJBRemote {

    void speakonTimeout();

    void hi();
}
