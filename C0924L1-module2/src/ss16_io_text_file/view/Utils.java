package ss16_io_text_file.view;

import java.util.Scanner;

public class Utils {

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

    public double getDouble(String prompt) {
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

    public String checkIdIT(String prompt) {
        String id;
        do {
            System.out.print(prompt);
            id = sc.nextLine().trim();
        } while (!id.matches("IT\\d{4}"));
        return id;
    }

    public String checkIdBiz(String prompt) {
        String id;
        do {
            System.out.print(prompt);
            id = sc.nextLine().trim();
        } while (!id.matches("BZ\\d{4}"));
        return id;
    }
}
