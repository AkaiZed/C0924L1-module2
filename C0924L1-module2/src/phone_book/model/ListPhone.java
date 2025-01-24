package phone_book.model;

public class ListPhone {
    private String phone;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String birthDate;
    private String email;

    public ListPhone(String phone, String group, String name, String gender, String address, String birthDate, String email) {
        this.phone = phone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Danh sách mới: " +
                "Số điện thoại: " + phone + "| " +
                "Họ và tên: " + name + "| " +
                "Giới tính: " + gender + "| " +
                "Địa chỉ: " + address + "| " +
                "Ngày sinh: " + birthDate + "| " +
                "Email: " + email + "\n";
    }
}
