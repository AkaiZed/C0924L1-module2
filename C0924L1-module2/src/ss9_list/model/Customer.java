package ss9_list.model;

public class Customer {
    private String customerName;
    private int customerAge;
    private String citizenID;
    private String customerPhone;
    private String customerAddress;

    public Customer(String customerName, int customerAge, String citizenID, String customerPhone, String customerAddress) {
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.citizenID = citizenID;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public String getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(String citizenID) {
        this.citizenID = citizenID;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerAge=" + customerAge +
                ", citizenID='" + citizenID + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
