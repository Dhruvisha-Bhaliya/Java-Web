/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;

/**
 *
 * @author DELL
 */
@Stateless
public class PublishBean implements PublishBeanLocal {

    @PersistenceContext(unitName = "publish_unit")
    EntityManager em;

    @Override
    public Collection<Customer> getAllCustomer() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Customer.findAll").getResultList();

    }

    @Override
    public void addCustomer(String firstName, String lastName) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Customer cu = new Customer();
        cu.setFirstName(firstName);
        cu.setLastName(lastName);
        em.persist(cu);
    }

    @Override
    public void updateCustomer(Integer custId, String firstName, String lastName) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Customer cu = (Customer) em.find(Customer.class, custId);
        cu.setFirstName(firstName);
        cu.setLastName(lastName);
        em.merge(cu);
    }

    @Override
    public void removeCustomer(Integer custId) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Customer cu = (Customer) em.find(Customer.class, custId);
        em.remove(cu);
    }

    @Override
    public Collection<Customer> findCustomerByFirstName(String fname) {
        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Collection<Customer> customers = em.createNamedQuery("Customer.findByFirstName").setParameter("firstName", fname).getResultList();
        return customers;
    }

    @Override
    public Collection<Customer> findCustomerByLastName(String lname) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Customer findCustomerbyId(Integer id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return (Customer) em.find(Customer.class, id);
    }

    @Override
    public Collection<Address> getAddressOfCustomer(Integer custId) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Customer c = (Customer) em.find(Customer.class, custId);
        return c.getAddressCollection();
    }

    @Override
    public Customer getCustomerByAddress(Integer aid) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Address add = (Address) em.find(Address.class, aid);
        return add.getCustomerId();

    }

    @Override
    public void addAddressToCustomer(String street, String city, String state, String zip, Integer custId) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Customer cu = (Customer) em.find(Customer.class, custId);
        if (cu == null) {
            System.out.println("❌ Customer not found with ID: " + custId);
            return;
        }
        Collection<Address> addresses = cu.getAddressCollection();
        Address a = new Address();
        a.setStreet(street);
        a.setCity(city);
        a.setState(state);
        a.setZip(zip);
        a.setCustomerId(cu);
        addresses.add(a);
        cu.setAddressCollection(addresses);
        em.persist(a);
        em.merge(cu);

    }

    @Override
    public void updateAddressToCustomer(Integer aid, String street, String city, String state, String zip, Integer custId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeAddressFromCustomer(Integer addressId, Integer custId) {
        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Customer c = (Customer) em.find(Customer.class, custId);
        Address a = (Address) em.find(Address.class, addressId);

        Collection<Address> addresses = c.getAddressCollection();

        if (addresses.contains(a)) {
            addresses.remove(a);
            c.setAddressCollection(addresses);
            em.remove(a);
        }

    }

    @Override
    public Collection<Address> getAddressesByCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByZip(String zip) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Subscription> getSubscriptionsOfCustomer(Integer custId) {
        Customer c = (Customer) em.find(Customer.class, custId);
        return c.getSubscriptionCollection();

        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Customer> getCustomersOfSuscription(Integer subId) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Subscription s = (Subscription) em.find(Subscription.class, subId);
        return s.getCustomerCollection();
    }

    @Override
    public void addSubscription(String title, String type) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Subscription s = new Subscription();
        s.setTitle(title);
        s.setType(type);
        em.persist(s);
    }

    @Override
    public void updateSubscription(Integer subId, String title, String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeSubscription(Integer subId) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Subscription s = (Subscription) em.find(Subscription.class, subId);
        em.remove(s);

    }

    @Override
    public Collection<Subscription> getAllSubscriptions() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Subscription.findAll").getResultList();
    }

    @Override
    public Collection<Subscription> getSubscriptionsByType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Subscription> getSubscriptionsByTitle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addSubscriptionsToCustomer(Integer customerId, Collection<Integer> subscriptionIds) {
        // Find the customer
        Customer c = (Customer) em.find(Customer.class, customerId);

        Collection<Subscription> subs = c.getSubscriptionCollection();

        for (Integer sid : subscriptionIds) {
            Subscription s = (Subscription) em.find(Subscription.class, sid);

            if (!subs.contains(s)) {
                Collection<Customer> customers = s.getCustomerCollection();

                customers.add(c);
                subs.add(s);

                c.setSubscriptionCollection(subs);
                s.setCustomerCollection(customers);

                em.merge(c);
            }

        }
    }

    @Override
    public void removeSubscriptionsToCustomer(Integer custId, Collection<Integer> subIds) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Customer c = (Customer) em.find(Customer.class,
                custId);

        Collection<Subscription> subs = c.getSubscriptionCollection();

        for (Integer sid : subIds) {
            Subscription s = (Subscription) em.find(Subscription.class, sid);

            if (subs.contains(s)) {
                Collection<Customer> customers = s.getCustomerCollection();

                customers.remove(c);
                subs.remove(s);

                c.setSubscriptionCollection(subs);
                s.setCustomerCollection(customers);

                em.merge(c);
            }

        }

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
