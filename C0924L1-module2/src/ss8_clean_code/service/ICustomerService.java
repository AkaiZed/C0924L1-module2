package ss8_clean_code.service;

import ss8_clean_code.model.Customer;

public interface ICustomerService {
    public Customer[] displayCustomer();

    public void addCustomer(Customer customer);

    public boolean deleteCustomer(String numbPhone);

    public void displayCustomerInfo();

//    public void sortCustomersByAge();
}
