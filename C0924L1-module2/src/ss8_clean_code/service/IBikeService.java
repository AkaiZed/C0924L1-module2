package ss8_clean_code.service;

import ss8_clean_code.model.Bike;

public interface IBikeService {
    public Bike[] displayBike();

    public void addBill(Bike bike);

    public boolean removeBill(String id);
}
