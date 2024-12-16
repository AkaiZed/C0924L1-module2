package ss8_clean_code.service;

import ss8_clean_code.model.Bike;
import ss8_clean_code.model.Customer;
import ss8_clean_code.view.Validations;

import java.time.LocalDate;

public class BikeService implements IBikeService {
    private static Bike[] bikes = new Bike[100];
    private static Customer[] customers = CustomerService.getCustomers();

    static {
        bikes[0] = new Bike("Bike-00", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 12), 15.0, customers[0]);
        bikes[1] = new Bike("Bike-01", LocalDate.of(2024, 12, 12), LocalDate.of(2024, 12, 14), 10.0, customers[1]);
        bikes[2] = new Bike("Bike-02", LocalDate.of(2024, 12, 15), LocalDate.of(2024, 12, 17), 12.5, customers[2]);
        bikes[3] = new Bike("Bike-03", LocalDate.of(2024, 12, 13), LocalDate.of(2024, 12, 15), 20.0, customers[3]);
        bikes[4] = new Bike("Bike-04", LocalDate.of(2024, 12, 14), LocalDate.of(2024, 12, 16), 14.5, customers[5]);
        bikes[5] = new Bike("Bike-05", LocalDate.of(2024, 12, 11), LocalDate.of(2024, 12, 13), 18.0, customers[4]);
        bikes[6] = new Bike("Bike-06", LocalDate.of(2024, 12, 16), LocalDate.of(2024, 12, 18), 22.0, customers[5]);
        bikes[7] = new Bike("Bike-07", LocalDate.of(2024, 12, 17), LocalDate.of(2024, 12, 19), 14.0, customers[3]);
        bikes[8] = new Bike("Bike-08", LocalDate.of(2024, 12, 18), LocalDate.of(2024, 12, 20), 16.5, customers[0]);
        bikes[9] = new Bike("Bike-09", LocalDate.of(2024, 12, 19), LocalDate.of(2024, 12, 21), 25.0, customers[6]);
    }

    @Override
    public Bike[] displayBike() {
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
        boolean isAdded = false;
        for (int i = 0; i < bikes.length; i++) {
            if (bikes[i] == null) {
                bikes[i] = bike;
                isAdded = true;
                break;
            }
        }
        if (isAdded) {
            System.out.println("Rental bill add successful");
        } else {
            System.out.println("Failed to add new bicycle. No available slots.");
        }
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
                    return;
                }
            }
            LocalDate startDate = LocalDate.parse(Validations.getDate("Enter start date"));
            LocalDate endDate;
            while (true) {
                endDate = LocalDate.parse(Validations.getDate("Enter end date"));
                if (endDate.isAfter(startDate)) {
                    break;
                } else {
                    System.out.println("End date must be after start date. Please try again.");
                }
            }
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
                        break;
                    }
                }
            }
            addBill(new Bike(id, startDate, endDate, price, customer));
            displayBike();
            return;
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
        for (Customer customer : customers) {
            if (customer != null && customer.getCustomerPhone().equals(phone)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public boolean removeBill(String id) {
        for (int i = 0; i < bikes.length; i++) {
            if (bikes[i] != null && bikes[i].getBikeID().equals(id)) {
                bikes[i] = null;
                System.out.println("Remove successful");
                displayBike();
                return true;
            }
        }
        System.out.println("No bike with id " + id + " found.");
        return false;
    }

}
