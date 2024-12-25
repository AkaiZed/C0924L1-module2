package ss9_list.service;

import ss9_list.model.Bike;

import java.util.ArrayList;

public interface IBikeService {
    public ArrayList<Bike> displayBike();

    public void addBill(Bike bike);

    public boolean removeBill(String id);
}
