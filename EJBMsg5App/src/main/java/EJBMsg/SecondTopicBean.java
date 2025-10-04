/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package EJBMsg;

import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

/**
 *
 * @author DELL
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/topic2"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Topic")
})
public class SecondTopicBean implements MessageListener {
    
    public SecondTopicBean() {
    }
    
    @Override
    public void onMessage(Message message) {
    try {
            TextMessage tmsg = (TextMessage) message;

            String msg = tmsg.getText();

            System.out.println("Message Recieved By SecondTopicBean:" + msg);

        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}
