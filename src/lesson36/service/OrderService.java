package lesson36.service;

import lesson36.model.Order;
import lesson36.model.Room;
import lesson36.model.User;
import lesson36.repository.OrderRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private UserService userService = new UserService();
    private RoomService roomService = new RoomService();

    private void validateOrder()throws Exception{
        for(String sO : orderRepository.readOrdersFromDb()){
            for (String sF : sO.split(",")){
                if(sF.trim().isEmpty())
                    throw new Exception("Exception in method 'validateOrder'. Data Base of Order is crashed");
            }
        }
    }

    public ArrayList<Order> getOrders()throws Exception{
        validateOrder();
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<String> orderFields = new ArrayList<>();
        Order order;

        for(String sO : orderRepository.readOrdersFromDb()){
            for (String sF : sO.split(",")){
                orderFields.add(sF.trim());
            }

            order = new Order(Long.parseLong(orderFields.get(0)),
                             getUser(Long.parseLong(orderFields.get(1))),
                             getRoom(Long.parseLong(orderFields.get(2))),
                             new SimpleDateFormat("dd-MM-yyyy").parse(orderFields.get(3)),
                             new SimpleDateFormat("dd-MM-yyyy").parse(orderFields.get(4)),
                             Double.parseDouble(orderFields.get(5)));
            orders.add(order);
            orderFields.clear();
        }
        return orders;
    }

    private User getUser(long userId)throws Exception{
        ArrayList<User> users = userService.getUsers();
        for(User u : users){
            if(u.getId() == userId){
                return u;
            }
        }
        throw new Exception("Exception in method 'getUser'. User with ID: " + userId + " is not exist");
    }

    private Room getRoom(long roomId)throws Exception{
        ArrayList<Room> rooms = roomService.getRooms();
        for(Room r : rooms){
            if(r.getId() == roomId){
                return r;
            }
        }
        throw new Exception("Exception in method 'getRoom'. Room with ID: " + roomId + " is not exist");
    }

    private void validateNewOrder(Order order)throws Exception{
        for(Order o : getOrders()){
            if(o.equals(order)){
                throw new Exception("Exception in method 'validateNewOrder'. This order with ID: " + o.getId() + " is exist already");
            }
        }
    }

    public Order addOrder(Order order)throws Exception{
        validateNewOrder(order);
        Room room = new Room(order.getRoom().getId(), order.getRoom().getNumberOfGuests(), order.getRoom().getPrice(), order.getRoom().isBreakfastIncluded(), order.getRoom().isPetsAllowed(), order.getDateTo(), order.getRoom().getHotel());

        roomService.deleteRoom(order.getRoom().getId());

        roomService.addRoom(room);

        return orderRepository.addOrder(order);
    }

    private Order getOrderById(long orderId)throws Exception{
        ArrayList<Order> orders = getOrders();

        for(Order o : orders){
            if(o.getId() == orderId){
                return o;
            }
        }
        throw new Exception("Exception in method 'getOrderById'. Order with this ID: " + orderId + " is not exist");
    }

    public void deleteOrder(long orderId)throws Exception{
        Order order = getOrderById(orderId);
        ArrayList<Order> orders = getOrders();

        int index = 0;
        for(Order o : orders){
            if(o.getId() == orderId){
                break;
            }
            index++;
        }

        Room room = new Room(orderId, order.getRoom().getNumberOfGuests(), order.getRoom().getPrice(), order.getRoom().isBreakfastIncluded(), order.getRoom().isPetsAllowed(), new Date(), order.getRoom().getHotel());

        roomService.deleteRoom(order.getRoom().getId());

        roomService.addRoom(room);

        orderRepository.deleteOrder(index);
    }
}
