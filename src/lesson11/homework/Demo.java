package lesson11.homework;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room room1 = new Room(1, 10, 1, null, "Kiev", "Kiev");
        Room room2 = new Room(2, 57, 2, new Date(), "Kiev", "Kiev");
        Room room3 = new Room(3, 234, 3, new Date(), "Kiev", "Kiev");
        Room room4 = new Room(4, 346, 4, null, "Kiev", "Kiev");
        Room room5 = null;
        Room room6 = new Room(6, 34, 1, null, "Odessa", "Odessa");
        Room room7 = new Room(7, 234, 3, new Date(), "Odessa", "Odessa");
        Room room8 = new Room(8, 123, 2, null, "Odessa", "Odessa");
        Room room9 = new Room(9, 23, 1, new Date(), "Lvov", "Lvov");
        Room room10 = new Room(10, 238, 2, new Date(), "Lvov", "Lvov");

        Room[] rooms1 = new Room[]{room1, room2, room3, room4, room5, room6, room7, room8, room9, room10};
        Room[] rooms2 = new Room[]{room1, room2, room3, room4, room5, room6};

        API api1 = new BookingComAPI(rooms1);
        System.out.println(Arrays.toString(api1.findRooms(30, 2, "Kiev", "Kiev")));
        API api2 = new TripAdvisorAPI(rooms2);
        System.out.println(Arrays.toString(api2.findRooms(123, 3, "Odessa", "Odessa")));
        API api3 = new GoogleAPI(rooms1);
        System.out.println(Arrays.toString(api3.findRooms(47, 1, "Lvov","Lvov")));
        System.out.println();

        API[] apis = new API[]{api1, api2, api3};
        Controller controller = new Controller(apis);
        System.out.println(Arrays.toString(controller.requestRooms(57, 2, "Kiev", "Kiev")));
        System.out.println(Arrays.toString(controller.check(api1, api2)));
        System.out.println((controller.cheapestRoom()));

        //Если город в котором ищем null
        System.out.println("Если город в котором ищем null");
        api1 = new BookingComAPI(rooms1);
        System.out.println(Arrays.toString(api1.findRooms(30, 2, null, "Kiev")));
        api2 = new TripAdvisorAPI(rooms2);
        System.out.println(Arrays.toString(api2.findRooms(123, 3, null, "Odessa")));
        api3 = new GoogleAPI(rooms1);
        System.out.println(Arrays.toString(api3.findRooms(47, 1, null,"Lvov")));
        System.out.println();

        //Если отель в котором ищем null
        System.out.println("Если отель в котором ищем null");
        api1 = new BookingComAPI(rooms1);
        System.out.println(Arrays.toString(api1.findRooms(30, 2, "Kiev", null)));
        api2 = new TripAdvisorAPI(rooms2);
        System.out.println(Arrays.toString(api2.findRooms(123, 3, "Odessa", null)));
        api3 = new GoogleAPI(rooms1);
        System.out.println(Arrays.toString(api3.findRooms(47, 1, "Lvov",null)));
        System.out.println();

        //Если количество людей 0
        System.out.println("Если количество людей 0");
        api1 = new BookingComAPI(rooms1);
        System.out.println(Arrays.toString(api1.findRooms(30, 0, "Kiev", "Kiev")));
        api2 = new TripAdvisorAPI(rooms2);
        System.out.println(Arrays.toString(api2.findRooms(123, 0, "Odessa", "Odessa")));
        api3 = new GoogleAPI(rooms1);
        System.out.println(Arrays.toString(api3.findRooms(47, 0, "Lvov","Lvov")));
        System.out.println();


    }
}
