package lesson29.homework;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static Set<Order> useHashSet(){
        Set<Order> orders1 = new HashSet<>();
        Order order1 = new Order(1, 10, "USD", "Nokia", "art1");
        Order order2 = new Order(2, 34, "UAH", "Samsung", "art2");
        Order order3 = new Order(3, 56, "RUR", "Sony", "art3");
        Order order4 = new Order(4, 130, "USD", "Asus", "art4");
        Order order5 = new Order(5, 78, "USD", "Acer", "art5");

        orders1.add(order1);
        orders1.add(order2);
        orders1.add(order3);
        orders1.add(order4);
        orders1.add(order5);

        orders1.remove(order1);


        Set<Order> orders2 = new HashSet<>();
        orders2.add(order1);
        orders2.add(order2);
        orders2.add(order3);
        orders2.add(order4);
        orders2.add(order5);

        orders1.retainAll(orders2);

        Object[] orders3 =  orders1.toArray();

        int size = orders1.size();

        return orders1;
    }
}
