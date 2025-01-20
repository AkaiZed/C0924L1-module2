package case_study.service;

import case_study.view.Validations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleManagement implements IVehicleManagement {

    private static final Validations validations = new Validations();

    @Override
    public void addVehicles(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String plate;
            while (true) {
                plate = validations.checkLicensePlate("Enter license plate: ", fileName);
                if (validations.isDuplicateLicensePlate(plate, fileName)) {
                    System.out.println("License plate already exists. Please try again.");
                } else {
                    break;
                }
            }

            String manufacturer = validations.checkManufacturer("Enter manufacturer: ", "manufacturer.csv");
            int year = validations.checkYearOfManufacture("Enter year of manufacture: ", plate);
            String owner = validations.getName("Enter owner's name: ");

            String additionalInfo = "";
            if (fileName.equalsIgnoreCase("truck.csv")) {
                additionalInfo = String.valueOf(validations.getFloat("Enter weight: "));
            } else if (fileName.equalsIgnoreCase("car.csv")) {
                additionalInfo = validations.getName("Enter vehicle type: ") + "," + validations.getInt("Enter number of seats: ");
            } else if (fileName.equalsIgnoreCase("moto.csv")) {
                additionalInfo = String.valueOf(validations.getFloat("Enter capacity: "));
            }

            String record = plate + "," + manufacturer + "," + year + "," + owner + "," + additionalInfo;
            writer.write(record);
            writer.newLine();
            System.out.println("Vehicle added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    @Override
    public void displayVehicleList(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("---- Displaying Vehicles from " + fileName + " ----");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    @Override
    public void deleteVehicle(String fileName) {
        Scanner sc = new Scanner(System.in);
        String plate = validations.checkLicensePlate("Enter license plate to delete: ", fileName);

        List<String> records = new ArrayList<>();
        String vehicleToDelete = null;
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(plate)) {
                    vehicleToDelete = line;
                    found = true;
                } else {
                    records.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        if (!found) {
            System.out.println("License plate not found!");
            return;
        }

        System.out.println("Vehicle found: " + vehicleToDelete);
        String answer = validations.checkAnswer("Are you sure you want to delete this vehicle? (yes/no): ");

        if (answer.equalsIgnoreCase("yes")) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (String record : records) {
                    writer.write(record);
                    writer.newLine();
                }
                System.out.println("Vehicle deleted successfully!");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        } else {
            System.out.println("Delete operation canceled.");
        }
    }
}
