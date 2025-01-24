package phone_book.controller;

import case_study.view.Menu;
import phone_book.model.ListPhoneManagement;

public class PhoneBookController extends Menu {
    static String[] options = {
            "Xem danh sách",
            "Thêm mới",
            "Cập nhật",
            "Xóa",
            "Tìm kiếm",
            "Đọc từ file",
            "Ghi vào file",
            "Thoát"
    };

    public PhoneBookController() {
        super("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----", options);
    }

    @Override
    public void execute(int choice) {
        ListPhoneManagement phoneManagement = new ListPhoneManagement();

        switch (choice) {
            case 1:
                System.out.println("---- DANH SÁCH DANH BẠ ----");
                phoneManagement.hienThiDanhBa();
                break;
            case 2:
                phoneManagement.themMoiDanhBa();
                break;
            case 3:
                phoneManagement.capNhatDanhBa();
                break;
            case 4:
                phoneManagement.xoaDanhBa();
                break;
            case 5:
                phoneManagement.timKiemDanhBa();
                break;
            case 6:
                phoneManagement.canhBaoLuuDanhBa();
                break;
            case 7:
                phoneManagement.luuDanhBaVaoFile();
                break;
            case 8:
                System.out.println("Đang thoát...");
                System.exit(0);
            default:
                System.out.println("Lỗi, vui lòng thử lại");
        }
    }

    public static void main(String[] args) {
        new PhoneBookController().run();
    }
}
