/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import jakarta.ejb.Local;
import java.util.Collection;

/**
 *
 * @author DELL
 */
@Local
public interface PublishBeanLocal {

    Collection<Customer> getAllCustomer();

    void addCustomer(String firstName, String lastName);

    void updateCustomer(Integer custId, String firstName, String lastName);

    void removeCustomer(Integer custId);

    Collection<Customer> findCustomerByFirstName(String fname);

    Collection<Customer> findCustomerByLastName(String lname);

    Customer findCustomerbyId(Integer id);

    Collection<Address> getAddressOfCustomer(Integer custId);

    Customer getCustomerByAddress(Integer aid);

    void addAddressToCustomer(String street, String city, String state, String zip, Integer custId);

    void updateAddressToCustomer(Integer aid, String street, String city, String state, String zip, Integer custId);

    void removeAddressFromCustomer(Integer addressId, Integer custId);

    Collection<Address> getAddressesByCity(String city);

    Collection<Address> getAddressesByState(String state);

    Collection<Address> getAddressesByZip(String zip);

    Collection<Subscription> getSubscriptionsOfCustomer(Integer custId);

    Collection<Customer> getCustomersOfSuscription(Integer subId);

    void addSubscription(String title, String type);

    void updateSubscription(Integer subId, String title, String type);

    void removeSubscription(Integer subId);

    Collection<Subscription> getAllSubscriptions();

    Collection<Subscription> getSubscriptionsByType();

    Collection<Subscription> getSubscriptionsByTitle();

    void addSubscriptionsToCustomer(Integer custId, Collection<Integer> subIds);

    void removeSubscriptionsToCustomer(Integer custId, Collection<Integer> subIds);
}
