package ss8_clean_code.controller;

import java.time.LocalDate;

import ss8_clean_code.model.Bicycle;
import ss8_clean_code.service.BikeService;
import ss8_clean_code.view.Menu;
import ss8_clean_code.view.Validations;

public class BikeRentController extends Menu<String> {
    BikeService bikeService = new BikeService();
    static String[] displayMainMenu = {
            "Shows the bikes being rented",
            "Add a bike rental bill",
            "Delete a bike rental bill",
            "Edit a bike rental bill",
            "Exit"
    };

    public BikeRentController() {
        super("-----------------------Menu-------------------", displayMainMenu);
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                bikeService.displayBike();
                break;
            case 2:
                bikeService.displayBike();
                bikeService.addNew();
                break;
            case 3:
                bikeService.displayBike();
                String id = Validations.getIdBike("Enter ID you want to delete: ");
                bikeService.removeBill(id);
                break;
            case 4:
                break;
            case 5:
                System.out.println("Exitting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice, please try again");
        }
    }

    public static void main(String[] args) {
        BikeRentController bikeRentController = new BikeRentController();
        bikeRentController.run();
    }
}