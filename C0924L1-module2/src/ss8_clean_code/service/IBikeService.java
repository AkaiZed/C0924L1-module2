package ss8_clean_code.service;

import ss8_clean_code.model.Bicycle;

public interface IBikeService {
    public Bicycle[] displayBike();
    public void addBill( Bicycle bike);
    public boolean removeBill( String id);
}
