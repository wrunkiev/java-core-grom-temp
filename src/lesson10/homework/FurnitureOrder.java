package lesson10.homework;

import java.util.Date;

public class FurnitureOrder extends Order {
    //fields
    private String furnitureCode;

    //constructor
    public FurnitureOrder(String itemName,
                          Date dateCreated,
                          String shipFromCity,
                          String shipToCity,
                          int basePrice,
                          Customer customerOwned,
                          String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        boolean[] flags = new boolean[]{false, false, false};

        if(getShipFromCity() == "Киев" || getShipFromCity() == "Львов"){
            flags[0] = true;
        }

        if(getBasePrice() >= 500){
            flags[1] = true;
        }

        if(getCustomerOwned().getName() != "Тест"){
            flags[2] = true;
        }

        setDateConfirmed(new Date());
        for(boolean flag : flags){
            if(flag == false){
                setDateConfirmed(null);
                break;
            }
        }
    }

    @Override
    public void calculatePrice() {
        double totalPrice;
        double shippedPrice;
        if(getBasePrice() < 5000){
            shippedPrice = 0.05 * getBasePrice();
        }
        else {
            shippedPrice = 0.02 * getBasePrice();
        }
        totalPrice = getBasePrice() + shippedPrice;
        setTotalPrice(totalPrice);
    }
}
