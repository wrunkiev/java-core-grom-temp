package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.controller.OrderController;
import lesson36.controller.RoomController;
import lesson36.controller.UserController;
import lesson36.model.*;
import lesson36.service.UserService;

import java.text.SimpleDateFormat;
import java.util.*;

public class DemoOrder {
    public static void main(String[] args) throws Exception{
        OrderController orderController = new OrderController();
        RoomController roomController = new RoomController();
        //UserController userController = new UserController();
        UserService userService = new UserService();


        Date dateFrom = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2019");
        Date dateTo = new SimpleDateFormat("dd-MM-yyyy").parse("02-08-2019");

        Filter filter = new Filter(1, 30, true, false, dateFrom, null, null, null, null);
        Set<Room> tempRooms = roomController.findRooms(filter);
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.addAll(tempRooms);
        //System.out.println(Arrays.toString(rooms.toArray()));

        dateFrom = new SimpleDateFormat("dd-MM-yyyy").parse("02-02-2019");
        dateTo = new SimpleDateFormat("dd-MM-yyyy").parse("02-08-2019");

        orderController.bookRoom(userService.getUsers().get(0).getId(), rooms.get(0).getId(), dateFrom, dateTo);
    }
}
