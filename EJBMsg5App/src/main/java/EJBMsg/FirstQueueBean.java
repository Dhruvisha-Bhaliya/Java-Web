/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package EJBMsg;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.MessageProducer;
import jakarta.jms.Queue;
import jakarta.jms.QueueConnection;
import jakarta.jms.QueueConnectionFactory;
import jakarta.jms.QueueSession;
import jakarta.jms.TextMessage;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author DELL
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/queue1"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queue"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/queue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
public class FirstQueueBean implements MessageListener {

    String msg;

    public FirstQueueBean() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tg = (TextMessage) message;
            msg = tg.getText();
            System.out.println("Message Recieved By FIrstQueueBean: " + msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        try {
            Properties p = new Properties();
            p.setProperty(Context.PROVIDER_URL, "mq://localhost:7676");
            InitialContext ic = new InitialContext(p);

            Queue qu = (Queue) ic.lookup("jms/mware");
            QueueConnectionFactory qf = (QueueConnectionFactory) ic.lookup("jms/mwareFactory");
            QueueConnection con = qf.createQueueConnection();
            QueueSession session = con.createQueueSession(true, 0);
            MessageProducer mp = session.createProducer(qu);
            TextMessage tm = session.createTextMessage();
            tm.setText("Message forwarded to Reciever servlet by FirstQueueBean" + msg);
            mp.send(tm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
