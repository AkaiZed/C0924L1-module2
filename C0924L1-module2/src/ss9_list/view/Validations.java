package ss9_list.view;

import java.time.LocalDate;
import java.util.Scanner;

public class Validations {
    private static final Scanner sc = new Scanner(System.in);

    public static String getName(String mess) {
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

    public static String getPhoneNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            String phoneNumber = sc.nextLine().trim();
            if (isValidPhoneNumber(phoneNumber)) {
                return phoneNumber;
            } else {
                System.out.println("Invalid phone number. It must be 10 digits and start with 0.");
            }
        }
    }

    public static String getCitizenId(String prompt) {
        while (true) {
            System.out.print(prompt);
            String citizenId = sc.nextLine().trim();
            if (citizenId.matches("0\\d{11}")) {
                return citizenId;
            } else {
                System.out.println("Invalid citizen id. It must be 10 digits and start with 0.");
            }
        }
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("0\\d{9}");
    }

    public static String getIdBike(String prompt) {
        while (true) {
            System.out.print(prompt);
            String id = sc.nextLine().trim();
            if (id.matches("Bike-\\d{2}")) {
                return id;
            } else {
                System.out.println("Invalid format. Customer ID must be in the format Bike-YY, where YY is a number between 00 and 99.");
            }
        }
    }

    public static boolean getYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("no")) {
                return Boolean.parseBoolean(input);
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'");
            }
        }
    }

    public static double getDouble(String prompt) {
        double value = -1;
        while (value < 0) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }

    public static long getLong(String prompt) {
        long value = -1;
        while (value < 0) {
            try {
                System.out.print(prompt);
                value = Long.parseLong(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String getStartDate(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                System.out.print("Enter day: ");
                int day = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Enter month: ");
                int month = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Enter year: ");
                int year = Integer.parseInt(sc.nextLine().trim());

                if (month < 1 || month > 12) {
                    System.out.println("Invalid month. Please enter a value between 1 and 12.");
                    continue;
                }

                if (month == 2) {
                    if (isLeapYear(year)) {
                        if (day < 1 || day > 29) {
                            System.out.println("Invalid day. February in a leap year has 29 days.");
                            continue;
                        }
                    } else {
                        if (day < 1 || day > 28) {
                            System.out.println("Invalid day. February has 28 days in a non-leap year.");
                            continue;
                        }
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day < 1 || day > 30) {
                        System.out.println("Invalid day. This month has 30 days.");
                        continue;
                    }
                } else {
                    if (day < 1 || day > 31) {
                        System.out.println("Invalid day. This month has 31 days.");
                        continue;
                    }
                }

                LocalDate enteredDate;
                try {
                    enteredDate = LocalDate.of(year, month, day);
                } catch (Exception e) {
                    System.out.println("Invalid date. Please try again.");
                    continue;
                }
                return enteredDate.toString();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        }
    }

    public static String getEndDate(String prompt, LocalDate startDate) {
        while (true) {
            try {
                System.out.println(prompt);
                System.out.print("Enter day: ");
                int day = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Enter month: ");
                int month = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Enter year: ");
                int year = Integer.parseInt(sc.nextLine().trim());

                if (month < 1 || month > 12) {
                    System.out.println("Invalid month. Please enter a value between 1 and 12.");
                    continue;
                }

                if (month == 2) {
                    if (isLeapYear(year)) {
                        if (day < 1 || day > 29) {
                            System.out.println("Invalid day. February in a leap year has 29 days.");
                            continue;
                        }
                    } else {
                        if (day < 1 || day > 28) {
                            System.out.println("Invalid day. February has 28 days in a non-leap year.");
                            continue;
                        }
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day < 1 || day > 30) {
                        System.out.println("Invalid day. This month has 30 days.");
                        continue;
                    }
                } else {
                    if (day < 1 || day > 31) {
                        System.out.println("Invalid day. This month has 31 days.");
                        continue;
                    }
                }

                LocalDate enteredDate;
                try {
                    enteredDate = LocalDate.of(year, month, day);
                } catch (Exception e) {
                    System.out.println("Invalid date. Please try again.");
                    continue;
                }

                if (enteredDate.isBefore(startDate)) {
                    System.out.println("End date must be the same as or after the start date. Please try again.");
                    continue;
                }

                return enteredDate.toString();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        }
    }

}


