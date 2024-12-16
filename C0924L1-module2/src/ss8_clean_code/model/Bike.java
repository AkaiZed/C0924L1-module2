package ss8_clean_code.model;

import java.time.LocalDate;

public class Bike {
    private String bikeID;
    private LocalDate startDate;
    private LocalDate endDate;
    private double bikePrice;
    private Customer cusName;

    public Bike(String bikeID, LocalDate startDate, LocalDate endDate, double bikePrice, Customer cusName) {
        this.bikeID = bikeID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bikePrice = bikePrice;
        this.cusName = cusName;
    }

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getBikePrice() {
        return bikePrice;
    }

    public void setBikePrice(double bikePrice) {
        this.bikePrice = bikePrice;
    }

    public Customer getCusName() {
        return cusName;
    }

    public void setCusName(Customer cusName) {
        this.cusName = cusName;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "bikeID='" + bikeID + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", bikePrice=" + bikePrice +
                ", customerName=" + cusName +
                '}';
    }
}
