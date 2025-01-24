package case_study.view;

import java.time.Year;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validations {

    private Scanner sc = new Scanner(System.in);

    public String getName(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                String name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Error, name cannot be empty.");
                }
                name = name.replaceAll("[^A-Za-z\\s]", "");
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Error, name cannot consist only of special characters.");
                }
                name = name.toLowerCase().replaceAll("\\s+", " ");
                String[] words = name.split(" ");
                StringBuilder formattedName = new StringBuilder();
                for (String word : words) {
                    if (!word.isEmpty()) {
                        formattedName.append(word.substring(0, 1).toUpperCase())
                                .append(word.substring(1))
                                .append(" ");
                    }
                }
                return formattedName.toString().trim();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public double getFloat(String prompt) {
        float value = -1;
        while (value < 0) {
            try {
                System.out.print(prompt);
                value = Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }

    public double getInt(String prompt) {
        int value = -1;
        while (value < 0) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }

    public String checkLicensePlate(String prompt, String fileType) {
        while (true) {
            System.out.print(prompt);
            String licensePlate = sc.nextLine().trim();

            if (isValidLicensePlate(licensePlate, fileType)) {
                return licensePlate;
            } else {
                System.out.println("Invalid license plate format. Please try again.");
            }
        }
    }

    private boolean isValidLicensePlate(String licensePlate, String fileName) {
        String regex;
        if (fileName.equalsIgnoreCase("car.csv")) {
            regex = "^[0-9]{2}[A-B]-[0-9]{5}$";
        } else if (fileName.equalsIgnoreCase("truck.csv")) {
            regex = "^[0-9]{2}C-[0-9]{5}$";
        } else if (fileName.equalsIgnoreCase("moto.csv")) {
            regex = "^[0-9]{2}[A-Z]{1,2}-[0-9]{5}$";
        } else {
            return false;
        }
        return Pattern.matches(regex, licensePlate);
    }

    public boolean isDuplicateLicensePlate(String licensePlate, String fileName) {
        HashSet<String> licensePlates = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0) {
                    licensePlates.add(data[0].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return licensePlates.contains(licensePlate);
    }

    public String checkManufacturer(String prompt, String manufacturerFile) {
        HashSet<String> manufacturers = loadManufacturers(manufacturerFile);

        while (true) {
            System.out.print(prompt);
            String manufacturer = sc.nextLine().trim();
            if (manufacturers.contains(manufacturer)) {
                return manufacturer;
            } else {
                System.out.println("Manufacturer not found in the list. Please try again.");
            }
        }
    }

    private HashSet<String> loadManufacturers(String manufacturerFile) {
        HashSet<String> manufacturers = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(manufacturerFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 1) {
                    manufacturers.add(data[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading manufacturer file: " + e.getMessage());
        }
        return manufacturers;
    }

    public int checkYearOfManufacture(String prompt, String licensePlate) {
        int currentYear = Year.now().getValue();

        while (true) {
            try {
                System.out.print(prompt);
                int year = Integer.parseInt(sc.nextLine().trim());

                if (year > currentYear + 1) {
                    throw new IllegalArgumentException("Year cannot exceed " + (currentYear + 1) + ".");
                }

                if (licensePlate.matches("^[0-9]{2}B-[0-9]{5}$")) {
                    if (currentYear - year > 20) {
                        throw new IllegalArgumentException("Vehicles with plate 'B' cannot be older than 20 years.");
                    }
                }

                if (licensePlate.matches("^[0-9]{2}[A-X]{1,2}-[0-9]{5}$")) {
                    if (currentYear - year > 25) {
                        throw new IllegalArgumentException("Vehicles with plate 'X' cannot be older than 25 years.");
                    }
                }

                return year;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid year.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String checkAnswer(String prompt) {
        while (true) {
            System.out.print(prompt);
            String answer = sc.nextLine().trim().toLowerCase();
            if (answer.equals("yes") || answer.equals("no")) {
                return answer;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
