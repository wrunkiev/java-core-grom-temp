package lesson36.controller;

import lesson36.model.*;
import lesson36.service.OrderService;
import lesson36.service.RoomService;
import lesson36.service.UserService;
import java.util.Date;
import java.util.Random;

public class OrderController {
    private OrderService orderService = new OrderService();

    public long genIdOrder()throws Exception{
        Random random = new Random();
        boolean flag;
        long id;

        do{
            flag = true;
            id = random.nextInt();
            for(Order o : orderService.getOrders()){
                if(o.getId() == id || id < 0){
                    flag = false;
                }
            }
        }while (!flag);
        return id;
    }

    private Room getRoomById(long roomId)throws Exception{
        RoomService roomService = new RoomService();
        for(Room r : roomService.getRooms()){
            if(r.getId() == roomId){
                return r;
            }
        }
        throw new Exception("Exception in method 'getRoomById'. Room with ID: " + roomId + " can't be find");
    }

    private User getUserById(long userId)throws Exception{
        UserService userService = new UserService();
        for(User u : userService.getUsers()){
            if(u.getId() == userId){
                return u;
            }
        }
        throw new Exception("Exception in method 'getUserById'. User with ID: " + userId + " can't be find");
    }

    public Order bookRoom(long userId, long roomId, Date dateFrom, Date dateTo)throws Exception{
        Room room = getRoomById(roomId);
        User user = getUserById(userId);

        if(dateFrom.getTime() < room.getDateAvailableFrom().getTime()){
            throw new Exception("Exception in method 'bookRoom'. Date of reservation of room" + roomId + " can't be les then Data of available.");
        }

        Order order = new Order(genIdOrder(), user, room, dateFrom, dateTo, room.getPrice());
        return orderService.addOrder(order);
    }

    public void cancelReservation(long orderId)throws Exception{
        orderService.deleteOrder(orderId);
    }
}
