package ss8_clean_code.model;

import java.time.LocalDate;

public class Bicycle {
    private String bikeID;
    private LocalDate bikeDate;
    private String bikeType;
    private double bikePrice;

    public Bicycle(String bikeID, LocalDate bikeDate, String bikeType, double bikePrice) {
        this.bikeID = bikeID;
        this.bikeDate = bikeDate;
        this.bikeType = bikeType;
        this.bikePrice = bikePrice;
    }

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public LocalDate getBikeDate() {
        return bikeDate;
    }

    public void setBikeDate(LocalDate bikeDate) {
        this.bikeDate = bikeDate;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public double getBikePrice() {
        return bikePrice;
    }

    public void setBikePrice(double bikePrice) {
        this.bikePrice = bikePrice;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "bikeID='" + bikeID + '\'' +
                ", bikeDate=" + bikeDate +
                ", bikeType='" + bikeType + '\'' +
                ", bikePrice=" + bikePrice +
                '}';
    }
}
