package ss8_clean_code.service;

import ss8_clean_code.model.Bicycle;
import ss8_clean_code.view.Validations;

import java.time.LocalDate;

public class BikeService implements IBikeService {
    private static Bicycle[] bikes = new Bicycle[10];

    static {
        bikes[0] = new Bicycle("Bike-00", LocalDate.of(2024, 12, 10), "Mountain", 15.0);
        bikes[1] = new Bicycle("Bike-01", LocalDate.of(2024, 12, 12), "Road", 10.0);
        bikes[2] = new Bicycle("Bike-02", LocalDate.of(2024, 12, 15), "Hybrid", 12.5);
        bikes[3] = new Bicycle("Bike-03", LocalDate.of(2024, 12, 13), "Electric", 20.0);
        bikes[4] = new Bicycle("Bike-04", LocalDate.of(2024, 12, 14), "Folding", 8.0);
    }

    @Override
    public Bicycle[] displayBike() {
        System.out.println("List of bicycles:");
        System.out.println("| ++ Bike ID ++ |      ++ Rental Date ++      |    ++ Type ++    |  ++ Price (USD) ++  |");
        System.out.println("|---------------|-----------------------------|------------------|---------------------|");
        for (Bicycle bike : bikes) {
            if (bike != null) {
                System.out.printf("| %-13s | %-27s | %-16s | %-19.2f |\n",
                        bike.getBikeID(), bike.getBikeDate(), bike.getBikeType(), bike.getBikePrice());
            }
        }
        return bikes;
    }

    @Override
    public void addBill(Bicycle bike) {
        boolean isAdded = false;
        for (int i = 0; i < bikes.length; i++) {
            if (bikes[i] == null) {
                bikes[i] = bike;
                isAdded = true;
                break;
            }
        }
        if (isAdded) {
            System.out.println("Added new bicycle: " + bike);
        } else {
            System.out.println("Failed to add new bicycle. No available slots.");
        }
    }

    public void addNew() {
        while (true) {
            String id = Validations.getIdBike("Enter bill id: ");
            if (isDuplicateId(id)) {
                if (!Validations.getYesNo("ID already exists. Try again? (yes/no): ")) {
                    System.out.println("Returning to the main menu...");
                    return;
                }
                continue;
            }
            String type = Validations.getName("Enter bike type: ");
            double price = Validations.getDouble("Enter bike price: ");
            String date = Validations.getDate("Enter rental date (YYYY-MM-DD)");
            Bicycle newBike = new Bicycle(id, LocalDate.parse(date), type, price);
            addBill(newBike);
            displayBike();
            return;
        }
    }

    private boolean isDuplicateId(String id) {
        for (Bicycle bike : bikes) {
            if (bike != null && bike.getBikeID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeBill(String id) {
        for (int i = 0; i < bikes.length; i++) {
            if (bikes[i] != null && bikes[i].getBikeID().equals(id)) {
                bikes[i] = null;
                System.out.println("Removed bicycle: " + bikes[i]);
                displayBike();
                return true;
            }
        }
        System.out.println("No bike with id " + id + " found.");
        return false;
    }

}
