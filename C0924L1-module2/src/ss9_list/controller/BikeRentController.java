package ss9_list.controller;

import ss9_list.service.BikeService;
import ss9_list.service.CustomerService;
import ss9_list.view.Menu;
import ss9_list.view.Validations;

public class BikeRentController extends Menu<String> {
    CustomerService customerService = new CustomerService();
    BikeService bikeService = new BikeService(customerService);
    static String[] displayMainMenu = {
            "Rental bill managerment",
            "Customer management",
            "Exit"
    };

    public BikeRentController() {
        super("-----------------------Menu-------------------", displayMainMenu);
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                billMng();
                break;
            case 2:
                cusMng();
                break;
            case 3:
                System.out.println("Exitting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice, please try again");
        }
    }

    private void billMng() {
        String[] billOptions = {
                "Shows the bikes being rented",
                "Add a bike rental bill",
                "Delete a bike rental bill",
                "Edit a bike rental bill",
                "Return to main menu",
        };
        Menu billMenu = new Menu("-----------------Rental Bill Mangerment------------", billOptions) {
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
                        main(displayMainMenu);
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                }
            }
        };
        billMenu.run();
    }

    private void cusMng() {
        String[] cusOptions = {
                "Show the list of customers",
                "Add a customer rental bill",
                "Delete a customer rental bill",
                "Edit a customer rental bill",
                "Return to main menu",
        };
        Menu cusMenu = new Menu("---------------Customer Management------------", cusOptions) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        customerService.displayCustomer();
                        break;
                    case 2:
                        customerService.addCus();
                        break;
                    case 3:
                        customerService.displayCustomer();
                        String phoneNumb = Validations.getPhoneNumber("Enter the phone number you want to delete: ");
                        customerService.deleteCustomer(phoneNumb);
                        break;
                    case 4:
                        break;
                    case 5:
                        main(displayMainMenu);
                    default:
                        System.out.println("Invalid choice, please try again");
                }
            }
        };
        cusMenu.run();
    }

//    public void editCusOptions() {
//        String[] editOptions = {
//                "Edit name",
//                "Edit age",
//                "Edit citizen id",
//                "Edit phone number",
//                "Edit address",
//                "Edit all",
//                "Exit"
//        };
//        Menu editMenu = new Menu("---------------Edit Customer------------", editOptions) {
//            @Override
//            public void execute(int choice) {
//                switch (choice) {
//                    case 1:
//                        break;
//                    case 2:
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                    case 5:
//                        break;
//                    case 6:
//                        break;
//                    case 7:
//                        main(displayMainMenu);
//                    default:
//                        System.out.println("Invalid choice, please try again");
//                        break;
//                }
//            }
//        };
//        editMenu.run();
//    }

    public static void main(String[] args) {
        BikeRentController bikeRentController = new BikeRentController();
        bikeRentController.run();
    }
}