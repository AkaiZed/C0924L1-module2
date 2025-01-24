package phone_book.model;

import phone_book.view.Validations;

import java.io.*;
import java.util.*;

public class ListPhoneManagement {

    private final List<ListPhone> danhBa = new ArrayList<>();
    private final Validations validations = new Validations();

    public void hienThiDanhBa() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/phone_book/data/contacts.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.printf("Số điện thoại: %s | Nhóm: %s | Họ tên: %s | Giới tính: %s | Địa chỉ: %s\n",
                        data[0], data[1], data[2], data[3], data[4]);
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file danh bạ. Vui lòng kiểm tra file 'data/contacts.csv'");
        }
        if (validations.checkAnswer("Bạn có muốn thêm mới danh bạ không? (yes/no): ").equals("yes")) {
            themMoiDanhBa();
        } else {
            System.out.println("Quay lại menu chính.");
        }
    }

    public void themMoiDanhBa() {
        String phone;
        do {
            phone = validations.getPhone("Nhập số điện thoại (10 hoặc 11 số, bắt đầu từ số 0): ");
            if (checkTrungSDT(phone)) {
                System.out.println("Số điện thoại này đã tồn tại. Vui lòng nhập lại.");
            }
        } while (checkTrungSDT(phone));

        String group = validations.getName("Nhập nhóm danh bạ: ");
        String name = validations.getName("Nhập họ tên: ");
        String gender = validations.checkAnswer("Nhập giới tính (yes là nam, no là nữ): ").equals("yes") ? "Nam" : "Nữ";
        String address = validations.getAddress("Nhập địa chỉ: ");
        String birthDate = validations.getValidDate("Nhập ngày sinh (dd/MM/yyyy): ");

        String email;
        do {
            email = validations.getEmail("Nhập email: ");
            if (checkTrungEmail(email)) {
                System.out.println("Email này đã tồn tại. Vui lòng nhập lại");
            }
        } while (checkTrungEmail(email));

        ListPhone newContact = new ListPhone(phone, group, name, gender, address, birthDate, email);
        danhBa.add(newContact);

        System.out.println("Đã thêm danh bạ mới thành công: ");
        System.out.println(newContact);
    }

    private boolean checkTrungSDT(String phone) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/phone_book/data/contacts.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(phone)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể kiểm tra số điện thoại từ file");
        }
        return false;
    }

    private boolean checkTrungEmail(String email) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/phone_book/data/contacts.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[6].equalsIgnoreCase(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể kiểm tra email từ file");
        }
        return false;
    }

    public void capNhatDanhBa() {
        String phone = validations.getPhone("Nhập số điện thoại cần cập nhật: ");
        List<ListPhone> danhBa = docDanhBa();
        ListPhone danhBaTimThay = null;

        for (ListPhone danhBaItem : danhBa) {
            if (danhBaItem.getPhone().equals(phone)) {
                danhBaTimThay = danhBaItem;
                break;
            }
        }

        if (danhBaTimThay == null) {
            System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            if (validations.checkAnswer("Bạn có muốn nhập lại không? (yes/no): ").equals("yes")) {
                capNhatDanhBa();
            } else {
                System.out.println("Quay lại menu chính.");
            }
            return;
        }

        System.out.println("Danh bạ cần cập nhật: " + danhBaTimThay);
        danhBaTimThay.setGroup(validations.getName("Nhập nhóm mới: "));
        danhBaTimThay.setName(validations.getName("Nhập họ tên mới: "));
        danhBaTimThay.setGender(validations.checkAnswer("Giới tính mới (yes: Nam, no: Nữ): ").equals("yes") ? "Nam" : "Nữ");
        danhBaTimThay.setAddress(validations.getAddress("Nhập địa chỉ mới: "));
        danhBaTimThay.setBirthDate(validations.getValidDate("Nhập ngày sinh mới (dd/MM/yyyy): "));
        String newEmail;
        do {
            newEmail = validations.getEmail("Nhập email mới: ");
        } while (kiemTraEmailTrung(danhBa, newEmail));
        danhBaTimThay.setEmail(newEmail);

        ghiDanhBa(danhBa);
        System.out.println("Cập nhật thành công.");
    }

    private boolean kiemTraEmailTrung(List<ListPhone> danhBa, String email) {
        for (ListPhone danhBaItem : danhBa) {
            if (danhBaItem.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email này đã tồn tại. Vui lòng nhập email khác");
                return true;
            }
        }
        return false;
    }

    public void xoaDanhBa() {
        String phone = validations.getPhone("Nhập số điện thoại cần xóa: ");
        List<ListPhone> danhBa = docDanhBa();
        ListPhone danhBaTimThay = null;

        for (ListPhone danhBaItem : danhBa) {
            if (danhBaItem.getPhone().equals(phone)) {
                danhBaTimThay = danhBaItem;
                break;
            }
        }

        if (danhBaTimThay == null) {
            System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            if (validations.checkAnswer("Bạn có muốn nhập lại không? (yes/no): ").equals("yes")) {
                xoaDanhBa();
            } else {
                System.out.println("Quay lại menu chính.");
            }
            return;
        }

        System.out.println("Danh bạ cần xóa: " + danhBaTimThay);
        if (validations.checkAnswer("Bạn có chắc muốn xóa không? (yes/no): ").equals("yes")) {
            danhBa.remove(danhBaTimThay);
            ghiDanhBa(danhBa);
            System.out.println("Đã xóa danh bạ.");
        } else {
            System.out.println("Hủy thao tác xóa. Quay lại menu chính");
        }
    }

    public void canhBaoLuuDanhBa() {
        if (validations.checkAnswer("Bạn có muốn lưu danh bạ vào file không? (yes/no): ").equals("yes")) {
            luuDanhBaVaoFile();
            System.out.println("Đã cập nhật file thành công");
        } else {
            System.out.println("Quay lại menu chính. Không có thay đổi nào được lưu");
        }
    }

    private List<ListPhone> docDanhBa() {
        List<ListPhone> danhBa = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/phone_book/data/contacts.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                danhBa.add(new ListPhone(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file danh bạ. Vui lòng kiểm tra lại");
        }
        return danhBa;
    }

    private void ghiDanhBa(List<ListPhone> danhBa) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/phone_book/data/contacts.csv"))) {
            bw.write("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email\n");
            for (ListPhone contact : danhBa) {
                bw.write(String.join(",", contact.getPhone(), contact.getGroup(), contact.getName(), contact.getGender(),
                        contact.getAddress(), contact.getBirthDate(), contact.getEmail()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Không thể ghi dữ liệu vào file");
        }
    }

    public void luuDanhBaVaoFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/phone_book/data/contacts.csv", true))) {
            for (ListPhone contact : danhBa) {
                bw.write(String.join(",", contact.getPhone(), contact.getGroup(), contact.getName(), contact.getGender(),
                        contact.getAddress(), contact.getBirthDate(), contact.getEmail()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Không thể ghi dữ liệu vào file");
        }
    }

    public void timKiemDanhBa() {
        String phone = validations.getPhone("Nhập số điện thoại để tìm kiếm: ");
        List<ListPhone> danhBa = docDanhBa();

        for (ListPhone danhBaItem : danhBa) {
            if (danhBaItem.getPhone().equals(phone)) {
                System.out.printf("Số điện thoại: %s | Nhóm: %s | Họ tên: %s | Giới tính: %s | Địa chỉ: %s | Ngày sinh: %s | Email: %s%n",
                        danhBaItem.getPhone(), danhBaItem.getGroup(), danhBaItem.getName(), danhBaItem.getGender(),
                        danhBaItem.getAddress(), danhBaItem.getBirthDate(), danhBaItem.getEmail());
                break;
            } else {
                System.out.println("Không tìm thấy danh bạ với số điện thoại: " + phone);

            }
        }

    }

}
