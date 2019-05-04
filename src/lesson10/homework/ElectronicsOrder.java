package lesson10.homework;

import java.util.Date;

public class ElectronicsOrder extends Order{
    //fields
    private int guaranteeMonths;

    //constructor
    public ElectronicsOrder(String itemName,
                            Date dateCreated,
                            String shipFromCity,
                            String shipToCity,
                            int basePrice,
                            Customer customerOwned,
                            int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    //methods
    @Override
    public void validateOrder() {
        String[] cities = new String[]{"Киев", "Одесса", "Днепр", "Харьков"};
        boolean[] flags = new boolean[]{false, false, false, false};

        for(String city : cities){
            if(getShipFromCity() == city){
                flags[0] = true;
                break;
            }
        }

        for (String city : cities){
            if(getShipToCity() == city){
                flags[1] = true;
                break;
            }
        }

        if(getBasePrice() >= 100){
            flags[2] = true;
        }

        if(getCustomerOwned().getGender() == "Женский"){
            flags[3] = true;
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
        double shippedPrice;
        double totalPrice;

        if(getShipToCity() == "Киев" || getShipToCity() == "Одесса"){
            shippedPrice = 0.1 * getBasePrice();
        }
        else {
            shippedPrice = 0.15 * getBasePrice();
        }

        if(getBasePrice() > 1000){
            totalPrice = (getBasePrice() + shippedPrice)* 0.95;
            setTotalPrice(totalPrice);
        }
        else {
            totalPrice = getBasePrice() + shippedPrice;
            setTotalPrice(totalPrice);
        }
    }
}
