package ss9_list.service;

import ss9_list.model.Customer;

import java.util.ArrayList;

public interface ICustomerService {
    public ArrayList<Customer> displayCustomer() ;

    public void addCustomer(Customer customer);

    public boolean deleteCustomer(String numbPhone);

    public void displayCustomerInfo();

//    public void sortCustomersByAge();
}
