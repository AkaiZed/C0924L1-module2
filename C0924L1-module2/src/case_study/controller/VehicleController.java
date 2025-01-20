package case_study.controller;

import case_study.service.VehicleManagement;
import case_study.view.Menu;
import ss16_io_text_file.view.Validations;

public class VehicleController extends Menu {
    static String[] options = {
            "Add New Vehicle",
            "Display Vehicle",
            "Delete Vehicle",
            "Exit"
    };

    public VehicleController() {
        super("------------------Manage Vehicle----------------", options);
    }

    Validations data = new Validations();
    VehicleManagement vehicleManagement = new VehicleManagement();

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                addVehicle();
                break;
            case 2:
                displayVehicle();
                break;
            case 3:
                deleteVehicle();
                break;
            case 4:
                System.exit(0);
            default:
                throw new AssertionError();
        }
    }

    private void addVehicle() {
        String[] addOptions = {
                "Add Truck",
                "Add Car",
                "Add Moto",
                "Return to main menu"
        };

        Menu<String> addMenu = new Menu<String>("------------------Add Vehicle----------------", addOptions) {
            @Override
            public void execute(int addChoice) {
                switch (addChoice) {
                    case 1:
                        vehicleManagement.addVehicles("src/case_study/data/truck.csv");
                        break;
                    case 2:
                        vehicleManagement.addVehicles("src/case_study/data/car.csv");
                        break;
                    case 3:
                        vehicleManagement.addVehicles("src/case_study/data/moto.csv");
                        break;
                    case 4:
                        System.out.println("Exiting add student menu...");
                        main(options);
                    default:
                        System.out.println("Invalid choice, please try again");
                        ;
                }
            }
        };
        addMenu.run();
    }

    private void displayVehicle() {
        String[] displayOptions = {
                "Display Truck",
                "Display Car",
                "Display Moto",
                "Return to main menu"
        };

        Menu<String> displayMenu = new Menu<String>("------------------Add Vehicle----------------", displayOptions) {
            @Override
            public void execute(int addChoice) {
                switch (addChoice) {
                    case 1:
                        vehicleManagement.displayVehicleList("src/case_study/data/truck.csv");
                        break;
                    case 2:
                        vehicleManagement.displayVehicleList("src/case_study/data/car.csv");
                        break;
                    case 3:
                        vehicleManagement.displayVehicleList("src/case_study/data/moto.csv");
                        break;
                    case 4:
                        System.out.println("Exiting add student menu...");
                        main(options);
                    default:
                        System.out.println("Invalid choice, please try again");
                        ;
                }
            }
        };
        displayMenu.run();
    }

    private void deleteVehicle() {
        String[] deleteOptions = {
                "Delete Truck",
                "Delete Car",
                "Delete Moto",
                "Return to main menu"
        };
        Menu<String> deleteMenu = new Menu<String>("------------------Delete Vehicle----------------", deleteOptions) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        vehicleManagement.deleteVehicle("src/case_study/data/truck.csv");
                        break;
                    case 2:
                        vehicleManagement.deleteVehicle("src/case_study/data/car.csv");
                        break;
                    case 3:
                        vehicleManagement.deleteVehicle("src/case_study/data/moto.csv");
                        break;
                    case 4:
                        System.out.println("Exiting delete student menu...");
                        main(options);
                    default:
                        System.out.println("Invalid choice, please try again");

                }
            }
        };
        deleteMenu.run();
    }

    public static void main(String[] args) {
        new VehicleController().run();
    }
}
