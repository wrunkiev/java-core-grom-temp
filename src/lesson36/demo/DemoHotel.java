package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.model.Hotel;


public class DemoHotel {
    public static void main(String[] args)throws Exception {
        HotelController hotelController = new HotelController();

        Hotel hotel = new Hotel(hotelController.genIdHotel(), "Victory", "Ukraine", "Odessa", "Mayakovsky");

        //hotelController.addHotel(hotel);
        //hotelController.deleteHotel(2050472883);
        //hotelController.findHotelByName("A");
        System.out.println(hotelController.findHotelByName("A"));




    }
}
