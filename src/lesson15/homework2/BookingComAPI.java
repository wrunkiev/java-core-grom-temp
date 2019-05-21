package lesson15.homework2;

import java.util.Date;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int n = getCountRooms(price,persons, city, hotel);
        return fillRoomArrays(n,price,persons, city, hotel);
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

    private int getCountRooms(int price, int persons, String city, String hotel){
        Room paramRoom = new Room(0,price, persons,null, hotel, city);
        int k = 0;
        if(rooms != null) {
            for (Room room : rooms) {
                if(room != null){
                    if (room.getPrice() >= price - 100 &&
                            room.getPrice() <= price + 100 &&
                            room.getPersons() == persons &&
                            room.equals(paramRoom)) {
                        k++;
                    }
                }
            }
        }
        return k;
    }

    private Room[] fillRoomArrays(int n, int price, int persons, String city, String hotel){
        Room[] tempRooms = new Room[n];
        Room paramRoom = new Room(0,price, persons,null, hotel, city);
        int i = 0;
        if(rooms != null) {
            for (Room room : rooms) {
                if(room != null){
                    if (room.getPrice() > price - 100 &&
                            room.getPrice() < price + 100 &&
                            room.getPersons() == persons &&
                            room.equals(paramRoom)) {
                        tempRooms[i] = room;
                        i++;
                    }
                }
            }
        }
        return tempRooms;
    }
}
