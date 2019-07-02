package lesson26.homework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {


    public static ArrayList<Order> useList(){
        Order order1 = new Order(1, 34, "USD", "Phone", "1234");
        Order order2 = new Order(2, 57, "UAH", "Nokia", "3454");
        Order order3 = new Order(3, 124, "USD", "Sony", "5467");
        Order order4 = new Order(4, 345, "RUR", "Samsung", "3490");
        Order order5 = new Order(5, 76, "USD", "TV", "5445");

        ArrayList<Order> list = new ArrayList<>();
        list.add(order1);
        list.add(1, order2);
        list.clear();
        list.add(order3);
        list.add(order4);
        list.add(order5);
        list.remove(0);
        list.remove(order2);

        ArrayList<Order> list1 = new ArrayList<>();
        list1.add(order2);
        list1.add(order3);
        list1.add(order4);


        list.addAll(list1);

        List<Order> list2 =  list.subList(1,4);

        list.set(0, order4);
        boolean flag = list.contains(order2);

        list.toArray();

        return list;
    }
}
