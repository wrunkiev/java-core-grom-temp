package lesson36.demo;

import lesson36.controller.RoomController;
import lesson36.model.Hotel;
import lesson36.model.Room;
import lesson36.repository.RoomRepository;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoRoom {
    public static void main(String[] args)throws Exception {
        Hotel hotel = new Hotel(5, "Victory", "Ukraine", "Odessa", "Mayakovsky");
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse("36-07-2019");
        RoomController roomController = new RoomController();
        Room room = new Room(roomController.genIdRoom(), 3, 340, true, false, date, hotel);

        roomController.addRoom(room);

        //roomController.deleteRoom(3);
    }
}
