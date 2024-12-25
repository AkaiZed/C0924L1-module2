package ss9_list.service;

import ss9_list.model.Customer;
import ss9_list.view.Validations;

import java.util.ArrayList;

public class CustomerService implements ICustomerService {
    private ArrayList<Customer> customers = new ArrayList<>();

    public CustomerService() {
        customers.add(new Customer("Nguyen Duc Nam", 35, "040089321364", "0973635870", "Le Loi"));
        customers.add(new Customer("Tran Van Hoang", 29, "030087654321", "0934567890", "Nguyen Hue"));
        customers.add(new Customer("Pham Tra Thanh", 42, "050012345678", "0912345678", "Hai Ba Trung"));
        customers.add(new Customer("Le Ha Phuc", 31, "020098765432", "0987654321", "Tran Phu"));
        customers.add(new Customer("Do Thi Bich", 27, "010011223344", "0923456789", "Quang Trung"));
        customers.add(new Customer("Hoang Minh Tuan", 45, "070056789123", "0909876543", "Phan Chu Trinh"));
        customers.add(new Customer("Nguyen Mai Hoa", 38, "080076543210", "0943216789", "Le Hong Phong"));
    }

    @Override
    public ArrayList<Customer> displayCustomer() {
        System.out.println("List of customers: ");
        System.out.println("|          ++ Name ++          | ++ Age ++ |      ++ ID Card ++      |   ++ Phone ++   |          ++ Address ++          |");
        System.out.println("|------------------------------|-----------|-------------------------|-----------------|---------------------------------|");
        for (Customer cus : customers) {
            if (cus != null) {
                System.out.printf("| %-28s | %-9d | %-23s | %-15s | %-31s |\n",
                        cus.getCustomerName(),
                        cus.getCustomerAge(),
                        cus.getCitizenID(),
                        cus.getCustomerPhone(),
                        cus.getCustomerAddress());
            }
        }
        System.out.println("|------------------------------|-----------|-------------------------|-----------------|---------------------------------|");
        return customers;
    }

    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Added new customer: " + customer);
    }

    public void addCus() {
        displayCustomer();
        while (true) {
            String numbPhone = Validations.getPhoneNumber("Enter phone number: ");
            if (!isDuplicateNumber(numbPhone)) {
                addInfor(numbPhone);
                break;
            } else {
                if (!Validations.getYesNo("Phone number already exists. Try again? (yes/no): ")) {
                    System.out.println("Returning to the main menu...");
                    return;
                }
            }
        }
    }

    private boolean isDuplicateNumber(String phoneNumber) {
        for (Customer cus : customers) {
            if (cus != null && cus.getCustomerPhone().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public void addInfor(String numbPhone) {
        while (true) {
            String citizenId = Validations.getCitizenId("Enter citizen id: ");
            if (isDuplicateCitizen(citizenId)) {
                if (!Validations.getYesNo("Citizen id already exists. Try again? (yes/no): ")) {
                    System.out.println("Returning to the main menu...");
                    return;
                }
            } else {
                String name = Validations.getName("Enter name: ");
                int age;
                while (true) {
                    age = (int) Validations.getLong("Enter age: ");
                    if (age < 15 && age > 110) {
                        System.out.println("Not old enough to rent");
                    } else {
                        break;
                    }
                }
                String address = Validations.getName("Enter address: ");
                addCustomer(new Customer(name, age, citizenId, numbPhone, address));
                System.out.println("Customer added successfully.");
                displayCustomer();
                break;
            }
        }
    }

    private boolean isDuplicateCitizen(String id) {
        for (Customer cus : customers) {
            if (cus != null && cus.getCitizenID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(String numbPhone) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerPhone().equals(numbPhone)) {
                customers.remove(i);
                System.out.println("Delete customer successful");
                displayCustomer();
                return true;
            }
        }
        System.out.println("No customer was deleted");
        return false;
    }

    @Override
    public void displayCustomerInfo() {
        System.out.println("|  ++ Phone Number ++  |           ++ Customer Name ++            | ++ Age ++ |");
        System.out.println("|----------------------|------------------------------------------|-----------|");
        for (Customer customer : customers) {
            if (customer != null) {
                System.out.printf("| %-20s | %-40s | %-9d |\n",
                        customer.getCustomerPhone(),
                        customer.getCustomerName(),
                        customer.getCustomerAge());
            }
        }
        System.out.println("|----------------------|------------------------------------------|-----------|");
    }

    public void editCus() {
        while (true) {
            displayCustomer();
            String phoneNumber = Validations.getPhoneNumber("Enter phone number you want to edit: ");
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getCustomerPhone().equals(phoneNumber)) {
                    System.out.println("Editing information of " + customers.get(i).getCustomerName());

//                    BikeRentController.editCusOptions();
                    int newAge;
                    while (true) {
                        newAge = (int) Validations.getLong("Enter new age: ");
                        if (newAge < 15 && newAge > 110) {
                            System.out.println("Not old enough to rent");
                        } else {
                            break;
                        }
                    }

                    customers.get(i).setCustomerName(Validations.getName("Enter new name: "));
                    customers.get(i).setCustomerAge(newAge);
                    customers.get(i).setCustomerAddress(Validations.getName("Enter new address: "));

                    System.out.println("Customer information updated successfully.");
                    displayCustomer();
                    break;
                }
            }
        }
    }
}

