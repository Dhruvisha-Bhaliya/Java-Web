/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CoreJava;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Represents a contact in the address book
class Address {

    String name;
    String homeAddress;
    String homePhone;
    String businessAddress;
    String businessPhone;
    String faxNumber;
    String cellPhone;
    String pagerNumber;

    public Address(String name, String homeAddress, String homePhone, String businessAddress, String businessPhone,
            String faxNumber, String cellPhone, String pagerNumber) {
        this.name = name;
        this.homeAddress = homeAddress;
        this.homePhone = homePhone;
        this.businessAddress = businessAddress;
        this.businessPhone = businessPhone;
        this.faxNumber = faxNumber;
        this.cellPhone = cellPhone;
        this.pagerNumber = pagerNumber;
    }

    @Override
    public String toString() {
        return String.format("""
                             -----------------------------
                             Name            : %s
                             Home Address    : %s
                             Home Phone      : %s
                             Business Address: %s
                             Business Phone  : %s
                             Fax Number      : %s
                             Cell Phone      : %s
                             Pager Number    : %s
                             -----------------------------
                             """,
                name, homeAddress, homePhone, businessAddress, businessPhone,
                faxNumber, cellPhone, pagerNumber);
    }
}

// Manages the list of contacts
class AddressBook {

    private final ArrayList<Address> contacts = new ArrayList<>();

    public void addContact(Address contact) {
        contacts.add(contact);
    }

    public Address findContact(String name) {
        for (Address a : contacts) {
            if (a.name.equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }

    public boolean editContact(String name, Address updatedContact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).name.equalsIgnoreCase(name)) {
                contacts.set(i, updatedContact);
                return true;
            }
        }
        return false;
    }

    public boolean deleteContact(String name) {
        return contacts.removeIf(contact -> contact.name.equalsIgnoreCase(name));
    }

    public String getAllContacts() {
        if (contacts.isEmpty()) {
            return "No contacts available.";
        }
        StringBuilder sb = new StringBuilder("=== All Contacts ===\n");
        for (Address a : contacts) {
            sb.append(a).append("\n");
        }
        return sb.toString();
    }
}

// Main GUI class for the Address Book
public class Q_2 extends JFrame {

    private final AddressBook addressBook = new AddressBook();

    private final JTextField nameField = new JTextField(20);
    private final JTextField homeAddressField = new JTextField(20);
    private final JTextField homePhoneField = new JTextField(15);
    private final JTextField businessAddressField = new JTextField(20);
    private final JTextField businessPhoneField = new JTextField(15);
    private final JTextField faxField = new JTextField(15);
    private final JTextField cellField = new JTextField(15);
    private final JTextField pagerField = new JTextField(15);
    private final JTextArea displayArea = new JTextArea(18, 45);

    public Q_2() {
        super("Address Book Application");
        setLayout(new BorderLayout(10, 10));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Contact Details"));

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Home Address:"));
        inputPanel.add(homeAddressField);
        inputPanel.add(new JLabel("Home Phone:"));
        inputPanel.add(homePhoneField);
        inputPanel.add(new JLabel("Business Address:"));
        inputPanel.add(businessAddressField);
        inputPanel.add(new JLabel("Business Phone:"));
        inputPanel.add(businessPhoneField);
        inputPanel.add(new JLabel("Fax Number:"));
        inputPanel.add(faxField);
        inputPanel.add(new JLabel("Cell Phone:"));
        inputPanel.add(cellField);
        inputPanel.add(new JLabel("Pager Number:"));
        inputPanel.add(pagerField);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        JButton addBtn = new JButton("Add");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");
        JButton findBtn = new JButton("Find");
        JButton showAllBtn = new JButton("Show All");

        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(findBtn);
        buttonPanel.add(showAllBtn);

        // Display Panel
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output"));

        // Add panels to Frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Event Listeners
        addBtn.addActionListener(e -> addContact());
        editBtn.addActionListener(e -> editContact());
        deleteBtn.addActionListener(e -> deleteContact());
        findBtn.addActionListener(e -> findContact());
        showAllBtn.addActionListener(e -> displayArea.setText(addressBook.getAllContacts()));

        // Window Settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Create Address from input fields
    private Address getInputAsAddress() {
        return new Address(
                nameField.getText().trim(),
                homeAddressField.getText().trim(),
                homePhoneField.getText().trim(),
                businessAddressField.getText().trim(),
                businessPhoneField.getText().trim(),
                faxField.getText().trim(),
                cellField.getText().trim(),
                pagerField.getText().trim()
        );
    }

    // Add contact
    private void addContact() {
        if (nameField.getText().trim().isEmpty()) {
            showMessage("Name is required to add a contact.");
            return;
        }

        Address newContact = getInputAsAddress();
        addressBook.addContact(newContact);
        displayArea.setText("Contact Added Successfully:\n\n" + newContact);
        clearFields();
    }

    // Edit contact
    private void editContact() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            showMessage("Enter the name of the contact to edit.");
            return;
        }

        Address existing = addressBook.findContact(name);
        if (existing == null) {
            displayArea.setText("Contact not found to edit.");
            return;
        }

        // Only update fields that are not empty
        String homeAddress = homeAddressField.getText().trim();
        String homePhone = homePhoneField.getText().trim();
        String businessAddress = businessAddressField.getText().trim();
        String businessPhone = businessPhoneField.getText().trim();
        String fax = faxField.getText().trim();
        String cell = cellField.getText().trim();
        String pager = pagerField.getText().trim();

        if (!homeAddress.isEmpty()) {
            existing.homeAddress = homeAddress;
        }
        if (!homePhone.isEmpty()) {
            existing.homePhone = homePhone;
        }
        if (!businessAddress.isEmpty()) {
            existing.businessAddress = businessAddress;
        }
        if (!businessPhone.isEmpty()) {
            existing.businessPhone = businessPhone;
        }
        if (!fax.isEmpty()) {
            existing.faxNumber = fax;
        }
        if (!cell.isEmpty()) {
            existing.cellPhone = cell;
        }
        if (!pager.isEmpty()) {
            existing.pagerNumber = pager;
        }

        displayArea.setText("Contact Updated Successfully:\n\n" + existing);
        clearFields();
    }

    // Delete contact
    private void deleteContact() {
        if (nameField.getText().trim().isEmpty()) {
            showMessage("Enter the name of the contact to delete.");
            return;
        }

        boolean removed = addressBook.deleteContact(nameField.getText().trim());
        displayArea.setText(removed ? "Contact Deleted Successfully." : "Contact not found.");
        clearFields();
    }

    // Find contact
    private void findContact() {
        if (nameField.getText().trim().isEmpty()) {
            showMessage("Enter the name of the contact to search.");
            return;
        }

        Address found = addressBook.findContact(nameField.getText().trim());
        displayArea.setText(found != null ? "Contact Found:\n\n" + found : "Contact not found.");
    }

    // Utility to clear all text fields
    private void clearFields() {
        nameField.setText("");
        homeAddressField.setText("");
        homePhoneField.setText("");
        businessAddressField.setText("");
        businessPhoneField.setText("");
        faxField.setText("");
        cellField.setText("");
        pagerField.setText("");
    }

    // Utility to show dialog message
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q_2::new);
    }
}
