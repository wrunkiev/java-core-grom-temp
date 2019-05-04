package lesson10.homework;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Сергей", "Киев", "Мужской");
        Order order1 = new ElectronicsOrder("Телефон",
                null,
                "Днепр",
                "Киев",
                345,
                customer1,
                12);

        Customer customer2 = new Customer("Наташа", "Житомир", "Женский");
        Order order2 = new ElectronicsOrder("Холодильник",
                new Date(),
                "Николаев",
                "Житомир",
                3454,
                customer2,
                24);

        Customer customer3 = new Customer("Глеб", "Одесса", "Мужской");
        Order order3 = new FurnitureOrder("Шкаф",
                null,
                "Львов",
                "Одесса",
                13454,
                customer3,
                "23456");

        Customer customer4 = new Customer("Дарья", "Харьков", "Женский");
        Order order4 = new FurnitureOrder("Сервант",
                new Date(),
                "Днепр",
                "Харьков",
                27454,
                customer4,
                "345");

        Order[] orders = new Order[]{order1, order2, order3, order4};

        // Если город откуда заказ не в списке городов
        System.out.println("Если город откуда заказ не в списке городов");
        customer1 = new Customer("Сергей", "Киев", "Женский");
        order1 = new ElectronicsOrder("Телефон",
                null,
                "Львов",
                "Киев",
                345,
                customer1,
                12);

        order1.confirmShipping();
        order1.validateOrder();
        if(order1.getDateConfirmed() != null){
            order1.calculatePrice();
        }
        System.out.println(order1.getTotalPrice());

        // Если город куда заказ не в списке городов
        System.out.println("Если город куда заказ не в списке городов");
        customer1 = new Customer("Сергей", "Киев", "Женский");
        order1 = new ElectronicsOrder("Телефон",
                null,
                "Киев",
                "Львов",
                345,
                customer1,
                12);

        order1.confirmShipping();
        order1.validateOrder();
        if(order1.getDateConfirmed() != null){
            order1.calculatePrice();
        }
        System.out.println(order1.getTotalPrice());

        // Если у заказчика пол мужской
        System.out.println("Если у заказчика пол мужской");
        customer1 = new Customer("Сергей", "Киев", "Мужской");
        order1 = new ElectronicsOrder("Телефон",
                null,
                "Киев",
                "Киев",
                345,
                customer1,
                12);

        order1.confirmShipping();
        order1.validateOrder();
        if(order1.getDateConfirmed() != null){
            order1.calculatePrice();
        }
        System.out.println(order1.getTotalPrice());

        // Если все ок
        System.out.println("Все ок");
        customer1 = new Customer("Сергей", "Киев", "Женский");
        order1 = new ElectronicsOrder("Телефон",
                null,
                "Киев",
                "Киев",
                345,
                customer1,
                12);

        order1.confirmShipping();
        order1.validateOrder();
        if(order1.getDateConfirmed() != null){
            order1.calculatePrice();
        }
        System.out.println(order1.getTotalPrice());
    }
}
