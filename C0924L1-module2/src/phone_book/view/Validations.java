package phone_book.view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validations {

    private final Scanner sc = new Scanner(System.in);

    public String getPhone(String prompt) {
        while (true) {
            System.out.print(prompt);
            String phone = sc.nextLine().trim();
            if (phone.matches("^0\\d{9,10}$")) {
                return phone;
            } else {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại");
            }
        }
    }

    public String getAddress(String prompt) {
        while (true) {
            System.out.print(prompt);
            String address = sc.nextLine().trim().replaceAll("\\s*-\\s*", "-");
            if (!address.isEmpty()) {
                return address;
            } else {
                System.out.println("Địa chỉ không được để trống");
            }
        }
    }

    public String getValidDate(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                System.out.print("Nhập ngày sinh: ");
                int day = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Nhập tháng sinh: ");
                int month = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Nhập năm sinh: ");
                int year = Integer.parseInt(sc.nextLine().trim());

                if (month < 1 || month > 12) {
                    System.out.println("Lỗi nhập tháng. Vui lòng nhập từ tháng 1 đến 12");
                    continue;
                }

                if (month == 2) {
                    if (isLeapYear(year)) {
                        if (day < 1 || day > 29) {
                            System.out.println("Lỗi nhập ngày. Tháng 2 năm nhuận chỉ có 29 ngày");
                            continue;
                        }
                    } else {
                        if (day < 1 || day > 28) {
                            System.out.println("Lỗi nhập ngày. Tháng 2 năm không nhuận chỉ có 28 ngày");
                            continue;
                        }
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day < 1 || day > 30) {
                        System.out.println("Lỗi nhập ngày. Tháng này chỉ có 30 ngày");
                        continue;
                    }
                } else {
                    if (day < 1 || day > 31) {
                        System.out.println("Lỗi nhập ngày. Tháng này chỉ có 31 ngày");
                        continue;
                    }
                }

                LocalDate enteredDate;
                try {
                    enteredDate = LocalDate.of(year, month, day);
                    LocalDate today = LocalDate.now();
                    if (enteredDate.isAfter(today)) {
                        System.out.println("Lỗi nhập ngày. Ngày sinh không được lớn hơn ngày hiện tại");
                        continue;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Ngày không hợp lệ. Vui lòng thử lại");
                    continue;
                }

                return enteredDate.toString();
            } catch (NumberFormatException e) {
                System.out.println("Sai đầu vào. Vui lòng nhập 1 số hợp lệ");
            }
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public String getEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String email = sc.nextLine().trim();
            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                return email;
            } else {
                System.out.println("Email không hợp lệ. Vui lòng nhập lại");
            }
        }
    }

    public String getName(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                String name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Lỗi, tên không được để trống");
                }
                name = name.replaceAll("[^A-Za-z\\s]", "");
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Lỗi, tên không được chỉ chứa ký tự đặc biệt");
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


    public String checkAnswer(String prompt) {
        while (true) {
            System.out.print(prompt);
            String answer = sc.nextLine().trim().toLowerCase();
            if (answer.equals("yes") || answer.equals("no") || answer.equals("n") || answer.equals("y")) {
                return answer;
            } else {
                System.out.println("Vui lòng nhập 'yes' hoặc 'no'");
            }
        }
    }
}
