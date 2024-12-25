package ss9_list.service;

import ss9_list.model.Bike;
import ss9_list.model.Customer;
import ss9_list.view.Validations;

import java.time.LocalDate;
import java.util.ArrayList;

public class BikeService implements IBikeService {
    //    private ArrayList<Customer> customers = CustomerService.getCustomers();
    private CustomerService customerService;
    ArrayList<Bike> bikes = new ArrayList<>();

    public BikeService(CustomerService customerService) {
        this.customerService = customerService;
        ArrayList<Customer> customers = customerService.getCustomers();

        bikes.add(new Bike("Bike-00", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 12), 15.0, customers.get(0)));
        bikes.add(new Bike("Bike-01", LocalDate.of(2024, 12, 12), LocalDate.of(2024, 12, 14), 10.0, customers.get(1)));
        bikes.add(new Bike("Bike-02", LocalDate.of(2024, 12, 15), LocalDate.of(2024, 12, 17), 12.5, customers.get(2)));
        bikes.add(new Bike("Bike-03", LocalDate.of(2024, 12, 13), LocalDate.of(2024, 12, 15), 20.0, customers.get(3)));
        bikes.add(new Bike("Bike-04", LocalDate.of(2024, 12, 14), LocalDate.of(2024, 12, 16), 14.5, customers.get(5)));
        bikes.add(new Bike("Bike-05", LocalDate.of(2024, 12, 11), LocalDate.of(2024, 12, 13), 18.0, customers.get(4)));
        bikes.add(new Bike("Bike-06", LocalDate.of(2024, 12, 16), LocalDate.of(2024, 12, 18), 22.0, customers.get(5)));
        bikes.add(new Bike("Bike-07", LocalDate.of(2024, 12, 17), LocalDate.of(2024, 12, 19), 14.0, customers.get(3)));
        bikes.add(new Bike("Bike-08", LocalDate.of(2024, 12, 18), LocalDate.of(2024, 12, 20), 16.5, customers.get(0)));
        bikes.add(new Bike("Bike-09", LocalDate.of(2024, 12, 19), LocalDate.of(2024, 12, 21), 25.0, customers.get(6)));
    }

    @Override
    public ArrayList<Bike> displayBike() {
        System.out.println("List of bicycles:");
        System.out.println("| ++ Bike ID ++ | ++ Start Date ++ | ++ End Date ++ | ++ Price (USD) ++ |           ++ Customer Name ++            |");
        System.out.println("|---------------|------------------|----------------|-------------------|------------------------------------------|");
        for (Bike bike : bikes) {
            if (bike != null) {
//                String customerName = (bike.getCusName() != null) ? bike.getCusName().getCustomerName() : "Unknown";
                System.out.printf("| %-13s | %-16s | %-14s | %-17.2f | %-40s |\n",
                        bike.getBikeID(),
                        bike.getStartDate(),
                        bike.getEndDate(),
                        bike.getBikePrice(),
                        bike.getCusName().getCustomerName());
//                        customerName);
            }
        }
        System.out.println("|---------------|------------------|----------------|-------------------|------------------------------------------|");
        return bikes;
    }

    @Override
    public void addBill(Bike bike) {
        bikes.add(bike);
        System.out.println("Rental bill add successful");
    }

    public void addNew() {
        while (true) {
            String id;
            while (true) {
                id = Validations.getIdBike("Enter bill id: ");
                if (!isDuplicateId(id)) {
                    break;
                }
                if (Validations.getYesNo("Id already exists. Try again? (yes/no): ")) {
                    System.out.println("Returning to the main menu...");
                    break;
                }
            }
            LocalDate startDate = LocalDate.parse(Validations.getStartDate("Enter start date"));
            LocalDate endDate = LocalDate.parse(Validations.getEndDate("Enter end date", startDate));
            double price = Validations.getDouble("Enter bike price: ");
            Customer customer = null;
            while (customer == null) {
                CustomerService customerService = new CustomerService();
                customerService.displayCustomerInfo();
                String phoneNumb = Validations.getPhoneNumber("Enter phone number: ");
                customer = findCustomerByPhone(phoneNumb);
                if (customer == null) {
                    if (!Validations.getYesNo("Phone number not found. Do you want to add a new customer? (yes/no): ")) {
                        customerService.addInfor(phoneNumb);
                        customer = findCustomerByPhone(phoneNumb);
                    } else {
                        System.out.println("Returning to the main menu...");
                        return;
                    }
                }
            }
            addBill(new Bike(id, startDate, endDate, price, customer));
            displayBike();
            break;
        }
    }

    private boolean isDuplicateId(String id) {
        for (Bike bike : bikes) {
            if (bike != null && bike.getBikeID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private Customer findCustomerByPhone(String phone) {
        ArrayList<Customer> customers = customerService.getCustomers();
        if (customers == null || customers.isEmpty()) {
            System.out.println("Customer list is empty.");
            return null;
        }
        for (Customer customer : customers) {
            if (customer != null && customer.getCustomerPhone().equals(phone)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public boolean removeBill(String id) {
        for (int i = 0; i < bikes.size(); i++) {
            if (bikes.get(i).getBikeID().equals(id)) {
                bikes.remove(i);
                System.out.println("Remove successful");
                displayBike();
                return true;
            }
        }
        System.out.println("No bike with id " + id + " found.");
        return false;
    }

}
